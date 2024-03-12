package org.salary.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.salary.model.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CsvServiceTest {
    @Test
    public void testGetEmployeesFromCsv() {

        List<Employee> employees = CsvService.readEmployeesFromCSV("src/main/resources/employees.csv");
        assertEquals(5, employees.size());

        Employee employee1 = employees.get(0);
        assertEquals(123, employee1.getId());
        assertEquals("Joe", employee1.getFirstName());
        assertEquals("Doe", employee1.getLastName());
        assertEquals(60000, employee1.getSalary(), 0.0);
        assertEquals(0, employee1.getManagerId());

        Employee employee2 = employees.get(1);
        assertEquals(124, employee2.getId());
        assertEquals("Martin", employee2.getFirstName());
        assertEquals("Chekov", employee2.getLastName());
        assertEquals(45000, employee2.getSalary(), 0.0);
        assertEquals(123, employee2.getManagerId());

        Employee employee3 = employees.get(2);
        assertEquals(125, employee3.getId());
        assertEquals("Bob", employee3.getFirstName());
        assertEquals("Ronstad", employee3.getLastName());
        assertEquals(47000, employee3.getSalary(), 0.0);
        assertEquals(123, employee3.getManagerId());

        Employee employee4 = employees.get(3);
        assertEquals(300, employee4.getId());
        assertEquals("Alice", employee4.getFirstName());
        assertEquals("Hasacat", employee4.getLastName());
        assertEquals(50000, employee4.getSalary(), 0.0);
        assertEquals(124, employee4.getManagerId());

        Employee employee5 = employees.get(4);
        assertEquals(305, employee5.getId());
        assertEquals("Brett", employee5.getFirstName());
        assertEquals("Hardleaf", employee5.getLastName());
        assertEquals(34000, employee5.getSalary(), 0.0);
        assertEquals(300, employee5.getManagerId());
    }

}
