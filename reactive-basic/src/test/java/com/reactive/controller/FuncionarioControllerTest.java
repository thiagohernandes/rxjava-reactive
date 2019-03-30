package com.reactive.controller;

import com.reactive.app.ReactiveBasicApplication;
import com.reactive.model.Funcionario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = ReactiveBasicApplication.class)
public class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String URL = "http://localhost:8080/api/funcionarios";

    @Test
    public void allFuncionarios() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .accept(MediaType.APPLICATION_STREAM_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
    }
}
