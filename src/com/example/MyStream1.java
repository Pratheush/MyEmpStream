package com.example;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream1 {
    public static void main(String[] args) {

        evenNumbers();
        numberStartingWith1();
        duplicateElements();
        findFirstElement();
        findTheTotalNumberOfElements();
        findMaxElement();
        firstNonRepeatedCharacters();
        firstRepeatedCharacter();
        sortedValuesReverseOrder();
        System.out.println("++++++++++++++++++++++++++++++++++++");
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        int[] nums1 = {1,2,3,4};
        System.out.println(containsDuplicate(nums1));
        java8DateNTime();
        java8ConcatenateStreams();
        cubeListElementFilter50();
        sortArrayConvertArray_Stream();
        mapListElementsToUpperCase();
        convertListOfObjectsToMapConsiderDuplicateKeysSortedOrder();
        countWordElementFrmArrayListToMapElementToKeyAndCountToValue();
        countOnlyDuplicateElementsFromStringArrayList();
        listOptionalCheckNullIfNotNullIterate();
        getMaxElementfrmArray();
        countOfEachCharacterInString();
    }

    public static void evenNumbers(){
        System.out.println("Given a list of integers, find out all the even numbers that exist in the list using Stream functions?");
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        list.stream().filter(i-> i%2==0).forEach(System.out::println);
    }
    public static void numberStartingWith1(){
        System.out.println("Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        List<Integer> i1list=myList.stream()
                .map(String::valueOf)
                .filter(s->s.startsWith("1"))
                .map(w-> Integer.parseInt(w))
                .collect(Collectors.toList());
        System.out.println(i1list);
    }

    public static void duplicateElements(){
        //How to find duplicate elements in a given integers list in java using Stream functions?
        System.out.println("How to find duplicate elements in a given integers list in java using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> duplicateElements=myList.stream()
                .collect(Collectors.toMap(k->k,v->1,(v1,v2)->v1+v2,LinkedHashMap::new))
                .entrySet()
                .stream()
                //.peek(e-> System.out.println(e.getKey()+":::::"+e.getValue()))
                .filter(e-> e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateElements);

        System.out.println("using HashSet");
        HashSet<Integer> nHashSet=new HashSet<>();
        Integer[] duplicateIntArray=myList.stream()
                .filter(n-> !nHashSet.add(n))
                .toList()
                .toArray(new Integer[0]);
        System.out.printf("Duplicate Integers from List into Array:::");
        for(Integer i:duplicateIntArray) System.out.print(i+",");
    }


    public static void findFirstElement(){
        System.out.println("\n Given the list of integers, find the first element of the list using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream()
                .findFirst()
                .ifPresentOrElse(e-> System.out.println("value is present:"+e),()-> System.out.println("value is empty"));

    }

    public static void findTheTotalNumberOfElements(){
        System.out.println("Given a list of integers, find the total number of elements present in the list using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Long ncount=myList.stream().count();
        System.out.println(ncount);

        int ncount1=myList.size();
        System.out.println(ncount1);
    }

    public static void findMaxElement(){
        System.out.println(" Given a list of integers, find the maximum value element present in it using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .ifPresentOrElse(e-> System.out.println("value is present:"+e),()-> System.out.println("value is not present"));

        int max =  myList.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

        Integer imax=myList.stream()
                .max(Comparator.comparingInt(Integer::intValue))
                //.orElse(0)
                .orElseGet(()->0);
        System.out.println(imax);

        // this will give error of unexpected type:  required reference but found int
        // In java we can't use primitive types directly as type arguments for generics correct way is to use wrapper class like List<Integer> ilist1=new ArrayList<>() so use Integer instead of int.
        // this is due to generics in java only accepting reference types and List expects objects not primitives.Autoboxing and boxing help in converting between primitive types and their corresponding wrapper classes when needed.
        // List<int> ilist=new ArrayList<int>(); // another experiment ArrayList() instance can't be created without generic<int> doesn't matter this statement will give error
        // List<Integer> ilist1=new ArrayList<>();
        // ilist.addAll(Arrays.asList(1,2,3,4,5));
        // ilist1.addAll(Arrays.asList(10,20,30,40,50));

        // valueOf() converting int into Integer and intValue() converting Integer into int and parseInt() converts a string to int
        // Integer inum=ilist.stream().max(Comparator.comparingInt(Integer::valueOf))  // gives incompatible types : as unable to infer the type : argument mismatch Object cannot be converted to int
           //     .get();
        // System.out.println(inum);

        int i=2;
        Integer ii=Integer.valueOf(i); // unnecessary boxing here value can be passed directly
        System.out.println(ii);
        int i2=ii;
        System.out.println(i2);

        int primitiveint=42;
        Integer wrapperInt=primitiveint; // Autoboxing : automatic conversion of primitive int to Integer i.e. primitive data type  to its corresponding wrapper class

        Integer wrapperInt1=43;
        int primitiveInt1=wrapperInt1; // autounboxing : automatically converting wrapper class to primitive type.
    }

    // .flatMap(s-> Stream.of(s.split(""))) flatMap operation flattens the stream of arrays into a single stream of strings. giving us stream of individual characters
    //  //.map(s-> s.split(""))  map operation would result in a stream of arrays of strings, where each array represents the characters of the corresponding string for example String "A" would be split into array ["A"]
    public static void firstNonRepeatedCharacters(){
        System.out.println("Given a String, find the first non-repeated character in it using Stream functions?");
        String input = "A Java articles are Awesome";
        String non_repeated_character=Stream.of(input)
                //.map(s-> s.split(""))   // this will give stream of string []
                .flatMap(s-> Stream.of(s.split("")))
                .peek(e-> System.out.println("non-repeated-characted-peek:::"+e))
                .collect(Collectors.toMap(k->k,v->1,(v1,v2)->v1+v2,LinkedHashMap::new))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(e->e.getKey())
                .collect(Collectors.joining(", ","[ "," ]"));
        //.forEach(System.out::print);
        System.out.println(non_repeated_character);

        //Function.identity() returns a Function that always returns it’s input argument.
        input.chars()
                //.peek(System.out::print)
                .mapToObj(s-> Character.toLowerCase(Character.valueOf((char)s)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(e->e.getKey())
                //.skip(1)
                .findFirst()
                .ifPresentOrElse((v)-> System.out.println("\n first non repeated character::"+v),()-> System.out.println("\n value is empty"));

        String secondNonRepeatedChar=Arrays.stream(input.split(""))
                .collect(Collectors.toCollection(ArrayList::new))
                .stream()
                .filter(n->Collections.frequency(Arrays.asList(input.split("")),n)==1)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .keySet().stream()
                .skip(1)
                .findFirst()
                .get();
        System.out.println("SECOND NON REPEATED CHARACTER IN STRING :> "+secondNonRepeatedChar);

        String secondNonRepeatedChar1=Arrays.stream(input.split(""))
                //.collect(Collectors.toCollection(ArrayList::new))
                //.stream()
                .filter(n->Collections.frequency(Arrays.asList(input.split("")),n)==1)
                .skip(1)
                .findFirst()
                .get();
        System.out.println("secondNonRepeatedChar1::::>>>"+secondNonRepeatedChar1);

        String secondNonRepeatedChar2=Arrays.asList(input.split("")).stream()
                .collect(Collectors.toMap(k->k,v->1,(v1,v2)->v1+v2,LinkedHashMap::new))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .orElseGet(()-> "No Second Non Repeated Char");
        System.out.println("secondNonRepeatedChar2::::>>>"+secondNonRepeatedChar2);

    }

    //  .mapToObj(s->Character.toLowerCase((char) s)) is used to convert the elements of a primitive stream (like IntStream,LongStream,DoubleStream) into their corresponding wrapper object representation.
    // like IntStream intstream=IntStream.of(1,2,3,4);
    // Stream<String> stringStream=intstream.mapToObj(String::valueOf) will convert each primitive int  to its string representation resulting Stream<String>
    public static void firstRepeatedCharacter(){
        System.out.println("Given a String, find the first repeated character in it using Stream functions?");
        String input = "A Java Articles are Awesome";
        input.chars()
                .mapToObj(s->Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(e->e.getKey())
                //.sorted(Comparator.reverseOrder())
                //.skip(2) // if we put 1 in skip() then it will skip one time and give space as the repeated character.
                //.findAny()
                .findFirst()
                .ifPresentOrElse(v-> System.out.println("first repeated character:"+v),()-> System.out.println("there is no repeated character"));


        List<String> strlist=Arrays.asList(input.split(""));
        System.out.println(strlist);
        input.chars()
                .mapToObj(s->String.valueOf(Character.toLowerCase((char)s)))
                //.peek(System.out::println)
                .filter(s->Collections.frequency(strlist,s)>1)
                //.peek(System.out::println)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .map(Map.Entry::getKey)
                //.keySet().stream()
                //.peek(System.out::print)
                .findFirst()
                        .ifPresentOrElse(e->System.out.println("FIRST REPEATED CHARACTER IN STRING::::"+e),()-> System.out.println("NO REPEATED CHARACTER"));

    }

    public static void sortedValuesReverseOrder(){
        System.out.println("Given a list of integers, sort all the values present in it using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> sortedList=myList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public static boolean containsDuplicate(int[] nums){
        //  int[] nums = {1,2,3,1};
        System.out.println("Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.");
        ArrayList<Integer> numlist=Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Set<Integer> numset=new HashSet<>(numlist);
        // return numset.size() < numlist.size();
        return numset.size()<numlist.size()?true:false;
    }

    public static void java8DateNTime(){
        System.out.println(" How will you get the current date and time using Java 8 Date and Time API?");
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time
    }

    public static void java8ConcatenateStreams(){
        System.out.println("Write a Java 8 program to concatenate two Streams?");
        String[] str={"Java","8"};
        List<String> list1 = Arrays.asList(str);
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream=Stream.concat(Arrays.stream(str),list2.stream());
        concatStream.forEach(s -> System.out.print(s+" "));
    }

    public static void cubeListElementFilter50(){
        System.out.println("\n Java 8 program to perform cube on list elements and filter numbers greater than 50.");
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream()
                .map(n->n*n*n)
                .filter(n->n>50)
                .forEach(s -> System.out.print(s+" "));
    }

    public static void sortArrayConvertArray_Stream(){
        System.out.println("\n Write a Java 8 program to sort an array and then convert the sorted array into Stream?");
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        // Sorted the Array using parallelSort()
        Arrays.parallelSort(arr);       // Sorts the specified array into ascending numerical order.
        for(int i:arr) System.out.print(i+" ");
        System.out.println();
        Arrays.stream(arr)
                .forEach(n -> System.out.print(n + " "));
        /* Converted it into Stream and then
           printed using forEach */

    }

    public static void mapListElementsToUpperCase(){
        System.out.println("\n How to use map to convert object into Uppercase in Java 8?");
        ArrayList<String> strlist=new ArrayList<>();
        strlist.add("Hello");
        strlist.add("Java");
        strlist.add("Ready To Code");
        strlist.stream().map(String::toUpperCase).forEach(e-> System.out.print(e+", "));
    }

    public static void convertListOfObjectsToMapConsiderDuplicateKeysSortedOrder(){
        System.out.println("\n How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?");
        ArrayList<Employee> elist=Employee.getEmployeeList();
        elist.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        Map<String,Integer> emap=elist.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(Collectors.toMap(Employee::getName,v->1, (v1,v2)->v1+v2,LinkedHashMap::new));
                //.collect(Collectors.toMap(Employee::getName,Employee::getAge, Integer::sum,LinkedHashMap::new));
        System.out.println(emap);

        Map<Employee,Long> emap1=elist.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(k->k,LinkedHashMap::new,Collectors.counting()));
        for(Map.Entry<Employee,Long> e:emap1.entrySet()) System.out.println(e.getKey()+"<<<<<>>>>>>>"+e.getValue());
    }

    public static void countWordElementFrmArrayListToMapElementToKeyAndCountToValue(){
        System.out.println(" How to count each element/word from the String ArrayList in Java8?");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> mnames=names.stream()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        //.entrySet().stream()
        //.forEach(e-> System.out.println(e.getKey()+":::"+e.getValue()));
        for(Map.Entry<String,Long> e:mnames.entrySet()) System.out.println(e.getKey()+"<<<<<>>>>>>>"+e.getValue());
    }

    public static void countOnlyDuplicateElementsFromStringArrayList(){
        System.out.println("\n How to find only duplicate elements with its count from the String ArrayList in Java8?");
        List<String> names = Arrays.asList("DD","AA", "BB", "AA", "CC","BB","DD","EE","FF","DD");
        Map<String,Long> dupElementCountMap=names.stream()
                .filter(n-> Collections.frequency(names,n)>1)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(dupElementCountMap);

        List<Map.Entry<String,Long>> dupElementCountMap1= names.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .toList();
        System.out.println("dupElementCountMap::::"+dupElementCountMap1);
    }

    public static void listOptionalCheckNullIfNotNullIterate(){
        System.out.println("How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?");
        List<Integer> integerList=Arrays.asList(10,8,9,7,5,6,3,4,2);
        List<Integer> integerList1=Arrays.asList();
        Optional.ofNullable(integerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                //.map(Integer::intValue)
                .forEach(e-> System.out.print(e+","));

        System.out.println();
        // Optional.ifPreset() If a value is present, performs the given action with the value, otherwise does nothing.
        // n.isEmpty() Returns true if this list contains no elements
        Optional<List<Integer>> optIntList=Optional.ofNullable(integerList);
        optIntList.ifPresent(n->{
            if(!n.isEmpty()){
                n.forEach(i->System.out.print(i+", "));
                //System.out.println(n+",");
            }
        });

       /* Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop through each object and consider non-null objects
                .map(note -> Notes::getTagName) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names*/
    }

    // getAsLong or getAsInt these are for primitive type streams like IntStream, LongStream, DoubleStream  and getAsLong() return primitive long value whereas Stream<Integer> as wrapper class stream
    // OptionalInt OptionalLong is a class in java.util like OptionalLong used to represent an optional long value, it either contains a long value or its empty
    // IntStream, LongStream, DoubleStream >> boxed() >> Stream<Integer>, Stream<Long>, Stream<Double>
    // Stream<Integer>, Stream<Long>, Stream<Double> :::> mapToInt / mapToLong / mapToDouble ::::>  IntStream, LongStream, DoubleStream
    public static void getMaxElementfrmArray(){
        System.out.println("\n Write a Program to find the Maximum element in an array?");
        long[] intarray={9,7,6,10,5};
        long i=Arrays.stream(intarray)
                .max()
                .getAsLong();
        System.out.println(i);

        Integer[] wrapperArray={9,7,6,10,5};
        int[] iArray=Arrays.stream(wrapperArray)
                .mapToInt(Integer::intValue)
                .toArray();
        int minInt=Arrays.stream(iArray)
                .min()
                .getAsInt();
        System.out.println("Minimum int from Integer Array::"+minInt);
    }

    public static void countOfEachCharacterInString(){
        System.out.println("Write a program to print the count of each character in a String?");
        //  Character.valueOf((char)s)  >> unnecessary boxing
        String str="Hello World I Love Java Coding Program";
        Map<Character,Long> countChars= str.chars()
                .mapToObj(s-> Character.toLowerCase(Character.valueOf((char)s)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(countChars);

        Map<String, Long> countChars1 = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s,LinkedHashMap::new, Collectors.counting()));
        System.out.println(countChars1);

        // to remove spaces in between string use !s.isBlank() if we use !s.isEmpty() this will not work
        Map<String,Integer>countChars2=Stream.of(str)
                .flatMap(s->Stream.of(str.split("")))
                .filter(s->!s.isBlank())
                .collect(Collectors.toMap(k->k,v->1,Integer::sum));
        System.out.println(countChars2);
    }

}

