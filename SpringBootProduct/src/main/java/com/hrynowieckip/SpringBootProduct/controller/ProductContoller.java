package com.hrynowieckip.SpringBootProduct.controller;

import com.hrynowieckip.SpringBootProduct.model.Product;
import com.hrynowieckip.SpringBootProduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductContoller {
    private final ProductRepository productRepository;
    @PostMapping("/createproduct")
    public void createProduct(@RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping("/getproducts")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
