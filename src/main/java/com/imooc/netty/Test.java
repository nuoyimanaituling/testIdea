package com.imooc.netty;

public class Test {

    public static void main(String[] args){
        // 512*2
        System.out.println(512 << 1);
        // 2的11次方
        System.out.println(1<<11);
        System.out.println(512 >>>1 );
        // 相当于+1操作
        System.out.println(512 ^ 1);
        System.out.println(512 & 2);

        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "ab";
        String str4 = "c";
        String str5 = str3 + str4;
        System.out.println(str1.intern() == str1);
        // 加操作返回的是一个不同对象
        System.out.println(str1 == str2);
        System.out.println(str1 == str5);

    }
}
