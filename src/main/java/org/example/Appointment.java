package org.example;


public class Appointment {
    private Patient patient;
    private Treatment treatment;

    public Appointment(Patient patient, Treatment treatment) {
        this.patient = patient;
        this.treatment = treatment;
    }

    public Patient getPatient() {
        return patient;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient.getName() +
                ", treatment=" + treatment.getTreatmentName() +
                ", date=" + treatment.getDateTime() +
                '}';
    }
}
