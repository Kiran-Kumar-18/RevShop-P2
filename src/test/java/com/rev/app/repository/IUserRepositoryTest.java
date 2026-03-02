package com.rev.app.repository;

import com.rev.app.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class IUserRepositoryTest {

    @Autowired
    private IUserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setName("John Doe");
        testUser.setEmail("john.doe@example.com");
        testUser.setPasswordHash("hashed_password");
        testUser.setPhone("1234567890");
        testUser.setRole("USER");
        testUser.setSecurityQuestion("Question?");
        testUser.setSecurityAnswer("Answer");
        testUser.setCreatedAt(LocalDateTime.now());
        testUser.setUpdatedAt(LocalDateTime.now());
    }

    @Test
    public void givenUserEmail_whenFindByEmail_thenUserIsFound() {
        userRepository.save(testUser);

        Optional<User> foundUser = userRepository.findByEmail(testUser.getEmail());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo(testUser.getEmail());
    }

    @Test
    public void givenInvalidEmail_whenFindByEmail_thenUserIsNotFound() {
        Optional<User> foundUser = userRepository.findByEmail("nonexistent@example.com");

        assertThat(foundUser).isNotPresent();
    }

    @Test
    public void givenUser_whenSave_thenUserIsSaved() {
        User savedUser = userRepository.save(testUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo(testUser.getName());
    }

    @Test
    public void givenUserId_whenFindById_thenUserIsFound() {
        User savedUser = userRepository.save(testUser);

        Optional<User> foundUser = userRepository.findById(savedUser.getUserId());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUserId()).isEqualTo(savedUser.getUserId());
    }
}
