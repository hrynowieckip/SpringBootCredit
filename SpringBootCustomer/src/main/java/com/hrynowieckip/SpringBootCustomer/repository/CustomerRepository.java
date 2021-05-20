package com.hrynowieckip.SpringBootCustomer.repository;

import com.hrynowieckip.SpringBootCustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
