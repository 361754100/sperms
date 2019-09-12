package com.smart.sperms.job;

import com.smart.sperms.config.QuartzProp;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class QuartzFactory {

    private static Logger logger = LoggerFactory.getLogger(QuartzFactory.class);

    @Autowired
    private QuartzProp quartzProp;

    public void execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ms");
        try {
            SchedulerFactory sf = new StdSchedulerFactory("quartz.properties");
            // 首先，必需要取得一个Scheduler的引用
            Scheduler sched = sf.getScheduler();
            //jobs可以在scheduled的sched.start()方法前被调用

            //---设备状态检查任务 ---- start
            boolean dev_state_check_flag = quartzProp.isDev_state_check_flag();
            if(dev_state_check_flag) {
                String dev_state_check_cron = quartzProp.getDev_state_check_cron();
                JobDetail dev_state_check_job = JobBuilder.newJob(DevStateCheckJob.class).withIdentity(DevStateCheckJob.class.getName()).build();

                CronTrigger dev_state_check_trigger = TriggerBuilder.newTrigger()
                        .withIdentity("dev_state_check_Trigger", "group-dwBasicInfoDataTrigger")
                        .withSchedule(CronScheduleBuilder.cronSchedule(dev_state_check_cron))
                        .build();
                logger.info(dev_state_check_job.getKey() + " 已被安排执行于: " + sdf.format(sched.scheduleJob(dev_state_check_job, dev_state_check_trigger))
                        + "，并且以如下重复规则重复执行: " + dev_state_check_trigger.getCronExpression());
            }
            //---设备状态检查任务 ---- end

            // 开始执行，start()方法被调用后，计时器就开始工作，计时调度中允许放入N个Job
            sched.start();
        } catch (Exception e) {
            logger.error("执行定时任务异常", e);
        }
    }
}
