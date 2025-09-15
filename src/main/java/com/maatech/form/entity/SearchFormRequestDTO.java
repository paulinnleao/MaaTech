package com.maatech.form.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SearchFormRequestDTO {

    // Mandatory questions
    @Schema(description = "Tipo de dispositivo, ex: notebook, computador, ar condicionado", example = "notebook")
    private String primaryUse;

    @Schema(description = "Orçamento disponível para o produto", example = "1500.00")
    private double budget;

    @Schema(description = "Marca preferida pelo usuário", example = "Apple")
    private String preferredBrand;

    @Schema(description = "Nível de desempenho desejado", example = "Alto")
    private String performanceLevel;

    @Schema(description = "Número de usuários que irão utilizar o produto", example = "1")
    private int numberOfUsers;

    @Schema(description = "Indica se há limitações de espaço", example = "true")
    private boolean spaceLimitations;

    @Schema(description = "Frequência de uso do produto", example = "Diário")
    private String usageFrequency;

    // Optional questions
    @Schema(description = "Preferência de design ou cor", example = "Preto")
    private String preferredDesign;

    @Schema(description = "Prefere eficiência energética", example = "true")
    private boolean energyEfficiency;

    @Schema(description = "Necessita suporte técnico", example = "false")
    private boolean needTechnicalSupport;

    @Schema(description = "Deseja sugestões de acessórios", example = "true")
    private boolean suggestAccessories;

    @Schema(description = "Compatibilidade com outros dispositivos", example = "Windows, Android")
    private String deviceCompatibility;

    @Schema(description = "Nível de durabilidade esperado", example = "Alto")
    private String durabilityLevel;

    // Construtores
    public SearchFormRequestDTO() {}

    public SearchFormRequestDTO(String primaryUse, double budget, String preferredBrand, String performanceLevel,
                                int numberOfUsers, boolean spaceLimitations, String usageFrequency) {
        this.primaryUse = primaryUse;
        this.budget = budget;
        this.preferredBrand = preferredBrand;
        this.performanceLevel = performanceLevel;
        this.numberOfUsers = numberOfUsers;
        this.spaceLimitations = spaceLimitations;
        this.usageFrequency = usageFrequency;
    }

    public SearchFormRequestDTO(String primaryUse, double budget, String preferredBrand, String performanceLevel,
                                int numberOfUsers, boolean spaceLimitations, String usageFrequency,
                                String preferredDesign, boolean energyEfficiency, boolean needTechnicalSupport,
                                boolean suggestAccessories, String deviceCompatibility, String durabilityLevel) {
        this.primaryUse = primaryUse;
        this.budget = budget;
        this.preferredBrand = preferredBrand;
        this.performanceLevel = performanceLevel;
        this.numberOfUsers = numberOfUsers;
        this.spaceLimitations = spaceLimitations;
        this.usageFrequency = usageFrequency;
        this.preferredDesign = preferredDesign;
        this.energyEfficiency = energyEfficiency;
        this.needTechnicalSupport = needTechnicalSupport;
        this.suggestAccessories = suggestAccessories;
        this.deviceCompatibility = deviceCompatibility;
        this.durabilityLevel = durabilityLevel;
    }
}
