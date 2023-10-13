package com.example;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyMiscellaneous1 {
    public static void main(String[] args) {
        hashSetToString();
        countNumberOfComas();
        capitalizeFirstLetterOfString();
        findDuplicateWordsInAString();
    }

    public static void hashSetToString(){
        HashSet<String> set = new HashSet();
        set.add("Apple");
        set.add("Google");
        set.add("Facebook");
        set.add("Amazon");

        System.out.println(set.toString().replaceAll("[,\\s\\]\\[]","#"));
        System.out.println(String.join(";",set));
        System.out.println(StringUtils.join(set,":"));
        String comps=set.stream()
                .collect(Collectors.joining(" "));
        System.out.println(comps);
    }

    public static void countNumberOfComas(){
        //"Alive, is, awesome"  // 2 commas
        //"23, 34, 45, 56, 67, 78, 89, 100" // 7 commas
        String input="Alive, is, awesome";
        int count=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==',') count++;
        }
        System.out.println("Number of commas:::"+count);
        Long numComas=input.chars()
                .mapToObj(c-> Character.toLowerCase((char) c))
                .filter(c->c.equals(','))
                .collect(Collectors.counting());
        System.out.println(numComas);

        String input1=input.replaceAll("[^,]","");
        System.out.println(input1);
        System.out.println(input.length());

    }

    public static void capitalizeFirstLetterOfString(){
        String givenString = "java is a popular programming language";

        String capStr=Pattern.compile("\\s")
                .splitAsStream(givenString.trim())
                .map(s->s.substring(0,1).toUpperCase()+s.substring(1,s.length()))
                .collect(Collectors.joining(" "));
        System.out.println(capStr);

        String capStr1=Pattern.compile("\\s")
                .splitAsStream(givenString.trim())
                .map(s->String.valueOf(s.charAt(0)).toUpperCase()+s.substring(1,s.length()))
                .collect(Collectors.joining(" "));
        System.out.println(capStr1);

        StringBuilder cword=new StringBuilder();
        for(String word:givenString.split(" ")){
            cword.append(String.valueOf(word.charAt(0)).toUpperCase()+word.substring(1)+" ");
        }
        System.out.println(cword.toString());
    }

    public static void findDuplicateWordsInAString(){
        String given_String= "Java is a programming language. Python is also a programming language.";
        //List<String> duplicate_words_are = ["is","a","programming","language."];

        /*Given String: "Java has 51 keywords in total. Null, true, and false might seem like keywords but they are not in Java"
        Duplicate words are : "keywords", "in", "java"*/

        String duplicate_words=Pattern.compile("\\s")
                .splitAsStream(given_String.trim().toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(" "));

        System.out.println(duplicate_words);

        List<String> repeatedWords=new ArrayList<>();
        Set<String> uniqueWords=new HashSet<>();
        String[] words=given_String.split("\\s");
        for(String word:words){
            if(!uniqueWords.add(word)) repeatedWords.add(word);
        }
        String rptwords=repeatedWords.stream()
                .collect(Collectors.joining(" "));
        System.out.println(rptwords);

        // USING COLLECTIONS FREQUENCY
        List<String> listOfWords=Arrays.asList(words);
        Set<String> repeatingWords=new LinkedHashSet<>();
        for(String word:words){
            if(Collections.frequency(listOfWords,word)>1) repeatingWords.add(word);
        }
        System.out.println(repeatingWords);

    }
}
