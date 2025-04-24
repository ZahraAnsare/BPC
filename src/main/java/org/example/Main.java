package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Physiotherapist> physioList = new ArrayList<>();
        ArrayList<Treatment> treatmentList = new ArrayList<>();
        patientList.addAll(generateSamplePatients());
        physioList.addAll(generateSamplePhysiotherapists());
        generateSampleAppointments(treatmentList, patientList, physioList);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Physiotherapist");
            System.out.println("3. Add Treatment");
            System.out.println("4. Book an Appointment");
            System.out.println("5. Cancel an Appointment");
            System.out.println("6. Exit");

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
                    System.out.print("Enter treatment name: ");
                    String treatmentName = scanner.nextLine();

                    System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
                    String dateInput = scanner.nextLine();
                    LocalDateTime dateTime = LocalDateTime.parse(dateInput.replace(" ", "T"));

                    System.out.print("Enter physiotherapist name: ");
                    String physioSearch = scanner.nextLine();
                    Physiotherapist foundPhysio = null;

                    for (Physiotherapist p : physioList) {
                        if (p.getFullName().equalsIgnoreCase(physioSearch)) {
                            foundPhysio = p;
                            break;
                        }
                    }

                    if (foundPhysio == null) {
                        System.out.println("Physiotherapist not found.");
                    } else {
                        Treatment treatment = new Treatment(treatmentName, dateTime, foundPhysio);
                        treatmentList.add(treatment);
                        foundPhysio.treatmentSchedule.addTreatment(treatment);
                        System.out.println("Treatment added: " + treatment);
                    }
                    break;

                case 4:
                    System.out.print("Enter physiotherapist name: ");
                    physioName = scanner.nextLine();

                    System.out.print("Enter your patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();

                    Appointment booked = Appointment.bookAppointment(physioName, physioList, treatmentList, patientList, patientId);
                    break;

                case 5:
                    Appointment.cancelAppointment(scanner);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.out.println("\nAll patients:");
                    for (Patient p : patientList) System.out.println(p);
                    System.out.println("\nAll physiotherapists:");
                    for (Physiotherapist pt : physioList) System.out.println(pt);
                    System.out.println("\nAll treatments:");
                    for (Treatment t : treatmentList) System.out.println(t);
                    System.out.println("\nAll appointments:");
                    for (Appointment a : Appointment.getAllAppointments()) System.out.println(a);
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static List<Patient> generateSamplePatients() {
        return Arrays.asList(
                new Patient(1, "Jack Black", "67 Saxon Drive, W3 0DR", "07789967762"),
                new Patient(2, "James Smith", "45 Oak St, W10 4RE", "07655233210"),
                new Patient(3, "Charles Lewis", "79 Edgware Rd, W9 2DR", "07672242110"),
                new Patient(4, "Debora Williams", "31 Notting hill Rd, W4 6TE", "07572884009"),
                new Patient(5, "Evie Walker", "65 Birch St, W3 0RE", "07466524909"),
                new Patient(6, "Faith Brown", "98 Elm St, W9 6DQ", "07464069588"),
                new Patient(7, "Timothy Clarke", "11 Ash St, W2 4DQ", "07890122080"),
                new Patient(8, "Amy Williams", "2 Spruce St, W1 2DE", "07889660800"),
                new Patient(9, "Keira Knight", "33 Redwood St, W12 4DE", "07996262001"),
                new Patient(10, "Julie Andrews", "44 Willow St, W12 4RE", "07832260001")
        );
    }

    private static List<Physiotherapist> generateSamplePhysiotherapists() {
        List<Physiotherapist> physios = new ArrayList<>();

        Map<String, String> timetable = new HashMap<>();
        timetable.put("Monday", "09:00 - 17:00");
        timetable.put("Wednesday", "09:00 - 17:00");
        timetable.put("Friday", "09:00 - 17:00");

        physios.add(new Physiotherapist("Dr. Rachel Green", "121 Rosewood Lane, W6 4DD", "07866262010", Arrays.asList("Massage", "Acupuncture"), new HashMap<>(timetable)));
        physios.add(new Physiotherapist("Dr. Ava Parker", "22 Richwood Avenue, W3 4DR", "07976224010", Arrays.asList("Sports Injury", "Rehab"), new HashMap<>(timetable)));
        physios.add(new Physiotherapist("Dr. Emma Lewis", "77 Quentin Drive, N2 6GB", "07727210010", Arrays.asList("Joint Therapy", "Manual Therapy"), new HashMap<>(timetable)));
        physios.add(new Physiotherapist("Dr. Noah Harris", "46  Horsehill St", "07455667788", Arrays.asList("Musculoskeletal", "Orthopedics"), new HashMap<>(timetable)));
        physios.add(new Physiotherapist("Dr. Olivia Moore", "57 Kingswood Rd", "07567678899", Arrays.asList("Post-Surgical", "Cardio Rehab"), new HashMap<>(timetable)));

        return physios;
    }

    private static void generateSampleAppointments(ArrayList<Treatment> treatmentList, ArrayList<Patient> patients, ArrayList<Physiotherapist> physios) {

            treatmentList.add(new Treatment("Acupuncture", LocalDateTime.of(2025, 4, 21, 10, 0), physios.get(0))); // Monday
            treatmentList.add(new Treatment("Sports Injury", LocalDateTime.of(2025, 4, 23, 11, 0), physios.get(1))); // Wednesday

            treatmentList.add(new Treatment("Joint Therapy", LocalDateTime.of(2025, 4, 28, 9, 30), physios.get(2))); // Monday
            treatmentList.add(new Treatment("Orthopedics", LocalDateTime.of(2025, 4, 30, 14, 0), physios.get(3))); // Wednesday

            treatmentList.add(new Treatment("Post-Surgical", LocalDateTime.of(2025, 5, 5, 13, 0), physios.get(4))); // Monday
            treatmentList.add(new Treatment("Cardio Rehab", LocalDateTime.of(2025, 5, 7, 15, 0), physios.get(4))); // Wednesday

            treatmentList.add(new Treatment("Manual Therapy", LocalDateTime.of(2025, 5, 12, 10, 30), physios.get(2))); // Monday
            treatmentList.add(new Treatment("Massage", LocalDateTime.of(2025, 5, 14, 11, 15), physios.get(0))); // Wednesday

            treatmentList.add(new Treatment("Acupuncture", LocalDateTime.of(2025, 4, 25, 10, 30), physios.get(0))); // Friday
            treatmentList.add(new Treatment("Rehab", LocalDateTime.of(2025, 4, 25, 15, 30), physios.get(1))); // Friday

            treatmentList.add(new Treatment("Joint Therapy", LocalDateTime.of(2025, 5, 2, 9, 0), physios.get(2))); // Friday
            treatmentList.add(new Treatment("Orthopedics", LocalDateTime.of(2025, 5, 2, 14, 30), physios.get(3))); // Friday

            treatmentList.add(new Treatment("Post-Surgical", LocalDateTime.of(2025, 5, 9, 13, 15), physios.get(4))); // Friday
            treatmentList.add(new Treatment("Massage", LocalDateTime.of(2025, 5, 9, 10, 15), physios.get(0))); // Friday

            treatmentList.add(new Treatment("Sports Injury", LocalDateTime.of(2025, 5, 16, 11, 45), physios.get(1))); // Friday
            treatmentList.add(new Treatment("Manual Therapy", LocalDateTime.of(2025, 5, 16, 9, 15), physios.get(2))); // Friday
        }
    }


