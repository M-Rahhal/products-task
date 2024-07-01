package com.task.Products_App.controller;


import com.task.Products_App.entity.Product;
import com.task.Products_App.req.AddProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable int id) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return null;
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequest request) {
        return null;
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateProduct(
            @RequestBody AddProductRequest request , @PathVariable int id) {
        return null;
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return null;
    }


}
