package com.example;

import java.io.*;
import java.util.ArrayList;

public class ArrayList_Serialize_Deserialize {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();

        // Adding elements to the ArrayList object
        list.add("Boston");
        list.add("Dallas");
        list.add("New York");

        /*try {
            FileOutputStream fileOS = new FileOutputStream("inputfile");
            ObjectOutputStream objOS = new ObjectOutputStream(fileOS);
            objOS.writeObject(list);
            objOS.close();
            fileOS.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }*/

        try(FileOutputStream fileOS = new FileOutputStream("inputfile");
            ObjectOutputStream objOS = new ObjectOutputStream(fileOS)) {
            objOS.writeObject(list);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }



        ArrayList<String> list1 = new ArrayList();

        try( FileInputStream fileIS = new FileInputStream("inputfile");
             ObjectInputStream objIS = new ObjectInputStream(fileIS)) {
            list1 = (ArrayList) objIS.readObject();

        }
        catch(IOException ex) {
            ex.printStackTrace();
            return;
        }
        catch(ClassNotFoundException ex2) {
            System.out.println(" Class Not Found Exception");
            ex2.printStackTrace();
            return;
        }
        // Printing the ArrayList
        for(String s : list1) {
            System.out.println(s);
        }
    }
}
