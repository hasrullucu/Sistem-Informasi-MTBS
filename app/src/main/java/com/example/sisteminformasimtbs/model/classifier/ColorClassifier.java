package com.example.sisteminformasimtbs.model.classifier;

import java.util.Arrays;
import java.util.List;

public class ColorClassifier{

    private static int[] arrOfRed = new int[]{1,2,5,10,13,15,17,20,24,28,31};
    private static int[] arrOfYellow = new int[]{3,6,35,9,11,16,18,21,22,25,26,29,32,33};
    private static int[] arrOfGreen = new int[]{4,7,12,14,19,23,27,30,34};

    /**
     * Method for checking classification level
     * 0 : green (not dangerous)
     * 1 : yellow  (dangerous)
     * 2 : red  (very dangerous
     *
     */
    public static int check(int id){
        for(int item : arrOfRed){
            if(item == id ) return 2;
        }

        for(int item : arrOfGreen){
            if(item == id) return 0;
        }

        for(int item : arrOfYellow){
            if(item == id) return 1 ;
        }

        return 1;

    }

}
