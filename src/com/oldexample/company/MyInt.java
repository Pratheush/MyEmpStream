package com.oldexample.company;


import com.example.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyInt {
    public static void main(String[] args) {
        int[] intarray={9,7,6,10,5};
        OptionalInt i=Arrays.stream(intarray).max();
        System.out.println(i);

        Optional i2=Arrays.stream(intarray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        //.get();
        System.out.println(i2);

        if(i2.isPresent()) System.out.println(i2.get());


        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
        Optional secondLargestNumber = numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(2).peek(System.out::println)
                .skip(1)
                .findFirst();
        //.get();
        System.out.println(secondLargestNumber);

        if(secondLargestNumber.isPresent()) System.out.println(secondLargestNumber.get());

        ArrayList<Employee> employeeArrayList=Employee.getEmployeeList();
        Map<String,Double> empNameSalary=employeeArrayList.stream()
                .collect(Collectors.toMap(Employee::getName,Employee::getSalary));
        System.out.println(empNameSalary);

        boolean answer= Stream.generate(new Random()::nextInt).limit(5).anyMatch(n-> (n%2)==0);
        boolean answer1=employeeArrayList.stream().map(Employee::getName).anyMatch(e-> e.startsWith("z"));
        System.out.println(answer1);
    }
}
