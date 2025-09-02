package com.spongestack.api.spongestack.service;

import java.util.List;

import com.spongestack.api.spongestack.entity.Product;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product saveProduct(Product product);

    Void deleteProduct(Long id);
}
