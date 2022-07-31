package com.lab;

import java.util.ArrayList;

public class Search {
    public static int binarySearch(ArrayList<Integer> src, int targetValue){
        return binarySearchOp(src,targetValue,0,src.size(), src.size()/2);
    }

    private  static int binarySearchOp(ArrayList<Integer> src, int targetValue, int lowIndex,int topIndex, int maxIteration){
        int low = lowIndex;
        int top = topIndex;
        int mid = Math.round((low + top)/2);

        System.out.println(low + " " + top + " " + mid);
        maxIteration--;

        if (maxIteration == 0) {
            return -1;
        }



        if (src.get(mid) == targetValue){
            return mid;
        }else if(src.get(mid) < targetValue){
            low = mid;
            return binarySearchOp(src, targetValue, low, top, maxIteration);
        }else{
            top = mid;
            return binarySearchOp(src, targetValue, low, top, maxIteration);
        }


    }
}
