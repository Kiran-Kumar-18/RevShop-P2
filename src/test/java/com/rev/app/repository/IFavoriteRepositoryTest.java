package com.rev.app.repository;

import com.rev.app.entity.Favorite;
import com.rev.app.entity.Product;
import com.rev.app.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class IFavoriteRepositoryTest {

    @Autowired
    private IFavoriteRepository favoriteRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user;
    private Product product;
    private Favorite favorite;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName("Favorite User");
        user.setEmail("fav@example.com");
        user.setPasswordHash("pass");
        user.setRole("USER");
        entityManager.persist(user);

        product = new Product();
        product.setName("Fav Product");
        product.setPrice(new BigDecimal("100.00"));
        product.setStockQuantity(10);
        product.setIsActive(true);
        entityManager.persist(product);

        favorite = new Favorite();
        favorite.setUser(user);
        favorite.setProduct(product);
        entityManager.persist(favorite);

        entityManager.flush();
    }

    @Test
    public void givenUserId_whenFindByUserUserId_thenFavoritesFound() {
        List<Favorite> favorites = favoriteRepository.findByUserUserId(user.getUserId());

        assertThat(favorites).hasSize(1);
        assertThat(favorites.get(0).getProduct().getName()).isEqualTo("Fav Product");
    }

    @Test
    public void givenProductId_whenFindByProductProductId_thenFavoriteFound() {
        List<Favorite> favorites = favoriteRepository.findByProductProductId(product.getProductId());

        assertThat(favorites).isNotNull();
        assertThat(favorites).isNotEmpty();
        assertThat(favorites.get(0).getProduct().getProductId()).isEqualTo(product.getProductId());
    }
}
