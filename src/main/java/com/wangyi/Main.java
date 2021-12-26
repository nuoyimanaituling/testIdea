package com.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author xzw
 * @create 2021/9/17 19:26
 */
public class Main {

    public static void main(String[] args) {
//        String s = Integer.toBinaryString(0);
//        String tmp = new String("10");
//        String tmp1 =tmp.substring(1);
        compute(10);
//        System.out.println(tmp1);
    }


    public static long  compute(int a) {
        List<Integer> list = new ArrayList<>();
        int tmp =  a;
        while(tmp != 0) {
            list.add(0,tmp%10);
            tmp = tmp/10;
        }
        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(Integer.toBinaryString(list.get(i)));
        }
        // 反转后二进制
        String reverseString = stringBuilder.reverse().toString();
        if (reverseString.charAt(0) == '0'){
            reverseString = reverseString.substring(1);
        }
        char[] preResult = reverseString.toCharArray();
        // 利用栈来排除数据
        Stack<Character> stack = new Stack<>();
        stack.push(preResult[0]);
        for (int i = 1; i < preResult.length; i++) {
            if (stack.peek() != preResult[i]){
                stack.push(preResult[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        String result = builder.reverse().toString();
        System.out.println("result " + result);
//        int b = Integer.parseInt(result);
        return Long.parseLong(result);
    }
}
