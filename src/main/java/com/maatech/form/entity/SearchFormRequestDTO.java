package com.maatech.form.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SearchFormRequestDTO {

    // Mandatory questions
    private String primaryUse;         // Utilidade principal
    private double budget;             // Orçamento
    private String preferredBrand;     // Preferência de marca
    private String performanceLevel;   // Nível de desempenho
    private int numberOfUsers;         // Número de usuários
    private boolean spaceLimitations;  // Limitações de espaço
    private String usageFrequency;     // Frequência de uso

    // Optional questions
    private String preferredDesign;    // Preferência de design ou cor
    private boolean energyEfficiency;  // Preferência por eficiência energética
    private boolean needTechnicalSupport; // Necessidade de suporte técnico
    private boolean suggestAccessories;   // Sugestões de acessórios
    private boolean acceptRefurbished;    // Aceitação de produtos recondicionados
    private String deviceCompatibility;   // Compatibilidade com outros dispositivos
    private String durabilityLevel;       // Nível de durabilidade

    public SearchFormRequestDTO(
            String primaryUse,
            double budget,
            String preferredBrand,
            String performanceLevel,
            int numberOfUsers,
            boolean spaceLimitations,
            String usageFrequency
            ) {
        this.primaryUse = primaryUse;
        this.budget = budget;
        this.preferredBrand = preferredBrand;
        this.performanceLevel = performanceLevel;
        this.numberOfUsers = numberOfUsers;
        this.spaceLimitations = spaceLimitations;
        this.usageFrequency = usageFrequency;
    }

    public SearchFormRequestDTO(String primaryUse, double budget, String preferredBrand, String performanceLevel, int numberOfUsers, boolean spaceLimitations, String usageFrequency, String preferredDesign, boolean energyEfficiency, boolean needTechnicalSupport, boolean suggestAccessories, boolean acceptRefurbished, String deviceCompatibility, String durabilityLevel) {
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
        this.acceptRefurbished = acceptRefurbished;
        this.deviceCompatibility = deviceCompatibility;
        this.durabilityLevel = durabilityLevel;
    }

    public SearchFormRequestDTO() {
    }
}
