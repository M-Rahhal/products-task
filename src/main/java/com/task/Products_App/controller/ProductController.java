package com.task.Products_App.controller;


import com.task.Products_App.entity.Product;
import com.task.Products_App.req.AddProductRequest;
import com.task.Products_App.req.UpdateProductRequest;
import com.task.Products_App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable int id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody AddProductRequest request) {
        try {
            Product product = productService.addProduct(request);
            return ResponseEntity.ok(product.toString());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateProduct(
            @RequestBody UpdateProductRequest request, @PathVariable int id){
        try {
            Product product = productService.updateProduct(request , id);
            return ResponseEntity.ok(product.toString());
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }


}
