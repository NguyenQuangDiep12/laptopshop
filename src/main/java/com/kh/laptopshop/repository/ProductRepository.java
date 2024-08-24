package com.kh.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.laptopshop.domain.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    Products save(Products products);

    Products findAllById(Long id);

    Products findProductById(Long id);

    void deleteById(Long id);

}