package com.rev.app.repository;

import com.rev.app.entity.Order;
import com.rev.app.entity.User;
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
public class IOrderRepositoryTest {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user;
    private Order order;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName("Order User");
        user.setEmail("order@example.com");
        user.setPasswordHash("pass");
        user.setRole("USER");
        entityManager.persist(user);

        order = new Order();
        order.setUser(user);
        order.setTotalAmount(new BigDecimal("500.00"));
        order.setStatus("PENDING");
        entityManager.persist(order);

        entityManager.flush();
    }

    @Test
    public void givenUserId_whenFindByUserUserId_thenOrdersFound() {
        List<Order> orders = orderRepository.findByUserUserId(user.getUserId());

        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getUser().getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    public void givenStatus_whenFindByStatus_thenOrdersFound() {
        List<Order> orders = orderRepository.findByStatus("PENDING");

        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getStatus()).isEqualTo("PENDING");
    }

    @Test
    public void givenUserIdAndPageable_whenFindByUserUserId_thenPageReturned() {
        Page<Order> orderPage = orderRepository.findByUserUserId(user.getUserId(), PageRequest.of(0, 10));

        assertThat(orderPage.getContent()).hasSize(1);
    }
}
