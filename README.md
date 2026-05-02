# Chatbot - IntegraKids

## Sobre
Microserviço de chatbot desenvolvido para a plataforma IntegraKids, voltada ao suporte de crianças com necessidades especiais. O chatbot atua como um assistente de atendimento, respondendo dúvidas frequentes sobre a plataforma e realizando a captura de leads interessados em um diagnóstico gratuito.

O serviço é construído em Java com Spring Boot, expondo uma API REST consumida pelo Front-End Web e Mobile do projeto.

## Repositórios adicionais
Segue abaixo os links das outras partes do projeto:

[Front-End Web](https://github.com/Jornada-Da-Inclusao/FrontEnd)

[Mobile](https://github.com/Jornada-Da-Inclusao/mobile)

[Back-End principal](https://github.com/Jornada-Da-Inclusao/BackEnd)

## Integrantes
- [Luciana Guedes de Araújo](https://github.com/Luciana-Guedes-de-Araujo)
- [Manuela Tenorio da Silva](https://github.com/ManuelaTenorio)
- [Marcos Vinícius de Oliveira](https://github.com/ViniMarkos283)
- [Pedro Henrique Santos Bernardo](https://github.com/Pedro-HSB)
- [Renato Wínicius de Lima Jacob](https://github.com/renatowljacob)

## Tecnologias
[![My Skills](https://skillicons.dev/icons?i=java,spring,docker,vscode&perline=4)](https://skillicons.dev)

- **Java 17**
- **Spring Boot 3** — framework para exposição da API REST
- **Docker** — containerização para deploy
- **Render** — hospedagem do microserviço em nuvem

## Endpoints disponíveis

### `GET /api/chat/start`
Inicia uma nova sessão do chatbot. Retorna o ID da sessão e a mensagem de boas-vindas.

**Resposta:**
```json
{
  "sessionId": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "welcomeMessage": {
    "role": "BOT",
    "text": "Ola! Sou o assistente da IntegraKids...",
    "quickActions": [...],
    "emotion": "NEUTRAL"
  }
}
```

### `POST /api/chat/message`
Envia uma mensagem para o chatbot e recebe a resposta.

**Corpo da requisição:**
```json
{
  "sessionId": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "text": "O app é gratuito?"
}
```

**Resposta:**
```json
{
  "role": "BOT",
  "text": "Sim! O aplicativo IntegraKids é gratuito...",
  "quickActions": [...],
  "emotion": "NEUTRAL"
}
```

## Utilização

### Rodando localmente
Baixe o repositório e execute na raiz do projeto:
```bash
./mvnw spring-boot:run
```
A API estará disponível em `http://localhost:8080`.

### Rodando com Docker
```bash
docker build -t chatbot-service .
docker run -p 8080:8080 chatbot-service
```

### Ambiente de produção
O serviço está hospedado no Render e pode ser acessado em:

https://chatbot-service-yu32.onrender.com

## Considerações Finais
Nós, desenvolvedores do projeto Jornada da Inclusão, agradecemos a contribuição e a orientação dos docentes das disciplinas que participaram desse projeto Integrador, e aos nossos colegas de turma e de outros ciclos que prestigiaram nossa apresentação e acessaram esse repositório para compreender melhor nosso projeto.
