package com.example.web.reflectdemo;


public class Person {
    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {
    }

    public Person(String a) {
        this.a = a;
    }

    protected Person(String a, String b) {
        this.a = a;
        this.b = b;
    }

    Person(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Person(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Person{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public void publicMethod() {
        // public method
    }

    protected void protectedMethod() {
        // protected method
    }

    void defaultMethod() {
        // default
    }

    private void privateMethod() {
        // private method
    }
}
