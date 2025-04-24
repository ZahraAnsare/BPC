package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appointment {
    private Patient patient;
    private Treatment treatment;

    // Static list to store all appointments
    private static final List<Appointment> allAppointments = new ArrayList<>();

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

    public static List<Appointment> getAllAppointments() {
        return allAppointments;
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
        Scanner scanner = new Scanner(System.in);
        Physiotherapist physio = null;

        for (Physiotherapist p : physioList) {
            if (p.getFullName().equalsIgnoreCase(physioName)) {
                physio = p;
                break;
            }
        }

        if (physio == null) {
            System.out.println("Physiotherapist not found.");
            return null;
        }

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

        System.out.print("Select a treatment by number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > availableTreatments.size()) {
            System.out.println("Invalid selection.");
            return null;
        }

        Treatment selectedTreatment = availableTreatments.get(choice - 1);

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

        Appointment appointment = new Appointment(selectedPatient, selectedTreatment);
        allAppointments.add(appointment);

        System.out.println("Appointment booked: " + appointment);
        return appointment;
    }

    // Static method to cancel appointment
    public static void cancelAppointment(Scanner scanner) {
        if (allAppointments.isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }

        System.out.println("\nAll Appointments:");
        for (int i = 0; i < allAppointments.size(); i++) {
            System.out.println((i + 1) + ". " + allAppointments.get(i));
        }

        System.out.print("Enter the number of the appointment to cancel: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > allAppointments.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Appointment cancelled = allAppointments.remove(choice - 1);
        System.out.println("Cancelled appointment: " + cancelled);
    }
}
