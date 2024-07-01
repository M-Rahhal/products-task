package com.task.Products_App.service;


import com.task.Products_App.entity.Product;
import com.task.Products_App.repo.ProductRepository;
import com.task.Products_App.req.AddProductRequest;
import com.task.Products_App.req.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(AddProductRequest request) {
        if (request.name().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (request.price() <= 0 )
            throw new IllegalArgumentException("Price cannot be negative or Zero!");

        Product product = Product.builder()
                .price(BigDecimal.valueOf(request.price()))
                .name(request.name())
                .description(request.description())
                .build();
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(UpdateProductRequest request , int id) {
        Optional<Product> obj = productRepository.findById(id);
        if (obj.isEmpty())
            throw new IllegalArgumentException("Product not found!");

        Product product = obj.get();
        product.setName(request.name()==null?product.getName():request.name());
        product.setDescription(request.description()==null?product.getDescription():request.description());
        product.setPrice(request.price() == null? product.getPrice():BigDecimal.valueOf(request.price()));
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> obj = productRepository.findById(id);
        if (obj.isEmpty())
            throw new IllegalArgumentException("Product not found!");
        return obj.get();
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }


}
