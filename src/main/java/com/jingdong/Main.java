package com.jingdong;


import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author xzw
 * @create 2021/10/9 18:41
 */
public class Main {


    public String reverseWords(String s1) {
        int rightCur = s1.length() - 1;// 确定第一个不为空格的位置
        int leftCur = s1.length() - 1; // 确定第一个为空格的位置
        char[] str = s1.toCharArray();
        
        while (leftCur >= 0) {
            while (leftCur >= 0 && str[leftCur] != ' ') {
                leftCur--;
            }
            reverseStr(str, rightCur, leftCur + 1);
            if (leftCur < 0) {
                break;
            }
            while (leftCur >= 0 && str[leftCur] == ' ') {
                leftCur--;
            }
            rightCur = leftCur;
        }
        StringBuilder stringBuilder = getStringBuilder(str);
        return stringBuilder.toString();
    }

    private StringBuilder getStringBuilder(char[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            stringBuilder.append(str[i]);
        }
        if (1==1) {
            for (int i = 0; i < 100; i++) {

            }
        }
        return stringBuilder;
    }

    public void reverseStr(char[] str, int rightCur, int leftCur) {
        while (leftCur <= rightCur) {
            char tmp = str[rightCur];
            str[rightCur] = str[leftCur];
            str[leftCur] = tmp;
            rightCur--;
            leftCur++;
        }
    }

//    public static int longestConsecutive(int[] nums) {
//        Arrays.sort(nums);
//        // [0,3,7,2,5,8,4,6,0,1]
//        int begin = 0;
//        int end =  1;
//        int length = nums.length -1;
//        int count  = 1;
//        int maxCount = 1;
//        while(end>=0 && begin <= length && end <= length){
//            if(nums[end] - nums[begin] == 1){
//                count ++;
//                if(count > maxCount){
//                    maxCount = count;
//
//                }
//                // 必须写外面，这样才可以累加count
//                begin++;
//                end++;
//                continue;
//            }else if(nums[end] - nums[begin] == 0){
//                begin++;
//                end++;
//                continue;
//            }
//            count =1;
//            begin++;
//            end++;
//        }
//        return maxCount;
//    }

    public static void main(String[] args) {
        Main mian = new Main();
        String a = mian.reverseWords("Let's take LeetCode contest");
        HashSet<Integer> set = new HashSet<>();
        System.out.println(a);
        CompletableFuture.completedFuture("http:localhost:8080");
        // longestConsecutive(new int[]{-1,-1,1,0,3,4,5,6,7,8,9});
        LinkedBlockingQueue<Integer> zeroInDegrees = new LinkedBlockingQueue<>();

        Main main1 = new Main();

//        char[] c = new char[]{'t','a','e'};
//        char[] b = new char[]{'a','e','t'};
//        String c = "tae";
//        String b = "aet";
//        Arrays.sort(c.toCharArray());
//        Arrays.sort(b.toCharArray());
//        System.out.println(new String(c));
//        System.out.println(b);

//        String[] strs = new String[3];
//        HashMap<String,List<String>> map = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            String s1 = strs[i];
//            char[] tmp = s1.toCharArray();
//            Arrays.sort(tmp);
//            if (!map.containsKey(new String(tmp))){
//                map.put(new String(tmp),new ArrayList<String>());
//            }
//        }
//        for (int i = 0; i < strs.length; i++) {
//            char[] c = strs[i].toCharArray();
//            Arrays.sort(c);
//            List<String> list = map.get(new String(c));
//            list.add(strs[i]);
//        }
//        List<List<String>> result = new ArrayList<>();
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//                result.add(entry.getValue());
//        }
//        return result;

    }
}
