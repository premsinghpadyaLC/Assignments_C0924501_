package com.assignment;

public class MainApplication {
    public static void main(String[] args) {
        // Creating a Person without a Dog
        Person person = new Person("John", 25);

        try {
            // Attempting to change the Dog's name (should throw an exception)
            person.changeDogsName("Max");
        } catch (RuntimeException e) {
            // Catching and printing the exception message
            System.out.println("Unable to change dog's name: " + e.getMessage());
        }
    }
}
