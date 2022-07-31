package com.lab;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // Usage of queue
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);

        // isEmpty function to check is queue contain items or not
        System.out.println("Is queue is empty : " + queue.isEmpty());
        // size function to get the number of items which contain in queue
        System.out.println("Size of queue : " + queue.size());
        // peek function to get the first entered item in queue
        System.out.println("Peek of queue : " + queue.peek());
        // poll function to get the first entered item in queue
        System.out.println("Poll of queue : " + queue.a());


    }
}
