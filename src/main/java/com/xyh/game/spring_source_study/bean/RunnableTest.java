package com.xyh.game.spring_source_study.bean;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable name:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        RunnableTest r = new  RunnableTest();
        Thread t = new Thread(r);
        System.out.println("now:"+Thread.currentThread().getName());
        t.start();
        System.out.println("last:"+Thread.currentThread().getName());
    }
}
