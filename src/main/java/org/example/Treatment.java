package org.example;

import java.time.LocalDateTime;

public class Treatment {
    private String treatmentName;
    private LocalDateTime dateTime;
    private Physiotherapist physiotherapist;
    private Patient patient; // Optional: assigned when booked

    public Treatment(String treatmentName, LocalDateTime dateTime, Physiotherapist physiotherapist) {
        this.treatmentName = treatmentName;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
    }

    public void assignPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

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
                ", physiotherapist=" + physiotherapist.FullName +
                (patient != null ? ", patient=" + patient.getName() : "") +
                '}';
    }
}