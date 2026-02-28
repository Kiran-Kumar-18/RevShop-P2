package com.rev.app.service;

import com.rev.app.entity.Product;
import com.rev.app.entity.Seller;

import java.util.List;

public interface ISellerService {
    Seller getSellerById(Integer id);
    List<Product> getSellerProducts(Integer id);
}


