package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SwapnaQues {
    public static void main(String[] args) {

        int[] intarray= new int[] {10,11,12,13,14,15,16,17};
        int[] intarray1=Arrays.copyOf(intarray,intarray.length);

        int[] intArray2=Arrays.stream(intarray)
                .toArray();


        for(int i: intarray1) System.out.println(i);
        for(int i: intArray2) System.out.println(i);

        String str="I love My India";
        StringBuilder sb1= new StringBuilder(str);
        String str1=sb1.reverse().toString();
        System.out.println(str1);

        String[] strArray=str.split("");
        List<String> strList=Arrays.asList(strArray);
        Collections.reverse(strList);
        //System.out.println(strList);
        String revString=strList.stream()
                .collect(Collectors.joining(""));
        System.out.println(revString);

        String revStr=IntStream.range(0,str.length())
                .mapToObj(i-> str.charAt(str.length()-i-1))
                .map(Objects::toString)
                .collect(Collectors.joining(""));
        System.out.println(revStr);

        String revStr1=Arrays.stream(str.split(""))
                .reduce("",(prevChar, nexChar)->nexChar+prevChar,String::concat);
        System.out.println(revStr1);

        String revStr2=IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - i - 1))
                .collect(StringBuilder::new, StringBuilder::append,StringBuilder::append)
                .toString();
        System.out.println(revStr2);


        String gl="Good Looking";
        String uniqueString=Stream.of(gl.toLowerCase().split(""))
                .collect(Collectors.toMap(k->k,v->1,(v1,v2)->v1+v2,LinkedHashMap::new))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining()).trim();
        System.out.println(uniqueString);

        gl.chars()
                .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresentOrElse(v-> System.out.println("first non repeated char::"+v),()-> System.out.println("There is No first non repeated character"));

        /*Input....aaaabbbcceeee
        Output.....4a3b2c4e*/
        String sw="aaaabbbcceeee";
        String outputSW=sw.chars()
                .mapToObj(s-> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .map(e-> e.getValue().toString()+e.getKey().toString())
                .collect(StringBuilder::new,StringBuilder::append,StringBuilder::append)
                .toString();
        System.out.println(outputSW);
    }

}
