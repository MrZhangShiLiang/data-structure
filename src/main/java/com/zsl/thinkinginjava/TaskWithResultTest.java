package com.zsl.thinkinginjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zsl
 * @date 2019/8/20
 */
public class TaskWithResultTest implements Callable<String> {
    private int id;

    public TaskWithResultTest() {
    }

    public TaskWithResultTest(int id) {
        this.id = id;
    }


    @Override
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.toString(id);
    }


}

class TestDemo{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResultTest(i)));
        }
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
