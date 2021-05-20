package com.hrynowieckip.SpringBootProduct.repository;

import com.hrynowieckip.SpringBootProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
