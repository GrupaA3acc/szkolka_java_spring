package pl.accenture.spring_exercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.accenture.spring_exercise.domain.Hobbit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class HobbitControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    MockMvc mockMvc;

    @Test
    void pokazHobbita() throws Exception {
        MvcResult response = mockMvc.perform
                (get("/hobbit")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Hobbit hobbit = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit.class);

        assertEquals(new Hobbit(1L,"Bilbo", "Baggins", true), hobbit);
    }
}