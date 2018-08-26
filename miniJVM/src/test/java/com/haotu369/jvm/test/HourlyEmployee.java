package com.haotu369.jvm.test;

public class HourlyEmployee extends EmployeeV2 {

    int hourlySalary;

    public HourlyEmployee(String name, int age, int hourlySalary) {
        super(name, age);
        this.hourlySalary = hourlySalary;
    }

    public static void main(String[] args) {
        EmployeeV2 e = new HourlyEmployee("Lisa", 20, 40);
        e.sayHello();
    }

    public int getHourlySalary() {
        return this.hourlySalary;
    }
}