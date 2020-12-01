package com.xyh.game.spring_source_study.bean;

public class ThreadTest extends Thread {
    public void run(){
        System.out.println("thread name："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.setName("threadtest");
        System.out.println(threadTest.getName());
        threadTest.start();
    }
}
