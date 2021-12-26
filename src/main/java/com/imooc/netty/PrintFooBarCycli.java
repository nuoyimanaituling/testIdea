package com.imooc.netty;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author xzw
 * @create 2021/9/1 15:53
 */
public class PrintFooBarCycli {
    // 打印次数
    private int n;
    public PrintFooBarCycli(int n){
        this.n = n;
    }
    CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean fin = true;
    public void foo(Runnable printFoo) throws BrokenBarrierException, InterruptedException {

        for (int i = 0; i < n; i++) {
            while(fin){
                printFoo.run();
                fin = false;
            }
            try {
                cb.await();
            } catch (BrokenBarrierException e){
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (Exception e){
                e.printStackTrace();
            }
            printBar.run();
            fin = true;
        }

    }

    class printFoo implements  Runnable{

        @Override
        public void run() {
            System.out.println("Foo");
        }
    }

    class printBar implements  Runnable{

        @Override
        public void run() {
            System.out.println("Bar");
        }
    }

}
