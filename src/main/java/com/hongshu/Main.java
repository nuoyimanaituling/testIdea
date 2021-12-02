package com.hongshu;


import java.util.*;
public class Main {

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String a;
        String b;
        while(cin.hasNextLine())
        {
            a = cin.nextLine();
            b = cin.nextLine();
            int arrLength = Integer.parseInt(a);
            int[] result = new int[arrLength];
            char[] arrResult = b.toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arrResult.length; i++) {
                if(arrResult[i] != ' '){
                    list.add(arrResult[i] -'0');
                }
            }
            int n = list.size();
            int[] finalResult = new int[n];
            for (int i = 0; i < n; i++) {
                finalResult[i] = list.get(i);
            }
            int c = getMin(finalResult);

            System.out.println(c);
        }
    }
    public static int getMin1(int [] result){

        Map<Integer,Integer> map = new HashMap<>();
        int[] preSort = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            preSort[i] = result[i];
        }
        // 让result有序
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            map.put(result[i],i);
        }
        int cnt = 0;
        for (int i = 0; i < result.length; i++) {
            if (preSort[i] ==  result[i]){
                continue;
            }
            swap(preSort,i,map.get(preSort[i]));
            cnt++;
        }
        return cnt;

    }


    public static int getMin(int [] result){

        Map<Integer,Integer> map = new HashMap<>();
        int[] preSort = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            preSort[i] = result[i];
        }
        // 让result有序
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            map.put(result[i],i);
        }
        int loops = 0;
        boolean[] flag = new boolean[result.length];
        for (int i = 0; i < result.length; i++) {
            if (!flag[i]){
                int j = i;
                while(!flag[j]){
                    flag[j] = true;
                    j = map.get(preSort[j]);
                }
                loops++;
            }
        }
        return result.length - loops;

    }

    private static void swap(int[] preSort, int i, int j) {
        int tmp = preSort[i];
        preSort[i] = preSort[j];
        preSort[j] = tmp;
    }
}
