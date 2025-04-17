package org.example;

import java.time.LocalDateTime;

public class Treatment {
    public String name;
    public LocalDateTime dateTime;
    public Physiotherapist physiotherapist;
    public Patient patient; // null if not yet booked
    public String status; // booked, cancelled, attended

    public Treatment(String name, LocalDateTime dateTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
        this.status = "available";
    }

    public void bookTreatment(Patient patient) {
        this.patient = patient;
        this.status = "booked";
    }

    public void cancelTreatment() {
        this.patient = null;
        this.status = "cancelled";
    }

    public void attendTreatment() {
        if (status.equals("booked")) {
            this.status = "attended";
        }
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", physiotherapist=" + physiotherapist.FullName +
                ", patient=" + (patient != null ? patient.FullName : "None") +
                ", status='" + status + '\'' +
                '}';
    }
}