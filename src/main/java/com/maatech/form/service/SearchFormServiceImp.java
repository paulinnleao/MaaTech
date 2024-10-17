package com.maatech.form.service;

import com.maatech.config.ApiKeyProvider;
import com.maatech.config.GeminiApiClient;
import com.maatech.config.GeminiRequest;
import com.maatech.form.entity.SearchFormRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class SearchFormServiceImp implements SearchFormService{
    @Override
    public ResponseEntity<?> findTheProductForm(SearchFormRequestDTO form) {
        StringBuilder query = new StringBuilder();
        query.append("Faça uma busca refinada do seguinte. ");

        // Mandatory
        query.append("primary use: ").append(form.getPrimaryUse());
        query.append(" budget: ").append(form.getBudget());
        query.append(" preferred brand: ").append(form.getBudget());
        query.append(" performance level: ").append(form.getPerformanceLevel());
        query.append(" number of users: ").append(form.getNumberOfUsers());
        query.append(" space limitations:").append(form.isSpaceLimitations());
        query.append(" usage frequency:").append(form.getUsageFrequency());

        //Optionals
        if(!form.getPreferredDesign().isEmpty()){
            query.append(" preferred design: ").append(form.getPreferredDesign());
        }
        if(!form.isEnergyEfficiency()){
            query.append(" energy efficiency: ").append(form.isEnergyEfficiency());
        }
        if(!form.isNeedTechnicalSupport()){
            query.append(" need technical support: ").append(form.isNeedTechnicalSupport());
        }
        if(!form.isSuggestAccessories()){
            query.append(" suggest accessories: ").append(form.isSuggestAccessories());
        }
        if(!form.getDeviceCompatibility().isEmpty()){
            query.append(" device compatibility: ").append(form.getDeviceCompatibility());
        }
        if(!form.getDurabilityLevel().isEmpty()){
            query.append(" durability level: ").append(form.getDurabilityLevel());
        }

        query.append(" busque apenas os top 20 até a sua última atualização. Forneça apenas os nomes, nada mais e nada menos.");

        try{
            ApiKeyProvider apiKeyProvider = new ApiKeyProvider();

            GeminiRequest.Part part = new GeminiRequest.Part(query.toString());
            GeminiRequest.Content content = new GeminiRequest.Content(Arrays.asList(part));
            GeminiRequest request = new GeminiRequest(Arrays.asList(content));

            GeminiApiClient.sendRequest(request, apiKeyProvider.getApiKey());

        }catch(Exception e){
            e.printStackTrace();
        }



        return null;
    }
}
