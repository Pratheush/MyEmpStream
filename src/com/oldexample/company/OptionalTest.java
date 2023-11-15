package com.oldexample.company;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> inputstring=Optional.of(null);
        String str=reverseString(inputstring);
        System.out.println(str);
    }

    public static String reverseString(Optional<String> str){
        String s=null;
        if(str.isPresent()) {
            String input=str.get();
            StringBuilder sb=new StringBuilder(input);
            s=sb.reverse().toString();
        }
        return s;
    }
}
