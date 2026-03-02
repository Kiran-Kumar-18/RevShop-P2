package com.rev.app.repository;

import com.rev.app.entity.Category;
import com.rev.app.entity.Product;
import com.rev.app.entity.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class IProductRepositoryTest {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Seller seller;
    private Category category;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        seller = new Seller();
        seller.setBusinessName("Company A");
        entityManager.persist(seller);

        category = new Category();
        category.setName("Category A");
        entityManager.persist(category);

        product1 = new Product();
        product1.setName("Product A");
        product1.setPrice(new BigDecimal("100.00"));
        product1.setStockQuantity(10);
        product1.setIsActive(true);
        product1.setSeller(seller);
        product1.setCategory(category);
        entityManager.persist(product1);

        product2 = new Product();
        product2.setName("Product B");
        product2.setPrice(new BigDecimal("200.00"));
        product2.setStockQuantity(5);
        product2.setIsActive(true);
        product2.setSeller(seller);
        product2.setCategory(category);
        entityManager.persist(product2);

        entityManager.flush();
    }

    @Test
    public void givenSellerId_whenFindBySellerSellerId_thenProductsFound() {
        List<Product> products = productRepository.findBySellerSellerId(seller.getSellerId());

        assertThat(products).hasSize(2);
        assertThat(products.get(0).getSeller().getSellerId()).isEqualTo(seller.getSellerId());
    }

    @Test
    public void givenCategoryId_whenFindByCategoryCategoryId_thenProductsFound() {
        List<Product> products = productRepository.findByCategoryCategoryId(category.getCategoryId());

        assertThat(products).hasSize(2);
        assertThat(products.get(0).getCategory().getCategoryId()).isEqualTo(category.getCategoryId());
    }

    @Test
    public void givenName_whenFindByNameContainingIgnoreCase_thenProductsFound() {
        List<Product> products = productRepository.findByNameContainingIgnoreCase("product");

        assertThat(products).hasSize(2);
    }

    @Test
    public void givenFilters_whenFilterProducts_thenFilteredCorrectly() {
        Page<Product> products = productRepository.filterProducts(
                category.getCategoryId(),
                new BigDecimal("50.00"),
                new BigDecimal("150.00"),
                null,
                null,
                PageRequest.of(0, 10)
        );

        assertThat(products.getContent()).hasSize(1);
        assertThat(products.getContent().get(0).getName()).isEqualTo("Product A");
    }

    @Test
    public void givenKeyword_whenFilterProducts_thenFilteredByName() {
        Page<Product> products = productRepository.filterProducts(
                null,
                null,
                null,
                "B",
                null,
                PageRequest.of(0, 10)
        );

        assertThat(products.getContent()).hasSize(1);
        assertThat(products.getContent().get(0).getName()).isEqualTo("Product B");
    }
}
