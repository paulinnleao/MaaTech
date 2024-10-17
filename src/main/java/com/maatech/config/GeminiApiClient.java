package com.maatech.config;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GeminiApiClient {

    public static void sendRequest(GeminiRequest request, String apiKey) throws Exception {

        ApiKeyProvider apiKeyProvider = new ApiKeyProvider();

        // URL da API do Gemini
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKeyProvider.getApiKey());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Configurando o método e cabeçalhos
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Convertendo o objeto Java para JSON
        String jsonInputString = convertToJson(request);

        // Enviando os dados
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Lendo a resposta (opcional)
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Lógica para lidar com a resposta (se necessário)
    }

    private static String convertToJson(GeminiRequest request) {
        // Aqui você pode usar uma biblioteca como Jackson ou Gson para converter o objeto para JSON
        // Exemplo usando Gson:
        com.google.gson.Gson gson = new com.google.gson.Gson();
        return gson.toJson(request);
    }
}