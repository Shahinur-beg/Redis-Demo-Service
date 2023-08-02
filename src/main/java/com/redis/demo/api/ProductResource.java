package com.redis.demo.api;

import com.redis.demo.domain.entity.Product;
import com.redis.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shahinur Beg
 * Created date : 7/4/2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductResource {
    private final ProductService productService;

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/find/all")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/find/by/id/{id}")
    public Product findById(@PathVariable Integer id){
        return productService.findById(id);
    }

    @DeleteMapping("/delete/by/id/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
