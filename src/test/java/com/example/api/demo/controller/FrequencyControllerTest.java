package com.example.api.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFrequencyCalculation() throws Exception {
        String input = "aaaaabcccc";
        String expectedOutput = "[{\"character\":\"a\",\"frequency\":5},{\"character\":\"c\",\"frequency\":4},{\"character\":\"b\",\"frequency\":1}]";

        mockMvc.perform(post("/api/frequency")
                        .contentType("text/plain")
                        .content(input))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedOutput));
    }
}
