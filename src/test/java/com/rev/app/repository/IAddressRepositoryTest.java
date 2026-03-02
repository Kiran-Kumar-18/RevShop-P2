package com.rev.app.repository;

import com.rev.app.entity.Address;
import com.rev.app.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class IAddressRepositoryTest {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user;
    private Address address;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName("Address User");
        user.setEmail("addr@example.com");
        user.setPasswordHash("pass");
        user.setRole("USER");
        entityManager.persist(user);

        address = new Address();
        address.setUser(user);
        address.setFullName("Home Address");
        address.setPhone("1234567890");
        address.setAddressLine1("123 Street");
        address.setCity("City");
        address.setState("State");
        address.setPostalCode("12345");
        address.setCountry("Country");
        address.setAddressType("Shipping");
        entityManager.persist(address);

        entityManager.flush();
    }

    @Test
    public void givenUserId_whenFindByUserUserId_thenAddressesFound() {
        List<Address> addresses = addressRepository.findByUserUserId(user.getUserId());

        assertThat(addresses).hasSize(1);
        assertThat(addresses.get(0).getAddressLine1()).isEqualTo("123 Street");
    }
}
