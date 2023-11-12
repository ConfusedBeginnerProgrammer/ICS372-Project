package com.example.mainscreen.Classes;

public class Appointment {
    private Patient patient;
    private Provider provider;
    private Department department;

    public Appointment(Patient patient, Provider provider, Department department){
        this.patient = patient;
        this.department = department;
        this.provider = provider;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
