package com.hrynowieckip.SpringBootCustomer.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerController customerController;

    @Test
    @DisplayName("Testing /createcustomer")
    void Test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/createcustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"creditId\": 1, \"firstName\": \"John\", \"pesel\": \"456456456\", \"surname\": \"Nhoj\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Testing /getcustomers")
    void Test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getcustomers"))
                .andExpect(status().isOk());
    }
}