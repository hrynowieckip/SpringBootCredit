package com.hrynowieckip.SpringBootCredit.controller;

import com.hrynowieckip.SpringBootCredit.dto.*;
import com.hrynowieckip.SpringBootCredit.model.Credit;
import com.hrynowieckip.SpringBootCredit.proxy.CustomerProxy;
import com.hrynowieckip.SpringBootCredit.proxy.ProductProxy;
import com.hrynowieckip.SpringBootCredit.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditRepository creditRepository;

    @PostMapping("/createcredit")
    public int createCredit(@RequestBody CreateCreditDTO createCreditDTO) {
        Credit credit = Credit.builder()
                .creditName(createCreditDTO.getCredit().getCreditName())
                .build();
        creditRepository.save(credit);


        ProductProxy productInputDTO = ProductProxy.builder()
                .creditId(credit.getId())
                .productName(createCreditDTO.getProduct().getProductName())
                .value(createCreditDTO.getProduct().getValue())
                .build();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(
                "http://localhost:8081/createproduct",
                productInputDTO,
                Void.class);

        CustomerProxy customerInputDTO = CustomerProxy.builder()
                .creditId(credit.getId())
                .firstName(createCreditDTO.getCustomer().getFirstName())
                .pesel(createCreditDTO.getCustomer().getPesel())
                .surname(createCreditDTO.getCustomer().getSurname())
                .build();

        restTemplate.postForObject(
                "http://localhost:8082/createcustomer",
                customerInputDTO,
                Void.class);

        return credit.getId();
    }

    @GetMapping("/getcredits")
    public List<GetCreditsListDTO> getCredits() {
        List<Credit> allCredits = creditRepository.findAll();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductProxy[]> responseProducts =
                restTemplate.getForEntity(
                        "http://localhost:8081/getproducts",
                        ProductProxy[].class);
        ProductProxy[] productInputDTOS = responseProducts.getBody();

        ResponseEntity<CustomerProxy[]> responseCustomers =
                restTemplate.getForEntity(
                        "http://localhost:8082/getcustomers",
                        CustomerProxy[].class);
        CustomerProxy[] customerInputDTOS = responseCustomers.getBody();

        List<GetCreditsListDTO> result = new ArrayList<>();

        for (int i = 0; i < allCredits.size(); i++) {
            ProductProxy productInputDTO = productInputDTOS[i];
            CustomerProxy customerInputDTO = customerInputDTOS[i];
            Credit credit = allCredits.get(i);
            GetCreditsListDTO build = GetCreditsListDTO.builder()
                    .customer(
                            CustomerDTO.builder()
                                    .firstName(customerInputDTO.getFirstName())
                                    .pesel(customerInputDTO.getPesel())
                                    .surname(customerInputDTO.getSurname())
                                    .build())
                    .product(
                            ProductDTO.builder()
                                    .productName(productInputDTO.getProductName())
                                    .value(productInputDTO.getValue())
                                    .build())
                    .credit(
                            CreditDTO.builder()
                                    .creditName(credit.getCreditName())
                                    .build())
                    .build();
            result.add(build);
        }

        return result;
    }
}
