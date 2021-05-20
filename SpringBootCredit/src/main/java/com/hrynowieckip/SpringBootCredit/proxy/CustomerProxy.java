package com.hrynowieckip.SpringBootCredit.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerProxy {
    private int creditId;
    private String firstName;
    private String pesel;
    private String surname;
}
