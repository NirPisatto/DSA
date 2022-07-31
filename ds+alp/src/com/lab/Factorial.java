package com.lab;

public class Factorial {
    public static Long  caculate(int number){
        if (number > 1){
            return caculate(number -1) * number;
        }else{
            return Long.valueOf(1);
        }
    }
}
