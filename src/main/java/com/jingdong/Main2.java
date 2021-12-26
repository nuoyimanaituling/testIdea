package com.jingdong;

import java.util.Arrays;

import java.util.Scanner;

/**
 * @Author xzw
 * @create 2021/10/9 20:35
 */
public class Main2 {

    public static int cutPre(int[] pre ,int n, int k ,int x){

        int count  = 1;
        int initPosition = 0;
        int end = pre.length-1;
        int [] tmp = new int[pre.length];
        for (int i = 0; i < pre.length; i++) {
            tmp[i] = pre[i];
        }
        while(initPosition < end){
            if (tmp[initPosition+1] - tmp[initPosition] <= x){
                initPosition++;
            } else{
                if (k!=0){
                    tmp[initPosition+1] = tmp[initPosition]+3;
                    k--;
                    initPosition++;
                } else{
                    count++;
                    initPosition++;
                }
            }
        }
        return count;
    }

    public static int cutBack(int[] pre ,int n, int k ,int x){
        int count  = 1;
        int initPosition = pre.length-1;
        int end = pre.length-1;
        int [] tmp = new int[pre.length];
        for (int i = 0; i < pre.length; i++) {
            tmp[i] = pre[i];
        }
        while(initPosition > 0){
            if (tmp[initPosition] - tmp[initPosition-1] <= x){
                initPosition--;
            } else{
                if (k!=0){
                    tmp[initPosition-1] = tmp[initPosition]-3;
                    k--;
                    initPosition--;
                } else{
                    count++;
                    initPosition--;
                }
            }
        }
        return count;
    }

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String a, b;

        while(cin.hasNext())
        {
            a = cin.nextLine();
            String[] arg = a.split(" ");
            int n = Integer.valueOf(arg[0]);
            int k = Integer.valueOf(arg[1]);
            int x = Integer.valueOf(arg[2]);
            b = cin.nextLine();
            String[] tmp = b.split(" ");
            int[] seq = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                seq[i] = Integer.valueOf(tmp[i]);
            }
            Arrays.sort(seq);
            int pre = cutPre(seq,n,k,x);
            int back =cutBack(seq,n,k,x);
            if (pre > back){
                System.out.println(back);
            } else {
                System.out.println(pre);
            }
        }
    }
}
