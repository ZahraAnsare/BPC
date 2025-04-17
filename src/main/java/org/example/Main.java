package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Physiotherapist> physioList = new ArrayList<>();
        ArrayList<Treatment> treatmentList = new ArrayList<>();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Physiotherapist");
            System.out.println("3. Add Treatment");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the ID of the patient: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the name of the patient: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the address of the patient: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter the phone number of the patient: ");
                    String phone = scanner.nextLine();

                    Patient patient = new Patient(id, name, address, phone);
                    patientList.add(patient);
                    System.out.println("Patient added: " + patient);
                    break;

                case 2:
                    System.out.print("Enter the name of the physiotherapist: ");
                    String physioName = scanner.nextLine();

                    System.out.print("Enter the address: ");
                    String physioAddress = scanner.nextLine();

                    System.out.print("Enter the phone number: ");
                    String physioPhone = scanner.nextLine();

                    System.out.println("Enter areas of expertise (comma-separated): ");
                    String expertiseInput = scanner.nextLine();
                    List<String> expertiseAreas = Arrays.asList(expertiseInput.split("\\s*,\\s*"));

                    Map<String, String> timetable = new HashMap<>();
                    System.out.println("Enter working timetable (type 'done' to finish):");
                    while (true) {
                        System.out.print("Day: ");
                        String day = scanner.nextLine();
                        if (day.equalsIgnoreCase("done")) break;

                        System.out.print("Working hours (e.g., 09:00 - 17:00): ");
                        String hours = scanner.nextLine();
                        timetable.put(day, hours);
                    }

                    Physiotherapist physio = new Physiotherapist(physioName, physioAddress, physioPhone, expertiseAreas, timetable);
                    physioList.add(physio);
                    System.out.println("Physiotherapist added: " + physio);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.out.println("\nAll patients:");
                    for (Patient p : patientList) {
                        System.out.println(p);
                    }
                    System.out.println("\nAll physiotherapists:");
                    for (Physiotherapist pt : physioList) {
                        System.out.println(pt);
                    }
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
