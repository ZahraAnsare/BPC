package org.example;

import java.util.List;
import java.util.Map;

public class Physiotherapist {
    private static int idCounter = 1;

    private int id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private List<String> expertiseAreas;
    private Map<String, String> workingTimetable;
    public TreatmentSchedule treatmentSchedule;

    public Physiotherapist(String fullName, String address, String phoneNumber,
                           List<String> expertiseAreas, Map<String, String> workingTimetable) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.expertiseAreas = expertiseAreas;
        this.workingTimetable = workingTimetable;
        this.treatmentSchedule = new TreatmentSchedule();
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getExpertiseAreas() {
        return expertiseAreas;
    }

    public Map<String, String> getWorkingTimetable() {
        return workingTimetable;
    }

    public TreatmentSchedule getTreatmentSchedule() {
        return treatmentSchedule;
    }

    @Override
    public String toString() {
        return "Physiotherapist{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", expertiseAreas=" + expertiseAreas +
                ", workingTimetable=" + workingTimetable +
                '}';
    }

    public static void resetIdCounter() {
        idCounter = 1;
    }
}
