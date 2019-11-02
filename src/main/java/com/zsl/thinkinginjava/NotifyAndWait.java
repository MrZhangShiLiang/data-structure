package com.zsl.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zsl
 * @date 2019/9/16
 */
public class NotifyAndWait {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        T1 t1 = new T1();
        executor.execute(t1);

        T2 t2 = new T2(t1);
        executor.execute(t2);
         executor.shutdown();

    }

}

class T1 implements Runnable{

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                wait();
                System.out.println("T1线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T2 implements Runnable{

    private T1 t1;

    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                TimeUnit.MICROSECONDS.sleep(200);
                notifyAll();
                System.out.println("t2......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

