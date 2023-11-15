package com.oldexample.company;

public class StrTest {
    public static void main(String[] args) {
        String str="I Love Java";
        System.out.println(str.length());
        // System.out.println(str.charAt(11)); // str has length 11 and if we try to retrieve char at 11 we get StringIndexOutOfBoundsException
        System.out.println(str.charAt(10));
        System.out.println(str.charAt(9));
        System.out.println(str.charAt(8));
        System.out.println(str.charAt(7));
        for(int i=0;i<str.length();i++){
            System.out.println("Value of i::>"+i);
            System.out.println(str.length()-i-1);
            System.out.println(str.charAt(str.length()-i-1));
        }
    }
}
