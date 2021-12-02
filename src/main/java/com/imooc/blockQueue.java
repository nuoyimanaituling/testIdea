package com.imooc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xzw
 * @create 2021/9/1 14:39
 */
public class blockQueue {
    private List<Integer> container = new ArrayList<>();

    /**
     * 用于多线程访问
     */
    private volatile int size;
    /**
     * 用于多线程访问
     */
    private volatile int capacity;
    private Lock lock  = new ReentrantLock();
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();
    public void add(int data){
        lock.lock();
        try {
            while(size >= capacity){
                System.out.println("阻塞队列满了");
                isFull.await();
            }
            size++;
            container.add(data);
            isNull.signalAll();
        }catch (Exception e){
            isFull.signal();
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public int take(){
        lock.lock();
        try{
           while(size == 0){
               System.out.println("阻塞队列空了");
               isNull.await();
           }
           size--;
           int data = container.remove(0);
           isFull.signalAll();
           return data;
        } catch (Exception e){
            isNull.signal();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return 0;
    }

}
