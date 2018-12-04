package com.tencent.cain.java;

public class HandleComputation {
    public void postponeComputation(int delay, Runnable runnable) {
        new Thread(runnable).start();
    }
}
