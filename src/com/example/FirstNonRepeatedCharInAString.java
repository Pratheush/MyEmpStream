package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharInAString {
    public static void main(String[] args) {
        final String st="hey yes hello world is java first programme";
        usingIndexOfLastIndexOf(st);
        usingLinkedHashMap(st);
        Character ch=usingSetArrayList(st);
        System.out.println("first Non Repeated Character using set-Arraylist >> "+ch);

        Character ch1=usingSetArrayList1(st);
        System.out.println("first Non Repeated Character using set-Arraylist >> "+ch1);

        Character chjava8=usingJava8(st);
        System.out.println("first Non Repeated Character using Java 8 >> "+chjava8);

        /*char chjava8_2=usingJava8_2("hey yes hello world is java first programme");
        System.out.println("first Non Repeated Character using Java 8_2 >> "+chjava8_2);*/

        Optional<Map.Entry<Character,Integer>> op_java_8_2=usingJava8_2(st);
        op_java_8_2.ifPresent(characterIntegerEntry -> System.out.println("first Non Repeated Character using java 8_2:::>>" + characterIntegerEntry.getKey()));
    }

    public static void usingIndexOfLastIndexOf(String str){
        for(char c:str.toCharArray()){
            if(str.indexOf(c)==str.lastIndexOf(c)){
                System.out.println("first non repeated character::"+c);
                break;
            }
        }
    }

    public static void usingLinkedHashMap(String str){
        LinkedHashMap<Character,Integer> cmap=new LinkedHashMap<>();
        int len=str.length();
        Character ch;
        //Integer count=1;
        for(int i=0;i<len;i++){
            Character chr= str.charAt(i);
            if(cmap.containsKey(chr)){
                Integer count=cmap.get(chr);
                cmap.put(chr,count+1);
            }else{
                cmap.put(chr,1);
            }
        }
        for(Map.Entry<Character,Integer> e: cmap.entrySet()){
            if(e.getValue()==1){
                System.out.println("First non repeated character:::"+e.getKey());
                break;
            }
        }
    }

    public static Character usingSetArrayList(String str){
        List<Character> nonRepeatingChar=new ArrayList<>();
        Set<Character> repeatingChar=new HashSet<>();
        for(int i=0;i<str.length();i++){
            Character ch= str.charAt(i);
            if(repeatingChar.contains(ch)) continue;
            if(nonRepeatingChar.contains(ch)){
                nonRepeatingChar.remove(ch);
                repeatingChar.add(ch);
            }else {
                nonRepeatingChar.add(ch);
            }
        }
        return nonRepeatingChar.get(0);
    }

    public static Character usingSetArrayList1(String str){
        // Create a HashSet to store encountered characters
        Set<Character> set = new HashSet<>();

        // Create an ArrayList to maintain the order of characters
        List<Character> order = new ArrayList<>();

        // Iterate through the characters in the string
        for (char c : str.toCharArray()) {
            // If the character is not in the HashSet, add it to both HashSet and ArrayList
            if (!set.contains(c)) {
                set.add(c);
                order.add(c);
            } else {
                // If the character is already in the HashSet, remove it from the ArrayList
                order.remove((Character) c); // Need to cast c to Character to avoid removing by index
            }
        }

        // The first character in the ArrayList is the first non-repeated character
        if (!order.isEmpty()) {
            return order.get(0);
        } else {
            // If there are no non-repeated characters, return a default value (e.g., '0')
            return '0';
        }
    }

    public static Character usingJava8(String str){
        Map<Character,Integer> cmap=new LinkedHashMap<>();
        for(Character ch: str.toCharArray()){
            //cmap.containsKey(ch) ? cmap.put(ch,cmap.get(ch)+1) : cmap.put(ch,1);
            cmap.put(ch,cmap.containsKey(ch)? cmap.get(ch)+1:1);
        }
        return cmap.entrySet().stream().filter(e-> e.getValue()==1).map(Map.Entry::getKey).findFirst().get();
    }

    public static Optional<Map.Entry<Character,Integer>> usingJava8_2(String str){
        return str.chars()
                .mapToObj(c->Character.toLowerCase((char) c))
                .collect(Collectors.toMap(k->k,v->1, Integer::sum))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .findFirst();

        /*return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();*/
    }

}
