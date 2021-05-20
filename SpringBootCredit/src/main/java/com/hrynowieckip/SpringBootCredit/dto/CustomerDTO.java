package com.hrynowieckip.SpringBootCredit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private String firstName;
    private String surname;
    private String pesel;

}
