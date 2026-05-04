package com.integrakids.chatbot_service.service;

import java.util.Arrays;
import java.util.List;

import com.integrakids.chatbot_service.util.TextNormalizer;

public class KnowledgeBaseService {

    public static final String TRIGGER_LEAD = "__TRIGGER_LEAD_CAPTURE__";

    private static class Entry {
        final List<String> keywords;
        final String response;

        Entry(String response, String... keywords) {
            this.keywords = Arrays.asList(keywords);
            this.response = response;
        }
    }

    private final List<Entry> entries = Arrays.asList(

       // ── FAQ: Sobre a plataforma ──────────────────────────────────────
new Entry(
    "O IntegraKids e uma plataforma educacional digital que apoia\n" +
    "o aprendizado de criancas de forma personalizada e inclusiva,\n" +
    "com atividades interativas que se adaptam ao nivel de cada usuario.",
    "o que e integrakids", "o que e o app", "o que e a plataforma",
    "integrakids", "jornada da inclusao"
),

new Entry(
    "O app e destinado a criancas entre 4 e 8 anos em fase de alfabetizacao,\n" +
    "alem de pais, responsaveis, professores e profissionais da educacao.\n" +
    "Cada perfil tem funcionalidades especificas.",
    "para quem e", "indicado para", "quem pode usar", "faixa etaria"
),

new Entry(
    "Sim! A plataforma oferece acesso gratuito as funcionalidades principais,\n" +
    "permitindo apoio ao aprendizado sem custo.",
    "gratuito", "gratis", "pago", "preco", "custa", "valor do app"
),

new Entry(
    "Sim, e necessario criar uma conta para usar a plataforma.\n" +
    "O cadastro permite salvar o progresso e personalizar as atividades.",
    "preciso de conta", "preciso cadastro", "criar conta", "cadastrar",
    "como criar conta", "como me cadastrar"
),

// ── FAQ: Pais e responsaveis ─────────────────────────────────────
new Entry(
    "Voce pode acompanhar o progresso pelo painel de controle,\n" +
    "que mostra relatorios de atividades, desempenho, dificuldades\n" +
    "e evolucao da crianca ao longo do tempo.",
    "progresso", "acompanhar", "relatorio", "desempenho", "painel"
),

new Entry(
    "Sim! A plataforma atende diferentes niveis de aprendizagem\n" +
    "com atividades adaptativas que evitam frustracoes e estimulam\n" +
    "o desenvolvimento gradual da crianca.",
    "dificuldade", "dificuldades de aprendizagem", "aprendizagem",
    "crianca com dificuldade"
),

new Entry(
    "Sim, o uso conjunto e recomendado!\n" +
    "A participacao do responsavel aumenta o engajamento, a seguranca\n" +
    "e fortalece o processo de aprendizagem.",
    "usar junto", "usar com filho", "participar junto", "responsavel usar"
),

// ── FAQ: Professores ─────────────────────────────────────────────
new Entry(
    "Sim! O app pode ser usado como ferramenta complementar em sala de aula,\n" +
    "tornando as aulas mais dinamicas e favorecendo praticas inclusivas.",
    "sala de aula", "usar na escola", "ferramenta professor",
    "usar em aula", "professor"
),

new Entry(
    "Sim, a plataforma permite personalizar atividades conforme o nivel\n" +
    "e necessidades de cada aluno, para uma experiencia mais adequada.",
    "personalizar", "personalizacao", "customizar atividade",
    "ajustar atividade", "nivel do aluno"
),

// ── FAQ: Acessibilidade ──────────────────────────────────────────
new Entry(
    "Sim! O app conta com suporte a audio, interface simplificada\n" +
    "e elementos visuais adaptados para facilitar navegacao e compreensao.",
    "acessibilidade", "acessivel", "recursos de acessibilidade"
),

new Entry(
    "Sim, a plataforma atende criancas com TEA com atividades de\n" +
    "linguagem simples, estrutura previsivel e estimulos controlados.\n" +
    "Importante: o app nao realiza diagnostico clinico, e apenas apoio educacional.",
    "tea", "autismo", "autista", "espectro", "transtorno"
),

new Entry(
    "Sim! O sistema oferece leitura em voz alta para ajudar na\n" +
    "compreensao dos conteudos e promover autonomia no uso.",
    "audio", "leitura em voz alta", "voz", "leitura", "narração"
),

// ── FAQ: Chatbot ─────────────────────────────────────────────────
new Entry(
    "O chatbot responde duvidas, orienta sobre o uso da plataforma\n" +
    "e gera relatorios de desempenho, oferecendo suporte imediato.",
    "chatbot", "assistente", "como o chat ajuda", "suporte chat"
),

new Entry(
    "Sim, o chatbot funciona 24 horas por dia, todos os dias,\n" +
    "garantindo atendimento a qualquer momento.",
    "funciona 24h", "horario", "disponivel", "funciona sempre"
),

new Entry(
    "Sim! Em situacoes especificas voce pode ser direcionado\n" +
    "para atendimento humano quando disponivel.",
    "falar com humano", "atendimento humano", "pessoa real",
    "atendente", "suporte humano"
),

// ── FAQ: Funcionalidades ─────────────────────────────────────────
new Entry(
    "Para criar conta, toque em 'Cadastrar' e preencha as informacoes solicitadas.",
    "como criar conta", "como cadastrar", "cadastro", "criar usuario"
),

new Entry(
    "Use a opcao 'Recuperar senha' e siga as instrucoes enviadas por e-mail.",
    "esqueci senha", "recuperar senha", "redefinir senha",
    "perdi senha", "senha errada"
),

new Entry(
    "Para iniciar uma atividade: selecione a crianca, escolha a atividade\n" +
    "desejada e clique em 'Iniciar'. Voce sera direcionado automaticamente.",
    "iniciar atividade", "como comecar atividade", "comecar",
    "iniciar", "como usar"
),

// ── FAQ: Seguranca ───────────────────────────────────────────────
new Entry(
    "Sim! A plataforma adota praticas de seguranca para proteger\n" +
    "suas informacoes, garantindo privacidade e integridade dos dados.",
    "dados seguros", "seguranca", "privacidade", "protecao de dados", "lgpd",
    "dado", "seguro", "informacao segura"  // adiciona fragmentos
),

new Entry(
    "Sim, voce pode excluir sua conta nas configuracoes,\n" +
    "tendo total controle sobre seus dados.",
    "excluir conta", "deletar conta", "remover conta", "apagar conta"
),

// ── FAQ: Problemas tecnicos ──────────────────────────────────────
new Entry(
    "Tente reiniciar ou atualizar o aplicativo — isso resolve a maioria\n" +
    "dos problemas causados por falhas temporarias ou versoes desatualizadas.",
    "app nao funciona", "erro", "problema", "nao abre", "travou",
    "bug", "falha", "nao carrega"
),

new Entry(
    "Entre em contato com o suporte e descreva o problema encontrado.\n" +
    "Isso nos ajuda a melhorar continuamente a plataforma.",
    "reportar erro", "reportar problema", "contato suporte",
    "falar com suporte", "enviar erro"
),

// ── FAQ: Sugestoes ───────────────────────────────────────────────
new Entry(
    "Sim! Envie sugestoes pelo suporte. Seu feedback ajuda no\n" +
    "aprimoramento constante da plataforma.",
    "feedback", "sugestao", "sugestoes", "opiniao", "melhoria"
),

new Entry(
    TRIGGER_LEAD,
    "contato", "falar com", "especialista", "agendar", "diagnostico", "suporte"
),

// ── Cortesia / Confirmações ──────────────────────────────────────
new Entry(
    "De nada! Fico feliz em poder ajudar. Se tiver mais alguma duvida,\n" +
    "e so perguntar!",
    "obrigado", "obrigada", "valeu", "agradeço", "agradeco", "grato", "grata"
),

new Entry(
    "Otimo! Se precisar de mais alguma coisa, estou aqui para ajudar.",
    "ok", "okay", "certo", "entendido", "entendi", "compreendi",
    "compreendido", "ta bom", "ta certo", "beleza", "blz"
),

new Entry(
    "Fico feliz que tenha gostado! Posso ajudar com mais alguma coisa?",
    "legal", "otimo", "massa", "show", "bacana", "incrivel", "top",
    "perfeito", "excelente", "muito bom", "que bom", "que otimo"
),

new Entry(
    "Sem problemas! Estou aqui sempre que precisar.",
    "tudo bem", "tudo certo", "ta", "ate mais", "tchau", "ate logo",
    "por enquanto e so", "e so isso", "foi isso"
),

// ── FAQ: Jogos e Atividades ──────────────────────────────────────
new Entry(
    "O app conta com jogos educativos interativos voltados para\n" +
    "alfabetizacao e reconhecimento de numeros.\n" +
    "Cada jogo e adaptado ao nivel da crianca e estimula o aprendizado\n" +
    "de forma ludica e divertida.",
    "jogos", "jogo", "atividades", "que jogos tem", "quais jogos",
    "que atividades tem", "como funcionam os jogos", "como funciona o jogo"
),

new Entry(
    "Os jogos de alfabetizacao ajudam a crianca a reconhecer letras,\n" +
    "formar palavras e desenvolver a leitura de maneira interativa.\n" +
    "Sao pensados para criancas de 4 a 8 anos em fase de alfabetizacao.",
    "jogo de alfabetizacao", "alfabetizacao", "letras", "palavras",
    "aprender a ler", "aprender letras", "jogo de letras"
),

new Entry(
    "Os jogos de numeros ajudam a crianca a identificar, contar\n" +
    "e compreender os numeros de forma visual e divertida,\n" +
    "estimulando o raciocinio logico desde cedo.",
    "jogo de numero", "numeros", "contar", "matematica", "jogo de matematica",
    "identificar numeros", "aprender numeros"
),

new Entry(
    "Antes de iniciar cada jogo, o app exibe uma descricao com\n" +
    "o objetivo da atividade e as instrucoes de como jogar.\n" +
    "Assim a crianca — e o responsavel — sabem o que esperar.",
    "como jogar", "instrucoes", "instrucao do jogo", "descricao do jogo",
    "como funciona a atividade", "regras do jogo"
),

new Entry(
    "O app registra o desempenho da crianca em cada atividade,\n" +
    "permitindo acompanhar a evolucao, identificar pontos de melhoria\n" +
    "e celebrar o progresso ao longo do tempo.",
    "pontuacao", "pontos", "resultado", "resultado do jogo",
    "desempenho no jogo", "historico de jogos", "evolucao nos jogos"
),

// ── FAQ: App Mobile ──────────────────────────────────────────────
new Entry(
    "O app IntegraKids está disponivel apenas para dispositivos Android.\n" +
    "Ele foi desenvolvido com Android Studio e Java, garantindo\n" +
    "boa compatibilidade e desempenho em smartphones e tablets.",
    "android", "celular", "smartphone", "tablet", "dispositivo",
    "disponivel para android", "funciona no celular"
),

new Entry(
    "O app possui versao web (acessivel pelo navegador) e versao mobile\n" +
    "para Android. Ambas se conectam ao mesmo back-end e oferecem\n" +
    "uma experiencia integrada.",
    "versao web", "versao mobile", "diferenca entre web e mobile",
    "tem versao web", "tem versao mobile", "navegador", "site"
),

new Entry(
    "Para usar o app mobile, basta instala-lo no seu dispositivo Android,\n" +
    "criar uma conta ou fazer login, e comecar as atividades.\n" +
    "O sistema carrega automaticamente ao abrir.",
    "como instalar", "instalar o app", "baixar o app", "download",
    "como baixar", "como usar o app"
),

// ── FAQ: Projeto Jornada da Inclusao ────────────────────────────
new Entry(
    "O projeto Jornada da Inclusao foi desenvolvido por estudantes\n" +
    "da Fatec com o objetivo de apoiar criancas com dificuldades\n" +
    "de inclusao escolar, promovendo educacao de qualidade e acessivel.",
    "jornada da inclusao", "sobre o projeto", "quem fez", "quem criou",
    "desenvolvedores", "equipe", "projeto integrador", "fatec"
),

new Entry(
    "O projeto contribui para os Objetivos de Desenvolvimento Sustentavel\n" +
    "da ONU: ODS 4 (Educacao de Qualidade) e ODS 10 (Reducao das\n" +
    "Desigualdades), promovendo uma educacao inclusiva e equitativa.",
    "ods", "objetivo de desenvolvimento", "sustentavel", "onu",
    "impacto social", "educacao inclusiva"
),

// ── FAQ: Saudacoes ───────────────────────────────────────────────
new Entry(
    "Ola! Seja bem-vindo ao IntegraKids!\n" +
    "Posso te ajudar com duvidas sobre a plataforma, jogos, cadastro\n" +
    "e muito mais. O que voce gostaria de saber?",
    "oi", "ola", "boa tarde", "bom dia", "boa noite", "oi tudo bem",
    "ola tudo bem", "hey", "ei", "hello", "salve"
),

new Entry(
    "Estou bem, obrigado por perguntar! E voce?\n" +
    "Posso te ajudar com algo sobre o IntegraKids?",
    "tudo bem voce", "como voce esta", "como vai", "tudo bem com voce"
), 

// ── FAQ: Tecnologias e Arquitetura ───────────────────────────────
new Entry(
    "A plataforma utiliza a arquitetura MVC:\n" +
    "- Web: React (frontend) + Spring Boot (backend)\n" +
    "- Mobile: Android nativo com Java\n" +
    "- Banco de dados: MySQL\n" +
    "As camadas se comunicam por meio de APIs RESTful.",
    "tecnologia", "tecnologias", "como foi feito", "arquitetura",
    "mvc", "como funciona por dentro", "stack", "linguagem"
),

new Entry(
    "O frontend web foi desenvolvido com React e hospedado no Firebase.\n" +
    "O app mobile foi desenvolvido em Android com Java nativo,\n" +
    "usando o Android Studio como ambiente de desenvolvimento.",
    "frontend", "front end", "react", "android studio", "firebase",
    "hospedagem frontend", "onde fica o frontend"
),

new Entry(
    "O backend foi desenvolvido com Spring Boot (Java) e hospedado no Render.\n" +
    "Ele expoe APIs RESTful consumidas tanto pelo app web quanto pelo mobile.",
    "backend", "back end", "spring boot", "render", "api", "api rest",
    "restful", "onde fica o backend", "hospedagem backend"
),

new Entry(
    "O banco de dados utilizado é o MySQL, responsavel por armazenar\n" +
    "informacoes de usuarios, dados das avaliacoes e resultados dos testes.",
    "banco de dados", "mysql", "dados armazenados", "onde ficam os dados",
    "persistencia", "armazenamento"
),

new Entry(
    "O projeto utiliza arquitetura de microsservicos.\n" +
    "O RabbitMQ e usado como mensageria para coordenar os microsservicos\n" +
    "de confirmacao de e-mail e redefinicao de senha.",
    "microsservico", "microsservicos", "rabbitmq", "mensageria",
    "confirmacao de email", "redefinir senha", "email confirmacao"
),

// ── FAQ: Metodologia de Desenvolvimento ──────────────────────────
new Entry(
    "O projeto foi desenvolvido com a metodologia Scrum,\n" +
    "dividido em sprints de duas semanas com tarefas designadas\n" +
    "a cada membro da equipe.",
    "metodologia", "scrum", "sprint", "como foi desenvolvido",
    "processo de desenvolvimento", "gestao do projeto"
),

new Entry(
    "As tarefas foram organizadas em cartoes no estilo Kanban.\n" +
    "Ao final de cada sprint, cada membro apresenta o progresso\n" +
    "e tarefas nao finalizadas sao realocadas para o proximo ciclo.",
    "kanban", "tarefas", "organizacao das tarefas", "cartoes",
    "scrum master", "sprint review"
),

new Entry(
    "O codigo-fonte e versionado no GitHub, com uma branch dedicada\n" +
    "ao deploy e branches separadas para desenvolvimento de cada recurso.\n" +
    "O repositorio esta sob a conta organizacional do projeto.",
    "github", "repositorio", "versionamento", "git", "branch",
    "codigo fonte", "controle de versao"
),

// ── FAQ: Requisitos e Funcionalidades ────────────────────────────
new Entry(
    "O product backlog do projeto inclui tres requisitos principais:\n" +
    "1. Chatbot para duvidas dos responsaveis\n" +
    "2. Progressao de niveis nos jogos\n" +
    "3. Ferramentas de acessibilidade para as criancas",
    "requisitos", "funcionalidades", "product backlog", "backlog",
    "o que o app tem", "o que foi planejado", "o que vai ter"
),

new Entry(
    "Sim! A progressao de niveis e um dos requisitos prioritarios da plataforma.\n" +
    "O objetivo e que a crianca avance gradualmente nos jogos conforme\n" +
    "demonstra evolucao no aprendizado.",
    "progressao", "nivel", "niveis", "progressao de nivel",
    "crianca progride", "dificuldade progressiva", "avanca de nivel"
),

new Entry(
    "A plataforma planeja oferecer ferramentas de acessibilidade\n" +
    "para facilitar ou possibilitar o uso por criancas com necessidades especiais,\n" +
    "sendo este um dos requisitos de alta prioridade do projeto.",
    "ferramenta de acessibilidade", "recurso de acessibilidade",
    "necessidades especiais", "inclusao", "acessibilidade para criancas"
),

// ── FAQ: Sobre o Chatbot (contexto tecnico) ───────────────────────
new Entry(
    "O chatbot é um microsservico independente desenvolvido em Java com Spring Boot,\n" +
    "hospedado no Render. Ele e consumido tanto pelo frontend web quanto pelo mobile\n" +
    "via API REST.",
    "como o chatbot funciona", "chatbot tecnico", "como o chat foi feito",
    "tecnologia do chatbot", "microsservico chatbot"
)
    );

    /**
     * Busca a primeira entrada cujo keyword aparece no input normalizado.
     * Retorna null se nenhuma entrada corresponder.
     */
    public String findMatch(String normalizedInput) {
        for (Entry entry : entries) {
            for (String keyword : entry.keywords) {
                if (normalizedInput.contains(TextNormalizer.normalize(keyword))) {
                    return entry.response;
                }
            }
        }
        return null;
    }
}