package com.openclassrooms.assessmentapi.enumeration;

import lombok.Getter;

/**
 * The enum Diabetes trigger.
 */
@Getter
public enum DiabetesTrigger {

    /**
     * The Hemoglobin a 1 c.
     */
    HEMOGLOBIN_A1C("Hemoglobin A1C"),
    /**
     * Microalbumin diabetes trigger.
     */
    MICROALBUMIN("Microalbumin"),
    /**
     * Height diabetes trigger.
     */
    HEIGHT("Height"),
    /**
     * Weight diabetes trigger.
     */
    WEIGHT("Weight"),
    /**
     * Smoker diabetes trigger.
     */
    SMOKER("Smoker"),
    /**
     * Abnormal diabetes trigger.
     */
    ABNORMAL("Abnormal"),
    /**
     * Cholesterol diabetes trigger.
     */
    CHOLESTEROL("Cholesterol"),
    /**
     * Dizziness diabetes trigger.
     */
    DIZZINESS("Dizziness"),
    /**
     * Relapse diabetes trigger.
     */
    RELAPSE("Relapse"),
    /**
     * Reaction diabetes trigger.
     */
    REACTION("Reaction"),
    /**
     * Antibodies diabetes trigger.
     */
    ANTIBODIES("Antibodies");

    private String trigger;

    DiabetesTrigger(final String trigger) {
        this.trigger = trigger;
    }
}
