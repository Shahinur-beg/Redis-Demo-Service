package com.redis.demo.repository;

import com.redis.demo.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shahinur Beg
 * Created date : 7/4/2023
 */
@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private static final String HASH_KEY = "Product";
    private final RedisTemplate<String, Object> redisTemplate;

    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        List<Object> productList = redisTemplate.opsForHash().values(HASH_KEY);

        return productList.stream()
                .filter(obj -> obj instanceof Product)
                .map(obj -> (Product) obj)
                .collect(Collectors.toList());
    }

    public Product findById(Integer id){
        return (Product) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public void delete(Integer id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }

}
