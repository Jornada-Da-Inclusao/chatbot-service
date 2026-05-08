package com.integrakids.chatbot_service.service;

import java.util.List;

import com.integrakids.chatbot_service.handler.LeadCaptureHandler;
import com.integrakids.chatbot_service.model.BotEmotion;
import com.integrakids.chatbot_service.model.ConversationPhase;
import com.integrakids.chatbot_service.model.LeadInfo;
import com.integrakids.chatbot_service.model.QuickAction;
import com.integrakids.chatbot_service.model.SDRResponse;
import com.integrakids.chatbot_service.util.TextNormalizer;

public class SDREngine {

        private SDREngine() {
        }

        public static SDRResponse process(String input,
                        ConversationPhase phase,
                        LeadInfo lead,
                        int msgCount) {

                String lower = TextNormalizer.normalize(input);

                // ── 1. Fases de captura de lead ──────────────────────────────────
                if (phase == ConversationPhase.LEAD_CAPTURE_NAME
                                || phase == ConversationPhase.LEAD_CAPTURE_COMPANY
                                || phase == ConversationPhase.LEAD_CAPTURE_EMAIL
                                || phase == ConversationPhase.LEAD_CAPTURE_PHONE) {
                        return LeadCaptureHandler.handle(phase, input, lead);
                }

                // ── 2. Lead já capturado tentando contato de novo ────────────────
                if (lead.isComplete()
                                && lower.matches(".*(falar|contato|especialista|agendar|diagnostico).*")) {
                        return new SDRResponse(
                                        "Ja temos seus dados, " + lead.nome + "!\n" +
                                                        "Nosso especialista entrara em contato pelo e-mail "
                                                        + lead.email + " em breve.\n\n" +
                                                        "Posso te ajudar com mais alguma duvida?",
                                        ConversationPhase.LEAD_CAPTURED,
                                        QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS, null, BotEmotion.CHAD);
                }

                // ── 3. Intenção de contato (lead ainda não capturado) ────────────
                if (lower.matches(".*(falar|contato|especialista|agendar|diagnostico).*")) {
                        return new SDRResponse(
                                        "Otimo! Vou te conectar com nossos especialistas!\n\n" +
                                                        "Para isso, preciso de algumas informacoes.\n" +
                                                        "Qual e o seu nome completo?",
                                        ConversationPhase.LEAD_CAPTURE_NAME, null, null, BotEmotion.SEARCHING);
                }

                // ── 4. Knowledge base ────────────────────────────────────────────
                KnowledgeBaseService kb = new KnowledgeBaseService();
                String kbResult = kb.findMatch(lower);
                if (kbResult != null) {
                        if (kbResult.equals(KnowledgeBaseService.TRIGGER_LEAD)) {
                                if (lead.isComplete()) {
                                        return new SDRResponse(
                                                        "Ja temos seus dados, " + lead.nome
                                                                        + "! Nosso especialista liga em breve.",
                                                        ConversationPhase.LEAD_CAPTURED,
                                                        QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS, null,
                                                        BotEmotion.CHAD);
                                }
                                return new SDRResponse(
                                                "Otimo! Para agendar um diagnostico gratuito, qual e o seu nome completo?",
                                                ConversationPhase.LEAD_CAPTURE_NAME);
                        }
                        ConversationPhase next = (phase == ConversationPhase.LEAD_CAPTURED)
                                        ? ConversationPhase.LEAD_CAPTURED
                                        : ConversationPhase.EXPLORING;
                        List<QuickAction> actions = resolveQuickActions(lower);
                        return new SDRResponse(kbResult, next, actions, null, BotEmotion.NEUTRAL);
                }

                // ── 5. Saudação ──────────────────────────────────────────────────
                if (lower.matches("^(oi|ola|hey|hello|hi|bom dia|boa tarde|boa noite|e ai|eai).*")) {
                        return new SDRResponse(
                                        "Ola! Que bom ter voce aqui!\n\n" +
                                                        "Sou o assistente do IntegraKids. Como posso te ajudar hoje?",
                                        ConversationPhase.EXPLORING,
                                        QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS, null, BotEmotion.NEUTRAL);
                }

                // ── 6. Agradecimento ─────────────────────────────────────────────
                if (lower.matches(".*(obrigad|valeu|thanks|brigad|agradec).*")) {
                        String extra = lead.isComplete() ? "" : "\nLembre-se: oferecemos diagnostico gratuito!";
                        return new SDRResponse(
                                        "De nada! Fico feliz em ajudar." + extra + "\n\nEstou por aqui!",
                                        phase, null, null, BotEmotion.HAPPY);
                }

                // ── 7. Afirmativo ────────────────────────────────────────────────
                if (lower.matches("^(sim|quero|pode|claro|com certeza|vamos|bora|yes|ok).*")) {
                        if (phase == ConversationPhase.SOLUTION) {
                                if (lead.isComplete()) {
                                        return new SDRResponse(
                                                        "Perfeito, " + lead.nome
                                                                        + "! Nosso especialista liga em breve.",
                                                        ConversationPhase.LEAD_CAPTURED,
                                                        QuickActionsConfig.CONTINUE_EXPLORING_ACTIONS, null,
                                                        BotEmotion.EXCITED);
                                }
                                return new SDRResponse(
                                                "Perfeito! Qual e o seu nome completo?",
                                                ConversationPhase.LEAD_CAPTURE_NAME, null, null, BotEmotion.INTELECT);
                        }
                        if (phase == ConversationPhase.LEAD_CAPTURED) {
                                return new SDRResponse(
                                                "Claro! Sobre o que gostaria de saber mais?\n" +
                                                                "Posso ajudar com o app, atividades, acessibilidade ou suporte.",
                                                ConversationPhase.LEAD_CAPTURED,
                                                QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS, null, BotEmotion.HAPPY);
                        }
                        return new SDRResponse(
                                        "Otimo! Para te orientar melhor: voce e pai, professor ou profissional de saude?",
                                        ConversationPhase.QUALIFYING_INFRA,
                                        QuickActionsConfig.QUALIFY_INFRA_ACTIONS, null, BotEmotion.INTELECT);
                }

                // ── 8. Negativo ──────────────────────────────────────────────────
                if (lower.matches("^(nao|nao|agora nao|depois|no).*")) {
                        ConversationPhase next = (phase == ConversationPhase.LEAD_CAPTURED)
                                        ? ConversationPhase.LEAD_CAPTURED
                                        : ConversationPhase.GENERAL;
                        return new SDRResponse(
                                        "Sem problemas! Estou aqui quando precisar.\n" +
                                                        "Pode perguntar sobre o app, acessibilidade, atividades ou suporte.",
                                        next,
                                        QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS, null, BotEmotion.SAD);
                }

                // ── 9. Fase qualifying_infra ─────────────────────────────────────
                if (phase == ConversationPhase.QUALIFYING_INFRA) {
                        String perfil = "desconhecido";
                        if (lower.matches(".*(pai|mae|responsavel|familiar).*"))
                                perfil = "responsavel";
                        else if (lower.matches(".*(professor|escola|sala).*"))
                                perfil = "professor";
                        else if (lower.matches(".*(saude|terapeuta|especial).*"))
                                perfil = "profissional";

                        LeadInfo update = new LeadInfo();
                        update.infra = perfil; // reutiliza o campo infra para guardar o perfil
                        return new SDRResponse(
                                        "Entendido! Qual a faixa etaria da crianca?",
                                        ConversationPhase.QUALIFYING_SERVERS,
                                        QuickActionsConfig.QUALIFY_SERVER_ACTIONS,
                                        update, BotEmotion.INTELECT);
                }

                // ── 10. Fase qualifying_servers ──────────────────────────────────
                if (phase == ConversationPhase.QUALIFYING_SERVERS) {
                        LeadInfo update = new LeadInfo();
                        update.servidores = input.trim();
                        return new SDRResponse(
                                        "Obrigado! Quais sao as principais dificuldades que a crianca enfrenta hoje?",
                                        ConversationPhase.QUALIFYING_PAIN,
                                        QuickActionsConfig.QUALIFY_PAIN_ACTIONS,
                                        update, BotEmotion.INTELECT);
                }

                // ── 11. Fase qualifying_pain → gera solução ──────────────────────
                if (phase == ConversationPhase.QUALIFYING_PAIN) {
                        String solution;
                        if (lower.matches(".*(leitura|alfabetiz|letra|silaba).*")) {
                                solution = "O IntegraKids tem atividades especificas para alfabetizacao!\n" +
                                                "Exercicios de leitura adaptados ao ritmo da crianca.";
                        } else if (lower.matches(".*(tea|autis|espectro).*")) {
                                solution = "A plataforma foi desenvolvida com suporte para TEA!\n" +
                                                "Linguagem simples, estrutura previsivel e estimulos controlados.";
                        } else if (lower.matches(".*(engaj|motivac|atencao|concentr).*")) {
                                solution = "Temos atividades interativas e gamificadas!\n" +
                                                "Desenvolvidas para manter o engajamento e a motivacao da crianca.";
                        } else if (lower.matches(".*(inclusao|sala|professor|escola).*")) {
                                solution = "O app e uma otima ferramenta de apoio em sala de aula!\n" +
                                                "Permite personalizacao por aluno e acompanhamento de turma.";
                        } else {
                                solution = "Com base no que voce descreveu, o IntegraKids pode ajudar!\n" +
                                                "Atividades adaptativas, relatorios de progresso e suporte a diferentes perfis.";
                        }
                        LeadInfo update = new LeadInfo();
                        update.problema = input.trim();
                        return new SDRResponse(
                                        solution + "\n\nQuer agendar um diagnóstico gratuito com um especialista?",
                                        ConversationPhase.SOLUTION,
                                        QuickActionsConfig.POST_SOLUTION_ACTIONS,
                                        update, BotEmotion.INTELECT);
                }

                // ── 12. SDR nudge a cada 5 mensagens ────────────────────────────
                if (msgCount > 0 && msgCount % 5 == 0 && !lead.isComplete()) {
                        return new SDRResponse(
                                        "A proposito, posso te ajudar a encontrar a atividade certa para a crianca!\n" +
                                                        "Quer que eu te oriente com base no perfil dela?",
                                        ConversationPhase.EXPLORING,
                                        QuickActionsConfig.POST_SOLUTION_ACTIONS,
                                        null, BotEmotion.INTELECT);
                }

                // ── 13. Fallback ─────────────────────────────────────────────────
                ConversationPhase next = (phase == ConversationPhase.LEAD_CAPTURED)
                                ? ConversationPhase.LEAD_CAPTURED
                                : ConversationPhase.EXPLORING;
                return new SDRResponse(
                                "Me desculpe, mas acho que não compreendi o que você deseja.\n\nMe conta mais sobre o que voce precisa!\n\n",
                                next,
                                QuickActionsConfig.INTEGRAKIDS_WELCOME_ACTIONS, null, BotEmotion.CONFUSED);
        }

        // ── Resolve QuickActions pelo tema da pergunta ───────────────────
        private static List<QuickAction> resolveQuickActions(String lower) {

                // Jogos específicos primeiro — evita repetir a listagem geral
                if (lower.matches(".*(jogo da memoria|como jogar memoria|jogo de pares|encontrar pares|cartas).*"))
                        return QuickActionsConfig.GAMES_ACTIONS;

                if (lower.matches(".*(jogo dos numeros|jogo de numeros|ordem crescente|ordenar numeros).*"))
                        return QuickActionsConfig.GAMES_ACTIONS;

                if (lower.matches(".*(jogo das letras|como jogar letras|vogais|identificar vogais).*"))
                        return QuickActionsConfig.GAMES_ACTIONS;

                if (lower.matches(".*(jogo das cores|como jogar cores|cor do animal|associar cores).*"))
                        return QuickActionsConfig.GAMES_ACTIONS;

                // Jogos - visão geral só se não for específico
                if (lower.matches(
                                ".*(quais jogos|que jogos|listar jogos|quantos jogos|jogos disponiveis|me fala os jogos|atividades).*"))
                        return QuickActionsConfig.GAMES_ACTIONS;

                // Acessibilidade
                if (lower.matches(
                                ".*(acessibilidade|tema|daltonismo|tamanho de texto|fonte|som|audio|protanomalia|deuteranomalia|baixa visao|modo escuro|dark mode).*"))
                        return QuickActionsConfig.ACCESSIBILITY_ACTIONS;

                // Perfil, avatar e conta
                if (lower.matches(
                                ".*(perfil|avatar|resultado|jogador|logout|sair da conta|boneco|criar avatar|editar avatar|trocar jogador|ver resultados).*"))
                        return QuickActionsConfig.PROFILE_ACTIONS;

                // Problemas tecnicos e suporte
                if (lower.matches(
                                ".*(erro|bug|nao funciona|travou|nao abre|nao carrega|problema|suporte|reportar|falha|nao loga|nao consigo entrar).*"))
                        return QuickActionsConfig.TECH_SUPPORT_ACTIONS;

                // Plataforma, acesso e download
                if (lower.matches(
                                ".*(ios|iphone|android|download|instalar|versao web|link|site|navegador|url|endereco web).*"))
                        return QuickActionsConfig.PLATFORM_ACTIONS;

                // Mascote Rigel
                if (lower.matches(".*(mascote|rigel|personagem|boneco do app|identidade visual|interface infantil).*"))
                        return QuickActionsConfig.MASCOT_ACTIONS;

                // Projeto, equipe e tecnologias
                if (lower.matches(
                                ".*(integrante|equipe|desenvolvedor|fatec|ods|projeto|tecnologia|scrum|kanban|github|arquitetura|backend|frontend|mysql|rabbitmq).*"))
                        return QuickActionsConfig.ABOUT_PROJECT_ACTIONS;

                // Cortesia e encerramento
                if (lower.matches(".*(obrigado|valeu|legal|otimo|era so|tchau|ate mais|ate logo|foi isso|e so isso).*"))
                        return QuickActionsConfig.FAREWELL_ACTIONS;

                // Usuário perdido ou primeira vez
                if (lower.matches(
                                ".*(perdido|nao sei mexer|como comeca|primeira vez|por onde comeco|nao sei usar|me ajuda a comecar).*"))
                        return QuickActionsConfig.CONTINUE_EXPLORING_ACTIONS;

                // Responsável preocupado com aprendizado
                if (lower.matches(
                                ".*(nao aprende|nao evolui|nao desenvolve|nao gosta de estudar|nao presta atencao|sem interesse).*"))
                        return QuickActionsConfig.QUALIFY_PAIN_ACTIONS;

                // Fallback genérico
                return QuickActionsConfig.CONTINUE_EXPLORING_ACTIONS;
        }
}