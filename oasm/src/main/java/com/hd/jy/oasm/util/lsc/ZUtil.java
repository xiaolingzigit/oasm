package com.hd.jy.oasm.util.lsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 
 * 小工具类
 * 
 * @author lsc
 *
 */
public class ZUtil {

	/**
	 * 字符串粗略模糊处理（姓名、电话、座机号码等）
	 * 
	 * @param phone
	 * @return
	 */
	public static String fuzzUp(String text) {
		if (text == null) {
			return null;
		}

		text = text.trim();

		if (text.isEmpty()) {
			return "";
		}

		String[] s = text.split("");// 数组0位是""

		if (s.length > 20) {
			s = DataUtil.replace(s, 4, s.length - 8, "*");
		} else if (s.length > 11) {
			int start = text.indexOf("-");

			if (start < 0) {
				start = text.indexOf(")");
			}

			if (start > 0 && s.length - start > 6) {
				s = DataUtil.replace(s, start + 4, 2, "*");
			} else {// 长字符串、手机号等，保留前三位和末四位
				s = DataUtil.replace(s, 4, s.length - 8, "*");
			}
		} else if (s.length > 9) {// 字符串或座机号码处理保留
			int start = text.indexOf("-");

			if (start < 0) {
				start = text.indexOf(")");
			}

			if (start < 0 || s.length - start < 5) {
				s = DataUtil.replace(s, 3, s.length - 6, "*");
			} else {
				s = DataUtil.replace(s, start + 4, s.length - start - 7, "*");
			}

		} else if (s.length >= 6) {
			s = DataUtil.replace(s, 3, s.length - 2 - 3, "*");
		} else if (s.length == 5) {
			s = DataUtil.replace(s, 3, 1, "*");
		} else if (s.length == 4) {
			s = DataUtil.replace(s, 2, 1, "*");
		} else if (s.length == 3) {
			s = DataUtil.replace(s, 1, 1, "*");
		}

		return toString(s);
	}

	private static String toString(String[] s) {
		if (s == null) {
			return null;
		}

		StringBuilder sbd = new StringBuilder();
		int count = 0;
		for (String str : s) {
			if ("*".equals(str)) {
				count++;
				if (count > 5) {
					continue;
				}
			}

			sbd.append(str);
		}

		return sbd.toString();
	}

	/**
	 * 显示Java平台环境
	 */
	public static void showSystemProperties() {
		Properties p = System.getProperties();

		System.out.println("======================");

		for (Map.Entry<Object, Object> entry : p.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
			System.out.println("-----------------------");
		}

		System.out.println("======================");
	}

	/**
	 * 执行cmd命令
	 * 
	 * @param envp
	 * @param cmds
	 * @return
	 */
	public static CmdReSult execCmd(String[] envp, String... cmds) {
		// 子进程，控制执行或获取该子进程的信息
		Process ps = null;
		int exitCode = -1;
		ArrayList<String> consoleInfo = null;
		try {
			// 创建子进程执行命令并返回该子进程
			if (envp == null) {
				ps = Runtime.getRuntime().exec(cmds);
			} else {
				ps = Runtime.getRuntime().exec(cmds, envp);
			}

			// 等待子进程完成再往下执行
			ps.waitFor();
			// 执行完毕的返回值0执行成功否则执行失败
			exitCode = ps.exitValue();
			consoleInfo = FileUtil.readToLines(ps.getInputStream(), null);
		} catch (Exception e) {
			consoleInfo = new ArrayList<String>();
			consoleInfo.add(e.getMessage());
		} finally {
			if (ps != null) {
				ps.destroy(); // 销毁子进程
			}
		}
		return new CmdReSult(exitCode, consoleInfo);
	}

	public static class CmdReSult extends BasicModel {
		public int exitCode;
		public List<String> consoleInfo;

		public CmdReSult(int exitCode, List<String> consoleInfo) {
			this.exitCode = exitCode;
			if (consoleInfo != null) {
				this.consoleInfo = consoleInfo;

			} else {
				this.consoleInfo = new ArrayList<String>();
			}
		}
	}
}
