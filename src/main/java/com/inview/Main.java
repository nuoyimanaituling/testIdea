package com.inview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author xzw
 * @create 2021/9/11 13:53
 */
public class Main {
    public int[] GetLeastNumbers(int[] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o1 - o2;
            }
        });
        int n = input.length;
        for (int i = 0; i < n ; i++) {
            queue.offer(input[i]);
        }
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return  result;
    }
    // Second question
    public int[] GetSortedTasks(int[][] taskLists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o1 - o2;
            }
        });
        int row = taskLists.length;
        int column = taskLists[0].length;
        for (int i = 0; i < taskLists.length; i++) {
            int j = taskLists[i].length;
            for (int k = 0; k < j; k++) {
                queue.offer(taskLists[i][k]);
            }
        }
        int size = queue.size();
        int []  result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = queue.poll();
        }
        return  result;


    }

}
