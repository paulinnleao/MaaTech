package com.maatech.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiKeyProvider {

    // Carrega a chave do application.yaml
    @Value("${api.key}")
    private String apiKey;
}