package com.maatech.form.entity;

import lombok.Data;

@Data
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

    public SearchFormRequestDTO(String primaryUse, double budget, String preferredBrand, String performanceLevel, int numberOfUsers, boolean spaceLimitations, String usageFrequency, String preferredDesign, boolean energyEfficiency, boolean needTechnicalSupport, boolean suggestAccessories, String deviceCompatibility, String durabilityLevel) {
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

    public SearchFormRequestDTO() {
    }

    public String getPrimaryUse() {
        return primaryUse;
    }

    public void setPrimaryUse(String primaryUse) {
        this.primaryUse = primaryUse;
    }

    public boolean isSuggestAccessories() {
        return suggestAccessories;
    }

    public void setSuggestAccessories(boolean suggestAccessories) {
        this.suggestAccessories = suggestAccessories;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getPreferredBrand() {
        return preferredBrand;
    }

    public void setPreferredBrand(String preferredBrand) {
        this.preferredBrand = preferredBrand;
    }

    public String getPerformanceLevel() {
        return performanceLevel;
    }

    public void setPerformanceLevel(String performanceLevel) {
        this.performanceLevel = performanceLevel;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public boolean isSpaceLimitations() {
        return spaceLimitations;
    }

    public void setSpaceLimitations(boolean spaceLimitations) {
        this.spaceLimitations = spaceLimitations;
    }

    public String getUsageFrequency() {
        return usageFrequency;
    }

    public void setUsageFrequency(String usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public String getPreferredDesign() {
        return preferredDesign;
    }

    public void setPreferredDesign(String preferredDesign) {
        this.preferredDesign = preferredDesign;
    }

    public boolean isEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(boolean energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    public boolean isNeedTechnicalSupport() {
        return needTechnicalSupport;
    }

    public void setNeedTechnicalSupport(boolean needTechnicalSupport) {
        this.needTechnicalSupport = needTechnicalSupport;
    }

    public String getDeviceCompatibility() {
        return deviceCompatibility;
    }

    public void setDeviceCompatibility(String deviceCompatibility) {
        this.deviceCompatibility = deviceCompatibility;
    }

    public String getDurabilityLevel() {
        return durabilityLevel;
    }

    public void setDurabilityLevel(String durabilityLevel) {
        this.durabilityLevel = durabilityLevel;
    }
}
