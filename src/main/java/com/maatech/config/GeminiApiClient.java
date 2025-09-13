package com.maatech.config;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GeminiApiClient {

    public static String sendRequest(GeminiRequest request, String apiKey) throws Exception {
        // 1. Defina os parâmetros da URL
        String projectId = "localizacao-407721"; // SEU PROJECT ID AQUI
        String region = "us-central1"; // Região válida e recomendada
        String modelName = "gemini-1.5-pro";

        // 2. Construa a URL correta para a API Vertex AI
        String urlString = String.format("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent",
                region, projectId, region, modelName);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // ... o resto do seu código permanece EXATAMENTE igual ...
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-goog-api-key", apiKey);
        connection.setDoOutput(true);

        String jsonInputString = convertToJson(request);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Código de resposta HTTP
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Decide de onde ler (sucesso ou erro)
        InputStream inputStream = (responseCode >= 200 && responseCode < 300)
                ? connection.getInputStream()
                : connection.getErrorStream();

        // Capturando a resposta da API
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            if (responseCode >= 200 && responseCode < 300) {
                return response.toString();
            } else {
                throw new IOException("Erro HTTP " + responseCode + ": " + response);
            }
        }
    }


    private static String convertToJson(GeminiRequest request) {
        // Aqui você pode usar uma biblioteca como Jackson ou Gson para converter o objeto para JSON
        // Exemplo usando Gson:
        com.google.gson.Gson gson = new com.google.gson.Gson();
        return gson.toJson(request);
    }
}
