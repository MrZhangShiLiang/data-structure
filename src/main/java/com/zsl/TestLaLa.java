package com.zsl;

/**
 * @author zsl
 * @date 2019/8/31
 */
public class TestLaLa {
    public static void main(String[] args) {

    }
}

interface Test1{
    void Csong();

    void Zsl();
}

class TestInterface1 implements Test1{

    @Override
    public void Csong() {
        System.out.println("陈松傻逼");
    }

    @Override
    public void Zsl() {
        System.out.println("hello world");
    }
}

class TestInterface2 implements Test1{

    @Override
    public void Csong() {
        System.out.println("陈松傻逼www");
    }

    @Override
    public void Zsl() {
        System.out.println("hello worldwwwww");
    }
}