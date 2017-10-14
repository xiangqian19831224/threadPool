package com.test.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment here
 *
 */
public class SpringThreadPoolLearn {
	public static void main(String[] args){
		ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
		//线程池所使用的缓冲队列
		poolTaskExecutor.setQueueCapacity(200);
		//线程池维护线程的最少数量
		poolTaskExecutor.setCorePoolSize(5);
		//线程池维护线程的最大数量
		poolTaskExecutor.setMaxPoolSize(1000);
		//线程池维护线程所允许的空闲时间
		poolTaskExecutor.setKeepAliveSeconds(30000);
		poolTaskExecutor.initialize();

		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			strList.add("String" + i);
		}

		int threadNum = strList.size() < 5 ? strList.size() : 5;
		for (int i = 0; i < threadNum; i++) {
			poolTaskExecutor.execute(new PrintStringThread(i, strList, threadNum));
		}
		poolTaskExecutor.shutdown();
	}
}
