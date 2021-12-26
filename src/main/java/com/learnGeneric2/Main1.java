package com.learnGeneric2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author xzw
 * @create 2021/9/8 19:49
 */
public class Main1 {
//    给你一个仅有红，白，蓝三种颜色组成的10个条块序列，现需要你将这些条块按照红，白，蓝的顺序排好，
//    可用1代表红色，2代表白色，3代表蓝色，要求时间复杂度为O(n)。例如，给定彩色条块序列为：
//  ｛蓝、白、红、白、蓝、红、白、白、红、蓝｝
//则要求排列结果为：
// ｛红、红、红、白、白、白、白、蓝、蓝、蓝｝
public static void main(String args[])
{
    Scanner cin = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    while(cin.hasNextInt())
    {
        int tmp = cin.nextInt();
        list.add(tmp);
    }
    int[] bianli = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        bianli[i] = list.get(i);
    }
    sortArray(bianli);
    for (int i = 0; i < list.size(); i++) {
        System.out.println(bianli[i]);
    }


}
public static int[]  sortArray(int [] noSort){
    int start = 0;
    int length = noSort.length-1;
    int end = noSort.length-1;
    while(start<=length-1 && end>=0 && start <=  end ){
        while(noSort[start] == 1){
            start++;
        }
        while(noSort[end] != 1 && end>=start){
            end --;
        }
        if(end < start){
            break;
        }
        int tmp = noSort[start];
        noSort[start] = noSort[end];
        noSort[end] = tmp;
    }
    int p = start + 1;
    int q = noSort.length -1;
    while(p <= q){
        while(noSort[p] == 2){
            p++;
        }
        while(noSort[q] != 2 && q>=p){
            q--;
        }
        if(q < p ){
        break;
        }
        int tmp = noSort[p];
        noSort[p] = noSort[q];
        noSort[q] = tmp;
    }
    return noSort;
}



}
