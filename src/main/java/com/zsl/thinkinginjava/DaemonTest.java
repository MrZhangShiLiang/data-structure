package com.zsl.thinkinginjava;

import java.util.concurrent.TimeUnit;

/**
 * 后台进程
 * @author zsl
 * @date 2019/8/24
 */
public class DaemonTest implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupt");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DaemonTest());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all darmon started");
        try {
            TimeUnit.MICROSECONDS.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
