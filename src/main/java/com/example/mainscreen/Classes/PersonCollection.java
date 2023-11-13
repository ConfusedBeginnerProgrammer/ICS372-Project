package com.example.mainscreen.Classes;

import java.util.ArrayList;

import com.example.mainscreen.AbstractClasses.Person;

public class PersonCollection {
    private ArrayList<Person> people = new ArrayList<Person>();

    public ArrayList<Person> searchByLastName(String lName) {
        ArrayList<Person> searchResults = new ArrayList<Person>();
        Person currentPerson;
        for (int i = 0; i < people.size(); i++) {
            currentPerson = people.get(i);
            if (currentPerson.getLastName().equalsIgnoreCase(lName)) {
                searchResults.add(currentPerson);
            }
        }
        return searchResults;
    }

    public Person getById(int id) {
        Person currentPerson;
        for (int i = 0; i < people.size(); i++) {
            currentPerson = people.get(i);
            if (currentPerson.id == id) {
                return currentPerson;
            }
        }
        return null;
    }

    public Person getByUsername(String username) {
        Person currentPerson;
        for (int i = 0; i < people.size(); i++) {
            currentPerson = people.get(i);
            if (currentPerson.getUsername().equals(username)) {
                return currentPerson;
            }
        }
        return null;
    }

    public Person getByPassword(String password) {
        Person currentPerson;
        for (int i = 0; i < people.size(); i++) {
            currentPerson = people.get(i);
            if (currentPerson.getPassword().equals(password)) {
                return currentPerson;
            }
        }
        return null;
    }

    public boolean usernameExists(String username) {
        Person currentPerson;
        for (int i = 0; i < people.size(); i++) {
            currentPerson = people.get(i);
            if (currentPerson.getUsername().equals(username) ) {
                return true;
            }
        }
        return false;
    }

    public boolean passwordExists(String password) {
        Person currentPerson;
        for (int i = 0; i < people.size(); i++) {
            currentPerson = people.get(i);
            if (currentPerson.getPassword().equals(password) ) {
                return true;
            }
        }
        return false;
    }

    public boolean addPerson(Person person) {
        boolean found = false;
        for (int i = 0; i < people.size(); i++) { //ensure that usernames are unique
            if (people.get(i).getUsername().equals(person.getUsername())) {
                found = true;
                break;
            }
        }
        if (found) {
            return false;
        }
        people.add(person);
        return true;
    }

    public boolean deletePerson(Patient person) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) == person) {
                people.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean logIn(String username, String password) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getUsername().equals(username)) {
                if (people.get(i).checkPassword(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public String getPassword(String username) {

        if(usernameExists(username)){
            return getByUsername(username).getPassword();
        }
        return null;
    }

    public String getUsername(String password) {

        if(passwordExists(password)){
            return getByPassword(password).getUsername();
        }
        return null;
    }
}
