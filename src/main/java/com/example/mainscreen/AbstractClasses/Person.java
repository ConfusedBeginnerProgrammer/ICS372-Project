package com.example.mainscreen.AbstractClasses;

public abstract class Person {
    private String firstName;
    private String lastName;
    public final int id;
    private String username;
    private String password;

    private static int idCount = 0; // for auto generating ids

    public Person(String firstName, String lastName,String username, String password){
        Person.idCount += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.id = Person.idCount;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() { return username; }

    public boolean checkPassword(String passwordAttempt) {
        return passwordAttempt.equals(this.password);
    }
}
