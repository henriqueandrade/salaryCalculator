package org.salary.model;

import java.util.ArrayList;
import java.util.List;


public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private int managerId;
    private List<Employee> subordinates;

    public Employee() {
        this.subordinates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public double getAverageSubordinateSalary() {
        if (subordinates.isEmpty()) {
            return 0;
        }

        double totalSalary = 0;
        for (Employee subordinate : subordinates) {
            totalSalary += subordinate.getSalary();
        }

        return totalSalary / subordinates.size();
    }

    public void addSubordinate(Employee subordinate) {
        this.subordinates.add(subordinate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                ", subordinates=" + subordinates +
                '}';
    }

}
