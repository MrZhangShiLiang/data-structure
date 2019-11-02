package com.zsl.thinkinginjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 带返回值
 * @author zsl
 * @date 2019/8/20
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult() {
    }

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult is "+id;
    }
}

class CallableDemo{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(
                        result.isDone()
                );
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
