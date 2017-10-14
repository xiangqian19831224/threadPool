package com.test.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaThreadPoolLearn {

	public static void main(String[] args) {

		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			strList.add("String" + i);
		}
		int threadNum = strList.size() < 5 ? strList.size() : 5;
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, threadNum, 300,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
				new ThreadPoolExecutor.CallerRunsPolicy());

		for (int i = 0; i < threadNum; i++) {
			executor.execute(new PrintStringThread(i, strList, threadNum));
		}
		executor.shutdown();
	}
}
