package com.pc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WelcomeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome/prashant"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome prashant !!!")));
    }

    @Test
    void shouldReturnWelcomeMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome?name=Prashant"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome Prashant !!!")));
    }

    @Test
    void shouldReturnErrorMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome/"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
