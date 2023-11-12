package com.example.mainscreen.Classes;

import com.example.mainscreen.AbstractClasses.Person;

public class Provider extends Person {
    private String discipline;

    public Provider(String firstName, String lastName,String username, String password, String discipline) {
        super(firstName, lastName,username, password);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
