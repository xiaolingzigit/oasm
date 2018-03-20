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

	// /r 回车 Carriage Return, /n 新行 New Line ,都会造成换行
	// 获取系统换行符：System.getProperty("line.separator")
	// 各系统应当是: /r Mac /n Unix/Linux /r/n Windows
	public static final String SEPARATOR_LINE_LINUX_UNIX = "\n";
	public static final String SEPARATOR_LINE_MAC = "\r";
	public static final String SEPARATOR_LINE_WIN = "\r\n";
	/** 半角分号 */
	public static final String SEPARATOR_ELE_SEMICOLON = ";";
	/** 半角逗号 */
	public static final String SEPARATOR_ELE_COMMA = ",";
	/** 竖线 */
	public static final String SEPARATOR_VERTICAL_LINE = "|";

	public static final String LINE_SEPARATOR_REGEX = "^" + SEPARATOR_LINE_WIN
			+ "|" + SEPARATOR_LINE_LINUX_UNIX + "|" + SEPARATOR_LINE_MAC + "$";// 换行符正则表达式

	public static final String KEY_VAL_CONNECTOR = "=";

	public static final int NOT_EXIST = 0;
	public static final int EXIST_AS_FILE = 1;
	public static final int EXIST_AS_DIR = 2;
	public static final int EXIST_AS_UNKNOWN = -1;

	// TODO FLAG WRITE

	/**
	 * 写文件,如需要换行符自行添加( Mac:\r,Unix/Linux: \n ,Windows: \r\n )
	 * 
	 * @param filePath
	 * @param content
	 * @param charset
	 *            null则不指定字符编码
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

			fos = new FileOutputStream(filePath, append); // 追加用true

			if (charset == null) {
				fos.write(content.getBytes());
				// osw = new OutputStreamWriter(fos);
			} else {
				fos.write(content.getBytes(charset));// 转换对应的字符集
				// osw = new OutputStreamWriter(fos, charset);
				// osw.write(content);
			}

			// 另外的方法:
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
	 * 将输入流的内容按字节写入到文件，适用于网络下载多媒体资源的保存等
	 * 
	 * @param filePath
	 *            保存的文件路径
	 * @param is
	 *            内容输入流
	 * @param append
	 *            是否追加
	 * @param colseIS
	 *            是否关闭输入流
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
	 * 写文件
	 * 
	 * @param destFile
	 * @param lines
	 *            要写入的行内容
	 * @param eleSeparator
	 *            元素分隔符FileUtil.separator_*，null则不添加元素分隔符
	 * @param charset
	 *            null则不指定编码
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
	 * 写文件
	 * 
	 * @param destFile
	 * @param lines
	 *            要写入的行内容
	 * @param eleSeparator
	 *            元素分隔符FileUtil.separator_*，null则不添加元素分隔符
	 * @param charset
	 *            null则不指定编码
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
	 * 写文件
	 * 
	 * @param destFile
	 * @param lines
	 *            要写入的行内容
	 * @param keyValConnector
	 *            键值对连接符，null则默认使用“=”
	 * @param eleSeparator
	 *            元素分隔符FileUtil.separator_*，null则不添加元素分隔符
	 * @param charset
	 *            null则不指定编码
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
	 * 将文件按字节读取到输出流
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
	 * 获取文件输入流
	 * 
	 * @param filePath
	 * @param inSrc
	 *            文件是否在包内
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
	 * 读取文件指定的行
	 * 
	 * @param filePath
	 * @param charset
	 * @param lineStart
	 *            起始行,从1开始（含）
	 * @param lineEnd
	 *            结束行（含）
	 * @param fix
	 *            当指定行数大于实际行数时，是否修正读取的最大行数为文件实际最大行数，否则抛异常
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
	 * 读取文件
	 * 
	 * @param filePath
	 * @param charset
	 *            null则不指定编码
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
			// 读取方式1
			// fr = new FileReader(file);

			// 读取方式2
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
	 * 读取文件
	 * 
	 * @param filePath
	 * @param charset
	 *            null则不指定编码
	 * @param lineSeparator
	 *            行分隔符FileUtil.separator_*，null则不添加
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
	 * 将输入流按行读取成字节数组
	 * 
	 * @param is
	 *            输入流
	 * @param readLenLimit
	 *            最大读取长度，-1读取最大长度
	 * @param closeIs
	 *            是否关闭输入流
	 * @return 读取的字节数组
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
	 * 将输入流按行读取成字节数组
	 * 
	 * @param is
	 *            输入流
	 * @param readLenLimit
	 *            最大读取长度
	 * @param charset
	 *            null则不指定编码
	 * @param trimLineSeparator
	 *            是否去除换行符
	 * @param closeIs
	 *            是否关闭输入流
	 * @return 读取的字节数组
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
	 * 将输入流按行读取成字符串
	 * 
	 * @param is
	 *            inputStream
	 * @param charset
	 *            null则使用环境默认编码
	 * @param closeIs
	 *            是否关闭输入流
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
	 * 将输入流按行读取成字符串，大文件小心内存溢出
	 *
	 * @param is
	 *            inputStream,读取完毕直接关闭
	 * @param charset
	 *            null则使用环境默认编码
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
	 * 把输入流数据写入到输出流，大文件小心内存溢出
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
	 * 判断是否使用当前路径path为null、""、"."、"./"、".\"均被视作当前路径
	 * 
	 * @param path
	 *            路径字符串
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

	public static final int MAKE_NOTHING = 0;// 不创建
	public static final int MAKE_FILE = 1;
	public static final int MAKE_DIR = 2;

	/**
	 * 判断文件（夹）是否存在
	 * 
	 * @param filePath
	 * @param make
	 *            当文件不存在时，0不创建任何东西，1创建文件，2创建目录
	 * @return 不存在返回0（NOT_EXIST），文件返回1（EXIST_AS_FILE），目录返回2（EXIST_AS_DIR），
	 *         存在其他形式返回 -1（EXIST_AS_UNKNOWN）
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
	 * 判断文件（夹）是否存在
	 * 
	 * @param filePath
	 * @return 不存在返回0（NOT_EXIST），文件返回1（EXIST_AS_FILE），目录返回2（EXIST_AS_DIR），
	 *         存在其他形式返回 -1（EXIST_AS_UNKNOWN）
	 * @throws IOException
	 */
	public static int isExists(String filePath) throws IOException {
		return isExists(filePath, MAKE_NOTHING);
	}

	/**
	 * 检查file的父目录是否存在，不存在则创建
	 * 
	 * @param filePath
	 *            文件路径
	 * @param ensureExist
	 *            如果其父目录不存在，是否尝试创建
	 * @return 不存在返回0，文件返回1，目录返回2，存在其他形式返回-1
	 * @throws IOException
	 *             尝试创建目录失败
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

	// TODO 文件遍历
	/**
	 * @Title: getFileSize
	 * @Description:递归获取文件(夹)大小
	 * @param file
	 * @param filter
	 * @return 文件/目录不存在，或者大小为0均返回0
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
	 * 判断文件/目录是否为空，不存在，或总大小为0均视为空
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
	 * 递归方法，遍历文件夹下所有目录和文件
	 * 
	 * @param srcPath
	 * @param includeFolder
	 * @param addFlag
	 *            添加文件夹标识（=:），文件标识（-:），例如："=:/abc"; "-:/abc.txt";
	 * @param fileFilter
	 *            null则不添加过滤器
	 * @param deep
	 *            目录层次，从0开始，负数不显示目录层次
	 * @param fileFilter
	 *            文件过滤器
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
		// 如果file不是目录返回null
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
	 * 递归方法，删除空目录
	 * 
	 * @param srcPath
	 *            要遍历的文件（夹）根路径
	 * @return
	 */
	public static boolean delEmptyFolders(String srcPath) {
		return delEmptyFolders(srcPath, srcPath);
	}

	/**
	 * 递归方法，删除空目录
	 * 
	 * @param srcPath
	 *            要遍历的文件（夹）根路径
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
		// 如果file不是目录返回null
		files = file.listFiles();

		if (files == null) {
			logger.warn("traverse files from [" + srcPath + "] failed:"
					+ "an I/O error occurs, readDenied=" + !file.canRead()
					+ ", ignore this directory");
			return true;
		}

		if (files.length > 0) {// 非空文件夹

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
	 * 遍历指定目录下文件的名称，注意：如果dropExpName=true
	 * 而文件没有扩展名且文件名（非扩展名部分）中含有"."，则文件名会被误处理截去末尾"."及其后面的字符
	 * 
	 * @param srcPath
	 *            要遍历的文件（夹路径）
	 * @param srcPath
	 *            是否去除拓展名
	 * @param fileFlag
	 *            文件路径包含字符
	 * @param strFilter
	 *            过滤性字符，如拓展名，文件名或路径中包含的字符等
	 * @return
	 */
	public static TreeSet<String> getFileNames(String srcPath,
			boolean dropExpName, String fileFlag, FileFilter fileFilter) {

		if (srcPath == null) {
			throw new NullException("srcPath", "");
		}

		// 获取文件（不含文件夹）
		List<String> filePaths = getFiles(srcPath, false, false, -1, fileFilter);

		TreeSet<String> fileNames = new TreeSet<String>();

		// 获取文件名
		for (String file : filePaths) {
			if (fileFlag == null || file.contains(fileFlag)) {
				fileNames.add(new File(file).getName());
			}
		}

		if (dropExpName) {
			TreeSet<String> fileNames1 = new TreeSet<String>();
			int index;
			for (String file : fileNames) {
				// 注意：如果文件没有扩展名且文件名（非扩展名部分）中含有"."，
				// 则文件名会被误处理截去"."及其后面的字符
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
	 * 文件移动
	 * 
	 * @param srcFileName
	 *            不含路径的文件名
	 * @param destFileName
	 *            不含路径的文件名 null则使用srcFileName
	 * @param srcDir
	 *            null则使用当前文件夹
	 * @param destDir
	 *            null则使用当前文件夹
	 * @param mkdir
	 *            是否创建目标路径文件夹（如果不存在）
	 * @return 是否移动成功
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

					return srcFile.renameTo(destFile);// 文件才可以移动

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
	 * 文件移动
	 * 
	 * @param srcFilePath
	 *            源文件路径
	 * @param destDir
	 *            null则使用当前文件夹
	 * @param mkdir
	 *            是否创建目标路径文件夹（如果不存在）
	 * @return 是否移动成功
	 * @throws IOException
	 */
	public static boolean moveFile(String srcFilePath, String destDir,
			boolean mkdir, boolean overwrite) throws IOException {

		File srcFile = new File(srcFilePath);

		return moveFile(srcFile.getName(), null, srcFile.getParent(), destDir,
				mkdir, overwrite);
	}
}
