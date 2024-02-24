package com.vikram.awsWebServiceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikram.awsWebServiceTest.controller.BookController;
import com.vikram.awsWebServiceTest.models.Book;
import com.vikram.awsWebServiceTest.repository.MySqlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {


    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testAddBook() throws Exception {
        Book bookToAdd = new Book(0L, "Test Book", "Test Author");
        MySqlRepository mySqlRepository = Mockito.mock(MySqlRepository.class);
        when(mySqlRepository.save(any(Book.class))).thenReturn(bookToAdd);
        BookController bookController = new BookController(mySqlRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookToAdd)))
                .andExpect(status().isCreated());
    }


    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

}
