package com.integrakids.chatbot_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.integrakids.chatbot_service.controller.ChatBotController;
import com.integrakids.chatbot_service.model.Message;

public class ChatBotControllerTest {

    @Test
    void deveCriarMensagemInicial() {

        ChatBotController bot = new ChatBotController();

        assertEquals(1, bot.getMessages().size());
    }

    @Test
    void deveResponderOi() {

        ChatBotController bot = new ChatBotController();

        Message resposta = bot.send("oi");

        assertNotNull(resposta);
        assertTrue(resposta.text.toLowerCase().contains("ola"));
    }

    @Test
    void naoDeveAceitarVazio() {

        ChatBotController bot = new ChatBotController();

        Message resposta = bot.send("");

        assertNull(resposta);
    }
}