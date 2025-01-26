package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DogPersonTest {

    @Test
    public void testDogCreation() {
        Dog dog = new Dog("Buddy", 5);
        assertEquals("Buddy", dog.getName());
        assertEquals(5, dog.getAge());
    }

    @Test
    public void testPersonWithoutDog() {
        Person person = new Person("John", 30);
        assertFalse(person.hasOldDog());
    }

    @Test
    public void testPersonWithOldDog() {
        Dog oldDog = new Dog("Max", 12);
        Person person = new Person("Jane", 40, oldDog);
        assertTrue(person.hasOldDog());
    }

    @Test
    public void testChangeDogsNameWithDog() {
        Dog dog = new Dog("Buddy", 5);
        Person person = new Person("John", 30, dog);
        person.changeDogsName("Charlie");
        assertEquals("Charlie", dog.getName());
    }

    @Test
    public void testChangeDogsNameWithoutDog() {
        Person person = new Person("John", 30);
        Exception exception = assertThrows(RuntimeException.class, () -> person.changeDogsName("Buddy"));
        assertEquals("John does not own a dog!", exception.getMessage());
    }
}
