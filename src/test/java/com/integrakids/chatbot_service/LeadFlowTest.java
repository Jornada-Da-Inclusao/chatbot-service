package com.integrakids.chatbot_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.integrakids.chatbot_service.controller.ChatBotController;
import com.integrakids.chatbot_service.model.ConversationPhase;

public class LeadFlowTest {

    @Test
    void deveCapturarLeadCompleto() {

        ChatBotController bot = new ChatBotController();

        bot.send("quero especialista");
        bot.send("Marcos Vinicius");
        bot.send("IntegraKids");
        bot.send("marcos@email.com");
        bot.send("11999999999");

        assertTrue(bot.getLead().isComplete());
    }

    @Test
    void deveMudarFase() {

        ChatBotController bot = new ChatBotController();

        bot.send("quero especialista");

        assertEquals(
                ConversationPhase.LEAD_CAPTURE_NAME,
                bot.getPhase()
        );
    }
}