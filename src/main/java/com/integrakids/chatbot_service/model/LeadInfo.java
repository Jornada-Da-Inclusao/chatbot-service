package com.integrakids.chatbot_service.model;


public class LeadInfo {
    public String nome;
    public String empresa;
    public String email;
    public String telefone;
    public String infra;
    public String servidores;
    public String problema;

    // retorna true só se os 4 campos obrigatórios estão preenchidos
    public boolean isComplete() {
        return nome != null && !nome.isEmpty()
                && empresa != null && !empresa.isEmpty()
                && email != null && !email.isEmpty()
                && telefone != null && !telefone.isEmpty();
    }

    // copia os campos não-nulos de outro LeadInfo para este
    public void merge(LeadInfo update) {
        if (update.nome != null)
            this.nome = update.nome;
        if (update.empresa != null)
            this.empresa = update.empresa;
        if (update.email != null)
            this.email = update.email;
        if (update.telefone != null)
            this.telefone = update.telefone;
        if (update.infra != null)
            this.infra = update.infra;
        if (update.servidores != null)
            this.servidores = update.servidores;
        if (update.problema != null)
            this.problema = update.problema;
    }

    @Override
    public String toString() {
        return "nome='" + nome + "' | perfil='" + infra + "' | email='" + email + "'";
    }
}