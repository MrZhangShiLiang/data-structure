package com.zsl.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 测试捕获异常的线程
 * @author zsl
 * @date 2019/8/24
 */
public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        Thread t  = Thread.currentThread();
        System.out.println("run by"+t);
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
        executorService.execute(new ExceptionThread());
    }
}

/**
 * 异常处理类
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("当前线程"+t.getName()+" ,caught:"+e);
    }
}

/**
 * 线程工厂
 */
class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+" creating new Thread");
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh= "+ thread.getUncaughtExceptionHandler());
        return thread;
    }
}