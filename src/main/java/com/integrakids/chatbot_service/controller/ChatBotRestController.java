package com.integrakids.chatbot_service.controller;

import com.integrakids.chatbot_service.model.Message;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatBotRestController {

    private final Map<String, ChatBotController> sessions = new ConcurrentHashMap<>();

    @PostMapping("/message")
    public Message sendMessage(@RequestBody MessageRequest request) {
        // pega ou cria uma sessão para esse usuário
        ChatBotController chatbot = sessions.computeIfAbsent(
                request.getSessionId(),
                id -> new ChatBotController());
        return chatbot.send(request.getText());
    }

    @GetMapping("/start")
    public StartResponse startConversation() {
        String sessionId = UUID.randomUUID().toString();
        ChatBotController chatbot = new ChatBotController();
        sessions.put(sessionId, chatbot);

        return new StartResponse(
                sessionId,
                chatbot.getMessages().get(0));
    }
}