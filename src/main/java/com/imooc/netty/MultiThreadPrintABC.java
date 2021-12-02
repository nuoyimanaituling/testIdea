package com.imooc.netty;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xzw
 * @create 2021/9/1 15:02
 */
public class MultiThreadPrintABC implements Runnable {
    // 打印次数
    private static final int PRINT_COUNT = 10;
    private final ReentrantLock reentrantLock;
    private final Condition thisCondition;

    public MultiThreadPrintABC(ReentrantLock reentrantLock, Condition condition, Condition nextCondition, char printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondition = condition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    private final Condition nextCondition;
    private final char printChar;

    @Override
    public void run() {
        // 访问共享资源
        reentrantLock.lock();
        try{

            for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.println(printChar);
                //因为只有一个线程在等待，所以signal或者signalAll都可以
                nextCondition.signal();
                if(i < PRINT_COUNT -1){
                    try{
                        thisCondition.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread threadA = new Thread(new MultiThreadPrintABC(lock,conditionA,conditionB,'A'));
        Thread threadB = new Thread(new MultiThreadPrintABC(lock,conditionB,conditionC,'B'));
        Thread threadC = new Thread(new MultiThreadPrintABC(lock,conditionC,conditionA,'C'));
        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();


    }
}
