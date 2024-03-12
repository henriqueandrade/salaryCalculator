package org.salary.service;

import org.junit.Test;
import org.salary.model.Employee;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService(CsvService.readEmployeesFromCSV("src/main/resources/employees-test.csv"));

    @Test
    public void testFindManagersEarningLessThanTheyShould() {
        List<Employee> managersEarningLessThanTheyShould = employeeService.findManagersEarningLessThanTheyShould();

        assertEquals(6, managersEarningLessThanTheyShould.size());
        assertEquals(124, managersEarningLessThanTheyShould.get(0).getId());
    }

    @Test
    public void testFindManagersEarningMoreThanTheyShould() {

        List<Employee> managersEarningMoreThanTheyShould = employeeService.findManagersEarningMoreThanTheyShould();

        assertEquals(1, managersEarningMoreThanTheyShould.size());
        assertEquals(123, managersEarningMoreThanTheyShould.get(0).getId());
    }

    @Test
    public void testFindEmployeesWithTooLongReportingLines() {

        List<Employee> employeesWithTooLongReportingLines = employeeService.findEmployeesWithTooLongReportingLines();

        assertFalse(employeesWithTooLongReportingLines.isEmpty());
        assertEquals(5, employeesWithTooLongReportingLines.size());
    }

}
