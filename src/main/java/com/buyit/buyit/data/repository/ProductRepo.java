package com.buyit.buyit.data.repository;

import com.buyit.buyit.data.model.Product;
import com.buyit.buyit.dtos.requests.AddProductRequest;
import com.buyit.buyit.dtos.response.AddProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {


    Optional<Product> findByProductName(String productName);
    Optional<Product> findById(Long id);
}