package com.example.springProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.service.ProductService;
import com.example.springProject.model.Product;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product geProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        service.addProduct(product);
        return "Product added successfully";
    }

    @PutMapping("/products/{prodId}")
    public Product updateProduct(@PathVariable int prodId, @RequestBody Product product){
        return service.updateProduct(prodId, product);
    }

    @DeleteMapping("/products/{prodId}")
    public String deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
        return "Product deleted successfully!";
    }
}
