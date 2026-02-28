package com.rev.app.service.impl;

import com.rev.app.entity.Product;
import com.rev.app.entity.Seller;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.ISellerRepository;
import com.rev.app.service.ISellerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SellerServiceImpl implements ISellerService {
    private final ISellerRepository isellerRepository;
    private final IProductRepository iproductRepository;

    @Override
    public Seller getSellerById(Integer id) {
        return isellerRepository.findByUserUserId(id).orElseThrow(() -> new ResourceNotFoundException("Seller not found for user ID: " + id));
    }

    @Override
    public List<Product> getSellerProducts(Integer id) {
        Seller seller = isellerRepository.findByUserUserId(id).orElseThrow(() -> new ResourceNotFoundException("Seller not found for user ID: " + id));
        return iproductRepository.findBySellerSellerId(seller.getSellerId());
    }

    @java.lang.SuppressWarnings("all")
    
    public SellerServiceImpl(final ISellerRepository isellerRepository, final IProductRepository iproductRepository) {
        this.isellerRepository = isellerRepository;
        this.iproductRepository = iproductRepository;
    }
}
