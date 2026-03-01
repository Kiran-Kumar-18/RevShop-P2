package com.rev.app.config;

import com.rev.app.entity.Category;
import com.rev.app.entity.User;
import com.rev.app.entity.Seller;
import com.rev.app.repository.ICategoryRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.repository.ISellerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DataSeeder implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(DataSeeder.class);

    private final ICategoryRepository categoryRepository;
    private final IUserRepository userRepository;
    private final ISellerRepository sellerRepository;

    public DataSeeder(ICategoryRepository categoryRepository, IUserRepository userRepository, ISellerRepository sellerRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedCategories();

        // Backfill missing sellers for existing SELLER users
        List<User> users = userRepository.findAll();
        for (User user : users) {
             if (user.getRole() != null && user.getRole().toUpperCase().contains("SELLER")) {
                 Optional<Seller> existingSeller = sellerRepository.findByUserUserId(user.getUserId());
                 if (existingSeller.isEmpty()) {
                     Seller newSeller = new Seller();
                     newSeller.setUser(user);
                     newSeller.setBusinessName(user.getName() + " Store");
                     newSeller.setCreatedAt(LocalDateTime.now());
                     sellerRepository.save(newSeller);
                     logger.info("Backfilled missing Seller profile for User ID: {}", user.getUserId());
                 }
             }
        }
    }

    private void seedCategories() {
        List<Category> defaultCategories = Arrays.asList(
                new Category(null, "Electronics", "Devices and Gadgets"),
                new Category(null, "Clothing", "Apparel and Accessories"),
                new Category(null, "Home & Kitchen", "Appliances and Furniture"),
                new Category(null, "Books", "Printed and Digital Media"),
                new Category(null, "Sports", "Athletic Equipment"),
                new Category(null, "Beauty & Health", "Personal Care and Wellness"),
                new Category(null, "Toys & Games", "Fun and Entertainment"),
                new Category(null, "Automotive", "Car Parts and Accessories"),
                new Category(null, "Grocery", "Daily Essentials and Food"),
                new Category(null, "Pet Supplies", "Everything for your Pets"),
                new Category(null, "Jewellery", "Exquisite Ornaments and Accessories")
        );

        for (Category category : defaultCategories) {
            if (!categoryRepository.existsByName(category.getName())) {
                categoryRepository.save(category);
                logger.info("Seeded category: {}", category.getName());
            }
        }
    }
}

