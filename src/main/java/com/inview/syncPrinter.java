package com.inview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xzw
 * @create 2021/9/13 11:31
 */
public class syncPrinter implements Runnable{
    // 打印次数
    private static final int PRINT_COUNT = 10;
    private final ReentrantLock reentrantLock;
    private final Condition thisCondtion;
    private final Condition nextCondtion;
    private final char printChar;
    public syncPrinter(ReentrantLock reentrantLock, Condition thisCondtion, Condition nextCondition, char printChar) {
        this.reentrantLock = reentrantLock;
        this.nextCondtion = nextCondition;
        this.thisCondtion = thisCondtion;
        this.printChar = printChar;
    }
    @Override
    public void run() {
        // 获取打印锁 进入临界区
        reentrantLock.lock();
        try {
            // 连续打印PRINT_COUNT次
            for (int i = 0; i < PRINT_COUNT; i++) {
                //打印字符
                System.out.print(printChar);
                // 使用nextCondition唤醒下一个线程
                // 因为只有一个线程在等待，所以signal或者signalAll都可以
                nextCondtion.signal();
                // 不是最后一次则通过thisCondtion等待被唤醒
                // 必须要加判断，不然虽然能够打印10次，但10次后就会直接死锁
                // 如果没有这一步那么所有线程都会被await，加了这一步最后所有线程释放锁后
                // 线程状态就是活动的
                // 倒数第二次的时候就不用阻塞了，正常打印就好了
                if (i < PRINT_COUNT - 1) {
                    try {
                        //本线程让出锁并等待唤醒
                        thisCondtion.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread printA = new Thread(new syncPrinter(lock, conditionA, conditionB,'A'));
        Thread printB = new Thread(new syncPrinter(lock, conditionB, conditionC,'B'));
        Thread printC = new Thread(new syncPrinter(lock, conditionC, conditionA,'C'));
        printA.start();
        Thread.sleep(100);
        printB.start();
        Thread.sleep(100);
        printC.start();
    }
}