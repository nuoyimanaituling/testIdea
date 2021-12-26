//package com.hongshu;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @Author xzw
// * @create 2021/9/18 11:34
// */
//public class Main1 {
//    public  static int[] preArr = new int[4000+10];
//
//    public static void main(String args[])
//    {
//        Scanner cin = new Scanner(System.in);
//        String a;
//        String b;
//        int arrLength ;
//        int[] newint =new int[4000+10];
//        while(cin.hasNextInt())
//        {
//             arrLength = cin.nextInt();
//            int[] ints = new int[arrLength+1];
//            for (int i = 1; i <= arrLength; i++) {
//                ints[i] = cin.nextInt();
//            }
//            process(arrLength,ints);
//            newint[1]=0;
//            newint[2]=0;
//            newint[3] =0;
//            for (int i = 0; i <= arrLength; i++) {
//                if (newint[i] < newint[i-1]){
//                    newint[i] = newint[i-1];
//                }
//                int j =ok(i);
//                if(j != 0 ){
//                    if (newint[i] < newint[j-1] +1){
//                        newint[i] = newint[j-1]+1;
//                    }
//                }
//            }
//
//        }
//        System.out.println(newint[arrLength]);
//    }
//    public static void process(int n,int [] ints){
//        for (int i = 1; i <= n; i++) {
//            for (int j = i+1; j <= n; j++) {
//                if(ints[i] == ints[j]){
//                    preArr[j] = i;
//                    break;
//                }
//            }
//        }
//    }
//    public static int ok(int i){
//        int positon = preArr[i];
//        int len = 0;
//        for (int j = i-1; j >= 1; j--) {
//            if (j == positon){
//                continue;
//            }
//            int posj = preArr[j];
//            len
//        }
//        if (len > positon){
//            len =positon;
//        }
//        return len;
//    }
//}
