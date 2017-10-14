package com.test.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO: comment here
 */
public class ExecutorsScheduledLearn {
	public static void main(String[] args) {
		// 创建一个可重用固定线程数的线程池
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Runnable t1 = new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ": t1");
			}
		};

		Runnable t2 = new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ": t2");
			}
		};

		Runnable t3 = new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ": t3");
			}
		};

		pool.schedule(t1,5, TimeUnit.SECONDS);
		pool.schedule(t2,1, TimeUnit.SECONDS);
		pool.schedule(t3,2, TimeUnit.SECONDS);

		// 关闭线程池
		pool.shutdown();
	}
}
