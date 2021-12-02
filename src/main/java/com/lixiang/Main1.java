package com.lixiang;

import java.util.Scanner;

/**
 * @Author xzw
 * @create 2021/11/12 19:04
 */
public class Main1 {


    public static void main(String[] args) {
        int[][] f = new int[Integer.MAX_VALUE][4];
        Scanner sc = new Scanner(System.in);
        char[] s = new char[Integer.MAX_VALUE];
        int n = sc.nextInt();
        char[] t = new char[]{'L','O','V','E'};
        while(n > 0){
            String s1 = sc.next();
            int len =  s1.length();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 4; j++) {
                    f[i][j] =len;
                }
            }
            int pos = 0;
            for (int j = 0; j < 4; j++) {
                pos = len;
                for (int i = len -1; i >= 0 ; i--) {
                    if (s[i] == t[j]){
                        pos = i;
                        f[i][j] =pos;
                    }
                }
            }
            long ans =0;
            for (int i = 0; i < len; i++) {
                int p = 0;
                for (int j = 0; j < 4; j++) {
                    p = Math.max(p,f[i][j]);
                }
                ans  = ans + len -p;
            }
            System.out.println(ans);
        }
        return;
    }
}
