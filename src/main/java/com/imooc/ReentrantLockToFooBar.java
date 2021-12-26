package com.imooc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xzw
 * @create 2021/9/1 16:16
 */
public class ReentrantLockToFooBar {
    private int n;
    public ReentrantLockToFooBar(int n){
        this.n = n;
    }
    Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    volatile boolean flag = true;
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
             try{
                 while(!flag){
                     condition.await();
                 }
                 printFoo.run();
                 flag = false;
                 condition.signal();
             } finally {
                 lock.unlock();
             }
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(flag){
                    condition.await();
                }
                printBar.run();
                flag = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
