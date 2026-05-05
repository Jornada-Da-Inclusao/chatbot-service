package com.integrakids.chatbot_service.model;

import java.util.List;

public class Message {

    public enum Role { BOT, USER }

    public final Role role;
    public final String text;
    public final List<QuickAction> quickActions;
    public final BotEmotion emotion;              
    
    // construtor sem quickActions (mensagem do usuário)
    public Message(Role role, String text) {
        this.role         = role;
        this.text         = text;
        this.quickActions = null;
        this.emotion      = null;
    }

    // construtor com quickActions (sem emotion — compatibilidade)
    public Message(Role role, String text, List<QuickAction> quickActions) {
        this.role         = role;
        this.text         = text;
        this.quickActions = quickActions;
        this.emotion      = null;
    }

    // construtor completo ← adicionar
    public Message(Role role, String text, List<QuickAction> quickActions, BotEmotion emotion) {
        this.role         = role;
        this.text         = text;
        this.quickActions = quickActions;
        this.emotion      = emotion;
    }

    @Override
    public String toString() {
        String prefix = (role == Role.BOT) ? "[BOT] " : "[VOCÊ] ";
        return prefix + text;
    }
}