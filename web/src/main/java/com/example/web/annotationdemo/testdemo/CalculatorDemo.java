package com.example.web.annotationdemo.testdemo;

public class CalculatorDemo {

    @Check
    public void checkAdd(){
        Calculator calculator = new Calculator();
        int add = calculator.add(2, 1);
        System.out.println(add);
    }

    @Check
    public void checkSub(){
        Calculator calculator = new Calculator();
        int sub = calculator.sub(2, 1);
        System.out.println(sub);
    }

    @Check
    public void checkMultiply(){
        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(2, 1);
        System.out.println(multiply);
    }

    @Check
    public void checkDivide(){
        Calculator calculator = new Calculator();
        int divide = calculator.divide(2, 1);
        System.out.println(divide);

        calculator.divide(2, 0);
    }

    public void test(){
        System.out.println("Every think is ok!");
    }
}
