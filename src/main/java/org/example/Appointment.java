package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                "patient=" + patient +
                ", treatment=" + treatment +
                '}';
    }

    // Static method to handle booking logic
    public static Appointment bookAppointment(
            String physioName,
            List<Physiotherapist> physioList,
            List<Treatment> treatmentList,
            List<Patient> patientList,
            int patientId
    ) {
        Physiotherapist physio = null;

        // Step 1: Find the physiotherapist
        for (Physiotherapist p : physioList) {
            if (p.FullName.equalsIgnoreCase(physioName)) {
                physio = p;
                break;
            }
        }

        if (physio == null) {
            System.out.println("Physiotherapist not found.");
            return null;
        }

        // Step 2: Show available treatments for this physiotherapist
        List<Treatment> availableTreatments = new ArrayList<>();
        for (Treatment t : treatmentList) {
            if (t.getPhysiotherapist().equals(physio)) {
                availableTreatments.add(t);
            }
        }

        if (availableTreatments.isEmpty()) {
            System.out.println("No treatments available for this physiotherapist.");
            return null;
        }

        System.out.println("\nAvailable Treatments:");
        for (int i = 0; i < availableTreatments.size(); i++) {
            System.out.println((i + 1) + ". " + availableTreatments.get(i));
        }

        // Step 3: Let user choose one
        System.out.print("Select a treatment by number: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > availableTreatments.size()) {
            System.out.println("Invalid selection.");
            return null;
        }

        Treatment selectedTreatment = availableTreatments.get(choice - 1);

        // Step 4: Find the patient
        Patient selectedPatient = null;
        for (Patient p : patientList) {
            if (p.getID() == patientId) {
                selectedPatient = p;
                break;
            }
        }

        if (selectedPatient == null) {
            System.out.println("Patient not found.");
            return null;
        }

        // Step 5: Create and return appointment
        Appointment appointment = new Appointment(selectedPatient, selectedTreatment);
        System.out.println("Appointment booked: " + appointment);
        return appointment;
    }
}