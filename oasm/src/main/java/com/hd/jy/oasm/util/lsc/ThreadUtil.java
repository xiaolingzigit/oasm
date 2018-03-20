package com.hd.jy.oasm.util.lsc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.hd.jy.oasm.util.lsc.excpts.MismatchException;

public class ThreadUtil {
	// Java通过Executors提供4种线程池：
	// 1)newCachedThreadPool
	// 2)newFixedThreadPool
	// 3)newScheduledThreadPool
	// 4)newSingleThreadExecutor
	// ThreadFactory

	private static int threadPoolSize = 5;
	private static ExecutorService cachedThreadPool;
	private static ExecutorService fixedThreadPool;
	private static ScheduledExecutorService scheduledThreadPool;
	private static ExecutorService singleThreadExecutor;

	public static void cachedExecute(Runnable runnable) {
		cachedThreadPool = checkEffect(cachedThreadPool, T_CACHED_THREAD_POOL);
		cachedThreadPool.execute(runnable);
	}

	public static void fixedExecute(Runnable runnable) {
		fixedThreadPool = checkEffect(fixedThreadPool, T_FIXED_THREAD_POOL);
		fixedThreadPool.execute(runnable);
	}

	public static void scheduledExecuteAtFixedRate(Runnable runnable, long initialDelay,
            long period,
            TimeUnit unit) {
		scheduledThreadPool = (ScheduledExecutorService) checkEffect(scheduledThreadPool, T_SCHEDULED__THREAD_POOL);
		scheduledThreadPool.scheduleAtFixedRate(runnable, initialDelay, period, unit);
	}
	
	public static void scheduledExecuteWithFixedDelay(Runnable runnable,  long initialDelay,
            long delay,TimeUnit unit) {
		scheduledThreadPool = (ScheduledExecutorService) checkEffect(scheduledThreadPool, T_SCHEDULED__THREAD_POOL);
		scheduledThreadPool.scheduleWithFixedDelay(runnable, initialDelay, delay, unit);
	}

	public static void singleThreadExecute(Runnable runnable) {
		singleThreadExecutor = checkEffect(singleThreadExecutor, T_SINGLE_THREAD_EXCUTOR);
		singleThreadExecutor.execute(runnable);
	}

	public static ExecutorService globalCachedThreadPool() {
		cachedThreadPool = checkEffect(cachedThreadPool, T_CACHED_THREAD_POOL);
		return cachedThreadPool;
	}

	public static ExecutorService globalFixedThreadPool() {
		fixedThreadPool = checkEffect(fixedThreadPool, T_FIXED_THREAD_POOL);
		return fixedThreadPool;
	}

	public static ScheduledExecutorService globalScheduledThreadPool() {
		scheduledThreadPool = (ScheduledExecutorService) checkEffect(scheduledThreadPool, T_SCHEDULED__THREAD_POOL);
		return scheduledThreadPool;
	}

	public static ExecutorService globalSingleThreadExecutor() {
		singleThreadExecutor = checkEffect(singleThreadExecutor, T_SINGLE_THREAD_EXCUTOR);
		return singleThreadExecutor;
	}

	/**
	 * newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
	 * 
	 * @param threadFactory
	 *            可null
	 * @return
	 */
	public static ExecutorService newCachedThreadPool(
			ThreadFactory threadFactory) {
		return threadFactory == null ? Executors.newCachedThreadPool()
				: Executors.newCachedThreadPool(threadFactory);
	}

	/**
	 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
	 * 
	 * @param threadSize
	 *            非正数则使用默认值3
	 * @param threadFactory
	 *            可null
	 * @return
	 */
	public static ExecutorService newFixedThreadPool(int threadSize,
			ThreadFactory threadFactory) {
		if (threadSize < 1) {
			threadSize = 3;
		}
		return threadFactory == null ? Executors.newFixedThreadPool(threadSize)
				: Executors.newFixedThreadPool(threadSize, threadFactory);
	}

	/**
	 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
	 * 
	 * @param threadSize
	 *            非正数则使用默认值3
	 * @param threadFactory
	 *            可null
	 * @return
	 */
	public static ExecutorService newScheduledThreadPool(int threadSize,
			ThreadFactory threadFactory) {
		if (threadSize < 1) {
			threadSize = 3;
		}
		return threadFactory == null ? Executors
				.newScheduledThreadPool(threadSize) : Executors
				.newScheduledThreadPool(threadSize, threadFactory);
	}

	/**
	 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO,
	 * LIFO, 优先级)执行。
	 * 
	 * @param threadFactory
	 *            可null
	 * @return
	 */
	public static ExecutorService newSingleThreadExecutor(
			ThreadFactory threadFactory) {

		return threadFactory == null ? Executors.newSingleThreadExecutor()
				: Executors.newSingleThreadExecutor(threadFactory);
	}

	private static final String T_CACHED_THREAD_POOL = "cachedThreadPool";
	private static final String T_FIXED_THREAD_POOL = "fixedThreadPool";
	private static final String T_SCHEDULED__THREAD_POOL = "scheduledThreadPool";
	private static final String T_SINGLE_THREAD_EXCUTOR = "singleThreadExecutor";

	private static ExecutorService checkEffect(ExecutorService service, String serviceType) {
		if (service == null || service.isTerminated() || service.isShutdown()) {
			switch (serviceType) {
			case T_CACHED_THREAD_POOL:
				return Executors.newCachedThreadPool();

			case T_FIXED_THREAD_POOL:
				return Executors.newFixedThreadPool(threadPoolSize);
				
			case T_SCHEDULED__THREAD_POOL:
				return Executors.newScheduledThreadPool(threadPoolSize);
				
			case T_SINGLE_THREAD_EXCUTOR:
				return Executors.newSingleThreadExecutor();

			default:
				throw new MismatchException(
						"serviceType",
						serviceType,
						"only cachedThreadPool, fixedThreadPool, scheduledThreadPool and singleThreadExecutor is available");
			}
		}
		
		return service;
	}

	public static void main(String[] args) {
		Runnable a = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("A:" + i);
				}

			}
		};

		Runnable b = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("B:" + i);
				}

			}
		};

		Runnable c = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("C:" + i);
				}

			}
		};
		
		
		scheduledExecuteAtFixedRate(a,1000,10000,TimeUnit.MILLISECONDS);
		scheduledExecuteAtFixedRate(b,1000,10000,TimeUnit.MILLISECONDS);
		scheduledExecuteAtFixedRate(c,1000,10000,TimeUnit.MILLISECONDS);
	}
	
	

}
