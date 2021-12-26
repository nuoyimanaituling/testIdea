package com.learnGeneric2;

/**
 * @Author xzw
 * @create 2021/9/7 19:49
 */



public   class Question1 {
    static {
        System.out.println("静态代码");
    }
    {
        System.out.println("代码块");
    }

    public static final Question1 question = new Question1();
    private Question1(){};

    public  static Question1 getInstance(){
        return  question;
    }

    public static void main(String[] args) {

        System.out.println(Question1.getInstance() == Question1.getInstance());
        System.out.println(Question1.getInstance().equals( Question1.getInstance()));
        Question1 question1 = new Question1();


    }
}


