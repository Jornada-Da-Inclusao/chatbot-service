package com.integrakids.chatbot_service.util;

import java.text.Normalizer;

public class TextNormalizer {

    private TextNormalizer() {} // bloqueia instanciação

    public static String normalize(String text) {
        if (text == null) return "";
        // NFD separa o caractere base do acento (ex: "a" + "´")
        String decomposto = Normalizer.normalize(text, Normalizer.Form.NFD);
        // \p{M} remove todos os acentos separados
        return decomposto.replaceAll("\\p{M}", "").toLowerCase();
    }
}