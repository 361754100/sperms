package com.smart.sperms.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通用的线程池任务管理器
 * @author Mojianzhang
 *
 */
public class CommonTaskManager {
	
	private static CommonTaskManager instance = null;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonTaskManager.class);
	
	private final static int initialThreadSize = 500;
	private final static int maxThreadSize = 500;
	private final static int threadWaitingTimeoutMillis = 30000;
	private final static int backlogSize = 10;
	
	private ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor( initialThreadSize, maxThreadSize, threadWaitingTimeoutMillis,
			TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(backlogSize));
	
	private static class HolderClass {
		private static final CommonTaskManager manager = new CommonTaskManager();
	}
	
	public static CommonTaskManager getInstance() {
		if(instance == null) {
			instance = HolderClass.manager;
		}
		return instance;
	}
	
	public void addTask(Runnable task) {
		logger.debug("[CommonTaskManager] Active Thread Count ->{}  maxThreadSize ->{}", taskExecutor.getActiveCount(), maxThreadSize);
		if (taskExecutor.getQueue().size() < backlogSize) {
			taskExecutor.execute(task);
		} else {
			logger.info("CommonTaskManager backlogSize has reach too limit!! Count ->{} maxThreadSize ->{}", taskExecutor.getActiveCount(), maxThreadSize);
			taskExecutor.getQueue().clear();
			logger.info("CommonTaskManager clear queue!!");
		}
	}
	
	public void stop() {
		taskExecutor.getQueue().clear();
		taskExecutor.shutdownNow();
		logger.info("<<< CommonTaskManager Executor shutdown >>>");
	}
	
}
