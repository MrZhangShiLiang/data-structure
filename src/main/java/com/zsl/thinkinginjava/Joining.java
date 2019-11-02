package com.zsl.thinkinginjava;

/**
 * 测试线程的join()方法
 * @author zsl
 * @date 2019/8/24
 */
public class Joining {

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("sleeper",1500),
                grump = new Sleeper("grump",1500);

        Joiner dopey = new Joiner("jdopey",sleeper),
                doc = new Joiner("doc",grump);
    }
}

class Sleeper extends Thread{
    private int sleepTime;


    public Sleeper(String name,int sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
        this.start();
    }

    @Override
    public void run(){
        try {
            sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println(this.getName()+" thread sleeper interrupt");
        }
        System.out.println(this.getName()+" thread sleeper waked");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name,  Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        this.start();
    }

    @Override
    public void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(this.getName()+" interrupt");
        }
        System.out.println(this.getName()+" waked");
    }
}
