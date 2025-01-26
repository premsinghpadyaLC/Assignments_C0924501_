package com.example;

import java.util.Optional;  // To handle Optional dog

// Represents a Person with a name, age, and an optional Dog
public class Person {
    private String name;  // Name of the person
    private int age;      // Age of the person
    private Optional<Dog> dog;  // Optional Dog, can be null

    // Constructor to initialize Person with name, age, and no dog
    public Person(String name, int age) {
        this(name, age, null);  // Calls the constructor below with a null dog
    }

    // Constructor to initialize Person with name, age, and an optional Dog
    public Person(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.ofNullable(dog);  // Wrap dog in Optional
    }

    // Getter for the name of the person
    public String getName() {
        return name;
    }

    // Setter for the name of the person
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the age of the person
    public int getAge() {
        return age;
    }

    // Setter for the age of the person
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for the optional Dog
    public Optional<Dog> getDog() {
        return dog;
    }

    // Setter for the optional Dog
    public void setDog(Dog dog) {
        this.dog = Optional.ofNullable(dog);
    }

    // Method to check if the person has a dog and if the dog is older than 10 years
    public boolean hasOldDog() {
        // Return true if the dog exists and its age is 10 or greater
        return dog.filter(d -> d.getAge() >= 10).isPresent();
    }

    // Method to change the dog's name if the person owns a dog
    public void changeDogsName(String newName) {
        dog.ifPresentOrElse(d -> d.setName(newName),
                            () -> { throw new RuntimeException(name + " does not own a dog!"); });
    }

    // Overriding toString for better debugging and display of information
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", dog=" + dog.orElse(null) + "}";
    }
}
