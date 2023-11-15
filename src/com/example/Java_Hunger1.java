package com.example;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Java_Hunger1 {
    public static void main(String[] args) {
        array_to_treeset();
        hashset_to_TreeSet();
        array_to_list_N_set();
        collection_list_collection();
        synchronize_ArrayList();
        initialize_arrayList();
    }

    public static void array_to_treeset(){
        Integer[] num = {7,34,45,23,38,56,21};

        // 1. Using TreeSet Constructor
        List<Integer> ilist= Arrays.asList(num);
        Set<Integer> iset=new TreeSet<>(ilist);
        for(Integer i:iset) System.out.println(i);

        // 2. Using TreeSet addAll method
        TreeSet<Integer> iset1=new TreeSet<>();
        iset1.addAll(Arrays.asList(num));
        for(Integer i:iset1) System.out.println(i);

        // 3. Using Collections addAll method.
        TreeSet<Integer> iset2=new TreeSet<>();
        Collections.addAll(iset2,num);
        for(Integer i:iset1) System.out.println(i);

        // 4. Using for-each
        TreeSet<Integer> iset3=new TreeSet<>();
        for(Integer i:num) iset3.add(i);
        for(Integer i:iset3) System.out.println(i);
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

    public static void collection_list_collection(){
        System.out.println("collection_list_collection");
        HashSet<String> hashset = new HashSet();
        // Adding elements
        hashset.add("Cap");
        hashset.add("T-Shirt");
        hashset.add("Jeans");
        hashset.add("Shoes");

        // 1. Using List.copyOf() method gives unmodifiable list
        List<String> slist=List.copyOf(hashset); // Set.copyOf(hashset) also works same way will give unmodifiable set
        System.out.println(slist);

        // 2. Using Java 8 Stream API
        List<String> slist1=hashset.stream()
                                .collect(Collectors.toList());
        System.out.println(slist1);

        // 2. Using Java 8 Stream API
        List<String> slist2=hashset.stream()
                        .toList();
        System.out.println(slist2);

        // 3. Using ArrayList Constructor
        // Given Collection is HashMap
        HashMap<String, Integer> hashmap = new HashMap();
        // Putting elements to hashmap object
        hashmap.put("Mango", 55);
        hashmap.put("Apple", 88);
        hashmap.put("Guava", 99);
        hashmap.put("Banana", 77);
        // Converting Collection to List using ArrayList constructor
        List<Map.Entry<String,Integer>> mlist=new ArrayList<>(hashmap.entrySet());
        System.out.println(mlist);
    }

    public static void array_to_list_N_set(){
        System.out.println("array_to_list_N_set");
        Integer[] num = {7,34,45,23,38,56,21};

        List<Integer> ilist=List.of(num);
        System.out.println(ilist);

        Set<Integer> iset=Set.of(num);
        System.out.println(iset);
    }

    public static void synchronize_ArrayList(){
        // 1. Using Collections.synchronizedList()
        // Converting ArrayList to Synchronized ArrayList
        List<String> synchronizedarraylist=Collections.synchronizedList(new ArrayList<String>());
        //Adding elements to synchronized ArrayList
        synchronizedarraylist.add("Basketball");
        synchronizedarraylist.add("Baseball");
        synchronizedarraylist.add("Football");
        System.out.println(synchronizedarraylist);
        Iterator<String> si=synchronizedarraylist.iterator();
        while (si.hasNext()) System.out.println(si.next());

        // Creating Synchronized ArrayList Object
        CopyOnWriteArrayList<String> al=new CopyOnWriteArrayList<>();
        //Adding elements to synchronized ArrayList
        al.add("Cricket");
        al.add("Volleyball");
        al.add("Hockey");
        System.out.println(al);
    }

    public static void initialize_arrayList(){

        // Using Anonymous inner class method
        ArrayList<String> al=new ArrayList<>(){{
            add("String 1");
            add("String 2");
            add("String 3");
        }};
        System.out.println(al);

        // Using Collections.nCopies() method
        ArrayList<String> al1=new ArrayList<>(Collections.nCopies(4,"String1"));
        System.out.println(al1);
    }
}
