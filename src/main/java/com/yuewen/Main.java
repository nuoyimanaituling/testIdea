package com.yuewen;

import java.util.Scanner;

/**
 * @Author xzw
 * @create 2021/9/29 18:45
 */
public class Main {

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String a,b;
        while(cin.hasNextLine())
        {
            a = cin.nextLine();
            String [] result = a.split(" ");
            for (int i = 0 ; i < result.length;i++){
                System.out.println(Integer.valueOf(result[i]));
            }

            System.out.println("");
        }
    }

}
