package com.example;

public class MainApplication {
    public static void main(String[] args) {
        // Create a Person without a Dog
        Person person = new Person("John", 30);
        
        try {
            // Try changing the dog's name (should throw exception)
            person.changeDogsName("Buddy");
        } catch (RuntimeException e) {
            // Catch and display the exception message
            System.out.println("Unable to change dog's name: " + e.getMessage());
        }
    }
}
