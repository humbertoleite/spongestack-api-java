package com.spongestack.api.spongestack.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import com.spongestack.api.spongestack.entity.Product;
import com.spongestack.api.spongestack.entity.Status;
import com.spongestack.api.spongestack.service.ProductService;

@Controller
public class ProductController {
   
    private final ProductService productService;

    public ProductController(ProductService productService) {
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
    @Secured("ROLE_ADMIN")
    public Product saveProduct(@Argument Product product) {
        return productService.saveProduct(product);
    }
    
    @MutationMapping("deleteProduct")
    @Secured("ROLE_ADMIN")
    public Status deleteProduct(@Argument Long id) {
        try {
            if (productService.getProductById(id) == null) {
                return Status.builder()
                        .success(false)
                        .message("Product not found")
                        .build();
            }
            productService.deleteProduct(id);
            return Status.builder()
                    .success(true)
                    .message("Product deleted successfully")
                    .build();
        } catch (Exception e) {
            return Status.builder()
                    .success(false)
                    .message("Error: " + e.getMessage())
                    .build();
        }
    }
}