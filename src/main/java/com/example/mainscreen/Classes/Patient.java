package com.example.mainscreen.Classes;

import com.example.mainscreen.AbstractClasses.Person;

public class Patient extends Person {
    private String email;
    private String address;

    public Patient(String firstName, String lastName,String username,String password, String email, String address) {
        super(firstName, lastName,username, password);
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
