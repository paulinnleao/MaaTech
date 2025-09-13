package com.maatech.form.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maatech.config.ApiKeyProvider;
import com.maatech.config.GeminiApiClient;
import com.maatech.config.GeminiRequest;
import com.maatech.form.entity.SearchFormRequestDTO;

@Service
public class SearchFormServiceImp implements SearchFormService {

    @Override
    public ResponseEntity<?> findTheProductForm(SearchFormRequestDTO form) {
        StringBuilder query = new StringBuilder();
        query.append("Me recomende uma lista com 20 nomes dos produtos lançados até 06/2024. Eu quero apenas os nomes em formato de lista. E que Atenda as seguintes características: \n\n");

        // Campos obrigatórios
        query.append("primary use: ").append(form.getPrimaryUse());
        query.append(" budget: ").append(form.getBudget());
        query.append(" preferred brand: ").append(form.getPreferredBrand());  // Corrigido
        query.append(" performance level: ").append(form.getPerformanceLevel());
        query.append(" number of users: ").append(form.getNumberOfUsers());
        query.append(" space limitations: ").append(form.isSpaceLimitations());
        query.append(" usage frequency: ").append(form.getUsageFrequency());

        // Campos opcionais
        if (!form.getPreferredDesign().isEmpty()) {
            query.append(" preferred design: ").append(form.getPreferredDesign());
        }
        if (!form.isEnergyEfficiency()) {
            query.append(" energy efficiency: ").append(form.isEnergyEfficiency());
        }
        if (!form.isNeedTechnicalSupport()) {
            query.append(" need technical support: ").append(form.isNeedTechnicalSupport());
        }
        if (!form.isSuggestAccessories()) {
            query.append(" suggest accessories: ").append(form.isSuggestAccessories());
        }
        if (!form.getDeviceCompatibility().isEmpty()) {
            query.append(" device compatibility: ").append(form.getDeviceCompatibility());
        }
        if (!form.getDurabilityLevel().isEmpty()) {
            query.append(" durability level: ").append(form.getDurabilityLevel());
        }

        query.append("\n\n.Apenas escreva a lista. Frases antes e depois podem me atrapalhar.");

        try {
            // Chave da API fornecida
            ApiKeyProvider apiKeyProvider = new ApiKeyProvider();

            // Construindo o request para a API Gemini
            GeminiRequest.Part part = new GeminiRequest.Part(query.toString());
            GeminiRequest.Content content = new GeminiRequest.Content(List.of(part));
            GeminiRequest request = new GeminiRequest(List.of(content));

            // Enviando requisição para a API Gemini
            String response = GeminiApiClient.sendRequest(request, "AIzaSyCDl5g6vC9BZF7OqfU_Jmwv-VSp93xBmFE");

            // Processando a resposta da API
            return ResponseEntity.ok(response);  // Retornando a resposta JSON da API

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
