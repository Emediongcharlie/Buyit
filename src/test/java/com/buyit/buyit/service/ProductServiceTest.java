package com.buyit.buyit.service;


import com.buyit.buyit.data.model.Product;
import com.buyit.buyit.data.repository.ProductRepo;
import com.buyit.buyit.dtos.requests.AddProductRequest;
import com.buyit.buyit.dtos.requests.SearchByNameRequest;
import com.buyit.buyit.dtos.response.AddProductResponse;
import com.buyit.buyit.dtos.response.SearchByNameResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepo productRepo;

    @InjectMocks
    ProductServiceImplementation productService;

    @Test
    void addProductTest(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("Rice");
        addProductRequest.setProductDescription("A delicious provision for every home");
        addProductRequest.setProductPrice(1000);

        Product product = new Product();
        product.setProductName("Rice");
        product.setProductDescription("A delicious provision for every home");
        product.setProductPrice(1000);

        when(productRepo.save(any(Product.class))).thenReturn(product);
        AddProductResponse response = productService.addProduct(addProductRequest);

        assertNotNull(response);

    }

    @Test
    void findProductTest(){

        SearchByNameRequest request = new SearchByNameRequest();
        request.setProductName("Rice");

        Product foundProduct = new Product();
        foundProduct.setProductName("Rice");

        when(productRepo.findByProductName("Rice")).thenReturn(Optional.of(foundProduct));
        SearchByNameResponse response = productService.searchByName(request);

        assertNotNull(response);
        assertEquals("Rice", response.getProductName());
    }
}
