package com.zsl.quartz.demo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zsl
 * @date 2019/10/5
 */
@PersistJobDataAfterExecution   //添加该注解后，有状态的信息，可以持久化一些必要的数据
public class MyJob1 implements Job {

    private String message;
    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 实现job接口，进行模拟执该job做什么东西
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println("正在备份数据库，当前时间："+s);

        System.out.println("当前任务开始执行时间"+simpleDateFormat.format(jobExecutionContext.getFireTime()));
        System.out.println("下次任务执行时间"+simpleDateFormat.format(jobExecutionContext.getNextFireTime()));

        System.out.println("当前任务类名称："+jobExecutionContext.getJobDetail().getJobClass().getName());
        System.out.println(jobExecutionContext.getJobDetail().getKey());
        System.out.println("message----->"+message);

        System.out.println(jobExecutionContext.getTrigger().getScheduleBuilder());

        System.out.println("count--->"+count);
        count++;

        jobExecutionContext.getJobDetail().getJobDataMap().put("count",count);

        if (--count==10){
            try {
                jobExecutionContext.getScheduler().shutdown();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }
}
