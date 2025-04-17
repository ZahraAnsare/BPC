package org.example;
import java.util.List;
import java.util.Map;

public class Patient {
    public int ID;
    public String FullName;
    public String Address;
    public String PhoneNumber;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Patient(int ID, String FullName, String Address, String PhoneNumber) {
        this.ID = ID;
        this.FullName = FullName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + ID +
                ", FullName='" + FullName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}


