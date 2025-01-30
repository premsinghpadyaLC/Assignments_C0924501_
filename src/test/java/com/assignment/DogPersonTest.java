package com.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DogPersonTest {

    @Test
    public void testDogCreation() {
        Dog dog = new Dog("Buddy", 5);
        assertEquals("Buddy", dog.getDogName());
        assertEquals(5, dog.getDogAge());
    }

    @Test
    public void testPersonWithoutDog() {
        Person person = new Person("John", 25);
        assertFalse(person.hasOldDog());
    }

    @Test
    public void testPersonWithOldDog() {
        Dog oldDog = new Dog("Charlie", 12);
        Person person = new Person("Bob", 40, oldDog);
        assertTrue(person.hasOldDog());
    }

    @Test
    public void testChangeDogsNameWithDog() {
        Dog dog = new Dog("Buddy", 5);
        Person person = new Person("John", 25, dog);
        person.changeDogsName("Rocky");
        assertEquals("Rocky", dog.getDogName());
    }

    @Test
    public void testChangeDogsNameWithoutDog() {
        Person person = new Person("John", 25);
        Exception exception = assertThrows(RuntimeException.class, () -> person.changeDogsName("Max"));
        assertEquals("John does not own a dog!", exception.getMessage());
    }
}

