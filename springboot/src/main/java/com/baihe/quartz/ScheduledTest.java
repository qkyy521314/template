package com.baihe.quartz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Administrator on 2018/8/10.
 */
@Component
public class ScheduledTest {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);

    @Scheduled(cron="${quartz.cloneExpression1}")
    public void executeFileDownLoadTask() {
        Date date = new Date();
        Thread current = Thread.currentThread();
        System.out.println("定时任务1: "+date);
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }

    @Scheduled(cron="${quartz.cloneExpression2}")
    public void executeUploadTask() {

        Thread current = Thread.currentThread();
        System.out.println("定时任务2: "+current.getId());
        logger.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
    }

    @Scheduled(cron="0/10 * * * * ?")
    public void executeUploadBackTask() {

        // 间隔10s,执行任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务3: "+current.getId());
        logger.info("ScheduledTest.executeUploadBackTask 定时任务3:"+current.getId()+ ",name:"+current.getName());
    }

}
