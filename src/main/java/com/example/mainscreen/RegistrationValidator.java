package com.example.mainscreen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {
    public static String validate(String username, String password, String verifyPassword, String firstName, String lastName, String email, String address){
        String result = "";
        result += username(username);
        result += password(password, verifyPassword);
        result += firstName(firstName);
        result += lastName(lastName);
        result += email(email);
        result += address(address);
        return result;
    }
  private static String username(String username) {
      if (username.length() >= 4){
          return "";
      }else {
          return "Username must be at least 4 characters.\n";
      }
  }
    private static String password(String password, String verifyPassword) {
      String result = "";
        if (password.length() < 8){
           result += "Password must be at least 8 characters.\n";
        }
        if (!password.equals(verifyPassword)) {
            result += "Passwords must match.\n";
        }
        return result;
    }

    private static String firstName(String firstName) {
        if (!firstName.isEmpty()){
            return "";
        }else {
            return "First name cannot be blank.\n";
        }
    }

    private static String lastName(String lastName) {
        if (!lastName.isEmpty()){
            return "";
        }else {
            return "Last name cannot be blank.\n";
        }
    }

    private static String email(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return "";
        }
        return "Must enter a valid e-mail address.\n";
    }

    private static String address(String address) {
        if (!address.isEmpty()){
            return "";
        }else {
            return "Home address cannot be blank.\n";
        }
    }
}
