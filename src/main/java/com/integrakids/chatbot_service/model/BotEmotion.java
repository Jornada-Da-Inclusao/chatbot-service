package com.integrakids.chatbot_service.model;


public enum BotEmotion {
    HAPPY,       // resolveu a duvida, lead capturado, obrigado
    THINKING,    // pergunta de qualificacao, pensando na resposta (requer um timer) / (vai haver variacoes desse comportamento)
    NEUTRAL,     // resposta informativa normal
    EXCITED,     // solucao encontrada, diagnostico gratuito
    SAD,          // nao conseguiu ajudar, erro, negativo

    // esses de baixo só vao ser usados se tiver um contexto para eles (alguns certamente serão inuteis)

    LISTENING,   // pesquisa por voz / escutando o usuário
    LAUGHING,    // tratativa que entenda algo engraçado
    SEARCHING,   // coleta de dados
    CONFUSED,    // não entendeu a mensagem
    INTELECT,    // dando um conselho ou orientação qualificada
    SATISFIED,   // resolveu a dúvida com sucesso
    INDIFFERENT, // sem contexto definido
    EMBARRASSED, // reconheceu um elogio
    SLEEPING,    // backend fora do ar
    SURPRISED    // reação inesperada

}