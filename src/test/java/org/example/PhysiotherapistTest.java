package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PhysiotherapistTest {

    @Test
    void testPhysiotherapistConstructorAndGetters() {
        String name = "Dr. Rachel Green";
        String address = "121 Rosewood Lane, W6 4DD";
        String phone = "07866262010";
        List<String> expertise = Arrays.asList("Massage", "Acupuncture");
        Map<String, String> timetable = new HashMap<>();
        timetable.put("Monday", "09:00 - 17:00");
        timetable.put("Wednesday", "09:00 - 17:00");

        Physiotherapist physio = new Physiotherapist(name, address, phone, expertise, timetable);

        assertEquals(name, physio.getFullName());
        assertEquals(address, physio.getAddress());
        assertEquals(phone, physio.getPhoneNumber());
        assertEquals(expertise, physio.getExpertiseAreas());
        assertEquals(timetable, physio.getWorkingTimetable());
    }

    @Test
    void testEmptyTimetableAndExpertise() {
        List<String> emptyExpertise = new ArrayList<>();
        Map<String, String> emptyTimetable = new HashMap<>();

        Physiotherapist physio = new Physiotherapist("Dr. No Skills", "No Address", "0000000000",
                emptyExpertise, emptyTimetable);

        assertTrue(physio.getExpertiseAreas().isEmpty());
        assertTrue(physio.getWorkingTimetable().isEmpty());
    }
}
