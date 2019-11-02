package com.zsl.generic;

interface Interface{
    void doSomething();
    void doSomethingElse(String args);
}

/**
 * @author zsl
 * @date 2019/9/3
 * 测试学习动态代理
 */
public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        SimpleProxyDemo.consumer(new RealObject());
        SimpleProxyDemo.consumer(new SimpleProxy(new RealObject()));
    }
}

class SimpleProxy implements Interface{

    private Interface anInterface;

    public SimpleProxy(Interface anInterface) {
        this.anInterface = anInterface;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        this.anInterface.doSomething();
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("SimpleProxy somthingElse "+args);
        this.anInterface.doSomethingElse(args);
    }
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("RealObject do somtthing");
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("RealObject something esle "+args);
    }
}

