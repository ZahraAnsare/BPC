package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TreatmentTest {

    private Physiotherapist physiotherapist;
    private LocalDateTime appointmentTime;
    private Treatment treatment;

    @BeforeEach
    void setUp() {
        Map<String, String> timetable = new HashMap<>();
        timetable.put("Wednesday", "08:00 - 16:00");

        physiotherapist = new Physiotherapist(
                "Dr. Sarah Lee",
                "20 Elm Street",
                "07998887766",
                Arrays.asList("Neuro Rehab", "Manual Therapy"),
                timetable
        );

        appointmentTime = LocalDateTime.of(2025, 6, 15, 9, 0);
        treatment = new Treatment("Neuro Rehab Session", "Neurological", appointmentTime, physiotherapist);
    }

    @Test
    void testTreatmentIsNotNull() {
        assertNotNull(treatment, "Treatment object should not be null");
    }

}
