package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyEmpStream {
    public static void main(String[] args) {
        execute();

        List<String> words = Arrays.asList("Hello", "world", "Java", "stream");

        // Join the elements with a comma delimiter, a prefix, and a suffix
        String joined = words.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(joined);



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Collect the integers into a list and calculate their sum
        int sum = numbers.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().mapToInt(Integer::intValue).sum()
                ));

        System.out.println("Sum: " + sum);
    }

    public static void execute(){
        ArrayList<Employee> employees=Employee.getEmployeeList();
        List<String> enames=employees.stream()
                .filter(e->e.getYearOfJoining()>2015)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(enames);
    }
}
