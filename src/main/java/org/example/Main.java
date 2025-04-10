package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patientList = new ArrayList<>();

        while (true) {
            System.out.print("Enter the ID of the patient: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter the name of the patient: ");
            String name = scanner.nextLine();

            System.out.print("Enter the address of the patient: ");
            String address = scanner.nextLine();

            System.out.print("Enter the phone number of the patient: ");
            String phone = scanner.nextLine();

            Patient patient = new Patient(id, name, address, phone);
            patientList.add(patient);
            System.out.println("Patient added: " + patient);

            System.out.print("Do you want to add another patient? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();

        // Print all patients at the end
        System.out.println("\nAll patients entered:");
        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}


