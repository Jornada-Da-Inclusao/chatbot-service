package com.integrakids.chatbot_service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ChatBotRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void startDeveRetornar200() throws Exception {

        mockMvc.perform(get("/api/chat/start"))
                .andExpect(status().isOk());
    }

    @Test
    void messageDeveRetornar200() throws Exception {

        mockMvc.perform(post("/api/chat/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "sessionId":"123",
                      "text":"oi"
                    }
                """))
                .andExpect(status().isOk());
    }
}