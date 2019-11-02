package com.zsl.thinkinginjava;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zsl
 * @date 2019/9/16
 */
public class NotifyVsNotifyAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new Task1());
        }

        executorService.execute(new Task2());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod){
                    System.out.println("notify");
                    Task1.blocker.prod();
                }else {
                    System.out.println("notifyAll");
                    Task1.blocker.prodAll();
                }

            }
        },400,400);


        TimeUnit.MICROSECONDS.sleep(50);
        timer.cancel();
        System.out.println("timer canceled");


        TimeUnit.MICROSECONDS.sleep(5000);
        Task2.blocker.prodAll();
        TimeUnit.MICROSECONDS.sleep(5000);
        executorService.shutdownNow();



    }

}

class Blocker{
    synchronized void waitingCall(){
        try {
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread()+"  ");
            }
        }catch (Exception e){

        }
    }

    synchronized void prod(){
        notify();
    }

    synchronized void prodAll(){
        notifyAll();
    }
}


class Task1 implements Runnable{

    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable{

    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}