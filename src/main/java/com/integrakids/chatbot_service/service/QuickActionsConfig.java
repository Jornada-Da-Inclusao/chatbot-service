package com.integrakids.chatbot_service.service;

import java.util.Arrays;
import java.util.List;

import com.integrakids.chatbot_service.model.QuickAction;

public class QuickActionsConfig {

    private QuickActionsConfig() {
    }

    public static final List<QuickAction> INTEGRAKIDS_WELCOME_ACTIONS = Arrays.asList(
            new QuickAction("O que e o IntegraKids", "O que e o IntegraKids"),
            new QuickAction("App e gratuito?", "O app e gratuito?"),
            new QuickAction("Atende criancas com TEA", "O app atende criancas com TEA?"),
            new QuickAction("Como acompanhar progresso", "Como acompanhar o progresso da crianca?"),
            new QuickAction("App nao funciona", "O app nao esta funcionando, o que fazer?"));

    public static final List<QuickAction> QUALIFY_INFRA_ACTIONS = Arrays.asList(
            new QuickAction("Sou pai ou responsavel", "Sou pai ou responsavel de uma crianca"),
            new QuickAction("Sou professor", "Sou professor e quero usar na escola"),
            new QuickAction("Sou profissional de saude", "Sou profissional de saude ou educacao especial"),
            new QuickAction("Nao sei por onde comecar", "Nao sei por onde comecar"));

    public static final List<QuickAction> QUALIFY_SERVER_ACTIONS = Arrays.asList(
            new QuickAction("4 a 6 anos", "A crianca tem entre 4 e 6 anos"),
            new QuickAction("6 a 8 anos", "A crianca tem entre 6 e 8 anos"),
            new QuickAction("Mais de 8 anos", "A crianca tem mais de 8 anos"),
            new QuickAction("Nao sei", "Nao tenho certeza da faixa etaria adequada"));

    public static final List<QuickAction> QUALIFY_PAIN_ACTIONS = Arrays.asList(
            new QuickAction("Dificuldade de leitura", "A crianca tem dificuldade de leitura"),
            new QuickAction("Crianca com TEA", "A crianca tem TEA ou suspeita de TEA"),
            new QuickAction("Baixo engajamento", "A crianca tem dificuldade de se engajar"),
            new QuickAction("Inclusao em sala", "Preciso de apoio para inclusao em sala de aula"),
            new QuickAction("Acompanhar progresso", "Quero acompanhar o progresso da crianca"));

    public static final List<QuickAction> POST_SOLUTION_ACTIONS = Arrays.asList(
            new QuickAction("Como criar conta", "Como eu crio minha conta no app?"),
            new QuickAction("Tenho outra duvida", "Tenho outra duvida sobre a plataforma"),
            new QuickAction("Falar com suporte", "Quero falar com o suporte"));
}