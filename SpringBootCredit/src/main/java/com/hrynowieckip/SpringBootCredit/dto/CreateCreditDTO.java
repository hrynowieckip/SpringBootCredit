package com.hrynowieckip.SpringBootCredit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCreditDTO {
    private CustomerDTO customer;
    private ProductDTO product;
    private CreditDTO credit;
}
