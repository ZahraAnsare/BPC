package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private List<Physiotherapist> physioList;
    private List<Treatment> treatmentList;
    private List<Patient> patientList;
    private List<Appointment> appointmentList;

    @BeforeEach
    void setUp() {

        physioList = new ArrayList<>();
        physioList.add(new Physiotherapist("Dr. Rachel Green", "121 Rosewood Lane, W6 4DD", "07866262010", null, null));

        patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Jack Black", "67 Saxon Drive, W3 0DR", "07789967762"));

        treatmentList = new ArrayList<>();
        treatmentList.add(new Treatment("Acupuncture", null, physioList.get(0)));

        appointmentList = new ArrayList<>();
    }

    @Test
    void testBookAppointment_Success() {
        Appointment appointment = Main.bookAppointment(patientList.get(0), appointmentList, treatmentList.get(0));


        assertNotNull(appointment, "Appointment should be booked successfully.");
        assertEquals(1, appointmentList.size(), "There should be one appointment in the list.");
        assertEquals("Jack Black", appointment.getPatient().getName(), "The patient's name should be 'Jack Black'.");
        assertEquals("Acupuncture", appointment.getTreatment().getTreatmentName(), "The treatment should be 'Acupuncture'.");
    }



}
