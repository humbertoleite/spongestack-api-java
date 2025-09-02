package com.spongestack.api.spongestack.service;

import com.spongestack.api.spongestack.entity.Product;
import com.spongestack.api.spongestack.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaProductService  implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;
    
   @Override
   public List<Product> getAllProducts() {
        return productRepository.findAll();
   }

   @Override
   public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
   }

   @Override
   public Product saveProduct(Product product) {
        return productRepository.save(product);
   }

   @Override
   public Void deleteProduct(Long id) {
        productRepository.deleteById(id);
        return null;
   }
}
