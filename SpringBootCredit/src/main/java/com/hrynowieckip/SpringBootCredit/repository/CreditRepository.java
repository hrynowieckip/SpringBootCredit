package com.hrynowieckip.SpringBootCredit.repository;

import com.hrynowieckip.SpringBootCredit.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
