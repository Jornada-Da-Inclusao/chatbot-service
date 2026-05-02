package com.integrakids.chatbot_service.model;

import java.util.List;

public class SDRResponse {
    public final String text;
    public final ConversationPhase nextPhase;
    public final List<QuickAction> quickActions; // pode ser null
    public final LeadInfo leadUpdate; // pode ser null

    public SDRResponse(String text, ConversationPhase nextPhase) {
        this(text, nextPhase, null, null, BotEmotion.NEUTRAL);
    }

    public SDRResponse(String text, ConversationPhase nextPhase,
            List<QuickAction> quickActions) {
        this(text, nextPhase, quickActions, null, BotEmotion.NEUTRAL);
    }

    public SDRResponse(String text, ConversationPhase nextPhase,
            List<QuickAction> quickActions, LeadInfo leadUpdate) {
        this(text, nextPhase, quickActions, leadUpdate, BotEmotion.NEUTRAL);
    }

    public final BotEmotion emotion;

    // atualiza o construtor completo
    public SDRResponse(String text, ConversationPhase nextPhase,
            List<QuickAction> quickActions, LeadInfo leadUpdate,
            BotEmotion emotion) {
        this.text = text;
        this.nextPhase = nextPhase;
        this.quickActions = quickActions;
        this.leadUpdate = leadUpdate;
        this.emotion = emotion;
    }
}