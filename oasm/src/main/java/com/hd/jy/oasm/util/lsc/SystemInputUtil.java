package com.hd.jy.oasm.util.lsc;

import java.util.Scanner;

/**
 * ����̨�������������
 * 
 * @author ander
 *
 */
public class SystemInputUtil {
	private static Scanner scanner = new Scanner(System.in);
	private static final String SYSTEM_INPUT_QUIT = "@qt";

	/**
	 * ��ȡ�ӿ���̨��������֣��� ����ȷ��
	 * 
	 * @param itemName
	 *            Ҫ�����ݵ�����
	 * @param max
	 *            ���������ֵ����ֵ
	 * @return
	 */
	public static int scanInputNum(String itemName, int max) {
		int inputNum = 0;
		String inputStr;

		System.out.print("������[" + itemName + "]��");
		inputStr = scanner.next().trim(); // ��ʵ����trim

		try {
			inputNum = Integer.parseInt(inputStr);
		} catch (NumberFormatException e) {
			System.out.println("�������ݴ���򳤶ȳ������ƣ�������[������]2,147,483,647��[����]��");
			inputNum = scanInputNum(itemName, max);
		}

		if (inputNum > max) {
			System.out.println("[WARN] ����ֵ���ܴ��ڣ�" + max + "��");
			inputNum = scanInputNum(itemName, max);
		}

		return inputNum;
	}

	/**
	 * ��ȡ�ӿ���̨��������ݣ��� ����ȷ��
	 * 
	 * @param itemName
	 *            Ҫ�����ݵ�����
	 * @param maxLength
	 *            �������ַ�����󳤶�
	 * @return
	 */
	public static String scanInput(String itemName, int maxLength) {
		String inputStr;
		System.out.print("������[" + itemName + "]��");
		inputStr = scanner.next().trim(); // ��ʵ����trim

		// ���������ж�
		if (inputStr.length() > maxLength) {
			System.out.println("�������ݳ��Ȳ��ܳ�����" + maxLength + "��");
			inputStr = scanInput(itemName, maxLength);
		}

		return inputStr;
	}

	/**
	 * ��ȡ�ӿ���̨��������ݣ��ж���ȷ��
	 * 
	 * @param itemName
	 *            Ҫ�����ݵ�����
	 * @param maxLength
	 *            �������ַ�����󳤶�
	 * @return
	 * 
	 */
	public static String scanInputWithConfirm(String itemName, int maxLength) {
		String inputStr;
		String inputStrRep;

		System.out.print("������[" + itemName + "]��");
		inputStr = scanner.next().trim();
		System.out.print("������[" + itemName + "]��");
		inputStrRep = scanner.next().trim();

		// ���������ж�
		if (inputStr.length() > maxLength) {
			System.out.println("�������ݳ��Ȳ��ܳ�����" + maxLength + "��");
			inputStr = scanInputWithConfirm(itemName, maxLength);
		}

		if (!inputStr.equals(inputStrRep)) {
			System.out.println("���������[" + itemName + "]��һ�£���Ҫ�������롣");
			inputStr = scanInputWithConfirm(itemName, maxLength);
		}
		return inputStr;
	}

	/**
	 * �ڿ���̨�г�ѡ�����ȡ��ѡ��ѡ���Ӧ�ı�ţ���Ŵ�0��ʼ��
	 * 
	 * @param optionContent
	 *            ѡ������(�ޱ��)
	 * @return ��ѡ��ѡ���Ӧ�ı��
	 */
	public static int choseOption(String... optionContent) {
		int optionLength = optionContent.length;

		System.out.println("\n��ѡ��");
		// �г�ѡ��
		for (int i = 0; i < optionLength; i++) {
			System.out.println(" " + i + ". " + optionContent[i]);
		}
		System.out.print("���������Ӧ�����֣�");
		return getChoseNum(optionLength - 1);
	}

	/**
	 * ������̨�����String�����ֱ��ת��Ϊ����
	 * 
	 * @param max
	 *            ��������ֵ
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
			System.out.print("������������������Ӧ��[����]��ţ�");
			num = getChoseNum(max);
		}

		if (num < 0 || num > max) {
			System.out.print("û�ж�Ӧ��ѡ����������룺");
			num = getChoseNum(max);
		}

		return num;

	}

	/**
	 * ����̨��¼����¼�˺Ż��¼���벻ƥ����ѭ������
	 * 
	 * @param supposedName
	 * @param nameLengthLimit
	 * @param supposedPwd
	 * @param pwdLengthLimit
	 */
	public static void loginGuard(String supposedName, int nameLengthLimit,
			String supposedPwd, int pwdLengthLimit) {
		String inputName = scanInput("��¼�˺�", nameLengthLimit);
		if (SYSTEM_INPUT_QUIT.equals(inputName)) {
			sysExit();
		}

		String inputPwd = scanInput("��¼����", pwdLengthLimit);
		if (SYSTEM_INPUT_QUIT.equals(supposedPwd)) {
			sysExit();
		}

		// ����˺ź����벻ƥ��
		if (!(inputName.equals(supposedName) && inputPwd.equals(supposedPwd))) {
			System.err.println("[��¼�˺�]��[��¼����]������Ҫ�������롣\n[�˳�]�����룺@qt��\n");
			loginGuard(supposedName, nameLengthLimit, supposedPwd,
					pwdLengthLimit);
		}
	}

	/**
	 * �˳���ǰJVM
	 */
	public static void sysExit() {
		System.out.print("\n�˳�");
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(200);
				System.out.print(".");
			} catch (InterruptedException e) {
				System.err.println("�˳�ʱ��������");
				e.printStackTrace();
			}
		}
		scanner.close();
		System.out.println();
		System.exit(0);
	}
}
