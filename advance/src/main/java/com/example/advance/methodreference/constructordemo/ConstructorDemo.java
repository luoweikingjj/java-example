package com.example.advance.methodreference.constructordemo;

/**
 * 类的构造器引用
 */
public class ConstructorDemo {
    public static void main(String[] args) {
        printName("张三", 20, new PersonBuilder() {
            @Override
            public Person builderPerson(String name, int age) {
                return new Person(name, age);
            }
        });

        // Lambda
        printName("张三", 20, (name, age) -> new Person(name, age));

        // 类的构造器引用
        printName("张三", 20, Person::new);
    }

    private static void printName(String name, int age, PersonBuilder personBuilder) {
        Person person = personBuilder.builderPerson(name, age);
        System.out.println(person.getName() + "=" + person.getAge());
    }
}
