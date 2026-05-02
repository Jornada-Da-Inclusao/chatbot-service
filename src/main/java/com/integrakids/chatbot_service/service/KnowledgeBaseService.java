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