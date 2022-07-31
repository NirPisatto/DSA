package com.lab.specializedList;

public class SpecializedList {
    public Link headLink;
    public Link tailLink;

    private int size;

    public SpecializedList(){
        headLink = null;
        tailLink = null;
        size = 0;
    }

    public Link get(int index) {
        if (!indexValidation(index)) return null;

        Link currentLink = headLink;
        for (int i = 0; i < size; i++) {
            if (index == i) return currentLink;
            currentLink = (Link) currentLink.getNext();
        }
        return null;
    }

    public void insertFirst(int value){
        Link newLink = new Link();
        if (headLink != null) headLink.setPrevious(newLink);
        if (tailLink == null && headLink == null) tailLink = newLink;
        newLink.setNext(headLink);
        newLink.setData(value);

        size++;
        headLink = newLink;
    }

    public void removeFirst(){
        if (size >= 2){
            Link removingLink = headLink;
            headLink = (Link) removingLink.getNext();
            removingLink = null;
            size--;
        }else{
            headLink = null;
            tailLink = null;
            size--;
        }
        System.gc();
    }

    public void removeTail(){
        if (size > 2){
            Link removingLink = tailLink;
            tailLink = (Link) removingLink.getPrevious();
            tailLink.setNext(null);
            removingLink = null;
            size--;
        }else if(size == 1){
            headLink = null;
            tailLink = null;
            size--;
        }
        System.gc();
    }

    public void removeAt(int index){
        if (indexValidationForOperation(index)){
            if (index == 0){
                removeFirst();
            }else if(index == size -1){
                removeTail();
            }else if(get(index) != null){
                Link currentLink = get(index);
                Link previousLink  = (Link) currentLink.getPrevious();
                Link nextLink = (Link) currentLink.getNext();
                previousLink.setNext(nextLink);
                nextLink.setPrevious(previousLink);
                size--;
            }else{
                System.out.println("Invalied index");
            }
        }
    }

    public void insertTail(int value){
        if (tailLink == null && headLink == null){
            insertFirst(value);
        }else{
            Link newLink = new Link();
            newLink.setData(value);
            tailLink.setNext(newLink);
            newLink.setPrevious(tailLink);
            tailLink = newLink;
            size++;
        }
    }

    public void insertAt(int value, int index){
        if (index == 0){
            insertFirst(value);
        }else if(get(index) != null){
            Link currentLink = get(index);
            Link previousLink  = (Link) currentLink.getPrevious();

            Link newLink = new Link();
            newLink.setData(value);
            newLink.setNext(currentLink);
            newLink.setPrevious(previousLink);

            previousLink.setNext(newLink);
            currentLink.setPrevious(newLink);
            size++;
        }else{
            System.out.println("Invalied index");
        }
    }


    private boolean indexValidationForOperation(int index){
        if (size != 0 && index >= 0 && index <= size) return true;
        return false;
    }

    private boolean indexValidation(int index){
        if (size != 0 && index >= 0 && index < size) return true;
        return false;
    }

    public void displayAllLink(){
        Link currentLink = headLink;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(currentLink.getData());
            currentLink = (Link) currentLink.getNext();
            if(currentLink != null){System.out.print(", ");}
        }
        System.out.println("] (" + size +")");
    }

    public boolean isEmpty(){
        if(size != 0) return true;
        return false;
    }

    public int size(){
        return size;
    }

}
