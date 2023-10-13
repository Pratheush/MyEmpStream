package com.example;

import java.util.Arrays;
import java.util.HashMap;

public class MyAnagram {
    public static void main(String[] args) {
        String s1 = "hi listen";
        String s2 = "silent ih ";

        if (checkAnagram(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
        }

        if (checkAnagramIterative(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
        }

        if (checkAnagramHashMap(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
        }
    }

    public static boolean checkAnagram(String st1,String st2){
        st1=st1.replaceAll("\\s","").toLowerCase();
        st2=st2.replaceAll("\\s","").toLowerCase();

        if(st1.length()!=st2.length()) return false;

        char[] st1ChArr=st1.toCharArray();
        char[] st2ChArr=st2.toCharArray();

        Arrays.sort(st1ChArr);
        Arrays.sort(st2ChArr);

        return Arrays.equals(st1ChArr,st2ChArr);
    }

    public static boolean checkAnagramIterative(String str1,String str2){
        str1=str1.replaceAll("\\s","").toLowerCase();
        str2=str2.replaceAll("\\s","").toLowerCase();

        if(str1.length()!=str2.length()) return false;

        char[] str1char=str1.toCharArray();
        char[] str2char=str2.toCharArray();
        for(char c: str1char){
            int index=str2.indexOf(c);
            if(index==-1) return false;
            str2=str2.substring(0,index)+str2.substring(index+1,str2.length());
        }
        return true;
    }

    public static boolean checkAnagramHashMap(String str1,String str2){
        str1=str1.replaceAll("\\s","").toLowerCase();
        str2=str2.replaceAll("\\s","").toLowerCase();

        if(str1.length()!=str2.length()) return false;

        HashMap<String,Integer> str1HashMap=createHashmapKey(str1);
        HashMap<String,Integer> str2HashMap=createHashmapKey(str2);
        if(str1HashMap.equals(str2HashMap)){
            System.out.println("Both strings are anagram");
            return true;
        }
        else {
            System.out.println("Both strings are not anagram");
            return false;
        }
    }

    public static HashMap<String,Integer> createHashmapKey(String str){
        HashMap<String,Integer> amap=new HashMap<String,Integer>();
        for(int i=0;i<str.length();i++){
            if(amap.containsKey(str.charAt(i))){
                Integer value=(int)amap.get(str.charAt(i));
                amap.put(String.valueOf(str.charAt(i)),value+1);
            }else{
                amap.put(String.valueOf(str.charAt(i)),1);
            }
        }
        return amap;
    }
}
