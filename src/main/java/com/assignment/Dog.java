package com.assignment;

// Represents a Dog with a name and age
public class Dog {
    private String dogName; // Name of the dog
    private Integer dogAge; // Age of the dog

    /**
     * Constructor to initialize the Dog object with name and age.
     * @param dogName The name of the dog.
     * @param dogAge The age of the dog.
     */
    public Dog(String dogName, Integer dogAge) {
        this.dogName = dogName;
        this.dogAge = dogAge;
    }

    // Getters and Setters for dogName and dogAge
    public String getDogName() { return dogName; }
    public void setDogName(String dogName) { this.dogName = dogName; }

    public Integer getDogAge() { return dogAge; }
    public void setDogAge(Integer dogAge) { this.dogAge = dogAge; }

    // Overriding equals for comparing Dog objects based on name and age
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same reference
        if (o == null || getClass() != o.getClass()) return false; // Null or different class check
        Dog dog = (Dog) o;
        return dogName.equals(dog.dogName) && dogAge.equals(dog.dogAge); // Compare attributes
    }

    // Overriding hashCode for consistency with equals
    @Override
    public int hashCode() {
        return 31 * dogName.hashCode() + dogAge.hashCode(); // Generating unique hash
    }
}
