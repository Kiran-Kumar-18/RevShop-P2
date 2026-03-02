package com.rev.app.controller;

import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IProductService productService;

    @InjectMocks
    private ProductController productController;

    private ProductResponseDTO productResponseDTO;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();

        productResponseDTO = ProductResponseDTO.builder()
                .productId(1)
                .name("Product A")
                .price(new BigDecimal("100.00"))
                .stockQuantity(10)
                .isActive(true)
                .build();
    }

    @Test
    public void givenProducts_whenGetAllProducts_thenReturnPage() throws Exception {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ProductResponseDTO> page = new PageImpl<>(Collections.singletonList(productResponseDTO), pageable, 1);
        when(productService.getAllActiveProducts(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/products")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.content[0].name").value("Product A"));
    }

    @Test
    public void givenProductId_whenGetProductById_thenReturnProduct() throws Exception {
        when(productService.getActiveProductById(anyInt())).thenReturn(productResponseDTO);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.productId").value(1));
    }
}
