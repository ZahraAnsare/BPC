package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    void testPatientConstructorAndGetters() {

        int id = 1;
        String name = "Jack Black";
        String address = "67 Saxon Drive, W3 0DR";
        String phoneNumber = "07789967762";


        Patient patient = new Patient(id, name, address, phoneNumber);


        assertEquals(id, patient.getId());
        assertEquals(name, patient.getName());
        assertEquals(address, patient.getAddress());
        assertEquals(phoneNumber, patient.getPhoneNumber());
    }

    @Test
    void testPatientToString() {
        // Arrange
        Patient patient = new Patient(2, "Jane Doe", "123 Main St", "07000000000");

        // Act
        String patientString = patient.toString();

        // Assert
        assertTrue(patientString.contains("Jane Doe"));
        assertTrue(patientString.contains("123 Main St"));
        assertTrue(patientString.contains("07000000000"));
        assertTrue(patientString.contains("2"));
    }
}

