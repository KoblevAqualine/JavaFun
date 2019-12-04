package com.home;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

   // private static final int KaprekarsConst = 6174;

    private static Integer GetSortVal (Integer _val, String sortType){
        Integer[] arrSort = new Integer[4];
        StringBuilder strVal = new StringBuilder(_val.toString());
        for (int i =0; i <4; i++){
            arrSort[i] = Integer.parseInt(strVal.substring(i, i+1));
        }
        strVal.setLength(0);
        if (sortType == "asc"){
            Arrays.sort(arrSort);
        } else {
            Arrays.sort(arrSort, Collections.reverseOrder());
        }
       for (int i =0; i < arrSort.length; i++){
           strVal.append(arrSort[i]);
        }
        Integer newVal = Integer.parseInt(strVal.toString());
        return  newVal;
    }

    private static int CalcInvoiс(Integer val, int i) {
        Integer AscVal = GetSortVal(val, "asc");
        Integer DescVal = GetSortVal(val, "desc");
        if (DescVal - AscVal == val){
            return i;
        }
        else {
            return  CalcInvoiс(DescVal - AscVal, i+=1);
        }
    }

    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(System.in);
            System.out.print("Input 4 digits: ");
            int val = in.nextInt();

            System.out.println("Iterations to calc Kaprekar's constant: " +CalcInvoiс(val, 0));

        } catch (Exception e) {
        }
    }
}
