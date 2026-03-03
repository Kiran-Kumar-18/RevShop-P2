package com.rev.app.controller;

import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.service.ICategoryService;
import com.rev.app.service.IProductService;
import com.rev.app.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class PageController {
    private static final Logger logger = LogManager.getLogger(PageController.class);
    private final IProductService iproductService;
    private final ICategoryService icategoryService;
    private final CategoryMapper categoryMapper;
    private final com.rev.app.service.IAuthService iauthService;

    // ---- Public Pages ----
    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size, @RequestParam(required = false) Integer categoryId, @RequestParam(required = false) String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponseDTO> products;
        if (keyword != null && !keyword.trim().isEmpty()) {
            products = iproductService.searchActiveProducts(keyword.trim(), pageable);
        } else if (categoryId != null) {
            products = iproductService.getActiveProductsByCategory(categoryId, pageable);
        } else {
            products = iproductService.getAllActiveProducts(pageable);
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", icategoryService.getAllCategories().stream().map(categoryMapper::toDto).collect(Collectors.toList()));
        model.addAttribute("selectedCategoryId", categoryId);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginDto", new com.rev.app.dto.LoginRequestDTO());
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerDto", new com.rev.app.dto.RegisterRequestDTO());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registerDto") com.rev.app.dto.RegisterRequestDTO request, Model model) {
        try {
            iauthService.register(request);
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "auth/register";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "auth/forgot-password";
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage() {
        return "auth/reset-password";
    }

    // ---- Product Pages ----
    @GetMapping("/products")
    public String productsPage(Model model, 
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "12") int size, 
            @RequestParam(required = false) Integer categoryId, 
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) java.math.BigDecimal minPrice,
            @RequestParam(required = false) java.math.BigDecimal maxPrice,
            @RequestParam(required = false) Double minRating,
            @RequestParam(defaultValue = "select") String sort) {
            
        Pageable pageable;
        if (sort != null && !sort.equalsIgnoreCase("select")) {
            String[] sortParts = sort.split(",");
            org.springframework.data.domain.Sort.Direction direction = (sortParts.length > 1 && sortParts[1].equalsIgnoreCase("asc")) ? 
                    org.springframework.data.domain.Sort.Direction.ASC : org.springframework.data.domain.Sort.Direction.DESC;
            pageable = PageRequest.of(page, size, org.springframework.data.domain.Sort.by(direction, sortParts[0]));
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<ProductResponseDTO> products = iproductService.filterActiveProducts(categoryId, minPrice, maxPrice, keyword, minRating, pageable);
        
        model.addAttribute("products", products);
        model.addAttribute("categories", icategoryService.getAllCategories().stream().map(categoryMapper::toDto).collect(Collectors.toList()));
        model.addAttribute("selectedCategoryId", categoryId);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minRating", minRating);
        model.addAttribute("sort", sort);
        return "products/list";
    }

    @GetMapping("/products/{id}")
    public String productDetailPage(@PathVariable Integer id, Model model) {
        try {
            ProductResponseDTO product = iproductService.getActiveProductById(id);
            model.addAttribute("product", product);
            return "products/detail";
        } catch (Exception e) {
            return "redirect:/products?error=notfound";
        }
    }

    // ---- Buyer Pages (data loaded via JS + API) ----
    @GetMapping("/cart")
    public String cartPage() {
        return "buyer/cart";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "buyer/checkout";
    }

    @GetMapping("/orders")
    public String ordersPage() {
        return "buyer/orders";
    }

    @GetMapping("/orders/{id}")
    public String orderDetailPage(@PathVariable Integer id, Model model) {
        model.addAttribute("orderId", id);
        return "buyer/order-detail";
    }

    @GetMapping("/favorites")
    public String favoritesPage() {
        return "buyer/favorites";
    }

    // ---- Seller Pages (data loaded via JS + API) ----
    @GetMapping("/seller/dashboard")
    public String sellerDashboard() {
        return "seller/dashboard";
    }

    @GetMapping("/seller/products")
    public String sellerProducts() {
        return "seller/products";
    }

    @GetMapping("/seller/products/new")
    public String sellerProductNew(Model model) {
        model.addAttribute("categories", icategoryService.getAllCategories().stream().map(categoryMapper::toDto).collect(Collectors.toList()));
        return "seller/product-form";
    }

    @GetMapping("/seller/products/edit/{id}")
    public String sellerProductEdit(@PathVariable Integer id, Model model) {
        ProductResponseDTO product = iproductService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", icategoryService.getAllCategories().stream().map(categoryMapper::toDto).collect(Collectors.toList()));
        return "seller/product-form";
    }

    @GetMapping("/seller/orders")
    public String sellerOrders() {
        return "seller/orders";
    }

    @GetMapping("/seller/notifications")
    public String sellerNotifications() {
        return "seller/notifications";
    }

    // ---- Help Pages ----
    @GetMapping("/help/contact")
    public String contactPage() {
        return "help/contact";
    }

    @GetMapping("/help/shipping")
    public String shippingPage() {
        return "help/shipping";
    }

    @GetMapping("/help/returns")
    public String returnsPage() {
        return "help/returns";
    }

    @GetMapping("/help/faq")
    public String faqPage() {
        return "help/faq";
    }

    @java.lang.SuppressWarnings("all")
    
    public PageController(final IProductService iproductService, final ICategoryService icategoryService, final CategoryMapper categoryMapper, final com.rev.app.service.IAuthService iauthService) {
        this.iproductService = iproductService;
        this.icategoryService = icategoryService;
        this.categoryMapper = categoryMapper;
        this.iauthService = iauthService;
    }
}
