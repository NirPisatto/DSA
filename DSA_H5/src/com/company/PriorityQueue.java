package com.company;

import java.security.Principal;

public class PriorityQueue {
    int maxSize = 10;
    int datas[] = new int[maxSize];
    int size = 0;
    private boolean isAscending = true;

    PriorityQueue(){
        maxSize = 10;
        datas = new int[maxSize];
    }

    PriorityQueue(int maxSize, boolean isAscending){
        this.maxSize = maxSize;
        datas = new int[this.maxSize];
        this.isAscending = isAscending;
    }


    public void insert(int newValue){
        int lastValue = newValue;

        if (size == 0){
            datas[0] = newValue;
            size++;
        }
        else if (isFull()){
            System.out.println("Array is full.");
        }else{
            if (isAscending) {
                for (int i = 0; i < size; i++) {
                    if (newValue <= datas[i]){
                        int nextValue = datas[i];
                        datas[i] = lastValue;
                        lastValue = nextValue;
                    }
                }
            }else{
                for (int i = 0; i < size; i++) {
                    if (newValue >= datas[i]){
                        int nextValue = datas[i];
                        datas[i] = lastValue;
                        lastValue = nextValue;
                    }
                }
            }
            datas[size] = lastValue;
            size++;
        }
    }
    public boolean isFull(){
        if (size == maxSize) return true;
        return false;
    }

    public boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    public void remove(){
        if(!isEmpty()){
            size--;
            for (int i = 0; i < size; i++) {
                datas[i] = datas[i + 1];
            }
        }else{
            System.out.println("Array is empty.");
        }

    }

    public int peekFront(){
        if(!isEmpty()) return datas[0];
        System.out.println("Array is empty.");
        return 0;
    }


}
