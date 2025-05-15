package com.buyit.buyit.service;

import com.buyit.buyit.data.model.Product;
import com.buyit.buyit.data.repository.ProductRepo;
import com.buyit.buyit.dtos.requests.AddProductRequest;
import com.buyit.buyit.dtos.requests.DeleteProductRequest;
import com.buyit.buyit.dtos.requests.SearchByNameRequest;
import com.buyit.buyit.dtos.response.AddProductResponse;
import com.buyit.buyit.dtos.response.DeleteProductResponse;
import com.buyit.buyit.dtos.response.SearchByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = new Product();
        product.setProductName(addProductRequest.getProductName());
        product.setProductDescription(addProductRequest.getProductDescription());
        product.setProductPrice(addProductRequest.getProductPrice());
        productRepo.save(product);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setProductName(product.getProductName());
        addProductResponse.setMessage("Product added successfully");
        return addProductResponse;
    }

    @Override
    public SearchByNameResponse searchByName(SearchByNameRequest searchByNameRequest) {
        Product product = productRepo.findByProductName(searchByNameRequest.getProductName())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        SearchByNameResponse searchByNameResponse = new SearchByNameResponse();
        searchByNameResponse.setProductName(product.getProductName());
        searchByNameResponse.setMessage("Product found");
        return searchByNameResponse;
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest deleteProductRequest) {
        Product product = productRepo.findById(deleteProductRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepo.delete(product);

        DeleteProductResponse deleteProductResponse = new DeleteProductResponse();
        deleteProductResponse.setMessage("Product deleted successfully");
        return deleteProductResponse;
    }


}
