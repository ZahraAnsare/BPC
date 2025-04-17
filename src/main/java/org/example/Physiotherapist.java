package org.example;

import java.util.List;
import java.util.Map;

public class Physiotherapist {
    private static int idCounter = 1; // Static counter shared by all instances

    public int ID;
    public String FullName;
    public String Address;
    public String PhoneNumber;
    public List<String> ExpertiseAreas;
    public Map<String, String> WorkingTimetable;
    public TreatmentSchedule treatmentSchedule;

    public Physiotherapist(String FullName, String Address, String PhoneNumber,
                           List<String> ExpertiseAreas, Map<String, String> WorkingTimetable) {
        this.ID = idCounter++; // Assign current value, then increment
        this.FullName = FullName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.ExpertiseAreas = ExpertiseAreas;
        this.WorkingTimetable = WorkingTimetable;
        this.treatmentSchedule = new TreatmentSchedule(); // Initialize TreatmentSchedule
    }



    @Override
    public String toString() {
        return "Physiotherapist{" +
                "ID=" + ID +
                ", FullName='" + FullName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", ExpertiseAreas=" + ExpertiseAreas +
                ", WorkingTimetable=" + WorkingTimetable +
                ", treatmentSchedule=" + treatmentSchedule +
                '}';
    }
}