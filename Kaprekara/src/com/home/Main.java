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

        /*
        if (KaprekarsConst == val)
            return i;
        else {

            Integer AscVal = GetSortVal(val, "asc");
            Integer DescVal = GetSortVal(val, "desc");
            return  CalcInvoiс(DescVal - AscVal, i+=1);
        }*/
    }

    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(System.in);
            //String s = in.nextLine();
            System.out.print("Введите число: ");
            int val = in.nextInt();
/*
            Integer val2 = GetSortVal(val, "asc");
            Integer val3 = GetSortVal(val, "desc");*/
            System.out.println("Итераций, чтобы посчитать постоянную Карприкара: " +CalcInvoiс(val, 0));
            //System.out.println(val + " ," + val2 + ", " + val3);
        } catch (Exception e) {
        }
    }
}
