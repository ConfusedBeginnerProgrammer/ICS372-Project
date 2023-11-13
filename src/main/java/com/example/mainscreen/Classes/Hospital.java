package com.example.mainscreen.Classes;

import com.example.mainscreen.AbstractClasses.Person;

public class Hospital {
    private static Hospital hospital = new Hospital();
    PersonCollection users = new PersonCollection();
    PersonCollection patients = new PersonCollection();
    PersonCollection providers = new PersonCollection();

    private Hospital() {}

    public static Hospital get() {
        return hospital;
    }

    public void addPatient(Patient patient) {
        patients.addPerson(patient);
        users.addPerson(patient);
    }

    public void addProvider(Provider provider) {
        providers.addPerson(provider);
        users.addPerson(provider);
    }

    public boolean registerPatient(String fName, String lName,String username, String password, String email, String address) {
        if (!users.usernameExists(username)) {
            Patient newPatient = new Patient(fName, lName, username, password, email, address);
            Hospital.get().addPatient(newPatient);
            return true;
        }
        return false;
    }

    public boolean registerProvider(String fName, String lName,String username, String password, String discipline) {
        if (!users.usernameExists(username)) {
            Provider newProvider = new Provider(fName, lName, username, password, discipline);
            Hospital.get().addProvider(newProvider);
            return true;
        }
        return false;
    }

    public boolean logIn(String username, String password) {
        return users.logIn(username, password);
    }

    public PersonCollection getUsers() {

        return users;
    }
}
