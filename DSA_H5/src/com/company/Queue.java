package com.company;

public class Queue {
    private int maxSIze = 10;
    private int[] datas = new int[maxSIze];
    private int[] indexs = new int[maxSIze];
    private int front = -1;
    private int rear = -1;
    private int count = 0;

    public void insert(int value){
        if (count == 0) front++;
        if (count < maxSIze){
            count++;
            if (rear == maxSIze -1){
                rear = 0;
            } else{
                rear++;
            }
            datas[rear] = value;
        } else{
            System.out.println("Datas is full");
        }
    }
    public void remove(){
        if (count == 0){
            System.out.println("Datas is empty");
        } else{
            count--;
            if (front == maxSIze -1){
                front = 0;
            }else {
                front++;
            }
        }
        if (count == 0){
            count = 0;
            rear = -1;
            front = -1;
        }
    }

    public int peekFront(){
        if (front == -1) {
            System.out.println("Datas is empty");
            return 0;
        }
        return datas[front];
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        if (count == 0) return true;
        return false;
    }
    public boolean isFull(){
        if (count == maxSIze) return  true;
        return false;
    }
}
