package com.integrakids.chatbot_service.controller;

public class MessageRequest {
    private String text;
    private String sessionId;
    
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
