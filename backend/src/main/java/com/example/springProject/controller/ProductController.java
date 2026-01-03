package com.example.springProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springProject.service.ProductService;
import com.example.springProject.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
        return ResponseEntity.ok(service.getProductById(prodId));
    }

    @PostMapping("")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        try {
            Product prod = service.addProduct(product, imageFile);
            return new ResponseEntity<>(prod, HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PutMapping("/{prodId}")
    // public ResponseEntity<Product> updateProduct(@PathVariable int prodId, @RequestBody Product product) {
    //     return ResponseEntity.ok(service.updateProduct(prodId, product));
    // }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId) {
        Product product = service.getProductById(prodId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        service.deleteProduct(prodId);
        return ResponseEntity.ok("Product deleted successfully!");
    }

    @GetMapping("/{prodId}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int prodId) {
        return ResponseEntity.ok(service.getProductByImage(prodId));
    }

    @PutMapping("/{prodId}")
    public ResponseEntity<String> updateProduct(@PathVariable int prodId, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product updatedProduct = null;

        try {
            updatedProduct = service.updateProduct(prodId, product, imageFile);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        if (updatedProduct != null) {
            return ResponseEntity.ok("Updated");
        } else {
            return ResponseEntity.badRequest().body("Product not found");
        }
    }
}
