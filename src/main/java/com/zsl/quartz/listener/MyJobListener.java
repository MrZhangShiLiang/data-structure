package com.zsl.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author zsl
 * @date 2019/10/5
 */
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        String str = this.getClass().getSimpleName();
        System.out.println("job监听名称："+str);
        return str;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {

    }
}
