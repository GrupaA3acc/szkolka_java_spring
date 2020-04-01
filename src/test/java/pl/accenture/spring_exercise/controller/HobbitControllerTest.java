package pl.accenture.spring_exercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.accenture.spring_exercise.entity.Hobbit;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void powinienZwrocicFrodoBaggins_hobbit_GET() throws Exception{

        MvcResult response = mockMvc.perform(
                get("/hobbit/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Hobbit hobbit = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit.class);

        //assertEquals(new Hobbit(1F,"Frodo", "Baggins"), hobbit);
        assertEquals("Frodo", hobbit.getName());
        assertEquals("Baggins", hobbit.getLastName());
    }

}