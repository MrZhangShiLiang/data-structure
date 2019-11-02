package com.zsl.quartz.main;

import com.zsl.quartz.demo.MyJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author zsl
 * @date 2019/10/5
 */
public class MyjobMain2 {

    public static void main(String[] args) throws SchedulerException {
        Date sDate = new Date();
        sDate.setTime(System.currentTimeMillis()+3000);
        System.out.println(sDate);
        Date eDate = new Date();
        eDate.setTime(System.currentTimeMillis()+10000);
        System.out.println(eDate);
        //1、获取schedule
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //2、JobDetail
        JobDetail job = JobBuilder.newJob(MyJob2.class)
                .withIdentity("job1", "group1")
                .build();
        //3、触发器trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startAt(sDate)
                .endAt(eDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }

}
