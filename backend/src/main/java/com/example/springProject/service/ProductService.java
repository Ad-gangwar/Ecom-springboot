package com.example.springProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.Arrays;
import com.example.springProject.model.Product;
import com.example.springProject.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    // List<Product> products = new ArrayList<Product>(Arrays.asList(new Product(1, "Laptop",50000),
    //                                        new Product(2, "Smartphone", 15000),
    //                                        new Product(3, "Tablet", 20000)));
    public List<Product>getProducts(){
        // return products;
        return repo.findAll();
    }

    public Product getProductById(int prodId){
        // return products.stream().filter(p -> p.getProdId() == prodId).findFirst().orElse(null);
        return repo.findById(prodId).orElse(null);
    }

    public void addProduct(Product product){
        // products.add(product);
        if(product != null) repo.save(product);
    }

    public Product updateProduct(int prodId, Product product){
        // for(int i=0; i<products.size(); i++){
        //     if(products.get(i).getProdId() == prodId){
        //         products.set(i, product);
        //         return products.get(i);
        //     }
        // }
        // return null;
        Product reqProduct = repo.findById((prodId)).orElse(null);
        if(reqProduct != null && product != null){
            repo.save(product);
            return reqProduct;
        }
        else return null;
    }

    public void deleteProduct(int prodId){
        // int index = 0;
        // for(int i=0; i<products.size(); i++){
        //     if(products.get(i).getProdId() == prodId){
        //         index = i;
        //     }
        // }
        // products.remove(index);
        repo.deleteById(prodId);
    }
}
