package com.arithmetic.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BigData {

    public static  List list = new ArrayList(100000);


    public static void main(String[] args) {
        try {
//            for (int i = 0; i < 100000; i++) {
//                byte b[] = new byte[10000];
//                list.add(b);
//            }
//
//            FileOutputStream fos=new FileOutputStream("D://MyTest.txt");
//            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fos);
//            objectOutputStream.writeObject(list);
//            objectOutputStream.close();
//            System.out.println("================== Done =======================");
//

            long start = System.currentTimeMillis();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://MyTest.txt"));
            list = (List)ois.readObject();
            System.out.println(System.currentTimeMillis() - start);
            TimeUnit.MILLISECONDS.sleep(1000000);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
