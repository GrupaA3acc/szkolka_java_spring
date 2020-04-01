package pl.accenture.spring_exercise.controller;

import com.fasterxml.jackson.core.type.TypeReference;
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

import java.util.Arrays;
import java.util.List;

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
                 get("/hobbit/id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Hobbit resultHobbit = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit.class);
        assertEquals(new Hobbit(1L,"Bilbo","Bagins",98,120d), resultHobbit);
    }

    @Test
    void shouldReturnNullHobbit_Hobbit_GET() throws Exception {
        MvcResult response = mockMvc.perform(
                get("/hobbit/id/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Hobbit resultHobbit = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit.class);
        assertEquals(new Hobbit(null,null,null,null,null), resultHobbit);
    }

    @Test
    void shouldReturnListWithTwoHobbits_Hobbit_GET() throws Exception {
        MvcResult response = mockMvc.perform(
                get("/hobbit/lastname/Bagins")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        List<Hobbit> hobbitList = Arrays.asList(OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit[].class));
        assertEquals(2,hobbitList.size());
    }

    @Test
    void shouldReturn5XXError_Hobbit_Get() throws Exception {
        MvcResult respone = mockMvc.perform(
                post("/hobbit/id/1")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed())
                .andDo(print())
                .andReturn();

    }
}