package com.zsl.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定義任務的一中方式--實現runnable接口，重寫run方法。
 * from 《thinking in java》 4th
 * @author zsl
 * @date 2019/8/19
 */
public class DefinedTask implements Runnable{
    protected int count = 0;
    private  final int id = count++;

    public DefinedTask(){}

    public String status(){
        return "#"+id+": count("+(count > 0 ? count : "down")+"), ";
    }

    public DefinedTask(int count) {
        this.count = count;
    }

    /**
     * 一般在run方法中是一個無限循環，條件符合才會結束綫程
     */
    @Override
    public void run() {
        while (count-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {

        // 使用Thread
        /*for (int i = 0; i < 5; i++) {
            new Thread(new DefinedTask(10)).start();
        }
        System.out.println("main()....");
        System.out.println("================================");*/
        // 使用executor
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new DefinedTask(10));
        }
        executorService.shutdown();*/

        /*System.out.println("======================");
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService2.execute(new DefinedTask(10));
        }
        executorService2.shutdown();*/

        System.out.println("======================");
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService3.execute(new DefinedTask(10));
        }
        executorService3.shutdown();

    }
}
