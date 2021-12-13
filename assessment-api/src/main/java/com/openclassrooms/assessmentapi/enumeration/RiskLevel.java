package com.openclassrooms.assessmentapi.enumeration;

import lombok.Getter;

@Getter
public enum RiskLevel {

    NONE("None"),
    BORDERLINE("Borderline"),
    IN_DANGER("In danger"),
    EARLY_ONSET("Early onset");

    private String riskLevel;

    private RiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
