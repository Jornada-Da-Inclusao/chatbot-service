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
                    "integrakids"),

            new Entry(
                    "O app e destinado a criancas entre 4 e 8 anos em fase de alfabetizacao,\n" +
                            "alem de pais, responsaveis, professores e profissionais da educacao.\n" +
                            "Cada perfil tem funcionalidades especificas.",
                    "para quem e", "indicado para", "quem pode usar", "faixa etaria"),

            new Entry(
                    "Sim! A plataforma oferece acesso gratuito as funcionalidades principais,\n" +
                            "permitindo apoio ao aprendizado sem custo.",
                    "gratuito", "gratis", "pago", "preco", "custa", "valor do app"),

            new Entry(
                    "Sim, e necessario criar uma conta para usar a plataforma.\n" +
                            "O cadastro permite salvar o progresso e personalizar as atividades.",
                    "preciso de conta", "preciso cadastro", "criar conta", "cadastrar",
                    "como criar conta", "como me cadastrar", "cadastro", "criar usuario"),

            // ── FAQ: Pais e responsaveis ─────────────────────────────────────
            new Entry(
                    "Voce pode acompanhar o progresso pelo painel de controle,\n" +
                            "que mostra relatorios de atividades, desempenho, dificuldades\n" +
                            "e evolucao da crianca ao longo do tempo.",
                    "progresso", "acompanhar", "relatorio", "painel",
                    "onde fica o painel", "onde fica o relatorio", "onde ver progresso",
                    "onde acompanho", "onde fica o dashboard"),

            new Entry(
                    "Sim! A plataforma atende diferentes niveis de aprendizagem\n" +
                            "com atividades adaptativas que evitam frustracoes e estimulam\n" +
                            "o desenvolvimento gradual da crianca.",
                    "dificuldades de aprendizagem", "aprendizagem",
                    "crianca com dificuldade"),

            new Entry(
                    "Sim, o uso conjunto e recomendado!\n" +
                            "A participacao do responsavel aumenta o engajamento, a seguranca\n" +
                            "e fortalece o processo de aprendizagem.",
                    "usar junto", "usar com filho", "participar junto", "responsavel usar"),

            // ── FAQ: Professores ─────────────────────────────────────────────
            new Entry(
                    "Sim! O app pode ser usado como ferramenta complementar em sala de aula,\n" +
                            "tornando as aulas mais dinamicas e favorecendo praticas inclusivas.",
                    "sala de aula", "usar na escola", "ferramenta professor",
                    "usar em aula", "professor"),

            new Entry(
                    "Sim, a plataforma permite personalizar atividades conforme o nivel\n" +
                            "e necessidades de cada aluno, para uma experiencia mais adequada.",
                    "personalizar", "personalizacao", "customizar atividade",
                    "ajustar atividade", "nivel do aluno"),

            // ── FAQ: Acessibilidade geral ────────────────────────────────────
            new Entry(
                    "O IntegraKids conta com 4 recursos de acessibilidade:\n" +
                            "1. Tema - altera as cores da interface\n" +
                            "2. Modo Daltonismo - auxilia quem tem dificuldade com cores\n" +
                            "3. Tamanho de Texto - amplia as letras da plataforma\n" +
                            "4. Som - feedback sonoro nos jogos\n\n" +
                            "Todos podem ser ajustados na tela de Configuracoes!",
                    "acessibilidade", "acessivel", "recursos de acessibilidade",
                    "funcoes de acessibilidade", "configuracoes de acessibilidade",
                    "quais recursos tem", "como tornar acessivel",
                    "opcoes de acessibilidade", "ferramenta de acessibilidade",
                    "recurso de acessibilidade", "acessibilidade para criancas",
                    "necessidades especiais"),

            new Entry(
                    "Sim, a plataforma atende criancas com TEA com atividades de\n" +
                            "linguagem simples, estrutura previsivel e estimulos controlados.\n" +
                            "Importante: o app nao realiza diagnostico clinico, e apenas apoio educacional.",
                    "tea", "autismo", "autista", "espectro", "transtorno"),

            // ── FAQ: Recursos de Acessibilidade - Detalhes ───────────────────
            new Entry(
                    "O recurso de Tema permite alterar as cores da interface\n" +
                            "de acordo com sua preferencia. Ha 3 opcoes disponiveis:\n\n" +
                            "- Claro: fundo branco com textos escuros\n" +
                            "- Escuro: fundo escuro com textos claros, ideal para\n" +
                            "  ambientes com pouca luz ou quem tem sensibilidade visual\n" +
                            "- Sistema: segue automaticamente o tema configurado\n" +
                            "  no seu dispositivo\n\n" +
                            "Para alterar, acesse Configuracoes e escolha o tema desejado.",
                    "tema", "tema claro", "tema escuro", "modo escuro", "dark mode",
                    "modo claro", "light mode", "tema do sistema", "mudar tema",
                    "alterar tema", "como mudar o tema", "cores da interface"),

            new Entry(
                    "O modo Daltonismo foi desenvolvido para auxiliar pessoas com\n" +
                            "dificuldade na percepcao de certas cores. O app oferece suporte para:\n\n" +
                            "- Protanomalia: dificuldade na percepcao da cor vermelha\n" +
                            "- Deuteranomalia: dificuldade na percepcao da cor verde\n\n" +
                            "Ao ativar o modo correspondente, a interface adapta sua\n" +
                            "paleta de cores para facilitar a visualizacao do conteudo.\n\n" +
                            "Para ativar, acesse Configuracoes e selecione o modo de daltonismo.",
                    "daltonismo", "daltonico", "daltonica", "protanomalia", "deuteranomalia",
                    "dificuldade com cores", "modo daltonismo", "como ativar daltonismo",
                    "nao consigo ver as cores", "cores dificeis de ver"),

            new Entry(
                    "O recurso de Tamanho de Texto foi pensado para quem tem\n" +
                            "dificuldade com letras pequenas, como criancas em fase de\n" +
                            "alfabetizacao ou pessoas com baixa visao.\n\n" +
                            "Ao ativar, os textos da plataforma sao ampliados para\n" +
                            "facilitar a leitura em todas as telas do app.\n\n" +
                            "Para ativar, acesse Configuracoes e habilite o Tamanho de Texto.",
                    "tamanho de texto", "texto maior", "aumentar letra", "aumentar fonte",
                    "letra grande", "fonte maior", "dificuldade pra ler", "texto pequeno",
                    "nao consigo ler", "como aumentar o texto", "baixa visao"),

            new Entry(
                    "O recurso de Som funciona como feedback sonoro durante os jogos.\n" +
                            "Ele emite sons para indicar acertos e erros, ajudando a crianca\n" +
                            "a compreender o resultado de cada acao sem depender apenas\n" +
                            "do feedback visual.\n\n" +
                            "Esse recurso e especialmente util para criancas com dificuldade\n" +
                            "de leitura ou que respondem melhor a estimulos auditivos.\n\n" +
                            "Para ativar, acesse Configuracoes e habilite o recurso de Som.",
                    "som", "audio", "feedback sonoro", "som nos jogos", "sons do jogo",
                    "ativar som", "como ativar o som", "sons de acerto", "sons de erro",
                    "estimulo auditivo", "feedback de audio", "recurso de som",
                    "leitura em voz alta", "voz", "leitura", "narracao"),

            // ── FAQ: Chatbot ─────────────────────────────────────────────────
            new Entry(
                    "O chatbot responde duvidas, orienta sobre o uso da plataforma\n" +
                            "e gera relatorios de desempenho, oferecendo suporte imediato.\n" +
                            "E um microsservico independente desenvolvido em Java com Spring Boot,\n" +
                            "hospedado no Render e consumido pela web e pelo mobile via API REST.",
                    "chatbot", "assistente", "como o chat ajuda", "suporte chat",
                    "como o chatbot funciona", "chatbot tecnico", "como o chat foi feito",
                    "tecnologia do chatbot", "microsservico chatbot"),

            new Entry(
                    "Sim, o chatbot funciona 24 horas por dia, todos os dias,\n" +
                            "garantindo atendimento a qualquer momento.",
                    "funciona 24h", "horario", "disponivel", "funciona sempre"),

            new Entry(
                    "Sim! Em situacoes especificas voce pode ser direcionado\n" +
                            "para atendimento humano quando disponivel.",
                    "falar com humano", "atendimento humano", "pessoa real",
                    "atendente", "suporte humano"),

            // ── FAQ: Onde fica o chatbot ─────────────────────────────────────
            new Entry(
                    "O chatbot fica no canto inferior direito da tela principal,\n" +
                            "representado por um icone de mensagem. Clique nele para abrir\n" +
                            "e digitar sua duvida!",
                    "onde fica o chat", "onde fica o chatbot", "como acessar o chat",
                    "como abrir o chat", "onde esta o assistente", "onde fica o assistente"),

            // ── FAQ: Funcionalidades / Navegacao ─────────────────────────────
            new Entry(
                    "O cadastro e feito na tela inicial do app, antes do login.\n" +
                            "Toque em 'Cadastrar' e preencha os dados solicitados.",
                    "onde faco cadastro", "onde e o cadastro", "onde criar conta",
                    "onde me cadastro", "tela de cadastro", "onde fica o cadastro"),

            new Entry(
                    "A tela de login e a primeira tela apos abrir o app.\n" +
                            "Insira seu e-mail e senha para acessar a plataforma.",
                    "onde fica o login", "onde e o login", "onde entro", "tela de login",
                    "como entrar no app", "onde coloco minha senha"),

            new Entry(
                    "Use a opcao 'Recuperar senha' na tela de login e siga\n" +
                            "as instrucoes enviadas por e-mail.",
                    "esqueci senha", "recuperar senha", "redefinir senha", "perdi senha",
                    "senha errada", "onde recupero senha", "onde redefino senha",
                    "onde fica esqueci senha", "como recuperar senha", "nao consigo entrar",
                    "esqueci minha senha"),

            new Entry(
                    "Para iniciar uma atividade: selecione a crianca, escolha a atividade\n" +
                            "desejada e clique em 'Iniciar'. Voce sera direcionado automaticamente.",
                    "iniciar atividade", "como comecar atividade", "comecar",
                    "iniciar", "como usar"),

            new Entry(
                    "As configuracoes ficam no menu lateral ou no icone de engrenagem\n" +
                            "no canto superior da tela. Por la voce pode ajustar preferencias,\n" +
                            "acessibilidade e dados da conta.",
                    "onde fica configuracao", "onde ficam as configuracoes", "como configurar",
                    "onde ajusto", "tela de configuracao", "icone de configuracao",
                    "onde fica o menu"),

            new Entry(
                    "A secao 'Sobre' do app fica no menu lateral.\n" +
                            "Nela voce encontra informacoes sobre o projeto Jornada da Inclusao,\n" +
                            "sua missao e a equipe desenvolvedora.",
                    "onde fica sobre", "onde fica informacoes do app",
                    "sobre o app", "tela sobre", "informacoes do projeto"),

            new Entry(
                    "O suporte pode ser acessado pelo chatbot ou pelo menu principal,\n" +
                            "na opcao 'Fale Conosco'. Para problemas tecnicos, descreva\n" +
                            "o erro encontrado para que possamos ajudar.",
                    "onde fica o suporte", "onde falo com suporte", "como acessar suporte",
                    "onde e fale conosco", "onde reporto problema", "onde fica ajuda"),

            // ── FAQ: Seguranca ───────────────────────────────────────────────
            new Entry(
                    "Sim! A plataforma adota praticas de seguranca para proteger\n" +
                            "suas informacoes, garantindo privacidade e integridade dos dados.",
                    "dados seguros", "seguranca", "privacidade", "protecao de dados",
                    "lgpd", "dado", "seguro", "informacao segura"),

            new Entry(
                    "Sim, voce pode excluir sua conta nas configuracoes,\n" +
                            "tendo total controle sobre seus dados.",
                    "excluir conta", "deletar conta", "remover conta", "apagar conta"),

            // ── FAQ: Problemas tecnicos ──────────────────────────────────────
            new Entry(
                    "Tente reiniciar ou atualizar o aplicativo — isso resolve a maioria\n" +
                            "dos problemas causados por falhas temporarias ou versoes desatualizadas.",
                    "app nao funciona", "erro", "problema", "nao abre", "travou",
                    "bug", "falha", "nao carrega"),

            new Entry(
                    "Entre em contato com o suporte e descreva o problema encontrado.\n" +
                            "Isso nos ajuda a melhorar continuamente a plataforma.",
                    "reportar erro", "reportar problema", "contato suporte",
                    "falar com suporte", "enviar erro"),

            // ── FAQ: Sugestoes ───────────────────────────────────────────────
            new Entry(
                    "Sim! Envie sugestoes pelo suporte. Seu feedback ajuda no\n" +
                            "aprimoramento constante da plataforma.",
                    "feedback", "sugestao", "sugestoes", "opiniao", "melhoria"),

            new Entry(
                    TRIGGER_LEAD,
                    "contato", "falar com", "especialista", "agendar", "diagnostico", "suporte"),

            // ── Cortesia / Confirmacoes ──────────────────────────────────────
            new Entry(
                    "De nada! Fico feliz em poder ajudar. Se tiver mais alguma duvida,\n" +
                            "e so perguntar!",
                    "obrigado", "obrigada", "valeu", "agradeco", "grato", "grata"),

            new Entry(
                    "Otimo! Se precisar de mais alguma coisa, estou aqui para ajudar.",
                    "ok", "okay", "certo", "entendido", "entendi", "compreendi",
                    "compreendido", "ta bom", "ta certo", "beleza", "blz"),

            new Entry(
                    "Fico feliz que tenha gostado! Posso ajudar com mais alguma coisa?",
                    "legal", "massa", "show", "bacana", "incrivel", "top",
                    "perfeito", "excelente", "muito bom", "que bom", "que otimo"),

            new Entry(
                    "Sem problemas! Estou aqui sempre que precisar.",
                    "tudo bem", "tudo certo", "ate mais", "tchau", "ate logo",
                    "por enquanto e so", "e so isso", "foi isso"),

            // ── FAQ: Jogos - Visao Geral ─────────────────────────────────────
            new Entry(
                    "O IntegraKids possui 4 jogos educativos:\n" +
                            "1. Jogo da Memoria - encontrar pares de cartas\n" +
                            "2. Jogo dos Numeros - ordenar numeros em ordem crescente\n" +
                            "3. Jogo das Letras - identificar e listar as vogais\n" +
                            "4. Jogo das Cores - associar a cor correta a cada animal\n\n" +
                            "Qual jogo voce gostaria de saber mais?",
                    "jogos", "jogo", "atividades", "que jogos tem", "quais jogos",
                    "que atividades tem", "quais sao os jogos", "listar jogos",
                    "jogos disponiveis", "quantos jogos tem", "me fala os jogos",
                    "como funcionam os jogos", "como funciona o jogo"),

            new Entry(
                    "Os jogos de alfabetizacao ajudam a crianca a reconhecer letras,\n" +
                            "formar palavras e desenvolver a leitura de maneira interativa.\n" +
                            "Sao pensados para criancas de 4 a 8 anos em fase de alfabetizacao.",
                    "jogo de alfabetizacao", "alfabetizacao", "palavras",
                    "aprender a ler", "aprender letras"),

            new Entry(
                    "Os jogos de numeros ajudam a crianca a identificar, contar\n" +
                            "e compreender os numeros de forma visual e divertida,\n" +
                            "estimulando o raciocinio logico desde cedo.",
                    "jogo de numero", "contar", "matematica", "jogo de matematica",
                    "identificar numeros", "aprender numeros"),

            new Entry(
                    "Antes de iniciar cada jogo, o app exibe uma descricao com\n" +
                            "o objetivo da atividade e as instrucoes de como jogar.\n" +
                            "Assim a crianca — e o responsavel — sabem o que esperar.",
                    "instrucoes", "instrucao do jogo", "descricao do jogo",
                    "como funciona a atividade", "regras do jogo"),

            // ── FAQ: Como Jogar - Detalhes ───────────────────────────────────
            new Entry(
                    "No Jogo da Memoria, cartas sao exibidas viradas para baixo na tela.\n" +
                            "O objetivo e encontrar todos os pares!\n\n" +
                            "Como jogar:\n" +
                            "1. Toque em uma carta para revela-la\n" +
                            "2. Toque em outra carta tentando encontrar o par\n" +
                            "3. Se as cartas forem iguais, o par e encontrado!\n" +
                            "4. Se forem diferentes, as cartas viram novamente\n" +
                            "5. Encontre todos os pares para completar o jogo!",
                    "jogo da memoria", "como jogar memoria",
                    "como funciona o jogo da memoria", "jogo de pares",
                    "encontrar pares", "cartas", "jogo das cartas",
                    "instrucoes jogo da memoria"),

            new Entry(
                    "No Jogo dos Numeros, uma sequencia de numeros embaralhados\n" +
                            "e exibida na tela. O objetivo e coloca-los em ordem crescente!\n\n" +
                            "Como jogar:\n" +
                            "1. Observe os numeros disponiveis na tela\n" +
                            "2. Toque no menor numero primeiro\n" +
                            "3. Continue selecionando do menor para o maior\n" +
                            "4. Complete a sequencia em ordem crescente para vencer!",
                    "jogo dos numeros", "jogo de numeros", "como jogar numeros",
                    "como funciona o jogo dos numeros", "ordem crescente",
                    "ordenar numeros", "instrucoes jogo dos numeros", "numeros"),

            new Entry(
                    "No Jogo das Letras, o objetivo e identificar e selecionar\n" +
                            "todas as vogais que aparecem na tela!\n\n" +
                            "Como jogar:\n" +
                            "1. Varias letras serao exibidas na tela\n" +
                            "2. Toque apenas nas vogais: A, E, I, O, U\n" +
                            "3. Evite tocar nas consoantes\n" +
                            "4. Encontre todas as vogais para completar o jogo!",
                    "jogo das letras", "como jogar letras",
                    "como funciona o jogo das letras", "vogais", "listar vogais",
                    "identificar vogais", "instrucoes jogo das letras", "letras"),

            new Entry(
                    "No Jogo das Cores, cada animal aparece na tela e voce\n" +
                            "deve associar a cor correta a ele!\n\n" +
                            "Como jogar:\n" +
                            "1. Um animal sera exibido na tela\n" +
                            "2. Escolha a cor que corresponde a esse animal\n" +
                            "3. Acertou? Proximo animal!\n" +
                            "4. Associe a cor certa a todos os animais para vencer!",
                    "jogo das cores", "como jogar cores",
                    "como funciona o jogo das cores", "associar cores",
                    "cor do animal", "animais e cores", "instrucoes jogo das cores"),

            // ── FAQ: Desempenho nos jogos ────────────────────────────────────
            new Entry(
                    "O app registra o desempenho da crianca em cada atividade,\n" +
                            "permitindo acompanhar a evolucao, identificar pontos de melhoria\n" +
                            "e celebrar o progresso ao longo do tempo.",
                    "pontuacao", "pontos", "resultado do jogo",
                    "desempenho no jogo", "historico de jogos", "evolucao nos jogos"),

            // ── FAQ: App Mobile ──────────────────────────────────────────────
            new Entry(
                    "O app IntegraKids esta disponivel apenas para dispositivos Android.\n" +
                            "Ele foi desenvolvido com Android Studio e Java, garantindo\n" +
                            "boa compatibilidade e desempenho em smartphones e tablets.",
                    "android", "celular", "smartphone", "tablet", "dispositivo",
                    "disponivel para android", "funciona no celular"),

            new Entry(
                    "O app possui versao web (acessivel pelo navegador) e versao mobile\n" +
                            "para Android. Ambas se conectam ao mesmo back-end e oferecem\n" +
                            "uma experiencia integrada.",
                    "versao web", "versao mobile", "diferenca entre web e mobile",
                    "tem versao web", "tem versao mobile", "navegador", "site"),

            new Entry(
                    "Para usar o app mobile, basta instala-lo no seu dispositivo Android,\n" +
                            "criar uma conta ou fazer login, e comecar as atividades.\n" +
                            "O sistema carrega automaticamente ao abrir.",
                    "como instalar", "instalar o app", "baixar o app", "download",
                    "como baixar", "como usar o app"),

            // ── FAQ: Disponibilidade iOS ─────────────────────────────────────
            new Entry(
                    "Por enquanto o IntegraKids esta disponivel apenas para Android.\n" +
                            "O app foi desenvolvido com Android Studio e Java nativo,\n" +
                            "o que exigiria uma reescrita completa para funcionar no iOS.\n\n" +
                            "O desenvolvimento para iOS nao esta nos planos atuais,\n" +
                            "mas voce pode usar a plataforma normalmente pelo navegador\n" +
                            "no seu iPhone ou iPad acessando a versao web!",
                    "ios", "iphone", "ipad", "apple", "app store",
                    "nao tem pra iphone", "funciona no iphone", "disponivel para ios",
                    "quando vai ter pra ios", "por que nao tem pra ios",
                    "nao funciona no iphone"),

            // ── FAQ: Projeto Jornada da Inclusao ─────────────────────────────
            new Entry(
                    "O projeto Jornada da Inclusao foi desenvolvido por estudantes\n" +
                            "da Fatec com o objetivo de apoiar criancas com dificuldades\n" +
                            "de inclusao escolar, promovendo educacao de qualidade e acessivel.",
                    "jornada da inclusao", "sobre o projeto", "quem fez", "quem criou",
                    "projeto integrador", "fatec", "onde faz o app", "quem fez o app"),

            new Entry(
                    "O projeto contribui para os Objetivos de Desenvolvimento Sustentavel\n" +
                            "da ONU: ODS 4 (Educacao de Qualidade) e ODS 10 (Reducao das\n" +
                            "Desigualdades), promovendo uma educacao inclusiva e equitativa.",
                    "ods", "objetivo de desenvolvimento", "sustentavel", "onu",
                    "impacto social", "educacao inclusiva", "inclusao"),

            // ── FAQ: Integrantes ─────────────────────────────────────────────
            new Entry(
                    "O projeto Jornada da Inclusao foi desenvolvido por 5 estudantes\n" +
                            "do curso de Desenvolvimento de Software Multiplataforma da Fatec:\n\n" +
                            "- Luciana Guedes de Araujo\n" +
                            "- Manuela Tenorio da Silva\n" +
                            "- Marcos Vinicius de Oliveira\n" +
                            "- Pedro Henrique Santos Bernardo\n" +
                            "- Renato Winicius de Lima Jacob\n\n" +
                            "O projeto foi orientado pelo Prof. Edson Saraiva de Almeida\n" +
                            "na disciplina de Laboratorio de Desenvolvimento Web.",
                    "integrantes", "quem desenvolveu", "equipe", "time",
                    "desenvolvedores", "membros do projeto", "quem sao os criadores",
                    "autores", "orientador", "quem orientou", "curso"),

            // ── FAQ: Tecnologias e Arquitetura ───────────────────────────────
            new Entry(
                    "A plataforma utiliza a arquitetura MVC:\n" +
                            "- Web: React (frontend) + Spring Boot (backend)\n" +
                            "- Mobile: Android nativo com Java\n" +
                            "- Banco de dados: MySQL\n" +
                            "As camadas se comunicam por meio de APIs RESTful.",
                    "tecnologia", "tecnologias", "como foi feito", "arquitetura",
                    "mvc", "como funciona por dentro", "stack", "linguagem"),

            new Entry(
                    "O frontend web foi desenvolvido com React e hospedado no Firebase.\n" +
                            "O app mobile foi desenvolvido em Android com Java nativo,\n" +
                            "usando o Android Studio como ambiente de desenvolvimento.",
                    "frontend", "front end", "react", "android studio", "firebase",
                    "hospedagem frontend", "onde fica o frontend"),

            new Entry(
                    "O backend foi desenvolvido com Spring Boot (Java) e hospedado no Render.\n" +
                            "Ele expoe APIs RESTful consumidas tanto pelo app web quanto pelo mobile.",
                    "backend", "back end", "spring boot", "render", "api", "api rest",
                    "restful", "onde fica o backend", "hospedagem backend"),

            new Entry(
                    "O banco de dados utilizado e o MySQL, responsavel por armazenar\n" +
                            "informacoes de usuarios, dados das avaliacoes e resultados dos testes.",
                    "banco de dados", "mysql", "dados armazenados", "onde ficam os dados",
                    "persistencia", "armazenamento"),

            new Entry(
                    "O projeto utiliza arquitetura de microsservicos.\n" +
                            "O RabbitMQ e usado como mensageria para coordenar os microsservicos\n" +
                            "de confirmacao de e-mail e redefinicao de senha.",
                    "microsservico", "microsservicos", "rabbitmq", "mensageria",
                    "confirmacao de email", "email confirmacao"),

            // ── FAQ: Metodologia ─────────────────────────────────────────────
            new Entry(
                    "O projeto foi desenvolvido com a metodologia Scrum,\n" +
                            "dividido em sprints de duas semanas com tarefas designadas\n" +
                            "a cada membro da equipe.",
                    "metodologia", "scrum", "sprint", "como foi desenvolvido",
                    "processo de desenvolvimento", "gestao do projeto"),

            new Entry(
                    "As tarefas foram organizadas em cartoes no estilo Kanban.\n" +
                            "Ao final de cada sprint, cada membro apresenta o progresso\n" +
                            "e tarefas nao finalizadas sao realocadas para o proximo ciclo.",
                    "kanban", "tarefas", "organizacao das tarefas", "cartoes",
                    "scrum master", "sprint review"),

            new Entry(
                    "O codigo-fonte e versionado no GitHub, com uma branch dedicada\n" +
                            "ao deploy e branches separadas para desenvolvimento de cada recurso.\n" +
                            "O repositorio esta sob a conta organizacional do projeto.",
                    "github", "repositorio", "versionamento", "git", "branch",
                    "codigo fonte", "controle de versao"),

            // ── FAQ: Requisitos ──────────────────────────────────────────────
            new Entry(
                    "O product backlog do projeto inclui tres requisitos principais:\n" +
                            "1. Chatbot para duvidas dos responsaveis\n" +
                            "2. Progressao de niveis nos jogos\n" +
                            "3. Ferramentas de acessibilidade para as criancas",
                    "requisitos", "funcionalidades", "product backlog", "backlog",
                    "o que o app tem", "o que foi planejado", "o que vai ter"),

            new Entry(
                    "Sim! A progressao de niveis e um dos requisitos prioritarios da plataforma.\n" +
                            "O objetivo e que a crianca avance gradualmente nos jogos conforme\n" +
                            "demonstra evolucao no aprendizado.",
                    "progressao", "nivel", "niveis", "progressao de nivel",
                    "crianca progride", "dificuldade progressiva", "avanca de nivel"),

            // ── FAQ: Aba de Perfil ───────────────────────────────────────────
            new Entry(
                    "A aba de Perfil concentra todas as opcoes relacionadas\n" +
                            "a sua conta e aos avatares das criancas. Ela possui 6 opcoes:\n\n" +
                            "1. Editar dados do usuario - altere nome, email ou senha\n" +
                            "2. Criar avatar - cadastre um perfil para a crianca\n" +
                            "3. Editar avatar - altere os dados do perfil da crianca\n" +
                            "4. Ver resultados - acompanhe o desempenho nos jogos\n" +
                            "5. Trocar jogador - alterne entre os avatares cadastrados\n" +
                            "6. Logout - saia da sua conta\n\n" +
                            "Acesse pelo menu principal tocando no icone de perfil.",
                    "aba de perfil", "tela de perfil", "o que tem no perfil",
                    "opcoes do perfil", "menu de perfil", "o que faz o perfil",
                    "como usar o perfil", "perfil"),

            new Entry(
                    "Na opcao de editar dados do usuario voce pode atualizar\n" +
                            "as seguintes informacoes da sua conta:\n\n" +
                            "- Nome\n" +
                            "- E-mail\n" +
                            "- Senha\n\n" +
                            "Para alterar, acesse Perfil, toque em 'Editar dados'\n" +
                            "e atualize as informacoes desejadas.",
                    "editar dados", "mudar dados", "alterar nome", "alterar email",
                    "alterar senha", "mudar nome", "mudar email", "mudar senha",
                    "atualizar dados", "editar conta", "como mudar meus dados"),

            new Entry(
                    "O avatar e o perfil da crianca dentro do app!\n" +
                            "Para criar um avatar, acesse Perfil e toque em 'Criar avatar'.\n\n" +
                            "Durante a criacao voce define:\n" +
                            "- O boneco que representa a crianca\n" +
                            "- O nome do avatar\n" +
                            "- A data de nascimento\n" +
                            "- O genero\n\n" +
                            "Cada responsavel pode ter mais de um avatar cadastrado,\n" +
                            "um para cada crianca!",
                    "criar avatar", "cadastrar avatar", "avatar da crianca",
                    "como criar perfil da crianca", "como cadastrar crianca",
                    "adicionar crianca", "novo avatar", "criar perfil crianca"),

            new Entry(
                    "Para editar um avatar ja cadastrado, acesse Perfil\n" +
                            "e toque em 'Editar avatar'. Voce pode alterar:\n\n" +
                            "- O boneco do avatar\n" +
                            "- O nome da crianca\n" +
                            "- A data de nascimento\n" +
                            "- O genero\n\n" +
                            "As alteracoes sao salvas automaticamente!",
                    "editar avatar", "mudar avatar", "alterar avatar",
                    "mudar dados da crianca", "editar perfil da crianca",
                    "alterar nome da crianca", "mudar boneco", "editar boneco"),

            new Entry(
                    "Na opcao de resultados voce acompanha o desempenho\n" +
                            "da crianca nos jogos. Para cada atividade sao exibidos:\n\n" +
                            "- Tempo: quanto tempo levou para concluir\n" +
                            "- Tentativas: quantas vezes tentou\n" +
                            "- Acertos: quantidade de respostas corretas\n" +
                            "- Erros: quantidade de respostas incorretas\n\n" +
                            "Acesse Perfil e toque em 'Ver resultados' para acompanhar\n" +
                            "a evolucao da crianca!",
                    "resultados", "ver resultados", "desempenho", "historico",
                    "acertos e erros", "tempo de jogo", "tentativas",
                    "como ver o desempenho", "relatorio de jogos", "evolucao da crianca",
                    "estatisticas", "como a crianca foi"),

            new Entry(
                    "Caso voce tenha mais de um avatar cadastrado, e possivel\n" +
                            "alternar entre eles sem precisar sair da conta!\n\n" +
                            "Para trocar o jogador ativo, acesse Perfil e toque em\n" +
                            "'Trocar jogador'. Selecione o avatar desejado e\n" +
                            "os jogos passarao a registrar o desempenho desse perfil.",
                    "trocar jogador", "mudar jogador", "alternar avatar",
                    "trocar avatar", "mudar crianca", "outro perfil",
                    "como trocar de crianca", "selecionar jogador",
                    "como alternar entre criancas", "trocar perfil ativo"),

            new Entry(
                    "Para sair da sua conta com seguranca, acesse Perfil\n" +
                            "e toque em 'Logout' ao final da lista de opcoes.\n\n" +
                            "Voce sera redirecionado para a tela de login.\n" +
                            "Seus dados e o progresso das criancas ficam salvos\n" +
                            "para o proximo acesso!",
                    "logout", "sair", "sair da conta", "deslogar", "desconectar",
                    "como sair", "como fazer logout", "encerrar sessao",
                    "fechar conta", "sair do app"),

            // ── Saudacoes ────────────────────────────────────────────────────
            new Entry(
                    "Ola! Seja bem-vindo ao IntegraKids!\n" +
                            "Posso te ajudar com duvidas sobre a plataforma, jogos, cadastro\n" +
                            "e muito mais. O que voce gostaria de saber?",
                    "oi", "ola", "boa tarde", "bom dia", "boa noite", "oi tudo bem",
                    "ola tudo bem", "hey", "ei", "hello", "salve"),

            new Entry(
                    "Estou bem, obrigado por perguntar! E voce?\n" +
                            "Posso te ajudar com algo sobre o IntegraKids?",
                    "tudo bem voce", "como voce esta", "como vai", "tudo bem com voce"),

            // ── Tratativa de Ofensas ─────────────────────────────────────────
            new Entry(
                    "Entendo que as vezes as coisas podem ser frustrantes,\n" +
                            "mas estou aqui para te ajudar da melhor forma possivel!\n" +
                            "Tem algo que eu possa fazer por voce?",
                    "idiota", "burro", "inutil", "lixo", "pessimo", "horrivel",
                    "nao presta", "que merda", "merda", "droga", "que bosta",
                    "bosta", "otario", "estupido", "ridiculo", "uma bosta"),

            new Entry(
                    "Opa! Vamos manter a conversa por aqui, tudo bem?\n" +
                            "Estou aqui para ajudar com o IntegraKids. O que voce precisa?",
                    "cala boca", "cale boca", "vai se", "seu lixo", "chatbot lixo",
                    "odio voce", "te odeio", "horrivel isso", "que horror"),

            // ── Usuário Perdido / Primeiros Passos ─────────────────────────────

            new Entry(
                    "Sem problema 😊 Posso te orientar! Voce pode cadastrar uma crianca, acessar jogos, ver resultados ou ajustar configuracoes. Me diga o que deseja fazer.",
                    "to perdido aqui", "nao sei mexer", "como comeca", "como inicio",
                    "primeira vez aqui", "acabei de entrar", "nao sei usar isso",
                    "me ajuda a começar", "por onde começo", "como usa isso"),

            new Entry(
                    "Se estiver com duvida no menu, posso te explicar cada area do app: Perfil, Jogos, Resultados ou Configuracoes.",
                    "nao entendi o menu", "pra que serve o menu", "como mexe no menu",
                    "onde clico agora", "qual opcao escolho"),

            // ── Usuário Frustrado ──────────────────────────────────────────────

            new Entry(
                    "Entendo sua frustracao 😕 Vamos resolver isso juntos. Me conte exatamente o que aconteceu para eu tentar ajudar.",
                    "nada funciona aqui", "ja tentei tudo", "isso nao vai",
                    "to tentando faz tempo", "nao resolve", "so da erro"),

            new Entry(
                    "Calma, vamos por partes 😊 Me diga em qual tela ou funcao voce encontrou dificuldade.",
                    "complicado demais", "que dificuldade", "muito dificil mexer",
                    "nao consigo de jeito nenhum"),

            // ── Responsável preocupado ─────────────────────────────────────────

            new Entry(
                    "Cada crianca aprende em seu proprio ritmo 😊 O app foi criado para estimular o desenvolvimento de forma leve e gradual.",
                    "meu filho nao aprende", "minha filha nao aprende",
                    "ta dificil aprender", "nao evolui", "nao desenvolve"),

            new Entry(
                    "Nem toda crianca gosta de estudar no formato tradicional. Atividades interativas podem ajudar no interesse e engajamento.",
                    "nao gosta de estudar", "nao quer aprender",
                    "nao presta atencao", "sem interesse nos estudos"),

            // ── Curiosidade / Exploração ──────────────────────────────────────

            new Entry(
                    "O app oferece jogos educativos, acompanhamento de desempenho, perfis infantis, acessibilidade e suporte via chatbot.",
                    "o que mais tem", "quais recursos possui", "me mostra recursos",
                    "o que consigo fazer", "tem mais funcoes"),

            new Entry(
                    "Vale a pena para quem busca aprendizado leve, inclusivo e acompanhamento da evolucao da crianca.",
                    "vale a pena usar", "compensa usar", "e bom usar isso",
                    "vale testar"),

            // ── Confiança / Segurança ─────────────────────────────────────────

            new Entry(
                    "A plataforma foi desenvolvida para oferecer um ambiente seguro, educativo e adequado ao publico infantil.",
                    "posso confiar nisso", "isso e confiavel", "e seguro usar",
                    "tem risco usar"),

            new Entry(
                    "O app tem foco educacional e nao possui conteudos inadequados para criancas.",
                    "tem conteudo ruim", "tem coisa impropria", "serve pra crianca mesmo"),

            // ── Usuário Impaciente ────────────────────────────────────────────

            new Entry(
                    "Pode falar direto 😊 Me diga objetivamente o que voce precisa e vou responder rapido.",
                    "vai direto ao ponto", "responde logo", "fala rapido",
                    "sem enrolacao", "so responde"),

            // ── Criança falando com o bot ─────────────────────────────────────

            new Entry(
                    "Oiii 😊 Eu sou o assistente do IntegraKids! Posso conversar e te ajudar a encontrar jogos legais.",
                    "oi robozinho", "oi bot", "amiguinho", "qual seu nome",
                    "quem e voce robo"),

            new Entry(
                    "Oba! Vamos brincar e aprender juntos 😊 Voce gosta de letras, numeros, memoria ou cores?",
                    "quero brincar", "vamos brincar", "quero jogar agora",
                    "bora brincar"),

            new Entry(
                    "Voce e muito legal tambem 😊",
                    "voce e legal", "gosto de voce", "amei voce", "bot legal"),

            // ── Digitação quebrada / Mobile ───────────────────────────────────

            new Entry(
                    "Se estiver tentando entrar na conta, confira e-mail e senha. Se precisar, posso ajudar na recuperacao de acesso.",
                    "n entra", "na entra", "nao loga", "num vai login",
                    "n consigo entra"),

            new Entry(
                    "Se quiser trocar o perfil da crianca, posso te explicar rapidinho como fazer.",
                    "cm muda avatar", "como troca boneco", "troca perfil ai",
                    "muda crianca"),

            // ── Continuação de conversa ───────────────────────────────────────

            new Entry(
                    "Posso te explicar melhor 😊 Me diga qual parte voce nao encontrou.",
                    "nao achei", "onde exatamente", "cadê isso", "nao vi aqui"),

            new Entry(
                    "Claro 😊 Isso funciona tanto no celular quanto na versao web, dependendo da funcao.",
                    "no celular?", "no pc?", "no site?", "tambem no navegador?")
                );

    private static final List<String> OFFENSIVE_KEYWORDS = Arrays.asList(
            "idiota", "burro", "inutil", "lixo", "merda", "bosta",
            "otario", "estupido", "ridiculo", "horrivel", "pessimo",
            "cala boca", "te odeio", "seu lixo", "vai se");

    private static final String OFFENSIVE_RESPONSE = "Entendo que as vezes as coisas podem ser frustrantes,\n" +
            "mas estou aqui para te ajudar da melhor forma possivel!\n" +
            "Tem algo que eu possa fazer por voce?";

    public String findMatch(String normalizedInput) {
        for (String offensive : OFFENSIVE_KEYWORDS) {
            if (normalizedInput.contains(TextNormalizer.normalize(offensive))) {
                return OFFENSIVE_RESPONSE;
            }
        }
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