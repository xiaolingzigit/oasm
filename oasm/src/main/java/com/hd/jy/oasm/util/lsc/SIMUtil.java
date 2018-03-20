package com.hd.jy.oasm.util.lsc;

import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 多线程流水号生成工具
 * @author admin
 *
 */
public class SIMUtil {
	private static AtomicInteger serialNumConter;// 线程安全的计数变量
	private static final String serialNumFile = "config/serialNumber.txt";
	private static final Charset serialNumFileCharset = Charset
			.forName("utf-8");

	private static ExecutorService singleThreadExecutor;

	/**
	 * 保存序列号
	 */
	private static void save() {
		if (singleThreadExecutor == null || singleThreadExecutor.isTerminated()
				|| singleThreadExecutor.isShutdown()) {
			singleThreadExecutor = Executors.newSingleThreadExecutor();
		}
		
		singleThreadExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					FileUtil.writeFile(serialNumFile,
							serialNumConter.toString(), serialNumFileCharset,
							false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 获取序列号
	 * 
	 * @return
	 */
	public static int get() {
		int tmpNum;
		if (serialNumConter == null) {
			try {
				tmpNum = DataUtil.toInt(FileUtil.readAsString(serialNumFile,
						serialNumFileCharset, null).trim());
			} catch (Exception e) {
				tmpNum = 0;
			}
			serialNumConter = new AtomicInteger(tmpNum);
		}

		tmpNum = serialNumConter.incrementAndGet();
		save();
		return tmpNum;
	}
}
