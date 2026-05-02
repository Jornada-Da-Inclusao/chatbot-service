package com.integrakids.chatbot_service.model;


public enum BotEmotion {
    HAPPY,       // resolveu a duvida, lead capturado, obrigado
    THINKING,    // pergunta de qualificacao, pensando na resposta (requer um timer) / (vai haver variacoes desse comportamento)
    NEUTRAL,     // resposta informativa normal
    EXCITED,     // solucao encontrada, diagnostico gratuito
    SAD,          // nao conseguiu ajudar, erro, negativo

    // esses de baixo só vao ser usados se tiver um contexto para eles (alguns certamente serão inuteis)

    LISTENING, // esse vai para a função de pesquisa por voz (vai haver variacoes desse comportamento)
    ANGER, // caso o user erre algo
    LAUGHING, // talvez uma tratativa q entenda algo engraçado (chance minima de rolar)
    SEARCHING, // vai servir para coleta de dados
    CONFUSED, // caso ele n entenda, facil
    INTELECT, // quando for dar algum conselho
    SATISFIED, // consegui resolver a duvida, GG
    INDIFFERENT, // ...n pensei onde usar isso
    EMBARRASED, // alguma tratativa q reconheça elogios
    SLEEPING, // quando o backend dele estiver fora do ar
    CHAD,
    SURPRISED // ... outro q n sei onde usar

}