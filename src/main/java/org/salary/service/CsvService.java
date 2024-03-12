package org.salary.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.salary.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CsvService {

    public static List<Employee> readEmployeesFromCSV(String file) {
        List<Employee> employees = Collections.emptyList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            employees = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }


}
