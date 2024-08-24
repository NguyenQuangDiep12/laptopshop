package com.kh.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.laptopshop.domain.Products;
import com.kh.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void handleSaveProduct(Products products) {
        productRepository.save(products);
    }

    public List<Products> getAllProduct() {
        return this.productRepository.findAll();
    }

    public Products getProductById(Long id) {
        return this.productRepository.findProductById(id);
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

}
