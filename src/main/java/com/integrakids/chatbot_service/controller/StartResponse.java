package com.integrakids.chatbot_service.controller;

import com.integrakids.chatbot_service.model.Message;

public class StartResponse {
    public final String sessionId;
    public final Message welcomeMessage;

    public StartResponse(String sessionId, Message welcomeMessage) {
        this.sessionId = sessionId;
        this.welcomeMessage = welcomeMessage;
    }
}
