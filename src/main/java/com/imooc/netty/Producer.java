package com.imooc.netty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzw
 * @create 2021/9/1 14:24
 */
public class Producer {
    private static int MAX_VALUE = 100;
    private List<Object> list = new ArrayList<>();
    public void producer(int sum){
        synchronized (list){
            while(list.size() + sum > MAX_VALUE){
                System.out.println("暂时不能生产任务");
                try{
                    list.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            for (int i = 0; i < sum; i++) {
                list.add(new Object());
            }
            System.out.println("已生产产品数"+sum+" 仓库容量"+list.size());
            list.notifyAll();
        }
    }

    public void consumer(int num) throws InterruptedException {
        synchronized (list){
            while(list.size() < num){
                System.out.println("暂时不能消费任务");
                list.wait();
            }
            for (int i = 0; i < num; i++) {
                list.remove(0);
            }
            System.out.println("已消费产品数"+num+" 仓库容量"+list.size());
            list.notifyAll();
        }



    }
}
