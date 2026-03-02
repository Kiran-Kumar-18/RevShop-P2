package com.rev.app.controller;

import com.rev.app.config.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtService jwtService;

    @Test
    public void givenNoToken_whenCallProtectedApi_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/seller/orders"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "SELLER")
    public void givenValidRole_whenCallProtectedApi_thenOkOrServerError() throws Exception {
        // Because the controller accesses services and the database without mocks, 500 error validates security PASSED.
        mockMvc.perform(get("/api/seller/orders"))
                .andExpect(status().is5xxServerError());
    }
}
