package com.integrakids.chatbot_service.model;

public class QuickAction {
    public final String label;  // texto exibido no botão
    public final String value;  // texto enviado ao clicar

    public QuickAction(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + label + "]";
    }
}