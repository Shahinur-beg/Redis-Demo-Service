package com.redis.demo.service;

import com.redis.demo.domain.entity.Product;
import com.redis.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shahinur Beg
 * Created date : 7/4/2023
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product){
       return productRepository.save(product);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Integer id){
        return productRepository.findById(id);
    }
    public void delete(Integer id){
        productRepository.delete(id);
    }
}
