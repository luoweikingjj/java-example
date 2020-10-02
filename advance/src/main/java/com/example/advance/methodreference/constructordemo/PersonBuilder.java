package com.example.advance.methodreference.constructordemo;

@FunctionalInterface
public interface PersonBuilder {
    Person builderPerson(String name, int age);
}
