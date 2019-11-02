package com.zsl.thinkinginjava;

/**
 * 测试使用ThreadLocal
 * @author zsl
 * @date 2019/8/29
 */
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) {
        this.id=idn;
    }



    @Override
    public void run() {

    }
}

class ThreadLocalVariableHolder{

}

