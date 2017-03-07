package com.intoms.Thread.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExcutor {
	public static void main(String[] args) {
		// createCachedThreadPool();
		// createFixThreadPool();
//		createScheduleThreadPool();
		createSingleThreadPool();
	}

	/**
	 * 创建一个newCachedThreadPool-------创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，
	 * 则新建线程
	 **/
	public static void createCachedThreadPool() {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			service.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}

	/** 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待 **/
	public static void createFixThreadPool() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			service.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2 * 1000);
						System.out.println(index);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/** 创建一个定时的线程池，支持定时及周期性任务执行。延迟执行示例代码如下： **/
	public static void createScheduleThreadPool() {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		service.schedule((new Runnable() {
			@Override
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}), 3, TimeUnit.SECONDS);
	}

	/** 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行 **/
	public static void createSingleThreadPool() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
