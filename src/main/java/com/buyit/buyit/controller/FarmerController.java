package com.buyit.buyit.controller;

import com.buyit.buyit.data.model.Farmer;
import com.buyit.buyit.dtos.requests.*;
import com.buyit.buyit.dtos.response.*;
import com.buyit.buyit.service.FarmerService;
import com.buyit.buyit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("farmers/"))
public class FarmerController {

    @Autowired
    private FarmerService farmerService;
    @Autowired
    private ProductService productService;

    @PostMapping("register/")
    public ResponseEntity<?> farmersRegistration(@RequestBody FarmerRegisterRequest request) {
        try{
            FarmerRegisterResponse response = farmerService.registerFarmer(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/")
    public ResponseEntity<?> farmersLogin(@RequestBody FarmerLoginRequest request) {
        try{
            FarmerLoginResponse response = farmerService.loginFarmer(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add-products/")
    public ResponseEntity<?> addNewProduct(@RequestBody AddProductRequest request) {
        try{
            AddProductResponse response = productService.addProduct(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("search-products/")
    public ResponseEntity<?> searchProductByName(@RequestParam SearchByNameRequest request) {
        try{
            SearchByNameResponse response = productService.searchByName(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete-product/")
    public ResponseEntity<?> deleteProducts(@RequestBody DeleteProductRequest request) {
        try{
            DeleteProductResponse response = productService.deleteProduct(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
