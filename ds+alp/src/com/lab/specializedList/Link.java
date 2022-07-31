package com.lab.specializedList;

import java.util.List;

public class Link {
    private Object next;
    private Object previous;
    private int data;

    public Link(){
        next = null;
        previous = null;
        data = 0;
    }


    public void setNext(Object next) {
        this.next = next;
    }

    public Object getNext() {
        return next;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Object getPrevious() {
        return previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
