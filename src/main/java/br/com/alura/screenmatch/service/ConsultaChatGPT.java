package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
