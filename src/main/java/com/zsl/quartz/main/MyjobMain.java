package com.zsl.quartz.main;

import com.zsl.quartz.demo.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author zsl
 * @date 2019/10/5
 */

public class MyjobMain {
    public static void main(String[] args) throws Exception {
        //1、获取schedule
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //2、JobDetail
        JobDetail job = JobBuilder.newJob(MyJob1.class)
                .withIdentity("job1", "group1")
                .usingJobData("message","test")
                .usingJobData("count",0)
                .build();
        //3、触发器trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();

    }
}
