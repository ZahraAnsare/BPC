package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;


class AppointmentTest {

    private List<Physiotherapist> physioList;
    private List<Treatment> treatmentList;
    private List<Patient> patientList;

    @BeforeEach
    void setUp() {

        physioList = new ArrayList<>();
        physioList.add(new Physiotherapist("Dr. Rachel Green", "121 Rosewood Lane, W6 4DD", "07866262010", null, null));

        patientList = new ArrayList<>();
        patientList.add(new Patient(1, "Jack Black", "67 Saxon Drive, W3 0DR", "07789967762"));

        treatmentList = new ArrayList<>();
        treatmentList.add(new Treatment("Acupuncture", null, physioList.get(0)));
    }

    @Test
    void testBookAppointment_Success() {
        Appointment appointment = Appointment.bookAppointment(
                "Dr. Rachel Green", physioList, treatmentList, patientList, 1
        );

        assertNotNull(appointment, "Appointment should be booked successfully.");
        assertEquals(1, Appointment.getAllAppointments().size(), "There should be one appointment in the list.");
        assertEquals("Jack Black", appointment.getPatient().getName(), "The patient's name should be 'Jack Black'.");
        assertEquals("Acupuncture", appointment.getTreatment().getTreatmentName(), "The treatment should be 'Acupuncture'.");
    }

    @Test
    void testBookAppointment_PhysiotherapistNotFound() {
        Appointment appointment = Appointment.bookAppointment(
                "Dr. Nonexistent", physioList, treatmentList, patientList, 1
        );

        assertNull(appointment, "Appointment should not be booked for a non-existent physiotherapist.");
    }

    @Test
    void testBookAppointment_TreatmentNotAvailable() {
        physioList.add(new Physiotherapist("Dr. Ava Parker", "22 Richwood Avenue, W3 4DR", "07976224010", null, null));

        Appointment appointment = Appointment.bookAppointment(
                "Dr. Ava Parker", physioList, treatmentList, patientList, 1
        );

        assertNull(appointment, "Appointment should not be booked if no treatments are available.");
    }

    @Test
    void testCancelAppointment_Success() {
        Appointment.bookAppointment(
                "Dr. Rachel Green", physioList, treatmentList, patientList, 1
        );

        Scanner scanner = new Scanner(System.in);
        Appointment.cancelAppointment(scanner);

        assertEquals(0, Appointment.getAllAppointments().size(), "There should be no appointments after cancellation.");
    }

    @Test
    void testCancelAppointment_NoAppointments() {
        Scanner scanner = new Scanner(System.in);
        Appointment.cancelAppointment(scanner);

        assertEquals(0, Appointment.getAllAppointments().size(), "There should be no appointments to cancel.");
    }
}
