package com.maatech.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GeminiApiClient {

    public static String sendRequest(GeminiRequest request, String apiKey) throws Exception {

        // URL da API do Gemini
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey);
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

        // Lendo a resposta
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Capturando a resposta da API
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }

    private static String convertToJson(GeminiRequest request) {
        // Aqui você pode usar uma biblioteca como Jackson ou Gson para converter o objeto para JSON
        // Exemplo usando Gson:
        com.google.gson.Gson gson = new com.google.gson.Gson();
        return gson.toJson(request);
    }
}
