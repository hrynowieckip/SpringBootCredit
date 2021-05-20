package com.hrynowieckip.SpringBootCredit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCreditsListDTO {
    private CustomerDTO customer;
    private ProductDTO product;
    private CreditDTO credit;

}
