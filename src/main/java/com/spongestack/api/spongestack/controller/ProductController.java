package com.spongestack.api.spongestack.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import com.spongestack.api.spongestack.entity.Product;
import com.spongestack.api.spongestack.service.JpaProductService;
import com.spongestack.api.spongestack.service.ProductService;

@Controller
public class ProductController {
   
    private final ProductService productService;

    public ProductController(JpaProductService productService) {
        this.productService = productService;
    }

    @QueryMapping("products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping("productById")
    public Product getProductById(@Argument Long id) {
        return productService.getProductById(id);
    }
    
    @MutationMapping("saveProduct")
    public Product saveProduct(@Argument Product product) {
        System.out.println("Saving product: " + product); // Debug log
        Product savedProduct = productService.saveProduct(product);
        System.out.println("Saved product: " + savedProduct); // Debug log
        return savedProduct;
    }
}