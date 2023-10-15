package com.example;

import java.util.*;

public class Java_Hunger1 {
    public static void main(String[] args) {
        array_to_treeset();
        hashset_to_TreeSet();
    }

    public static void array_to_treeset(){
        Integer[] num = {7,34,45,23,38,56,21};
        List<Integer> ilist= Arrays.asList(num);
        Set<Integer> iset=new TreeSet<>(ilist);
        for(Integer i:iset) System.out.println(i);
    }

    public static void hashset_to_TreeSet(){
        System.out.println("hashset_to_TreeSet and vice-versa possible from treeset-hashset");
        // Creating a HashSet object
        HashSet<String> hashset = new HashSet<>();

        // Putting elements to HashSet object
        hashset.add("Air");
        hashset.add("Water");
        hashset.add("Fire");

        // 1. Using TreeSet constructor
        TreeSet<String> tset=new TreeSet<>(hashset);
        for(String s:tset) System.out.println(s);
        // 2. Using addAll() method
        TreeSet<String> tset1=new TreeSet<>();
        tset1.addAll(hashset);
        for(String s:tset1) System.out.println(s);
        // 3. Using for-each
        TreeSet<String> tset2=new TreeSet<>();
        for(String s:hashset) tset2.add(s);
        System.out.println(tset2);
    }

}
