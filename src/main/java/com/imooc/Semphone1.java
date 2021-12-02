package com.imooc;

import java.util.concurrent.Semaphore;

/**
 * @Author xzw
 * @create 2021/9/1 16:36
 */
public class Semphone1 {

    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);
    public Semphone1(int n){
        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();


        }

    }
    public void bar(Runnable printBar) throws InterruptedException{
        for (int i = 0; i <n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {
        String word = "aasdfgh";
        System.out.println(word.startsWith("asdf",1));
    }
}
