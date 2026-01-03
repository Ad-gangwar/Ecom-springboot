package com.example.springProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.service.ProductService;
import com.example.springProject.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        return ResponseEntity.ok(service.getProductById(prodId));
    }

    @PostMapping("")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        service.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @PutMapping("/{prodId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int prodId, @RequestBody Product product){
        return ResponseEntity.ok(service.updateProduct(prodId, product));
    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
