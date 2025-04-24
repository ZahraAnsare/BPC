package org.example;

import java.time.LocalDateTime;

public class Treatment {
    private String treatmentName;
    private LocalDateTime dateTime;
    private Physiotherapist physiotherapist;

    // Constructor
    public Treatment(String treatmentName, LocalDateTime dateTime, Physiotherapist physiotherapist) {
        this.treatmentName = treatmentName;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
    }

    public Treatment(String treatmentName, String treatmentType, LocalDateTime dateTime, Physiotherapist physio) {
    }

    // Getter methods
    public String getTreatmentName() {
        return treatmentName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentName='" + treatmentName + '\'' +
                ", dateTime=" + dateTime +
                ", physiotherapist=" + physiotherapist.getFullName() +
                '}';
    }

    public String getTreatmentType() {
        return "";
    }
}
