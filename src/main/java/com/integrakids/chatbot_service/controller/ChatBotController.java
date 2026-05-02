package com.integrakids.chatbot_service.controller;

import java.util.ArrayList;
import java.util.List;

import com.integrakids.chatbot_service.model.BotEmotion;
import com.integrakids.chatbot_service.model.ConversationPhase;
import com.integrakids.chatbot_service.model.LeadInfo;
import com.integrakids.chatbot_service.model.Message;
import com.integrakids.chatbot_service.model.SDRResponse;
import com.integrakids.chatbot_service.service.QuickActionsConfig;
import com.integrakids.chatbot_service.service.SDREngine;

public class ChatBotController {

    // ── Estado da conversa ───────────────────────────────────────────────
    private final List<Message> messages = new ArrayList<>();
    private ConversationPhase phase = ConversationPhase.WELCOME;
    private final LeadInfo lead = new LeadInfo();
    private int msgCount = 0;

    private BotEmotion lastEmotion = BotEmotion.NEUTRAL;

    private static final String WELCOME = "Ola! Sou o assistente da IntegraKids\n" +
            "Posso te ajudar com dúvidas sobre a plataforma web e aplicativo.\n" +
            "O que traz voce aqui hoje?";

    public ChatBotController() {
        // mensagem inicial já entra no histórico
        messages.add(new Message(
                Message.Role.BOT,
                WELCOME,
                QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS,
                BotEmotion.NEUTRAL));
    }

    // ── Envia mensagem e retorna a resposta do bot ───────────────────────
    public Message send(String input) {
        input = input.trim();
        if (input.isEmpty())
            return null;

        // 1. registra mensagem do usuário
        messages.add(new Message(Message.Role.USER, input));
        msgCount++;

        // 2. processa pelo motor
        SDRResponse response = SDREngine.process(input, phase, lead, msgCount);

        lastEmotion = response.emotion;

        // 3. atualiza estado
        phase = response.nextPhase;
        if (response.leadUpdate != null) {
            lead.merge(response.leadUpdate);
        }

        // 4. registra e retorna resposta do bot
        Message botMsg = new Message(
                Message.Role.BOT,
                response.text,
                response.quickActions,
                response.emotion);
        messages.add(botMsg);
        return botMsg;
    }

    // ── Getters úteis para debug ─────────────────────────────────────────
    public List<Message> getMessages() {
        return messages;
    }

    public ConversationPhase getPhase() {
        return phase;
    }

    public LeadInfo getLead() {
        return lead;
    }

    public BotEmotion getLastEmotion() {
        return lastEmotion;
    }

}