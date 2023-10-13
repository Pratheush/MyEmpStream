package com.example;

import java.util.*;

public class Java_Hunger {
    public static void main(String[] args) {
        hashset_to_array();
        array_to_arraylist();
        arraylist_to_string_array();
        sort_arraylist_descendingOrder();
        remove_method();
    }

    public static void hashset_to_array(){
        HashSet<String> hashset2 = new HashSet<String>();

        // Adding elements to HashSet object
        hashset2.add("Soccer");
        hashset2.add("Football");
        hashset2.add("Baseball");
        hashset2.add("Basketball");

        // 1. using toArray()
        String[] strarray=hashset2.toArray(new String[hashset2.size()]);
        for(String s:strarray) System.out.println(s);
        System.out.printf("---------------------\n");
        // 2. using traversing and adding
        int index=0;
        String[] strarray1=new String[hashset2.size()];
        for(String s:hashset2) strarray1[index++]=s;
        for(String s:strarray1) System.out.println(s);
    }

    public static void array_to_arraylist(){
        System.out.printf("array_to_arraylist\n");
        String[] cities={"Boston", "Dallas", "New York", "Chicago"};

        // 1.
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(cities));
        for(String s:arrayList) System.out.println(s);
        System.out.printf("=================================\n");
        // 2.
        ArrayList<String> arrayList1=new ArrayList<>();
        Collections.addAll(arrayList1,cities);
        for(String s:arrayList1) System.out.println(s);
        System.out.printf("=================================\n");
        // 3.
        ArrayList<String> arrayList2=new ArrayList<>();
        for(String s:cities) arrayList2.add(s);
        for(String s:arrayList2) System.out.println(s);
    }

    public static void arraylist_to_string_array(){
        System.out.println("-----arraylist_to_string_array-------");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Pear");

        // 1.
        String[] strarray=fruits.toArray(new String[0]);
        for(String s:strarray) System.out.println(s);
        // 2.
        System.out.println("");
        int index=0;
        String[] strarray1=new String[fruits.size()];
        for(String s: fruits) strarray1[index++]=s;
        for(String s:strarray1) System.out.println(s);
        // 3.
        System.out.println();
        String[] strarray2=new String[fruits.size()];
        for(int i=0;i< fruits.size();i++){
            strarray2[i]= fruits.get(i);
        }
        for(String s:strarray2) System.out.println(s);
        // 4.
        System.out.println("");
        String[] strarray3=Arrays.copyOf(fruits.toArray(),fruits.size(),String[].class);
        for(String s:strarray3) System.out.println(s);
    }

    public static void sort_arraylist_descendingOrder(){
        System.out.println("sort_arraylist_descendingOrder()");
        ArrayList<String> arrList = new ArrayList();
        arrList.add("Mozilla");
        arrList.add("Safari");
        arrList.add("Chrome");
        arrList.add("Opera");

        // 1.
        Collections.reverse(arrList);
        for(String s: arrList) System.out.printf(s+"\t");
        System.out.println();
        // 2.
        Collections.sort(arrList, Comparator.naturalOrder());
        for(String s: arrList) System.out.printf(s+"\t");
        // 3.
        System.out.println();
        Collections.sort(arrList,Comparator.reverseOrder());
        for(String s: arrList) System.out.printf(s+"\t");
        // 4.
        System.out.println();
        Collections.sort(arrList,Collections.reverseOrder());
        for(String s: arrList) System.out.printf(s+"\t");

    }

    public static void remove_method(){
        System.out.println("remove_method()");
        ArrayList<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("AA");
        list.add("ZZ");

        boolean bb=list.remove("BB");
        System.out.println(bb);
        bb=list.remove("ff");
        System.out.println(bb);
        Object obj1=list.remove(2);
        System.out.println(obj1.toString());
        // remove(index) method throws IndexOutOfBoundsException.
        // String obj2=list.remove(10); this will throw IndexOutOfBoundException
        // System.out.println(obj2);
        for(String s:list) System.out.printf(s+"\t");
    }
}
