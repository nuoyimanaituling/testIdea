package com.imooc;

/**
 * @Author xzw
 * @create 2021/9/1 16:08
 */
public class YieldToConsumer {

   private int n;
   public YieldToConsumer(int n){
       this.n = n;
   }
   volatile boolean fin = true;

   public void PrintFoo(Runnable printFoo){
       for (int i = 0; i < n; i++) {
           if(fin){
               printFoo.run();
               fin = false;
           } else {
               Thread.yield();
           }
       }
   }
   public void PrintBar(Runnable printBar){
       for (int i = 0; i < n; i++) {
           if (!fin){
               printBar.run();
               fin = true;
           }else{
               Thread.yield();
           }
       }
   }
}
