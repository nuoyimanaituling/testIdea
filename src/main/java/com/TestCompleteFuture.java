package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @Author xzw
 * @create 2021/9/29 16:16
 */
public class TestCompleteFuture {


    /**
     * 对比一般的 Future，CompletableFuture 实现了完成状态的访问和设置，而 Future只能通过 get方法被动等待 future完成（可以无限等待也可以设置超时），
     * 无法设置状态，要取得瞬时状态只能调用 isDone() 来判断是否完成，若完成，则可以安心调用 get() 避免阻塞。
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> future = new CompletableFuture<>();
//        future.getNow(-1);
//        future.complete(10);
//        System.out.println(future.getNow(-1));
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] indexes = {0, array.length / 2, array.length};
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < indexes.length - 1; i++) {
            final int start = indexes[i];
            final int end = indexes[i + 1];
            futures.add(CompletableFuture.supplyAsync(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            }));
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
            List<Integer> results =
                    futures.stream().map(future -> future.getNow(-1)).collect(Collectors.toList());
            System.out.println(results);
        }
    }

}
