package com;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;

/**
 * @Author xzw
 * @create 2021/9/27 17:14
 */
public class Question1 {
    private static final HashMap<Character, Integer> numMap = new HashMap<>();



    public static int  chinese2digits(String InputStr){
        numMap.put('零', 0);
        numMap.put('一', 1);
        numMap.put('二', 2);
        numMap.put('两',2);
        numMap.put('三', 3);
        numMap.put('四', 4);
        numMap.put('五', 5);
        numMap.put('六', 6);
        numMap.put('七', 7);
        numMap.put('八', 8);
        numMap.put('九', 9);
        numMap.put('十', 10);
        numMap.put('百', 100);
        numMap.put('千', 1000);
        numMap.put('万', 10000);
        numMap.put('亿', 100000000);

        int total = 0;
        int r = 1;
        char[] inputstr =  InputStr.toCharArray();
        for (int i = inputstr.length-1; i >= 0 ; i--) {
            int val = numMap.get(inputstr[i]);
            if (val >= 10 && i==0 ){
                if(val > r ){
                    r =val;
                    total = total + val;
                } else {
                    r = r * val;
                }
            } else if (val >= 10){
                if (val  > r){
                    r =val;
                } else {
                    r = r *val;
                }
            } else {
                total = total + r*val;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(chinese2digits("两百三十二"));
        System.out.println(chinese2digits("一亿零八万零三百二十三"));
        System.out.println(chinese2digits("3333333333333333333333"));
        System.out.println(chinese2digits("1111111111111111111111"));
        System.out.println(chinese2digits("2222222222222222222222"));
    }
}
