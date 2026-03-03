package com.rev.app.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Integer favoriteId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    @java.lang.SuppressWarnings("all")
    
    public static class FavoriteBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer favoriteId;
        @java.lang.SuppressWarnings("all")
        
        private User user;
        @java.lang.SuppressWarnings("all")
        
        private Product product;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime createdAt;

        @java.lang.SuppressWarnings("all")
        
        FavoriteBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public Favorite.FavoriteBuilder favoriteId(final Integer favoriteId) {
            this.favoriteId = favoriteId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Favorite.FavoriteBuilder user(final User user) {
            this.user = user;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Favorite.FavoriteBuilder product(final Product product) {
            this.product = product;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Favorite.FavoriteBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public Favorite build() {
            return new Favorite(this.favoriteId, this.user, this.product, this.createdAt);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "Favorite.FavoriteBuilder(favoriteId=" + this.favoriteId + ", user=" + this.user + ", product=" + this.product + ", createdAt=" + this.createdAt + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static Favorite.FavoriteBuilder builder() {
        return new Favorite.FavoriteBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getFavoriteId() {
        return this.favoriteId;
    }

    @java.lang.SuppressWarnings("all")
    
    public User getUser() {
        return this.user;
    }

    @java.lang.SuppressWarnings("all")
    
    public Product getProduct() {
        return this.product;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setFavoriteId(final Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUser(final User user) {
        this.user = user;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setProduct(final Product product) {
        this.product = product;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Favorite)) return false;
        final Favorite other = (Favorite) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$favoriteId = this.getFavoriteId();
        final java.lang.Object other$favoriteId = other.getFavoriteId();
        if (this$favoriteId == null ? other$favoriteId != null : !this$favoriteId.equals(other$favoriteId)) return false;
        final java.lang.Object this$user = this.getUser();
        final java.lang.Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final java.lang.Object this$product = this.getProduct();
        final java.lang.Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
        final java.lang.Object this$createdAt = this.getCreatedAt();
        final java.lang.Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Favorite;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $favoriteId = this.getFavoriteId();
        result = result * PRIME + ($favoriteId == null ? 43 : $favoriteId.hashCode());
        final java.lang.Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final java.lang.Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        final java.lang.Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "Favorite(favoriteId=" + this.getFavoriteId() + ", user=" + this.getUser() + ", product=" + this.getProduct() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public Favorite() {
    }

    @java.lang.SuppressWarnings("all")
    
    public Favorite(final Integer favoriteId, final User user, final Product product, final LocalDateTime createdAt) {
        this.favoriteId = favoriteId;
        this.user = user;
        this.product = product;
        this.createdAt = createdAt;
    }
}
