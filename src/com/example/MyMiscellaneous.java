package com.example;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyMiscellaneous {
    public static void main(String[] args) {
        comma_String_HashSet();
        hashSetToString();
        myStringBuilder();
        arrayList_StringArray();
        System.out.println("==============");
        newJava12();
        newJava11();
    }

    public static void comma_String_HashSet(){
        String givenString = "Be, in,  Present";
        Set<String> setString=Arrays.stream(givenString.trim().split("\\s*,\\s*"))
                .collect(Collectors.toSet());
        System.out.println(setString);

        givenString = "Boston, NewYork, Chicago";
        String[] strArray=givenString.split("\\s*,\\s*");
        List<String> strlist=Arrays.asList(strArray);
        Set<String> strset=new HashSet<>(strlist);
        System.out.println(strset);

        // \\s*: This part represents a regular expression for zero or more whitespace
        // The \\s is an escape sequence for whitespace characters, and * means "zero or more occurrences.
        // " So, \\s* matches spaces, tabs, or any other whitespace characters
        givenString = "Alive, is, Awesome";
        Set<String> result=Pattern.compile("\\s*,\\s*")
                .splitAsStream(givenString.trim())
                .collect(Collectors.toSet());
        System.out.println(result);
    }

    public static void hashSetToString(){
        HashSet<String> set = new HashSet();
        set.add("Boston");
        set.add("NewYork");
        set.add("SanFrancisco");
        set.add("Washington");

        System.out.println(set.toString());
        System.out.println(set.toString().replaceAll("\\,|\\[|\\]|\\s",":"));
        System.out.println(set.toString().replaceAll("[,\\[\\]\\s]","<>"));

        String result=String.join("; ",set);
        System.out.println(result);

        String set2String=set.stream().collect(Collectors.joining("*"));
        System.out.println(set2String);

        // ArrayList<String> al = new ArrayList(Collections.nCopies(count, element));
        ArrayList<String> al = new ArrayList(Collections.nCopies(7, 7));
        System.out.println("nCopies prints elements are: "+ al);

        ArrayList<String> al1 = new ArrayList(Arrays.asList("Boston", "Chicago", "Dallas"));
        System.out.println("Elements are: "+ al1);

    }

    public static void myStringBuilder(){

        // DELETE LAST CHARACTER AT STRING-BUILDER:::::
        // Initialize StringBuilder Object
        StringBuilder sb = new StringBuilder("Alive is Awesome");
        if(!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println("Removed last character: " + sb);

        // Initializing StringBuilder Object
        StringBuilder sb2 = new StringBuilder("Be in Present");
        // Checking if StringBuilder object is not empty
        if(!sb2.isEmpty()) {
            sb2.setLength(sb2.length() - 1);
        }
        System.out.println("Removed last character using setLength() method: " + sb2);


        String str="";
        StringBuilder sb3=new StringBuilder(str);
        if(str.isEmpty()) System.out.println("string is empty");
        if(sb3.isEmpty()) System.out.println("string-builder is empty");

        // StringBuilder add or append at the start or front
        StringBuilder sb4=new StringBuilder();
        sb4.append("AAA");
        sb4.append("BBB");
        sb4.append("CCC");
        System.out.println(sb4);
        sb4.insert(0,"ZZZ");
        System.out.println(sb4);
        sb4.replace(0,0,"YYY");
        System.out.println(sb4);
        sb4.reverse();
        System.out.println(sb4);
        sb4.append(new StringBuilder("XXX").reverse());
        sb4.reverse();
        System.out.println(sb4);

        // convert string to stringbuilder
        String st_sb="new way of converting string to string-builder";
        sb4.append(st_sb);
        System.out.println(sb4);

    }

    public static void arrayList_StringArray(){
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Pear");

        String[] frts=new String[fruits.size()];
        for(int i=0;i<fruits.size();i++){
            frts[i]=fruits.get(i);
        }
        for(String s:frts) System.out.println(s);

        String[] frts1=fruits.toArray(new String[fruits.size()]);
        for(String s:frts1) System.out.println(s);

        String[] frts2=Arrays.copyOf(fruits.toArray(),fruits.size(),String[].class);
        for(String s: frts2) System.out.println(s);
    }

    public static void newJava12(){
        //method adjusts the indentation of each line of the String based on the input value of n.
        String str="Hi \nI am New \nFeature in Java12".indent(5);
        System.out.println(str);

        //java.lang.constant.Constable && java.lang.constant.ConstantDesc
        // describeConstable() returns optional object describing string's instance.
        String str1="another new feature java12";
        Optional<String> optStr1=str1.describeConstable();
        System.out.println(optStr1);
        System.out.println(optStr1.get());

        // Returns descriptor instance string of given string.
        String str2 = "JavaHungry";
        String constantDesc = str2. resolveConstantDesc(MethodHandles.lookup());
        System.out.println(constantDesc.equals(str2));
        System.out.println(constantDesc);

        String str3="I am another new feature in Java12";
        String transformedStr3=str3.transform(value-> new StringBuilder(value).reverse().toString().replaceAll("\\s","::"));
        System.out.println(transformedStr3);


        // Switch Expressions enables switch statement to be used as a statement as well as an expression. syntax is “case L ->”.
        String month="JAN";
        int numberOfDays = switch (month) {
            case "JAN", "MAR", "MAY","JUL","AUG","OCT","DEC" -> 31;
            case "APR","JUNE","SEP","NOV" -> 30;
            case "FEB" -> 28;
            default -> throw new IllegalStateException("Invalid Month");
        };
        System.out.println(numberOfDays);

        // OLD WAY of SWITCH:::
        String color="blue";
        switch (color) {
            case "blue":
                System.out.println("BLUE");
                break;
            case "red":
                System.out.println("RED");
                break;
            default:
                System.out.println("INVALID COLOR CODE");
        }
    }

    public static void newJava11(){
        // repeat the string content number of times specified in repeat.
        var tempString="java hungry";
        var repeatTempString=tempString.repeat(3);
        System.out.println(repeatTempString); // java hungryjava hungryjava hungry

        var tempstr="java11 hungry";
        var repeattempstr=tempstr.repeat(0);
        System.out.println(repeattempstr); // Output : "" (Empty String)

        String tempString1 = ""; // empty String
        String repeatString = tempString1.repeat(2);
        System.out.println(repeatString); // Output : "" (Empty String)

        String tempString2 = "Java Hungry";
        //String repeatString2 = tempString2.repeat(-1);// It will throw IllegalArgumentException

        //String.strip() method ,stripLeading() method, stripTrailing() method
        /*String.strip() method : returns a String with all leading and trailing white space removed.
        String.stripLeading() method : returns a String with all leading white space removed.
        String stripTrailing() method : returns a String with all trailing white space removed.*/
        System.out.println("  JavaHungry  ".strip().equals("JavaHungry"));// Output : true
        System.out.println("   JavaHungry".stripLeading().equals("JavaHungry"));// Output : true
        System.out.println("JavaHungry    ".stripTrailing().equals("JavaHungry"));// Output : true

        // Difference between strip() and trim() method in java
        // not able to remove the trailing white spaces.
        // This is because trim() does not have idea of unicode characters.
        // As a result, it does not consider "\u2005" as white space character.
        System.out.println("\n\s\t java hungry \u2005".strip().equals("java hungry \u2005"));
        System.out.println("\n\s\t java hungry \u2005".strip().equals("java hungry"));
        System.out.println("\n\s\t java hungry \u2005".trim().equals("java hungry \u2005"));
        System.out.println("\n\s\t java hungry \u2005".trim().equals("java hungry"));

        /*public boolean isBlank() : isBlank() returns true if the string contains
        only white space codepoints or is empty. For any other conditions, it return false.*/
        String str5="";
        String str6="Raj";
        if(!str6.isBlank()) System.out.println("String str6 is not Blank");
        if(str5.isBlank()) System.out.println("String str5 is Blank");

        /*lines() method Returns a stream of lines extracted from the input string,
        separated by line terminators.*/
        String intro="Good Morning\nHi I am Raj\nI am learning Java11.\n I am writing code in MyMiscellaneous Module";
            intro
                .lines()
                .forEach(System.out::println);


        // Collections.toArray(IntFunction) Default Method
        final Set set1=Set.of("Java","Python","SQL","GO","C","C++");
        final List list1=List.of("Java","Python","SQL","GO","C","C++");
        final Map map1=Map.of("1","Java","2","Python","3","SQL","4","Spring");
        System.out.println(Arrays.toString(set1.toArray(String[]::new)));
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(map1.entrySet().toArray()));


        // readString() :: reads all content from a file into a String.
        // Using UTF-8 charset it decodes from bytes to characters
        try {
            String applicationConfig = Files.readString(Path.of("src/com/example/myconfig_read.txt"));
            System.out.println(applicationConfig);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        //writeString() :: writes a CharSequence to a file.
        // Using the UTF-8 charset Characters are encoded into bytes.
        try{
            Files.writeString(Path.of("src/com/example/myconfig_out.txt"),Arrays.toString(list1.toArray()));
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        //In some situtations we use functions that require Reader/Writer/InputStream/OutputStream parameter
        // and we want to process the parameter even if it represents a null.
        //Initializing the stream with null is not possible prior to  java 11.
        // If you try to do so, then it will throw NullPointerException.
        // Below methods return streams that represent disabled input/output.
        // They do not read anything and discard all writes.
        /*public static InputStream nullInputStream() // java.io.InputStream class
        public static OutputStream nullOutputStream() // java.io.OutputStream class
        public static Reader nullReader() // java.io.Reader class
        public static Writer nullWriter() // java.io.Writer class*/
        Stream strm=null;
        Reader rd=null;
        Reader rd1=Reader.nullReader(); // Do not read anything
        Writer wt=Writer.nullWriter();  // Discard write
        InputStream in=InputStream.nullInputStream();
        OutputStream out=OutputStream.nullOutputStream();

        Path path=Path.of("src/com/example/myconfig_out.txt","Java Hungry");
        if(Files.exists(path)) System.out.println("File Exists::"+path);

        URI uri=URI.create("src/com/example/myconfig_out.txt");
        System.out.println(uri);


    }
}
