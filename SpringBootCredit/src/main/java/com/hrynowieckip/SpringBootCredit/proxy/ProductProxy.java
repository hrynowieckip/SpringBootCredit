package com.hrynowieckip.SpringBootCredit.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductProxy {
    private int creditId;
    private String productName;
    private int value;
}
