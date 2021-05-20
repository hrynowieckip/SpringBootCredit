package com.hrynowieckip.SpringBootProduct.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductContoller.class)
class ProductContollerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductContoller productContoller;

    @Test
    @DisplayName("Testing /createproduct")
    void Test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/createproduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"creditId\": 1, \"productName\": \"productNaaame\", \"value\": 56456 }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Testing /getproducts")
    void Test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getproducts"))
                .andExpect(status().isOk());
    }
}