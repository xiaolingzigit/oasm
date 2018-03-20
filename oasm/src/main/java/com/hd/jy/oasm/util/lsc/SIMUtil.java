package com.hd.jy.oasm.util.lsc;

import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * ���߳���ˮ�����ɹ���
 * @author admin
 *
 */
public class SIMUtil {
	private static AtomicInteger serialNumConter;// �̰߳�ȫ�ļ�������
	private static final String serialNumFile = "config/serialNumber.txt";
	private static final Charset serialNumFileCharset = Charset
			.forName("utf-8");

	private static ExecutorService singleThreadExecutor;

	/**
	 * �������к�
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
	 * ��ȡ���к�
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
