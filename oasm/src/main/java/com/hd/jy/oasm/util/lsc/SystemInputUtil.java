package com.hd.jy.oasm.util.lsc;

import java.util.Scanner;

/**
 * 控制台输入与操作工具
 * 
 * @author ander
 *
 */
public class SystemInputUtil {
	private static Scanner scanner = new Scanner(System.in);
	private static final String SYSTEM_INPUT_QUIT = "@qt";

	/**
	 * 获取从控制台输入的数字，无 二次确认
	 * 
	 * @param itemName
	 *            要输内容的名称
	 * @param max
	 *            可输入数字的最大值
	 * @return
	 */
	public static int scanInputNum(String itemName, int max) {
		int inputNum = 0;
		String inputStr;

		System.out.print("请输入[" + itemName + "]：");
		inputStr = scanner.next().trim(); // 其实不用trim

		try {
			inputNum = Integer.parseInt(inputStr);
		} catch (NumberFormatException e) {
			System.out.println("输入内容错误或长度超过限制，请输入[不大于]2,147,483,647的[数字]。");
			inputNum = scanInputNum(itemName, max);
		}

		if (inputNum > max) {
			System.out.println("[WARN] 输入值不能大于：" + max + "。");
			inputNum = scanInputNum(itemName, max);
		}

		return inputNum;
	}

	/**
	 * 获取从控制台输入的内容，无 二次确认
	 * 
	 * @param itemName
	 *            要输内容的名称
	 * @param maxLength
	 *            可输入字符串最大长度
	 * @return
	 */
	public static String scanInput(String itemName, int maxLength) {
		String inputStr;
		System.out.print("请输入[" + itemName + "]：");
		inputStr = scanner.next().trim(); // 其实不用trim

		// 长度限制判断
		if (inputStr.length() > maxLength) {
			System.out.println("输入内容长度不能超过：" + maxLength + "。");
			inputStr = scanInput(itemName, maxLength);
		}

		return inputStr;
	}

	/**
	 * 获取从控制台输入的内容，有二次确认
	 * 
	 * @param itemName
	 *            要输内容的名称
	 * @param maxLength
	 *            可输入字符串最大长度
	 * @return
	 * 
	 */
	public static String scanInputWithConfirm(String itemName, int maxLength) {
		String inputStr;
		String inputStrRep;

		System.out.print("请输入[" + itemName + "]：");
		inputStr = scanner.next().trim();
		System.out.print("再输入[" + itemName + "]：");
		inputStrRep = scanner.next().trim();

		// 长度限制判断
		if (inputStr.length() > maxLength) {
			System.out.println("输入内容长度不能超过：" + maxLength + "。");
			inputStr = scanInputWithConfirm(itemName, maxLength);
		}

		if (!inputStr.equals(inputStrRep)) {
			System.out.println("两次输入的[" + itemName + "]不一致，需要重新输入。");
			inputStr = scanInputWithConfirm(itemName, maxLength);
		}
		return inputStr;
	}

	/**
	 * 在控制台列出选项，并获取被选中选项对应的编号（编号从0开始）
	 * 
	 * @param optionContent
	 *            选项内容(无编号)
	 * @return 被选中选项对应的编号
	 */
	public static int choseOption(String... optionContent) {
		int optionLength = optionContent.length;

		System.out.println("\n请选择：");
		// 列出选项
		for (int i = 0; i < optionLength; i++) {
			System.out.println(" " + i + ". " + optionContent[i]);
		}
		System.out.print("输入操作对应的数字：");
		return getChoseNum(optionLength - 1);
	}

	/**
	 * 将控制台输入的String型数字编号转换为数字
	 * 
	 * @param max
	 *            允许的最大值
	 * @return
	 */
	public static int getChoseNum(int max) {
		int num = 0;
		try {
			if (scanner.hasNext()) {
				num = Integer.parseInt(scanner.next());
			} else {
				System.out.println("=============");
			}
		} catch (NumberFormatException e) {
			System.out.print("输入错误，请输入操作对应的[数字]编号：");
			num = getChoseNum(max);
		}

		if (num < 0 || num > max) {
			System.out.print("没有对应的选项，请重新输入：");
			num = getChoseNum(max);
		}

		return num;

	}

	/**
	 * 控制台登录，登录账号或登录密码不匹配则循环调用
	 * 
	 * @param supposedName
	 * @param nameLengthLimit
	 * @param supposedPwd
	 * @param pwdLengthLimit
	 */
	public static void loginGuard(String supposedName, int nameLengthLimit,
			String supposedPwd, int pwdLengthLimit) {
		String inputName = scanInput("登录账号", nameLengthLimit);
		if (SYSTEM_INPUT_QUIT.equals(inputName)) {
			sysExit();
		}

		String inputPwd = scanInput("登录密码", pwdLengthLimit);
		if (SYSTEM_INPUT_QUIT.equals(supposedPwd)) {
			sysExit();
		}

		// 如果账号和密码不匹配
		if (!(inputName.equals(supposedName) && inputPwd.equals(supposedPwd))) {
			System.err.println("[登录账号]或[登录密码]错误，需要重新输入。\n[退出]请输入：@qt。\n");
			loginGuard(supposedName, nameLengthLimit, supposedPwd,
					pwdLengthLimit);
		}
	}

	/**
	 * 退出当前JVM
	 */
	public static void sysExit() {
		System.out.print("\n退出");
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(200);
				System.out.print(".");
			} catch (InterruptedException e) {
				System.err.println("退出时发生错误：");
				e.printStackTrace();
			}
		}
		scanner.close();
		System.out.println();
		System.exit(0);
	}
}
