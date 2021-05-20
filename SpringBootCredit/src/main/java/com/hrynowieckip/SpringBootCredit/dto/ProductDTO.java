package com.hrynowieckip.SpringBootCredit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String productName;
    private int value;
}
