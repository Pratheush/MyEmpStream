package com.oldexample.company;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WefArray {
    //Given a string array ["hello","world"], using streams , print all unique characters
    public static void main(String[] args) {
        String[] str={"hello","world"};

        List<String> uniqueList = Arrays.stream(str)
                .flatMap(st -> Arrays.stream(st.split(""))).peek(System.out::println)
                .collect(Collectors.toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println(uniqueList);

        List<String> words=Arrays.asList("Hello","world","java","streams");
        List<String> characters=words.stream().flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());
        System.out.println(characters);

        List<Character> chars=words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char)c))
                .collect(Collectors.toList());
        System.out.println(chars);

        List<Stream<Character>> char2=words.stream()
                .map(word -> word.chars().mapToObj(c -> (char)c))
                .collect(Collectors.toList());
        System.out.println(char2);

        System.out.println(characters);
        //System.out.println(chars);

        List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8);
        // gives new stream as long as it satisfy given predicate once an element
        // is encountered that doest not satisfy predicate streams stops no further elements are included
        List<Integer> result=nums.stream().takeWhile(n->n<4).collect(Collectors.toList());
        System.out.println(result);

        List<Integer> nums1=Arrays.asList(1,2,3,4,5,6,7,8);
        // gives new stream that excludes elements as long as it satisfy given predicate once an element
        // is encountered that doest not satisfy predicate remaining elements are included in the output stream.
        result=nums1.stream().dropWhile(n->n<4).collect(Collectors.toList());
        System.out.println(result);

        List<Integer> nums2=Arrays.asList(1,2,3,4,5,6,7,8);
        boolean isParallel=nums2.stream().isParallel();
        System.out.println("Is the stream parallel "+isParallel);

        // allows you to work with streams in parallel
        // converts sequential stream into parallel stream that process the elements concurrently
        // parallel streams is effective when performing operations that can be divided easily among threads such as filtering or mapping large data sets
        List<Integer> nums3=Arrays.asList(1,2,3,4,5,6,7,8);
        nums3.stream().parallel().forEach(n-> System.out.println("Thread:"+Thread.currentThread().getName()+", Number::"+n));

        List<Integer> nums4=Arrays.asList(1,2,3,4,5,6,7,8);
        int sumOfSquares=nums4.parallelStream().mapToInt(n-> n*n).sum();
        System.out.println(sumOfSquares);

        List<Integer> nums5=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // spliterator() is used to get a Spliterator from the stream.
        Spliterator<Integer> spliterator=nums5.stream().spliterator();
        // trySplit() is used to attempt to split the Spliterator into two parts.
        spliterator.trySplit().forEachRemaining(n-> System.out.println("Thread::"+Thread.currentThread().getName()+" , Numbers::"+n));

        // BinaryOperator takes 2 arguments of same type and returns a result of same type of its arguments
        // BiFunction takes two arguments of any type and returns a result of any type.
        BinaryOperator<Integer> add=(n1,n2) -> n1+n2;
        int result1=add.apply(4,5);
        System.out.println(result1);

        List<Integer> nums6=Arrays.asList(1,2,3,4,4,3,2,1,6,7,9,10,7,5);
        HashSet<Integer> iset=new HashSet<>(nums6);
        List<Integer> iSetList= new ArrayList<>(iset);
        System.out.println(iSetList);

        HashMap<String,String> strHashMap=new HashMap<>();
        strHashMap.put("1","1");
        strHashMap.put("2","2");
        strHashMap.put("3","4");
        System.out.println("Hashmap PUT()::"+strHashMap.put("3","3"));

        HashMap<String,String> stringHashMap1=new HashMap<>(strHashMap);
        for(Map.Entry<String,String> e:stringHashMap1.entrySet()){
            System.out.println(e.getKey()+":::"+e.getValue());
        }

        HashSet<String> strHashSet=new HashSet<>();
        strHashSet.add(null);
        strHashSet.add(null);
        System.out.println(strHashSet);


    }
}
