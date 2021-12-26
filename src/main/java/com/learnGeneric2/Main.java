package com.learnGeneric2;

import java.util.Scanner;

/**
 * @Author xzw
 * @create 2021/9/8 18:54
 */
public class Main {


    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String text1;
        String text2;
        while(cin.hasNext())
        {
            text1 = cin.next();
            text2 = cin.next();
            int result = longSequence(text1,text2);
            if (result == 0){
                System.out.println("0");
            }
            System.out.println(result);
        }
    }
    public static int longSequence(String text1,String text2){
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m ; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1[i-1] == t2[j-1]){
                    dp[i][j] =maxCompare3(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return  dp[n][m];
    }

    public static int maxCompare3(int i, int i1, int i2) {
        int max =Integer.MIN_VALUE;
        if (i > max){
            max = i;
        }
        if(i1 > max){
            max = i1;
        }
        if(i2 > max){
            max = i2;
        }
        return  max;
    }

}
