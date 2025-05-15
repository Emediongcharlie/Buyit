package com.buyit.buyit.service;

import com.buyit.buyit.dtos.requests.AddProductRequest;
import com.buyit.buyit.dtos.requests.DeleteProductRequest;
import com.buyit.buyit.dtos.requests.SearchByNameRequest;
import com.buyit.buyit.dtos.response.AddProductResponse;
import com.buyit.buyit.dtos.response.DeleteProductResponse;
import com.buyit.buyit.dtos.response.SearchByNameResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    AddProductResponse addProduct(AddProductRequest addProductRequest);
    SearchByNameResponse searchByName(SearchByNameRequest searchByNameRequest);
    DeleteProductResponse deleteProduct(DeleteProductRequest deleteProductRequest);
}
