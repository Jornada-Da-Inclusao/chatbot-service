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

        public static final List<QuickAction> CONTINUE_EXPLORING_ACTIONS = Arrays.asList(
                        new QuickAction("Sobre os jogos", "Quais jogos o app possui?"),
                        new QuickAction("Meu perfil ideal", "Qual perfil de uso combina comigo?"),
                        new QuickAction("Recursos acessiveis", "Quais recursos de acessibilidade o app possui?"),
                        new QuickAction("Sobre o app", "O que e o IntegraKids?"),
                        new QuickAction("Chamar suporte", "Quero falar com o suporte"),
                        new QuickAction("Tenho outra duvida", "Tenho outra duvida sobre a plataforma"),
                        new QuickAction("Encerrar atendimento", "Obrigado, era so isso"));

        // ── Ações: Jogos ─────────────────────────────────────────────────
        public static final List<QuickAction> GAMES_ACTIONS = Arrays.asList(
                        new QuickAction("Jogo da Memoria", "Como funciona o Jogo da Memoria?"),
                        new QuickAction("Jogo dos Numeros", "Como funciona o Jogo dos Numeros?"),
                        new QuickAction("Jogo das Letras", "Como funciona o Jogo das Letras?"),
                        new QuickAction("Jogo das Cores", "Como funciona o Jogo das Cores?"),
                        new QuickAction("Voltar ao menu", "Tenho outra duvida sobre a plataforma"));

        // ── Ações: Acessibilidade ────────────────────────────────────────
        public static final List<QuickAction> ACCESSIBILITY_ACTIONS = Arrays.asList(
                        new QuickAction("Mudar tema", "Como funciona o recurso de tema?"),
                        new QuickAction("Modo daltonismo", "O app tem modo para daltonismo?"),
                        new QuickAction("Aumentar texto", "Como aumentar o tamanho do texto?"),
                        new QuickAction("Feedback sonoro", "Como funciona o recurso de som?"),
                        new QuickAction("Voltar ao menu", "Tenho outra duvida sobre a plataforma"));

        // ── Ações: Perfil e Conta ────────────────────────────────────────
        public static final List<QuickAction> PROFILE_ACTIONS = Arrays.asList(
                        new QuickAction("Criar avatar", "Como criar um avatar para a crianca?"),
                        new QuickAction("Editar avatar", "Como editar os dados do avatar?"),
                        new QuickAction("Ver resultados", "Como ver os resultados da crianca nos jogos?"),
                        new QuickAction("Trocar jogador", "Como trocar o jogador ativo?"),
                        new QuickAction("Editar meus dados", "Como editar meus dados de usuario?"),
                        new QuickAction("Fazer logout", "Como fazer logout da minha conta?"));

        // ── Ações: Problemas Tecnicos ────────────────────────────────────
        public static final List<QuickAction> TECH_SUPPORT_ACTIONS = Arrays.asList(
                        new QuickAction("App nao abre", "O app nao esta abrindo, o que fazer?"),
                        new QuickAction("Nao consigo fazer login", "Nao consigo fazer login no app"),
                        new QuickAction("Esqueci minha senha", "Esqueci minha senha, como recuperar?"),
                        new QuickAction("Reportar problema", "Quero reportar um problema no app"),
                        new QuickAction("Falar com suporte", "Quero falar com o suporte"));

        // ── Ações: Plataforma e Acesso ───────────────────────────────────
        public static final List<QuickAction> PLATFORM_ACTIONS = Arrays.asList(
                        new QuickAction("Acessar versao web", "Qual o link da versao web do IntegraKids?"),
                        new QuickAction("Disponivel no iPhone?", "O app esta disponivel para iPhone?"),
                        new QuickAction("Disponivel no Android?", "O app esta disponivel para Android?"),
                        new QuickAction("Preciso de cadastro?", "Preciso criar uma conta para usar?"),
                        new QuickAction("App e gratuito?", "O app e gratuito?"));

        // ── Ações: Mascote ───────────────────────────────────────────────
        public static final List<QuickAction> MASCOT_ACTIONS = Arrays.asList(
                        new QuickAction("Quem e o Rigel?", "Quem e o mascote do IntegraKids?"),
                        new QuickAction("Por que Rigel?", "Por que o mascote se chama Rigel?"),
                        new QuickAction("O que ele representa?", "O que o mascote representa?"),
                        new QuickAction("Voltar ao menu", "Tenho outra duvida sobre a plataforma"));

        // ── Ações: Sobre o Projeto ───────────────────────────────────────
        public static final List<QuickAction> ABOUT_PROJECT_ACTIONS = Arrays.asList(
                        new QuickAction("Quem desenvolveu?", "Quem desenvolveu o IntegraKids?"),
                        new QuickAction("Qual a proposta?", "Qual e a proposta do projeto Jornada da Inclusao?"),
                        new QuickAction("ODS do projeto", "Quais ODS o projeto atende?"),
                        new QuickAction("Tecnologias usadas", "Quais tecnologias foram usadas no projeto?"),
                        new QuickAction("Voltar ao menu", "Tenho outra duvida sobre a plataforma"));

        // ── Ações: Pos Encerramento ──────────────────────────────────────
        public static final List<QuickAction> FAREWELL_ACTIONS = Arrays.asList(
                        new QuickAction("Tenho outra duvida", "Tenho outra duvida sobre a plataforma"),
                        new QuickAction("Ver os jogos", "Quais jogos o app possui?"),
                        new QuickAction("Falar com suporte", "Quero falar com o suporte"),
                        new QuickAction("Encerrar atendimento", "Obrigado, era so isso"));
}