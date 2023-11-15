package com.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmpStream {

    public static void main(String[] args) {
        getCountOfMaleFemale();
        getDepartmentName();
        getAverageAgeOfMaleFemale();
        getEmployeeJoinedAfter2017();
        getAverageAgeOfEmployeeDepartment();
        getAverageAgeOfEmployeeDepartment();
        getNameOfEmp2015();
        countEmpByDept();
        avgSalaryDept();
        olderEmpInDept();
        oldestEmpInDept();
        System.out.println("++++++++++++++++++");
        totalSalaryDept();
        getAvgTotalSummarizingStatisticsSalary();
        System.out.println("-----------------------");
        listDownEmpNameInDept();
        System.out.println("=======================================");
        seniorMostEmpDept();
        System.out.println("********************************************");
        seniorEmpComp();
        youngestEmpComp();
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::");
        myPartitioningByExample();
        myPartitioningByExample1();
        myReducingExample();
        femaleEmployeeDept();
    }
    public static void getCountOfMaleFemale(){
        System.out.println("getCountOfMaleFemale");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        long fcount=employees.stream().filter(e-> "female".equalsIgnoreCase(e.getGender())).count();
        System.out.println(fcount);
        long mcount=employees.stream().filter(e-> e.getGender().equalsIgnoreCase("male")).count();
        System.out.println(mcount);

        Map<String,Long> noOfMaleFemale=employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(noOfMaleFemale);

        Map<String, List<Employee>> noOfMaleFemale1=employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.toList()));
        System.out.println(noOfMaleFemale1);
    }

    public static void getDepartmentName(){
        System.out.println("getDepartmentName");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        List<String> departments=employees.stream()
                .map(e->e.getDepartment()).distinct().collect(Collectors.toList());
        System.out.println(departments);
    }

    public static void getAverageAgeOfMaleFemale(){
        System.out.println("getAverageAgeOfMaleFemale");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Double> avgAge=employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAge);
    }

    public static void getEmployeeJoinedAfter2017(){
        System.out.println("getEmployeeJoinedAfter2017");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        List<Employee> elist2017=employees.stream()
                .collect(Collectors.filtering(e->e.getYearOfJoining()>2017,Collectors.toList()));
        System.out.println(elist2017);
    }

    public static void getAverageAgeOfEmployeeDepartment(){
        System.out.println("getAverageAgeOfEmployeeDepartment");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Integer> avgAgeDpt=employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors.averagingInt(Employee::getAge),avgAge-> (int) Math.round(avgAge) )));
        System.out.println(avgAgeDpt);
    }

    public static void getNameOfEmp2015(){
        System.out.println("getNameOfEmp2015");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        List<String> names=employees.stream()
                .filter(e-> e.getYearOfJoining()>2015)
                .map(e-> e.getName())
                .collect(Collectors.toList());

        System.out.println(names);

    }

    public static void countEmpByDept(){
        System.out.println("countEmpByDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Long> empDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        System.out.println(empDept);
    }

    public static void avgSalaryDept(){
        System.out.println("avgSalaryDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Double> avgSalaryDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryDept);
    }

    public static void olderEmpInDept(){
        System.out.println("oldestEmpDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String, Optional<Employee>> oldEmpDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));

        for(Map.Entry<String,Optional<Employee>> e:oldEmpDept.entrySet()){
            System.out.print("Dept:"+e.getKey()+"::::::");
            System.out.println("Max Age:"+e.getValue().get().getAge());
        }
    }

    public static void oldestEmpInDept(){
        System.out.println("oldestEmpInDept()");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Optional<Employee>> oldestEmpDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))));

        for(Map.Entry<String,Optional<Employee>> e:oldestEmpDept.entrySet()){
            System.out.print("Dept:"+e.getKey()+"::::::");
            System.out.println("Max Age:"+e.getValue().get().getYearOfJoining());
        }
    }


    public static void totalSalaryDept(){
        System.out.println("totalSalaryDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Double> empSalaryDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)));
        System.out.println(empSalaryDept);
    }

    public static void getAvgTotalSummarizingStatisticsSalary(){
        System.out.println("getAvgTotalSummarizingStatisticsSalary");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        DoubleSummaryStatistics empSalary=employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("AverageSalary:"+empSalary.getAverage());
        System.out.println("Total Salary:"+empSalary.getSum());
        System.out.println("Max salary:"+empSalary.getMax());
    }

    public static void listDownEmpNameInDept(){
        System.out.println("listDownEmpDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,List<Employee>>  empListDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList)));
        for(Map.Entry<String,List<Employee>> e:empListDept.entrySet()){
            System.out.println("Deparment::::"+e.getKey());
            System.out.println(e.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
        }
        //System.out.println(empListDept);
    }

    public static void seniorMostEmpDept(){
        System.out.println("seniorMostEmpDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Optional<Employee>> seniorEmpDept=employees.stream()
                //.sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))));
        for(Map.Entry<String ,Optional<Employee>> e:seniorEmpDept.entrySet()){
            System.out.println("Department:::"+e.getKey());
            System.out.println("Senior Most Employee Name:::"+e.getValue().get().getName());
        }
        //System.out.println(seniorEmpDept);
    }

    public static void seniorEmpComp(){
        System.out.println("seniorEmpComp");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Optional<Employee> optEmp= employees.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        System.out.println(optEmp.get().getName());
        System.out.println(optEmp.get().getId());
        System.out.println(optEmp.get().getAge());
        System.out.println(optEmp.get().getDepartment());
        System.out.println(optEmp.get().getYearOfJoining());
    }

    public static void youngestEmpComp(){
        System.out.println("youngestEmpComp()");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        employees.stream()
                .max(Comparator.comparingInt(Employee::getYearOfJoining))
                .ifPresentOrElse(employee -> System.out.println(employee),()-> System.out.println("No Youngest Employee"));

        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining).reversed())
                .findFirst()
                .ifPresentOrElse(employee -> System.out.println(employee),()-> System.out.println("No Youngest Employee"));
    }

    public static void myPartitioningByExample(){
        System.out.println("myPartitioningByExample");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<Boolean,Long> empMapCount=employees.stream()
                .collect(Collectors.partitioningBy(e-> e.getAge()>25,Collectors.counting()));

        System.out.println(empMapCount);
    }

    public static void myPartitioningByExample1(){
        System.out.println("myPartitioningByExample1");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<Boolean,Long> femaleEmpCountComp=employees.stream()
                .collect(Collectors.partitioningBy(e-> e.getGender().equalsIgnoreCase("female"),Collectors.counting()));
        System.out.println(femaleEmpCountComp);
    }

    //The BinaryOperator is a functional interface and it extends BiFunction which takes two arguments of the same type
    // and returns a result of the same type of its arguments.
    public static void myReducingExample(){
        System.out.println("myReducingExample");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Optional<Employee>> empDeptMinSal= employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.reducing(BinaryOperator.minBy(Comparator.comparingDouble(Employee::getSalary)))));
        System.out.println(empDeptMinSal);Map<String,Optional<Employee>> empDeptMaxSal= employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
        System.out.println(empDeptMaxSal);
    }

    public static void femaleEmployeeDept(){
        System.out.println("femaleEmployeeDept");
        ArrayList<Employee> employees=Employee.getEmployeeList();
        Map<String,Integer> femaleEmpByDept=employees.stream()
                .collect(Collectors.filtering(e->"female".equalsIgnoreCase(e.getGender()),Collectors.toList()))
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.reducing(0,e->1,Integer::sum),count->count)));
        System.out.println(femaleEmpByDept);
    }
}

