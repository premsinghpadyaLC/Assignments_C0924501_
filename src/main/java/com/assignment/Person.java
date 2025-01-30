package com.assignment;

import java.util.Optional;

// Represents a Person with a name, age, and an optional Dog
public class Person {
    private String personName; // Name of the person
    private Integer personAge; // Age of the person
    private Optional<Dog> petDog; // Optional Dog object

    /**
     * Constructor to initialize a Person without a Dog.
     * @param personName The name of the person.
     * @param personAge The age of the person.
     */
    public Person(String personName, Integer personAge) {
        this(personName, personAge, null); // Delegate to the other constructor
    }

    /**
     * Constructor to initialize a Person with a Dog.
     * @param personName The name of the person.
     * @param personAge The age of the person.
     * @param petDog The Dog object (can be null).
     */
    public Person(String personName, Integer personAge, Dog petDog) {
        this.personName = personName;
        this.personAge = personAge;
        this.petDog = Optional.ofNullable(petDog); // Wrapping the Dog in an Optional
    }

    // Getters and Setters
    public String getPersonName() { return personName; }
    public void setPersonName(String personName) { this.personName = personName; }

    public Integer getPersonAge() { return personAge; }
    public void setPersonAge(Integer personAge) { this.personAge = personAge; }

    public Optional<Dog> getPetDog() { return petDog; }
    public void setPetDog(Dog petDog) { this.petDog = Optional.ofNullable(petDog); }

    /**
     * Checking if the person has a Dog that is 10 years old or older.
     * @return ing true if the person has a Dog with age >= 10, otherwise false.
     */
    public boolean hasOldDog() {
        return petDog.map(dog -> dog.getDogAge() >= 10).orElse(false); // Functional style, no if statements
    }

    /**
     * Changes the name of the Dog owned by the person.
     * @param newDogName The new name for the Dog.
     * @throws RuntimeException if the person does not own a Dog.
     */
    public void changeDogsName(String newDogName) {
        petDog.ifPresentOrElse(
            dog -> dog.setDogName(newDogName), // Change the dog's name
            () -> { throw new RuntimeException(personName + " does not own a dog!"); } // Throw exception
        );
    }

    // Overriding toString for better representation
    @Override
    public String toString() {
        return "Person{name='" + personName + '\'' +
               ", age=" + personAge +
               ", petDog=" + (petDog.isPresent() ? petDog.get() : "No Dog") +
               '}';
    }
}
