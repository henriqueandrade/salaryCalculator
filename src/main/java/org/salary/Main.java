package org.salary;

import org.salary.model.Employee;
import org.salary.service.CsvService;
import org.salary.service.EmployeeService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");

        List<Employee> employees = CsvService.readEmployeesFromCSV("src/main/resources/employees.csv");

        EmployeeService employeeService = new EmployeeService(employees);

        System.out.println("Managers earning less than they should:");
        for(Employee manager: employeeService.findManagersEarningLessThanTheyShould()){
            System.out.println(manager.getFirstName() + " " + manager.getLastName());
        }

        System.out.println("\nManagers earning more than they should:");
        for(Employee manager: employeeService.findManagersEarningMoreThanTheyShould()){
            System.out.println(manager.getFirstName() + " " + manager.getLastName());
        }

        System.out.println("\nEmployees with reporting lines that are too long:");
        for(Employee employee: employeeService.findEmployeesWithTooLongReportingLines()) {
            System.out.println(employee.getFirstName() + " " + employee.getLastName());
        }

    }
}