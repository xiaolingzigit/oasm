package com.hd.jy.oasm.util.lsc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.NullException;
import com.hd.jy.oasm.util.lsc.excpts.NullOrEmptyException;

public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);
	// ByteArrayInputStream ByteArrayOutputStream ByteBuffer...

	// /r �س� Carriage Return, /n ���� New Line ,������ɻ���
	// ��ȡϵͳ���з���System.getProperty("line.separator")
	// ��ϵͳӦ����: /r Mac /n Unix/Linux /r/n Windows
	public static final String SEPARATOR_LINE_LINUX_UNIX = "\n";
	public static final String SEPARATOR_LINE_MAC = "\r";
	public static final String SEPARATOR_LINE_WIN = "\r\n";
	/** ��Ƿֺ� */
	public static final String SEPARATOR_ELE_SEMICOLON = ";";
	/** ��Ƕ��� */
	public static final String SEPARATOR_ELE_COMMA = ",";
	/** ���� */
	public static final String SEPARATOR_VERTICAL_LINE = "|";

	public static final String LINE_SEPARATOR_REGEX = "^" + SEPARATOR_LINE_WIN
			+ "|" + SEPARATOR_LINE_LINUX_UNIX + "|" + SEPARATOR_LINE_MAC + "$";// ���з�������ʽ

	public static final String KEY_VAL_CONNECTOR = "=";

	public static final int NOT_EXIST = 0;
	public static final int EXIST_AS_FILE = 1;
	public static final int EXIST_AS_DIR = 2;
	public static final int EXIST_AS_UNKNOWN = -1;

	// TODO FLAG WRITE

	/**
	 * д�ļ�,����Ҫ���з��������( Mac:\r,Unix/Linux: \n ,Windows: \r\n )
	 * 
	 * @param filePath
	 * @param content
	 * @param charset
	 *            null��ָ���ַ�����
	 * @param append
	 * @throws IOException
	 */
	public static void writeFile(String filePath, String content,
			Charset charset, boolean append) throws IOException {

		if (DataUtil.isEmpty(filePath)) {
			throw new NullOrEmptyException("filePath", filePath, null);
		}

		FileOutputStream fos = null;
		// OutputStreamWriter osw = null;
		try {
			int flag = isParentDirExist(new File(filePath), true);
			if (flag != EXIST_AS_DIR) {
				throw new IOException("parent of " + filePath
						+ " not exists or exists as not a directory");
			}

			fos = new FileOutputStream(filePath, append); // ׷����true

			if (charset == null) {
				fos.write(content.getBytes());
				// osw = new OutputStreamWriter(fos);
			} else {
				fos.write(content.getBytes(charset));// ת����Ӧ���ַ���
				// osw = new OutputStreamWriter(fos, charset);
				// osw.write(content);
			}

			// ����ķ���:
			// FileWriter fw = new FileWriter(str, true);
			// fw.append(str).append(str).flush();
			// fw.close();

		} catch (IOException e) {
			throw new IOException("write string to file failed, content["
					+ content + "], filePath[" + filePath + "], charset["
					+ charset + "], append[" + append + "]", e);
		} finally {
			IOCloseUtil.close(fos);
			// IOCloseUtil.close(osw);
		}
	}

	/**
	 * �������������ݰ��ֽ�д�뵽�ļ����������������ض�ý����Դ�ı����
	 * 
	 * @param filePath
	 *            ������ļ�·��
	 * @param is
	 *            ����������
	 * @param append
	 *            �Ƿ�׷��
	 * @param colseIS
	 *            �Ƿ�ر�������
	 * @throws IOException
	 */
	public static void writeFile(String filePath, InputStream is,
			boolean append, boolean colseIS) throws IOException {

		if (DataUtil.isEmpty(filePath)) {
			throw new NullOrEmptyException("filePath", filePath, null);
		}

		byte[] bf = new byte[2048];
		int len = 0;
		FileOutputStream fos = null;

		try {

			int flag = isParentDirExist(new File(filePath), true);
			if (flag != EXIST_AS_DIR) {
				throw new IOException("parent of " + filePath
						+ " not exists or exists as not a directory");
			}

			fos = new FileOutputStream(filePath, append);

			while ((len = is.read(bf)) != -1) {
				fos.write(bf, 0, len);
			}

		} catch (IOException e) {
			throw new IOException(
					"binaryWrite inputStream to file failed, filePath["
							+ filePath + "], append[" + append
							+ "], colseInputStream[" + colseIS + "]", e);

		} finally {

			if (colseIS) {
				IOCloseUtil.close(is);
			}
			IOCloseUtil.close(fos);
		}
	}

	/**
	 * д�ļ�
	 * 
	 * @param destFile
	 * @param lines
	 *            Ҫд���������
	 * @param eleSeparator
	 *            Ԫ�طָ���FileUtil.separator_*��null�����Ԫ�طָ���
	 * @param charset
	 *            null��ָ������
	 * @param append
	 * @throws IOException
	 */
	public static void writeFile(String destFile, String[] lines,
			String eleSeparator, Charset charset, boolean append)
			throws IOException {

		if (lines == null) {
			return;
		}

		StringBuilder sbd = new StringBuilder();
		for (String line : lines) {
			sbd.append(line);
			if (eleSeparator != null) {
				sbd.append(eleSeparator);
			}
		}

		writeFile(destFile, sbd.toString(), charset, append);
	}

	/**
	 * д�ļ�
	 * 
	 * @param destFile
	 * @param lines
	 *            Ҫд���������
	 * @param eleSeparator
	 *            Ԫ�طָ���FileUtil.separator_*��null�����Ԫ�طָ���
	 * @param charset
	 *            null��ָ������
	 * @param append
	 * @throws IOException
	 */
	public static void writeFile(String destFile, List<String> lines,
			String eleSeparator, Charset charset, boolean append)
			throws IOException {

		if (lines == null) {
			return;
		}

		StringBuilder sbd = new StringBuilder();
		for (String line : lines) {
			sbd.append(line);
			if (eleSeparator != null) {
				sbd.append(eleSeparator);
			}
		}

		writeFile(destFile, sbd.toString(), charset, append);
	}

	/**
	 * д�ļ�
	 * 
	 * @param destFile
	 * @param lines
	 *            Ҫд���������
	 * @param keyValConnector
	 *            ��ֵ�����ӷ���null��Ĭ��ʹ�á�=��
	 * @param eleSeparator
	 *            Ԫ�طָ���FileUtil.separator_*��null�����Ԫ�طָ���
	 * @param charset
	 *            null��ָ������
	 * @param append
	 * @throws IOException
	 */
	public static void writeFile(String destFile, Map<?, ?> lines,
			String keyValConnector, String eleSeparator, Charset charset,
			boolean append) throws IOException {

		if (lines == null) {
			return;
		}

		if (keyValConnector == null) {
			keyValConnector = KEY_VAL_CONNECTOR;
		}

		StringBuilder sbd = new StringBuilder();

		for (java.util.Map.Entry<?, ?> entry : lines.entrySet()) {
			sbd.append(entry.getKey());
			sbd.append(keyValConnector);
			sbd.append(entry.getValue());
			if (eleSeparator != null) {
				sbd.append(eleSeparator);
			}
		}

		writeFile(destFile, sbd.toString(), charset, append);
	}

	// TODO FLAG READ

	/**
	 * ���ļ����ֽڶ�ȡ�������
	 * 
	 * @param srcFile
	 * @param os
	 * @param closeOs
	 * @throws IOException
	 */
	public static void fileToOutputStream(String srcFile, OutputStream os,
			boolean closeOs) throws IOException {

		if (DataUtil.isEmpty(srcFile)) {
			throw new NullOrEmptyException("srcFile", srcFile, null);
		}

		byte[] buf = new byte[2048];
		int len = 0;
		FileInputStream fis = null;
		try {

			fis = new FileInputStream(srcFile);

			while ((len = fis.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			os.flush();
		} catch (IOException e) {
			throw new IOException("read from file[" + srcFile
					+ "] and write to outputStream failed", e);
		} finally {
			IOCloseUtil.close(fis);
			if (closeOs) {
				IOCloseUtil.close(os);
			}
		}
	}

	/**
	 * ��ȡ�ļ�������
	 * 
	 * @param filePath
	 * @param inSrc
	 *            �ļ��Ƿ��ڰ���
	 * @return
	 * @throws IOException
	 */
	public static InputStream getAsStream(String filePath, boolean inSrc)
			throws IOException {
		InputStream is = null;
		if (inSrc) {
			is = ClassLoader.getSystemClassLoader().getResourceAsStream(
					filePath);

		} else {
			is = new FileInputStream(filePath);
		}
		
		if (is == null) {
			throw new IOException("Could not find resource: " + filePath);
		}

		return is;
	}
	
	
	/**
	 * ��ȡ�ļ�ָ������
	 * 
	 * @param filePath
	 * @param charset
	 * @param lineStart
	 *            ��ʼ��,��1��ʼ������
	 * @param lineEnd
	 *            �����У�����
	 * @param fix
	 *            ��ָ����������ʵ������ʱ���Ƿ�������ȡ���������Ϊ�ļ�ʵ������������������쳣
	 * @return never null
	 * @throws IOException
	 */
	public static List<String> readLines(String filePath, Charset charset,
			int lineStart, int lineEnd, boolean fix) throws IOException {

		if (lineStart < 1 || lineEnd < 1) {
			throw new IllegalException(
					"lineStart and lineEnd must greater than 0. now: lineStart="
							+ lineStart + ", lineEnd=" + lineEnd);
		}

		if (lineStart > lineEnd) {
			throw new IllegalException(
					"lineEnd must greater than lineStart. now: lineStart="
							+ lineStart + ", lineEnd=" + lineEnd);
		}

		List<String> allLines = readAsLines(filePath, charset);
		List<String> subLines = new ArrayList<String>();
		int allSize = allLines.size();

		if (lineEnd > allSize) {
			if (fix) {
				lineEnd = allSize;
			} else {
				throw new IOException("lineEnd[" + lineEnd
						+ "] is out of range[" + allSize + "]");
			}
		}

		for (int i = 1; i < allSize; i++) {
			if (i >= lineStart && i <= lineEnd) {
				subLines.add(allLines.get(i - 1));
			}
		}

		return subLines;
	}

	/**
	 * ��ȡ�ļ�
	 * 
	 * @param filePath
	 * @param charset
	 *            null��ָ������
	 * @return never null
	 * @throws IOException
	 */
	public static ArrayList<String> readAsLines(String filePath, Charset charset)
			throws IOException {

		if (DataUtil.isEmpty(filePath)) {
			throw new NullOrEmptyException("filePath", filePath, null);
		}

		// FileReader fr = null;

		FileInputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			// ��ȡ��ʽ1
			// fr = new FileReader(file);

			// ��ȡ��ʽ2
			is = new FileInputStream(filePath);

			if (charset == null) {
				isr = new InputStreamReader(is);
			} else {
				isr = new InputStreamReader(is, charset);
			}

			br = new BufferedReader(isr);// InputStreamReader,FileReader

			ArrayList<String> lines = new ArrayList<String>();

			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			return lines;
		} catch (IOException e) {
			throw new IOException("read file[" + filePath + "] with charset["
					+ charset + "] failed", e);

		} finally {
			IOCloseUtil.close(is);
			IOCloseUtil.close(isr);
			IOCloseUtil.close(br);
		}
	}

	/**
	 * ��ȡ�ļ�
	 * 
	 * @param filePath
	 * @param charset
	 *            null��ָ������
	 * @param lineSeparator
	 *            �зָ���FileUtil.separator_*��null�����
	 * @return never null
	 * @throws IOException
	 */
	public static String readAsString(String filePath, Charset charset,
			String lineSeparator) throws IOException {

		List<String> lines = readAsLines(filePath, charset);

		StringBuilder sbd = new StringBuilder();
		for (String line : lines) {
			sbd.append(line);
			if (lineSeparator != null) {
				sbd.append(lineSeparator);
			}
		}
		return sbd.toString();
	}

	/**
	 * 
	 * �����������ж�ȡ���ֽ�����
	 * 
	 * @param is
	 *            ������
	 * @param readLenLimit
	 *            ����ȡ���ȣ�-1��ȡ��󳤶�
	 * @param closeIs
	 *            �Ƿ�ر�������
	 * @return ��ȡ���ֽ�����
	 * @throws IOException
	 */
	public static byte[] readToBytes(InputStream is, int readLenLimit,
			boolean closeIs) throws IOException {

		try {
			if (is == null) {
				throw new NullException("InputStream", "");
			}
			
			
			byte[] total = null;
			byte[] tmp = new byte[10240];
			int len;
			while ((len = is.read(tmp)) != -1) {
				total = DataUtil.byteMerger(total, DataUtil.byteArrCut(tmp, 0, len));
			}

			return total;
		} catch (IOException e) {
			throw new IOException("read inputStream to byte[] failed", e);

		} finally {
			if (closeIs) {
				IOCloseUtil.close(is);
			}
		}
	}

	/**
	 * 
	 * �����������ж�ȡ���ֽ�����
	 * 
	 * @param is
	 *            ������
	 * @param readLenLimit
	 *            ����ȡ����
	 * @param charset
	 *            null��ָ������
	 * @param trimLineSeparator
	 *            �Ƿ�ȥ�����з�
	 * @param closeIs
	 *            �Ƿ�ر�������
	 * @return ��ȡ���ֽ�����
	 * @throws IOException
	 */
	public static String readToString(InputStream is, int readLenLimit,
			Charset charset, boolean trimLineSeparator, boolean closeIs)
			throws IOException {

		try {
			if (is == null) {
				throw new NullException("InputStream", "");
			}

			String data = null;

			if (charset == null) {
				data = new String(readToBytes(is, readLenLimit, closeIs),
						charset);
			} else {
				data = new String(readToBytes(is, readLenLimit, closeIs),
						charset);
			}

			if (trimLineSeparator) {
				data = data.replaceAll(LINE_SEPARATOR_REGEX, "");
			}

			return data;

		} catch (IOException e) {
			throw new IOException("read inputStream to string failed", e);
		}
	}

	/**
	 * �����������ж�ȡ���ַ���
	 * 
	 * @param is
	 *            inputStream
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @param closeIs
	 *            �Ƿ�ر�������
	 * @return
	 * @throws IOException
	 */
	public static List<String> readToLines(InputStream is, Charset charset,
			boolean closeIs) throws IOException {

		try {
			if (is == null) {
				throw new NullException("InputStream", "");
			}

			String[] lines = readToString(is, -1, charset, false, closeIs)
					.split(LINE_SEPARATOR_REGEX);

			return DataUtil.toList(lines);
		} catch (IOException e) {
			throw new IOException("read inputStream to lines failed", e);

		} finally {
			if (closeIs) {
				IOCloseUtil.close(is);
			}
		}
	}

	/**
	 * �����������ж�ȡ���ַ��������ļ�С���ڴ����
	 *
	 * @param is
	 *            inputStream,��ȡ���ֱ�ӹر�
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> readToLines(InputStream is, Charset charset)
			throws IOException {

		InputStreamReader isr = null;
		BufferedReader br = null;

		try {

			if (charset == null) {
				isr = new InputStreamReader(is);
			} else {
				isr = new InputStreamReader(is, charset);
			}

			br = new BufferedReader(isr);

			ArrayList<String> lines = new ArrayList<String>();
			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			return lines;
		} catch (IOException e) {
			throw new IOException("read inputStream to lines failed, charset="
					+ charset, e);

		} finally {
			IOCloseUtil.close(is);
			IOCloseUtil.close(isr);
			IOCloseUtil.close(br);
		}
	}

	/**
	 * ������������д�뵽����������ļ�С���ڴ����
	 * 
	 * @param is
	 * @param closeIs
	 * @param os
	 * @param closeOs
	 * @throws IOException
	 */
	public static void streamCopy(InputStream is, boolean closeIs,
			OutputStream os, boolean closeOs) throws IOException {

		// BufferedInputStream bfis = new BufferedInputStream(is);
		// BufferedOutputStream bfos = new BufferedOutputStream(os);

		byte[] buf = new byte[2048];
		int len = 0;
		try {
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			os.flush();
		} catch (IOException e) {
			throw new IOException("streamCopy(is=>os) failed", e);
		} finally {

			if (closeIs) {
				IOCloseUtil.close(is);
			}
			if (closeOs) {
				IOCloseUtil.close(os);
			}
		}
	}

	/**
	 * �ж��Ƿ�ʹ�õ�ǰ·��pathΪnull��""��"."��"./"��".\"����������ǰ·��
	 * 
	 * @param path
	 *            ·���ַ���
	 * @return
	 */
	public static boolean isOfCurrDir(String path) {
		if (path == null) {
			return true;
		}

		path = new File(path).getParent();
		if (path != null) {
			path = path.replace("\\", "/");
		}

		if (path == null || ".".equals(path) || ("./").equals(path)) {
			return true;
		}

		return false;
	}

	public static final int MAKE_NOTHING = 0;// ������
	public static final int MAKE_FILE = 1;
	public static final int MAKE_DIR = 2;

	/**
	 * �ж��ļ����У��Ƿ����
	 * 
	 * @param filePath
	 * @param make
	 *            ���ļ�������ʱ��0�������κζ�����1�����ļ���2����Ŀ¼
	 * @return �����ڷ���0��NOT_EXIST�����ļ�����1��EXIST_AS_FILE����Ŀ¼����2��EXIST_AS_DIR����
	 *         ����������ʽ���� -1��EXIST_AS_UNKNOWN��
	 * @throws IOException
	 */
	public static int isExists(String filePath, int make) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			if (make != MAKE_NOTHING) {
				file.getParentFile().mkdirs();
			}

			if (make == MAKE_FILE && file.createNewFile()) {
				logger.info("make file[" + file + "]");
				return EXIST_AS_FILE;

			} else if (make == MAKE_DIR && file.mkdirs()) {
				logger.info("make dir[" + file + "]");
				return EXIST_AS_DIR;

			} else {
				return NOT_EXIST;
			}
		} else if (file.isDirectory()) {
			return EXIST_AS_DIR;
		} else if (file.isFile()) {
			return EXIST_AS_FILE;
		} else {
			return EXIST_AS_UNKNOWN;
		}
	}

	/**
	 * �ж��ļ����У��Ƿ����
	 * 
	 * @param filePath
	 * @return �����ڷ���0��NOT_EXIST�����ļ�����1��EXIST_AS_FILE����Ŀ¼����2��EXIST_AS_DIR����
	 *         ����������ʽ���� -1��EXIST_AS_UNKNOWN��
	 * @throws IOException
	 */
	public static int isExists(String filePath) throws IOException {
		return isExists(filePath, MAKE_NOTHING);
	}

	/**
	 * ���file�ĸ�Ŀ¼�Ƿ���ڣ��������򴴽�
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @param ensureExist
	 *            ����丸Ŀ¼�����ڣ��Ƿ��Դ���
	 * @return �����ڷ���0���ļ�����1��Ŀ¼����2������������ʽ����-1
	 * @throws IOException
	 *             ���Դ���Ŀ¼ʧ��
	 */
	public static int isParentDirExist(File filePath, boolean ensureExist)
			throws IOException {

		if (filePath == null) {
			throw new NullException("filePath", "");
		}

		File parentFile = filePath.getParentFile();

		if (parentFile == null) {
			// if parentFile is null, set current directory as parentFile
			parentFile = new File("./");
		}

		if (!parentFile.exists()) {

			if (!ensureExist) {
				return NOT_EXIST;
			}

			boolean isOK = parentFile.mkdirs();
			if (isOK) {
				return EXIST_AS_DIR;
			} else {
				throw new IOException("mkdirs " + parentFile.getPath()
						+ " failed, maybe permission denied");
			}

		} else if (parentFile.isDirectory()) {
			return EXIST_AS_DIR;
		} else if (parentFile.isFile()) {
			return EXIST_AS_FILE;
		} else {
			return EXIST_AS_UNKNOWN;
		}
	}

	// TODO �ļ�����
	/**
	 * @Title: getFileSize
	 * @Description:�ݹ��ȡ�ļ�(��)��С
	 * @param file
	 * @param filter
	 * @return �ļ�/Ŀ¼�����ڣ����ߴ�СΪ0������0
	 */
	public static long getFileSize(File file, FileFilter filter) {
		long size = 0;
		if (file.isDirectory()) {
			File[] flist;
			if (filter == null) {
				flist = file.listFiles();
			} else {
				flist = file.listFiles(filter);
			}

			for (int i = 0; i < flist.length; i++) {
				if (flist[i].isDirectory()) {
					size = size + getFileSize(flist[i], filter);
				} else {
					size = size + flist[i].length();
				}
			}
		} else {
			size = size + file.length();
		}

		return size;
	}

	/**
	 * �ж��ļ�/Ŀ¼�Ƿ�Ϊ�գ������ڣ����ܴ�СΪ0����Ϊ��
	 * 
	 * @param filePath
	 * @param filter
	 * @return
	 */
	public static boolean isEmpty(String filePath, FileFilter filter) {
		File file = new File(filePath);
		return !file.exists() || getFileSize(file, filter) == 0;

	}

	/**
	 * �ݹ鷽���������ļ���������Ŀ¼���ļ�
	 * 
	 * @param srcPath
	 * @param includeFolder
	 * @param addFlag
	 *            ����ļ��б�ʶ��=:�����ļ���ʶ��-:�������磺"=:/abc"; "-:/abc.txt";
	 * @param fileFilter
	 *            null����ӹ�����
	 * @param deep
	 *            Ŀ¼��Σ���0��ʼ����������ʾĿ¼���
	 * @param fileFilter
	 *            �ļ�������
	 * @return
	 */
	public static List<String> getFiles(String srcPath, boolean includeFolder,
			boolean addFlag, int deep, FileFilter fileFilter) {

		if (srcPath == null) {
			throw new NullException("srcPath", "");
		}

		List<String> fileList = new ArrayList<String>();

		String FLAG_FOLDER = "";
		String FLAG_FILE = "";

		if (addFlag) {
			FLAG_FOLDER = "=:";
			FLAG_FILE = "-:";
		}

		if (deep < 0) {
			deep = -2;
		}

		String deepSpace = getDeepSpace(deep);
		String subDeepSpace = getDeepSpace(deep + 1);

		File file = new File(srcPath);
		if (!file.isDirectory()) {
			if (file.isFile()) {
				logger.warn(srcPath + " is a file, igonre traversal");
			} else {
				logger.warn(srcPath
						+ " is not a directory or a file, igonre traversal");
			}

			return fileList;
		} else if (includeFolder) {
			fileList.add(deepSpace + FLAG_FOLDER + file);
		}

		File[] files;
		// ���file����Ŀ¼����null
		if (fileFilter == null) {
			files = file.listFiles();
		} else {
			files = file.listFiles(fileFilter);
		}

		if (files == null) {
			logger.warn("traverse files from [" + srcPath + "] failed:"
					+ "an I/O error occurs, readDenied=" + !file.canRead()
					+ ", ignore this directory");
			return fileList;
		}

		if (files.length > 0) {

			for (File file2 : files) {
				if (file2.isDirectory()) {
					String file3 = file2.getAbsolutePath();

					fileList.addAll(getFiles(file3, includeFolder, addFlag,
							deep + 1, fileFilter));
				} else {
					String file3 = file2.getAbsolutePath();
					fileList.add(subDeepSpace + FLAG_FILE + file3);
				}
			}
		} else {
			logger.info(FLAG_FOLDER + srcPath + ", is empty.");
			return fileList;
		}

		return fileList;
	}

	private static String getDeepSpace(int deep) {
		StringBuilder sbd = new StringBuilder();
		for (int i = 0; i < deep; i++){
			sbd.append("\t");
		};
		return sbd.toString();
	}

	/**
	 * �ݹ鷽����ɾ����Ŀ¼
	 * 
	 * @param srcPath
	 *            Ҫ�������ļ����У���·��
	 * @return
	 */
	public static boolean delEmptyFolders(String srcPath) {
		return delEmptyFolders(srcPath, srcPath);
	}

	/**
	 * �ݹ鷽����ɾ����Ŀ¼
	 * 
	 * @param srcPath
	 *            Ҫ�������ļ����У���·��
	 * @param stopFlag
	 * @return
	 */
	private static boolean delEmptyFolders(String srcPath, String stopFlag) {

		if (srcPath == null) {
			throw new NullException("srcPath", "");
		}

		File file = new File(srcPath);

		if (!file.isDirectory()) {
			if (file.isFile()) {
				logger.warn(srcPath + " is a file, igonre traversal");
			} else {
				logger.warn(srcPath
						+ " is not a directory or a file, igonre traversal");
			}

			return true;
		}

		File[] files;
		// ���file����Ŀ¼����null
		files = file.listFiles();

		if (files == null) {
			logger.warn("traverse files from [" + srcPath + "] failed:"
					+ "an I/O error occurs, readDenied=" + !file.canRead()
					+ ", ignore this directory");
			return true;
		}

		if (files.length > 0) {// �ǿ��ļ���

			for (File file2 : files) {
				if (!file2.isDirectory()) {
					continue;
				}

				if (!delEmptyFolders(file2.getAbsolutePath(), stopFlag)) {
					return false;
				}
			}

			return true;
		} else {

			boolean isDelSuccess = file.delete();
			logger.warn("delete empty dir[" + srcPath + "]"
					+ (isDelSuccess ? "sucess" : "failed"));

			if (stopFlag == null || file.getParent().contains(stopFlag)) {
				return isDelSuccess
						&& delEmptyFolders(file.getParent(), stopFlag);
			} else {
				return isDelSuccess;
			}
		}
	}

	/**
	 * ����ָ��Ŀ¼���ļ������ƣ�ע�⣺���dropExpName=true
	 * ���ļ�û����չ�����ļ���������չ�����֣��к���"."�����ļ����ᱻ�����ȥĩβ"."���������ַ�
	 * 
	 * @param srcPath
	 *            Ҫ�������ļ�����·����
	 * @param srcPath
	 *            �Ƿ�ȥ����չ��
	 * @param fileFlag
	 *            �ļ�·�������ַ�
	 * @param strFilter
	 *            �������ַ�������չ�����ļ�����·���а������ַ���
	 * @return
	 */
	public static TreeSet<String> getFileNames(String srcPath,
			boolean dropExpName, String fileFlag, FileFilter fileFilter) {

		if (srcPath == null) {
			throw new NullException("srcPath", "");
		}

		// ��ȡ�ļ��������ļ��У�
		List<String> filePaths = getFiles(srcPath, false, false, -1, fileFilter);

		TreeSet<String> fileNames = new TreeSet<String>();

		// ��ȡ�ļ���
		for (String file : filePaths) {
			if (fileFlag == null || file.contains(fileFlag)) {
				fileNames.add(new File(file).getName());
			}
		}

		if (dropExpName) {
			TreeSet<String> fileNames1 = new TreeSet<String>();
			int index;
			for (String file : fileNames) {
				// ע�⣺����ļ�û����չ�����ļ���������չ�����֣��к���"."��
				// ���ļ����ᱻ�����ȥ"."���������ַ�
				index = file.lastIndexOf(".");
				if (index > 0) {
					file = file.substring(0, index);
				}
				fileNames1.add(file);
			}

			return fileNames1;
		} else {
			return fileNames;
		}
	}

	/**
	 * �ļ��ƶ�
	 * 
	 * @param srcFileName
	 *            ����·�����ļ���
	 * @param destFileName
	 *            ����·�����ļ��� null��ʹ��srcFileName
	 * @param srcDir
	 *            null��ʹ�õ�ǰ�ļ���
	 * @param destDir
	 *            null��ʹ�õ�ǰ�ļ���
	 * @param mkdir
	 *            �Ƿ񴴽�Ŀ��·���ļ��У���������ڣ�
	 * @return �Ƿ��ƶ��ɹ�
	 * @throws IOException
	 */
	public static boolean moveFile(String srcFileName, String destFileName,
			String srcDir, String destDir, boolean mkdir, boolean overwrite)
			throws IOException {

		if (DataUtil.isEmpty(srcFileName, true)) {
			throw new NullOrEmptyException("srcFileName", srcFileName, null);
		}

		destFileName = DataUtil.isEmpty(destFileName, true) ? srcFileName
				: destFileName;

		srcDir = DataUtil.isEmpty(srcDir, true) ? "" : srcDir + "/";
		destDir = DataUtil.isEmpty(destDir, true) ? "" : destDir + "/";

		String srcFilePath = srcDir + srcFileName;
		String destFilePath = destDir + destFileName;

		try {
			File srcFile = new File(srcFilePath);
			File destFile = new File(destFilePath);

			if (srcFile.exists()) {

				int dirStatus = isParentDirExist(destFile, mkdir);

				if (dirStatus == EXIST_AS_DIR) {

					if (!overwrite && destFile.exists()) {
						throw new IOException("destFile[" + destFile
								+ "] exists");

					} else if (destFile.exists() && !destFile.delete()) {
						throw new IOException("delete destFile[" + destFile
								+ "] failed");
					}

					return srcFile.renameTo(destFile);// �ļ��ſ����ƶ�

				} else if (dirStatus == NOT_EXIST) {
					throw new IOException("destDir not exist");
				} else {
					throw new IOException("destDir exists as not a directory");
				}

			} else {
				throw new IOException("file not found");
			}
		} catch (IOException e) {
			throw new IOException("move file[" + srcFileName + "] from srcDir["
					+ srcDir + "] to destDir[" + destDir + "] named["
					+ destFileName + "] failed", e);
		}
	}

	/**
	 * �ļ��ƶ�
	 * 
	 * @param srcFilePath
	 *            Դ�ļ�·��
	 * @param destDir
	 *            null��ʹ�õ�ǰ�ļ���
	 * @param mkdir
	 *            �Ƿ񴴽�Ŀ��·���ļ��У���������ڣ�
	 * @return �Ƿ��ƶ��ɹ�
	 * @throws IOException
	 */
	public static boolean moveFile(String srcFilePath, String destDir,
			boolean mkdir, boolean overwrite) throws IOException {

		File srcFile = new File(srcFilePath);

		return moveFile(srcFile.getName(), null, srcFile.getParent(), destDir,
				mkdir, overwrite);
	}
}
