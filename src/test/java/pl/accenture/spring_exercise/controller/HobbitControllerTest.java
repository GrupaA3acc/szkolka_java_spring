package pl.accenture.spring_exercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.accenture.spring_exercise.model.Hobbit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    void shouldReturnBilboBaginsById_hobbit_GET() throws Exception {
        MvcResult response = mockMvc.perform(
                 get("/hobbit/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Hobbit resultHobbit = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit.class);
        assertEquals(new Hobbit(1L,"Bilbo","Bagins",98,120d), resultHobbit);
    }
}