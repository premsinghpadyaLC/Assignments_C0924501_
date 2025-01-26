package com.example;

// Represents a Dog with a name and age
public class Dog {
    private String name;
    private Integer age;

    // Constructor to initialize Dog
    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    // Overriding equals for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return name.equals(dog.name) && age.equals(dog.age);
    }

    // Overriding hashCode to maintain consistency with equals
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age.hashCode();
    }
}
