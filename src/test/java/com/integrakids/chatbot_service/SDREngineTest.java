package com.integrakids.chatbot_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.integrakids.chatbot_service.model.ConversationPhase;
import com.integrakids.chatbot_service.model.LeadInfo;
import com.integrakids.chatbot_service.model.SDRResponse;
import com.integrakids.chatbot_service.service.SDREngine;

public class SDREngineTest {

    @Test
    void deveReconhecerSaudacao() {

        SDRResponse r = SDREngine.process(
                "oi",
                ConversationPhase.WELCOME,
                new LeadInfo(),
                1
        );

        assertTrue(r.text.toLowerCase().contains("ola"));
    }

    @Test
    void deveResponderFallback() {

        SDRResponse r = SDREngine.process(
                "xpto123",
                ConversationPhase.WELCOME,
                new LeadInfo(),
                1
        );

        assertTrue(r.text.toLowerCase().contains("compreendi")
                || r.text.toLowerCase().contains("desculpe"));
    }

    @Test
    void deveEntrarEmCapturaLead() {

        SDRResponse r = SDREngine.process(
                "quero falar com especialista",
                ConversationPhase.WELCOME,
                new LeadInfo(),
                1
        );

        assertEquals(
                ConversationPhase.LEAD_CAPTURE_NAME,
                r.nextPhase
        );
    }
}