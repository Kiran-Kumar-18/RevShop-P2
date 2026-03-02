 const RevShop = (() => {
    const API_BASE = '/api';

    // ---- Token Management ----
    function getToken() { return localStorage.getItem('rs_token'); }
    function setToken(token) { localStorage.setItem('rs_token', token); }
    function removeToken() { localStorage.removeItem('rs_token'); }

    function getUserInfo() {
        try {
            const raw = localStorage.getItem('rs_user');
            return raw ? JSON.parse(raw) : null;
        } catch (e) {
            console.error('Failed to parse user info', e);
            return null;
        }
    }
    function setUserInfo(user) { localStorage.setItem('rs_user', JSON.stringify(user)); }
    function removeUserInfo() { localStorage.removeItem('rs_user'); }

    function isLoggedIn() { return !!getToken(); }

    function logout() {
        removeToken();
        removeUserInfo();
        window.location.href = '/logout';
    }

    // ---- API Fetch Wrapper ----
    async function apiFetch(endpoint, options = {}) {
        const url = endpoint.startsWith('http') ? endpoint : `${API_BASE}${endpoint}`;
        const headers = { 'Content-Type': 'application/json', ...options.headers };
        const token = getToken();
        if (token) headers['Authorization'] = `Bearer ${token}`;

        const response = await fetch(url, { ...options, headers });

        if (response.status === 401) {
            logout();
            throw new Error('Session expired. Please log in again.');
        }

        if (response.status === 403) {
            throw new Error('Permission denied.');
        }

        let data;
        const contentType = response.headers.get('content-type');
        if (contentType && contentType.includes('application/json')) {
            data = await response.json();
        } else {
            data = { message: await response.text() };
        }

        if (!response.ok) {
            let errorMsg = data.message;
            if (!errorMsg && typeof data === 'object') {
                // Handle Spring validation errors map
                errorMsg = Object.values(data).filter(v => typeof v === 'string').join(', ');
            }
            throw new Error(errorMsg || `Server Error: ${response.status} ${response.statusText}`);
        }
        return data;
    }

    // ---- Auth ----
    async function login(email, password) {
        const res = await apiFetch('/auth/login', {
            method: 'POST',
            body: JSON.stringify({ email, password })
        });
        if (res.success) {
            setToken(res.data);
            const userRes = await apiFetch(`/users/email/${email}`);
            if (userRes.success) setUserInfo(userRes.data);
        }
        return res;
    }

    async function register(data) {
        return await apiFetch('/auth/register', {
            method: 'POST',
            body: JSON.stringify(data)
        });
    }

    // ---- Products ----
    async function getProducts(page = 0, size = 12) {
        return await apiFetch(`/products?page=${page}&size=${size}`);
    }

    async function getProduct(id) {
        return await apiFetch(`/products/${id}`);
    }

    async function getSellerProducts(sellerId) {
        return await apiFetch(`/sellers/${sellerId}/products`);
    }

    async function getSellerInfo(userId) {
        return await apiFetch(`/sellers/${userId}`);
    }

    async function createProduct(data) {
        return await apiFetch('/products', { method: 'POST', body: JSON.stringify(data) });
    }

    async function updateProduct(id, data) {
        return await apiFetch(`/products/${id}`, { method: 'PUT', body: JSON.stringify(data) });
    }

    async function deleteProduct(id) {
        return await apiFetch(`/products/${id}`, { method: 'DELETE' });
    }

    async function updateStock(productId, delta) {
        return await apiFetch(`/products/${productId}/stock?quantityChange=${delta}`, { method: 'PATCH' });
    }

    async function uploadImage(file) {
        const formData = new FormData();
        formData.append('file', file);
        const token = getToken();
        const headers = {};
        if (token) headers['Authorization'] = `Bearer ${token}`;

        const response = await fetch(`${API_BASE}/upload/image`, {
            method: 'POST',
            headers,
            body: formData
        });

        const data = await response.json();
        if (!response.ok) throw new Error(data.message || 'Upload failed');
        return data;
    }

    // ---- Cart ----
    async function getCart(userId) {
        return await apiFetch(`/cart/${userId}`);
    }

    async function addToCart(userId, productId, quantity) {
        return await apiFetch(`/cart/${parseInt(userId)}/items`, {
            method: 'POST',
            body: JSON.stringify({
                productId: parseInt(productId),
                quantity: parseInt(quantity)
            })
        });
    }

    async function removeFromCart(userId, itemId) {
        return await apiFetch(`/cart/${userId}/items/${itemId}`, { method: 'DELETE' });
    }

    // ---- Orders ----
    async function placeOrder(data) {
        // Ensure data fields are valid numbers
        const userId = parseInt(data.userId);
        const shippingAddressId = parseInt(data.shippingAddressId);
        const billingAddressId = parseInt(data.billingAddressId);

        if (isNaN(userId) || isNaN(shippingAddressId) || isNaN(billingAddressId)) {
            throw new Error('User ID and Address IDs must be valid numbers');
        }

        const payload = { userId, shippingAddressId, billingAddressId, paymentMethod: data.paymentMethod };
        return await apiFetch('/orders', { method: 'POST', body: JSON.stringify(payload) });
    }

    async function getOrder(id) {
        return await apiFetch(`/orders/${id}`);
    }

    async function getUserOrders(userId, page = 0, size = 10) {
        return await apiFetch(`/orders/user/${userId}?page=${page}&size=${size}`);
    }

    async function getSellerOrders(sellerId, page = 0, size = 10) {
        return await apiFetch(`/orders/seller/${sellerId}?page=${page}&size=${size}`);
    }

    async function updateOrderStatus(orderId, status) {
        return await apiFetch(`/orders/${orderId}/status?status=${status}`, { method: 'PATCH' });
    }

    // ---- Payments ----
    async function processPayment(data) {
        const orderId = parseInt(data.orderId);
        if (isNaN(orderId)) {
            throw new Error('Order ID must be a valid number');
        }
        const payload = {
            orderId: orderId,
            method: data.method,
            amount: parseFloat(data.amount)
        };
        return await apiFetch('/payments', { method: 'POST', body: JSON.stringify(payload) });
    }

    // ---- Recovery ----
    async function getSecurityQuestion(email) {
        return await apiFetch(`/auth/security-question?email=${encodeURIComponent(email)}`, { method: 'GET' });
    }

    async function resetPassword(data) {
        return await apiFetch('/auth/reset-password', {
            method: 'POST',
            body: JSON.stringify(data)
        });
    }

    // ---- Addresses ----
    async function getUserAddresses(userId) {
        return await apiFetch(`/addresses/user/${userId}`);
    }

    async function createAddress(userId, data) {
        return await apiFetch(`/addresses/user/${userId}`, { method: 'POST', body: JSON.stringify(data) });
    }

    // ---- Favorites ----
    async function addFavorite(userId, productId) {
        return await apiFetch(`/favorites/${userId}/${productId}`, { method: 'POST' });
    }

    async function removeFavorite(userId, productId) {
        return await apiFetch(`/favorites/${userId}/${productId}`, { method: 'DELETE' });
    }

    async function getUserFavorites(userId) {
        return await apiFetch(`/favorites/user/${userId}`);
    }

    // ---- Notifications ----
    async function getUserNotifications(userId) {
        return await apiFetch(`/notifications/user/${userId}`);
    }

    async function markNotificationRead(notificationId) {
        return await apiFetch(`/notifications/${notificationId}/read`, { method: 'PUT' });
    }

    // ---- UI Utilities ----
    function showToast(message, type = 'info') {
        const container = document.getElementById('toast-container') || createToastContainer();
        const toast = document.createElement('div');
        toast.className = `toast alert-${type}`;
        toast.textContent = message;
        container.appendChild(toast);
        setTimeout(() => { toast.style.opacity = '0'; setTimeout(() => toast.remove(), 300); }, 3000);
    }

    function createToastContainer() {
        const container = document.createElement('div');
        container.id = 'toast-container';
        container.className = 'toast-container';
        document.body.appendChild(container);
        return container;
    }

    function formatCurrency(amount) {
        return '₹' + parseFloat(amount || 0).toLocaleString('en-IN', { minimumFractionDigits: 2 });
    }

    function showSuccess(message, redirectUrl) {
        const overlay = document.getElementById('success-overlay');
        const msgEl = document.getElementById('success-message');
        if (overlay && msgEl) {
            msgEl.textContent = message;
            overlay.classList.add('open');
            setTimeout(() => {
                window.location.href = redirectUrl;
            }, 2000);
        } else {
            // Fallback if overlay not found
            alert(message);
            window.location.href = redirectUrl;
        }
    }

    function formatDate(dateStr) {
        if (!dateStr) return '';
        return new Date(dateStr).toLocaleDateString('en-IN');
    }

    function formatDateTime(dateStr) {
        if (!dateStr) return '';
        return new Date(dateStr).toLocaleString('en-IN');
    }

    function getStatusBadge(status) {
        const s = (status || 'PENDING').toLowerCase();
        return `<span class="status-badge ${s}">${status}</span>`;
    }

    function getStockStatus(qty) {
        if (qty <= 0) return { text: 'Out of Stock', cls: 'cancelled' };
        if (qty <= 5) return { text: 'Low Stock', cls: 'pending' };
        return { text: 'In Stock', cls: 'delivered' };
    }

    return {
        getToken, setToken, getUserInfo, setUserInfo, isLoggedIn, logout,
        login, register, apiFetch,
        getProducts, getProduct, getSellerProducts, getSellerInfo, createProduct, updateProduct, deleteProduct, updateStock, uploadImage,
        getCart, addToCart, removeFromCart,
        placeOrder, getOrder, getUserOrders, getSellerOrders, updateOrderStatus,
        processPayment,
        getSecurityQuestion, resetPassword,
        getUserAddresses, createAddress,
        addFavorite, removeFavorite, getUserFavorites,
        getUserNotifications, markNotificationRead,
        showToast, showSuccess, formatCurrency, formatDate, formatDateTime, getStatusBadge, getStockStatus
    };
})();

const revshop = RevShop;

document.addEventListener('DOMContentLoaded', () => {
    const navbar = document.querySelector('header');
    if (navbar) {
        window.addEventListener('scroll', () => {
            if (window.scrollY > 10) {
                navbar.style.boxShadow = '0 2px 10px rgba(0,0,0,0.15)';
            } else {
                navbar.style.boxShadow = '0 2px 5px rgba(0,0,0,0.1)';
            }
        });
    }

    const toggle = document.querySelector('.navbar-toggle');
    const nav = document.querySelector('.navbar-nav');
    if (toggle && nav) {
        toggle.addEventListener('click', () => nav.classList.toggle('open'));
    }

    const notiBtn = document.getElementById('notification-btn');
    const notiList = document.getElementById('notification-list');
    if (notiBtn && notiList) {
        notiBtn.addEventListener('click', (e) => {
            e.stopPropagation();
            notiList.classList.toggle('open');
        });
        document.addEventListener('click', () => notiList.classList.remove('open'));
    }

    updateNavbar();

    const searchBtn = document.getElementById('header-search-btn');
    const searchInput = document.getElementById('header-search-input');
    if (searchBtn && searchInput) {
        searchBtn.addEventListener('click', () => {
            const query = searchInput.value.trim();
            if (query) window.location.href = `/products?keyword=${encodeURIComponent(query)}`;
        });
        searchInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') {
                const query = searchInput.value.trim();
                if (query) window.location.href = `/products?keyword=${encodeURIComponent(query)}`;
            }
        });
    }
});

function updateNavbar() {
    const authLinks = document.getElementById('auth-links');
    const userLinks = document.getElementById('user-links');
    const userName = document.getElementById('user-name');
    const cartCount = document.getElementById('cart-count');
    const favBtn = document.getElementById('nav-favorite-btn');

    if (RevShop.isLoggedIn()) {
        const user = RevShop.getUserInfo();
        if (authLinks) authLinks.style.display = 'none';
        if (userLinks) userLinks.style.display = 'flex';
        if (userName) userName.textContent = user ? user.name : 'User';

        if (user && user.role === 'ROLE_BUYER') {
            if (cartCount) {
                RevShop.getCart(user.userId).then(res => {
                    if (res.success && res.data && res.data.items) {
                        cartCount.textContent = res.data.items.length;
                        cartCount.parentElement.style.display = 'flex';
                    }
                }).catch(() => { });
            }
            if (favBtn) favBtn.style.display = 'flex';
        } else {
            if (cartCount) cartCount.parentElement.style.display = 'none';
            if (favBtn) favBtn.style.display = 'none';
        }

        if (user) {
            RevShop.getUserNotifications(user.userId).then(res => {
                if (res.success && res.data) {
                    const unread = res.data.filter(n => !n.isRead);
                    const notiBadge = document.getElementById('noti-count');
                    if (notiBadge) {
                        notiBadge.textContent = unread.length;
                        notiBadge.style.display = unread.length > 0 ? 'flex' : 'none';
                    }
                    renderNotifications(res.data);
                }
            }).catch(() => { });
        }
    } else {
        if (authLinks) authLinks.style.display = 'flex';
        if (userLinks) userLinks.style.display = 'none';
    }
}

function renderNotifications(notifications) {
    const container = document.getElementById('noti-items-container');
    if (!container) return;

    if (!notifications || notifications.length === 0) {
        container.innerHTML = '<div style="padding:15px;text-align:center;color:#888;">No notifications</div>';
        return;
    }

    container.innerHTML = notifications.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt)).map(n => `
        <div class="noti-item" 
             style="border-left: 3px solid ${n.isRead ? '#eee' : '#007bff'}; background: ${n.isRead ? 'transparent' : '#f0f7ff'}"
             onclick="handleNotificationClick(${n.notificationId}, this)">
            <div style="font-weight:bold;font-size:14px;">${n.title}</div>
            <div style="font-size:13px;color:#666;">${n.message}</div>
        </div>
    `).join('');
}

async function handleNotificationClick(id, element) {
    try {
        // Prevent multiple clicks if already read locally (optimization)
        const isRead = element.style.borderLeftColor === 'rgb(238, 238, 238)'; // #eee
        if (isRead) return;

        const res = await RevShop.markNotificationRead(id);
        if (res.success) {
            // Update UI immediately
            element.style.borderLeftColor = '#eee';
            element.style.background = 'transparent';

            // Decrease badge count
            const badge = document.getElementById('noti-count');
            if (badge) {
                let currentCount = parseInt(badge.textContent) || 0;
                if (currentCount > 0) {
                    currentCount--;
                    badge.textContent = currentCount;
                    if (currentCount === 0) badge.style.display = 'none';
                }
            }
        }
    } catch (err) {
        console.error('Failed to mark notification as read:', err);
    }
}
