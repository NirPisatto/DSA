package com.lab;

import com.lab.specializedList.SpecializedList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        System.out.println(Factorial.caculate(20));

//        ArrayList<Integer> array = new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            array.add(i + 1);
//        }

//        System.out.println(Search.binarySearch(array,11));

        SpecializedList test = new SpecializedList();
//        test.insertFirst(10);
//        System.out.println(test.headLink.getData());
//        test.insertFirst(15);
//        System.out.println(test.headLink.getData());

        test.insertFirst(10);
        test.displayAllLink();
        test.insertTail(11);
        test.displayAllLink();
        test.insertAt(1,0);
        test.displayAllLink();
        test.insertAt(2,0);
        test.displayAllLink();
        test.insertAt(3,1);
        test.displayAllLink();
        test.insertAt(4,2);
        test.displayAllLink();
        test.insertAt(5,0);
        test.displayAllLink();
        test.insertTail(30);
        test.displayAllLink();
        test.removeAt(5);
        test.displayAllLink();


        System.out.println(test.headLink);
        System.out.println(test.get(0));
        System.out.println(test.tailLink);



    }
}
