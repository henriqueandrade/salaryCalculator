package org.salary.service;

import org.salary.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    public static List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
        addSubordinatesToManager();
    }

    public List<Employee> findManagersEarningMoreThanTheyShould() {
        List<Employee> managersEarningMore = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (employee.getSubordinates().size() > 0) { // Check if the employee is a manager
                double averageSalary = employee.getAverageSubordinateSalary();
                if (employee.getSalary() > averageSalary * 1.5) {
                    managersEarningMore.add(employee);
                }
            }
        }
        return managersEarningMore;
    }

    public List<Employee> findManagersEarningLessThanTheyShould() {
        List<Employee> managersEarningLess = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (employee.getSubordinates().size() > 0) { // Check if the employee is a manager
                double averageSalary = employee.getAverageSubordinateSalary();
                if (employee.getSalary() < averageSalary * 1.2) {
                    managersEarningLess.add(employee);
                }
            }
        }
        return managersEarningLess;
    }

    public List<Employee> findEmployeesWithTooLongReportingLines() {
        Map<Integer, Integer> managerLevels = new HashMap<>();
        managerLevels.put(0, 0); // Root level (CEO) has level 0
        List<Employee> employeesWithLongReportingLine = new ArrayList<>();
        for (Employee employee : this.employees) {
            int managerId = employee.getManagerId();
            if (managerId > 0) {
                int level = findManagerLevel(managerLevels, managerId);
                managerLevels.put(employee.getId(), level + 1);
            } else {
                managerLevels.put(employee.getId(), 0);
            }
        }

        for (Employee employee : employees) {
            int level = managerLevels.get(employee.getId());
            if (level > 4) {
                employeesWithLongReportingLine.add(employee);
            }
        }
        return employeesWithLongReportingLine;
    }

    private int findManagerLevel(Map<Integer, Integer> managerLevels, int managerId) {
        int level = 0;
        while (managerId > 0) {
            Employee employee = findEmployeeById(this.employees, managerId);
            if (employee == null) {
                throw new IllegalArgumentException("Invalid manager ID: " + managerId);
            }
            managerId = employee.getManagerId();
            level++;
        }
        return level;
    }

    public Employee findEmployeeById(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addSubordinatesToManager() {

        for (Employee employee : employees) {
            int managerId = employee.getManagerId();
            if (managerId > 0) {
                Employee manager = findEmployeeById(employees, managerId);
                if (manager != null) {
                    manager.addSubordinate(employee);
                }
            }
        }
    }
}
