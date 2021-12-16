package com.openclassrooms.assessmentapi.enumeration;

import lombok.Getter;

/**
 * The enum Risk level.
 */
@Getter
public enum RiskLevel {

    /**
     * None risk level.
     */
    NONE("None"),
    /**
     * Borderline risk level.
     */
    BORDERLINE("Borderline"),
    /**
     * The In danger.
     */
    IN_DANGER("In danger"),
    /**
     * The Early onset.
     */
    EARLY_ONSET("Early onset");

    private String riskLevel;

    private RiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
