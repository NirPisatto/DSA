package com.lab.specializedList;

public class SpecializedListV2 {
    private Link headLink;
    private Link tailLink;

    private int size;

    public SpecializedListV2(){
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
    public void removeFirst(){
        if (size >= 2){
            Link removingLink = headLink;
            headLink = (Link) removingLink.getNext();
            removingLink = null;
            size--;
        }else if(size == 1){
            headLink = null;
            tailLink = null;
            size--;
        }else{
            System.err.println("Specialized List Error: Invalid index of list.");
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
        }else{
            System.err.println("Specialized List Error: Invalid index of list.");
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
                System.err.println("Specialized List Error: Invalid index of list.");
            }
        }
    }

    public void insertFirst(int value){
        insertAt(value, 0);
    }


    public void insertTail(int value){
        insertAt(value, size);
    }

    public void insertAt(int value, int index){
        Link newLink = new Link();
        newLink.setData(value);
        if (headLink == null && tailLink == null){
           headLink = newLink;
           tailLink = newLink;
           size++;
        }else{
           Link currentLink = get(index);
           if (currentLink != null){
               if (currentLink.getPrevious() == null){
                   headLink.setPrevious(newLink);

                   newLink.setNext(headLink);

                   headLink = newLink;
                   size++;
               }
               else if (currentLink.getPrevious() != null){
                   Link previousLink = (Link) currentLink.getPrevious();

                   newLink.setNext(currentLink);
                   newLink.setPrevious(previousLink);

                   previousLink.setNext(newLink);
                   currentLink.setPrevious(newLink);

                   size++;
               }
           }else if (index == size){
               tailLink.setNext(newLink);
               newLink.setPrevious(tailLink);

               tailLink = newLink;
               size++;
           }else{
               System.err.println("Specialized List Error: Invalid index of list.");
           }
        }
    }


    private boolean indexValidationForOperation(int index){
        if (index >= 0 && index <= size) return true;
        System.err.println("Specialized List Error: Invalid index of list.");
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
