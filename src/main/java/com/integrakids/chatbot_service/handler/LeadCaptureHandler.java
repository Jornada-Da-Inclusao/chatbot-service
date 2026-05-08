package com.integrakids.chatbot_service.handler;

import java.util.regex.Pattern;

import com.integrakids.chatbot_service.model.BotEmotion;
import com.integrakids.chatbot_service.model.ConversationPhase;
import com.integrakids.chatbot_service.model.LeadInfo;
import com.integrakids.chatbot_service.model.SDRResponse;
import com.integrakids.chatbot_service.service.QuickActionsConfig;

public class LeadCaptureHandler {

    private LeadCaptureHandler() {
    }

    public static SDRResponse handle(ConversationPhase phase,
            String input,
            LeadInfo lead) {
        switch (phase) {

            case LEAD_CAPTURE_NAME: {
                String nome = input.trim();
                if (nome.length() < 2) {
                    return new SDRResponse(
                            "Por favor, me informe seu nome completo. :)",
                            ConversationPhase.LEAD_CAPTURE_NAME,null,null,BotEmotion.SEARCHING);
                }
                LeadInfo update = new LeadInfo();
                update.nome = nome;
                return new SDRResponse(
                        "Prazer, " + nome + "! :)\n\nVoce e pai/responsavel, professor ou profissional de saude?",
                        ConversationPhase.LEAD_CAPTURE_COMPANY,
                        null,
                        update, BotEmotion.SEARCHING);
            }

            case LEAD_CAPTURE_COMPANY: {
                String empresa = input.trim();
                if (empresa.length() < 2) {
                    return new SDRResponse(
                            "Voce e pai/responsavel, professor ou profissional de saude?",
                            ConversationPhase.LEAD_CAPTURE_COMPANY,null, null, BotEmotion.SEARCHING);
                }
                LeadInfo update = new LeadInfo();
                update.empresa = empresa;
                return new SDRResponse(
                        empresa + " anotado!\n\nQual o melhor e-mail para contato?",
                        ConversationPhase.LEAD_CAPTURE_EMAIL,
                        null,
                        update, BotEmotion.SEARCHING);
            }

            case LEAD_CAPTURE_EMAIL: {
                String email = input.trim();
                boolean valido = Pattern.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+", email);
                if (!valido) {
                    return new SDRResponse(
                            "Esse e-mail nao parece valido. Pode verificar?",
                            ConversationPhase.LEAD_CAPTURE_EMAIL,null, null, BotEmotion.CONFUSED);
                }
                LeadInfo update = new LeadInfo();
                update.email = email;
                return new SDRResponse(
                        "E-mail anotado!\n\nQual o melhor telefone? (com DDD)",
                        ConversationPhase.LEAD_CAPTURE_PHONE,
                        null,
                        update, BotEmotion.SEARCHING);
            }

            case LEAD_CAPTURE_PHONE: {
                String apenasDigitos = input.trim().replaceAll("\\D", "");
                if (apenasDigitos.length() < 10) {
                    return new SDRResponse(
                            "O telefone precisa ter pelo menos 10 digitos com DDD.",
                            ConversationPhase.LEAD_CAPTURE_PHONE,null,null,BotEmotion.ANGER);
                }
                LeadInfo update = new LeadInfo();
                update.telefone = input.trim();
                String resumo = "Tudo anotado!\n\n"
                        + "Nome: " + lead.nome + "\n"
                        + "Perfil: " + lead.empresa + "\n"
                        + "E-mail: " + lead.email + "\n"
                        + "Telefone: " + input.trim() + "\n\n"
                        + "Um especialista entrará em contato em breve!\n\n"
                        +  "Posso ajudá-lo em mais alguma coisa?\n\n";
                return new SDRResponse(
                        resumo,
                        ConversationPhase.LEAD_CAPTURED,
                        QuickActionsConfig.CONTINUE_EXPLORING_ACTIONS,
                        update, BotEmotion.SATISFIED);
            }

            default:
                return null; // fase nao e de captura, SDREngine continua
        }
    }
}