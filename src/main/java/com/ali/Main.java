package com.ali;

import java.util.Scanner;

/**
 * @Author xzw
 * @create 2021/10/8 19:28
 */
public class Main {

    public static int computeFushuToInt(String s){
        StringBuilder stringBuilder =  new StringBuilder();
        char[] c = s.toCharArray();
        int length = c.length;
        for (int i = 0; i < length; i++) {
            if (c[i] == '1'){
                stringBuilder.append('0');
            } else {
                stringBuilder.append('1');
            }
        }
        int tmp = Integer.parseInt(stringBuilder.toString(),2);
        int result =tmp -2*tmp;
        return result-1;
    }
//            00000000000000000000000001010101 11111111111111111111111111111001
//            00000000000000000000000000011111 00000000000000000000000000000111
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);

            // 组数
            String s = cin.nextLine();
            int rowfGroup = Integer.parseInt(s);
            for (int i = 1; i <= rowfGroup ; i++) {
                String s1 = cin.nextLine().trim();
                String s2 = cin.nextLine().trim();
                long result1;
                long result2;
                if (s1.charAt(0)=='1'){
                    result1 = computeFushuToInt(s1);
                } else{
                    result1 = Long.parseLong(s1,2);
                }

                if (s2.charAt(0) == '1'){
                    result2 = computeFushuToInt(s2);
                } else{
                    result2 = Long.parseLong(s2,2);
                }
                System.out.println(result1+result2);
            }
        System.out.println("被熊忠伟修改过的地方");
        System.out.println("被熊忠伟修改过的地方3");
//        System.out.println(Integer.parseInt("00000000000000000000000000011111",2));
//        System.out.println(Integer.parseInt("00000000000000000000000000011111",2));
//        System.out.println(Integer.parseInt("00000000000000000000000000000111",2));
//        System.out.println(computeFushuToInt("11111111111111111111111111111111"));



    }
}
