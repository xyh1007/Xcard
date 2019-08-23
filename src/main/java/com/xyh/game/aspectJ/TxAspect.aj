package com.xyh.game.aspectJ;

public aspect TxAspect {
    void around():call(void TestMain.say()){
        System.out.println("before");
        proceed();
        System.out.println("after");
    }
}
