package com.Test;

/**
 * @Author xzw
 * @create 2021/10/20 19:45
 */
public class Main {

    public static int reverse(int x) {
        int symbolBit = 1;
        if(x < 0){
            symbolBit = -1;
            x = (-1)*x;
        }
        String s = String.valueOf(x);
        int result = 0;
        for(int i = s.length()-1;i>=0;i--){
            result = result *10 + s.charAt(i) -'0';
        }
        return result*symbolBit;

    }
    public static void main(String[] args) {
        System.out.println("修改testmain包下文件第二次 熊忠伟" );
       System.out.println("修改 Test包下文件第一次");
       reverse(123);
       reverse(456);
    }
}
