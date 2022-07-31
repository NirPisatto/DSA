package com.company;

public class Stack {
    private int maxSize = 1;
    private int currentSize = 0;
    private int[] datas = new int[maxSize];

    Stack(){
        maxSize = 1;
        datas = new int[maxSize];
    }

    Stack(int maxSize){
        this.maxSize = maxSize;
        datas = new int[maxSize];
    }

    public int length(){
        return currentSize;
    }

    public boolean isFull(){
            if (currentSize == maxSize) return true;
        return false;
    }

    public boolean isEmpty(){
            if (currentSize == 0) return true;
        return false;
    }

    public int peek(){
        return datas[currentSize - 1];
    }

    public void push(int value){
        if (!isFull()){
            datas[currentSize] = value;
            currentSize++;
        }else {
            System.out.println("Array is full.");
        }
    }

    public void pop(){
        if (!this.isEmpty()){
            datas[currentSize - 1] = 0;
            currentSize--;
        }else {
            System.out.println("Array is empty.");
        }
    }

    public int [] getData(){
        int[] result = new int[currentSize];
        for (int i = 0; i < currentSize; i++) {
            result[i] = datas[i];
        }
        return result;
    }
}
