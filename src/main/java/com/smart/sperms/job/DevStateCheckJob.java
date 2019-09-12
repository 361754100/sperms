package com.smart.sperms.job;

import com.smart.sperms.threadpool.CommonTaskManager;
import com.smart.sperms.threadpool.DevStateCheckTask;
import com.smart.sperms.utils.DateUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 设备状态检测任务
 */
public class DevStateCheckJob implements Job {

    private static Logger logger = LoggerFactory.getLogger(DevStateCheckJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DevStateCheckTask task = new DevStateCheckTask();

        CommonTaskManager.getInstance().addTask(task);

        logger.info("execute DevStateCheckJob ..."+ DateUtils.parseDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
