package com.xyh.game.aspectJ;

public class TestMain {
    public void say(){
        System.out.println("asj!");
    }

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.say();
    }
}
