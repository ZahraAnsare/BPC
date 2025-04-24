package org.example;

public class Patient {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    // Constructor
    public Patient(int id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "', address='" + address + "', phoneNumber='" + phoneNumber + "'}";
    }
}
