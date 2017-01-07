package com.dcits.jb.manager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.manager.env.FileuploadEnv;

/**
 * @author xingyxa
 * @date 创建时间：2016年3月2日 上午11:34:25
 * @version 1.0
 * @since 1.8
 */
public class FileSaveUtil {
	/**
	 * 根据参数生成html文件
	 * 
	 * @author xingyxa
	 * @param type
	 *            类型，01 保存文件全部内容，包含头和尾，02 代表只保存body中间的内容，不含<body>和</body>
	 * @param content
	 *            html文件中的全部内容
	 * @param htmlName
	 *            html文件的名称，包含.html
	 * @return html存放的完整路径
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String saveHtml(String type, String content, String htmlName) {
		OutputStreamWriter out1 = null;
		FileOutputStream fs=null;
		try{
			String preHtml = "<!DOCTYPE HTML><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>栏目文章内容</title>"
					+ "</head><body>";
			String aftHtml = "</body></html>";
			String filePath = FileuploadEnv.getFileHtmlPath();
			String fullFilePath = filePath + "/" + htmlName;
			// 找到文件名称
			int nameNum = fullFilePath.lastIndexOf("/");
			filePath = fullFilePath.substring(nameNum + 1);
			String CharsetName = "UTF-8";
			System.out.println("路径---->" + filePath);
			File file2 = new File(filePath);
			if (file2.exists()) { // 如果一级文件夹存在，则检测二级文件夹
				System.out.println("现在路径---->" + fullFilePath);
				file2 = new File(fullFilePath);
			} else { // 如果一级不存在，则创建一级文件夹
				file2.mkdirs();
				System.out.println("mkdirs现在路径---->" + fullFilePath);
				file2 = new File(fullFilePath);
			}
			// 创建FileOutputStream对应OutputStreamWriter：将字节流转换为字符流，即写入out1的数据会自动由字节转换为字符。
			fs = new FileOutputStream(fullFilePath);
			out1 = new OutputStreamWriter(fs, CharsetName);
			// 写入内容
			out1.write(preHtml + content + aftHtml);
		}catch(Exception exception){
			exception.printStackTrace();
		}finally {
			try{
				if(out1 != null){
					out1.close();
				}
			}catch(Exception exception2){
				exception2.printStackTrace();
			}
			try{
				if(fs != null){
					fs.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return htmlName;
	}

	/**
	 * 
	 * @author xingyxa
	 * @param type
	 *            类型，01 传过来的内容为文件全部内容，包含头和尾，02 代表只保存body中间的内容，不含<body>和</body>
	 * @param content
	 *            html文件中的全部内容
	 * @param htmlName
	 *            html文件的名称，包含.html
	 * @param newPrePath
	 *            文件存放路径
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String saveHtml(String type, String content, String htmlName, String newPrePath){
		String preHtml = "<!DOCTYPE HTML>"
				+ "<html>"
				+ "<head>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
				+ "<title>栏目文章内容</title>"
				+ "</head><body>";
		String aftHtml = "</body></html>";
		String fullFilePath = htmlName;
		if (!StringUtil.getNullStr(newPrePath).equals("")) {
			fullFilePath = newPrePath + "/" + htmlName;
		}
		String CharsetName = "UTF-8";
		System.out.println("路径---->" + newPrePath);
		OutputStreamWriter out1=null;
		FileOutputStream fs= null;
		try{
			File file2 = new File(newPrePath);
			if (file2.exists()) { // 如果一级文件夹存在，则检测二级文件夹
				System.out.println("现在路径---->" + fullFilePath);
				file2 = new File(fullFilePath);
			} else { // 如果一级不存在，则创建一级文件夹
				file2.mkdirs();
				System.out.println("mkdirs现在路径---->" + fullFilePath);
				file2 = new File(fullFilePath);
			}
			// 创建FileOutputStream对应OutputStreamWriter：将字节流转换为字符流，即写入out1的数据会自动由字节转换为字符。
			 fs = new FileOutputStream(fullFilePath);
			 out1 = new OutputStreamWriter(fs, CharsetName);
			// 写入内容
			if (type.equals("01")) {
				out1.write(content);
			}else if (type.equals("02")) {
				out1.write(preHtml + content + aftHtml);
			}else {
				htmlName = "";
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(out1!=null){
					out1.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if(fs!=null){
					fs.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return htmlName;
	}

	/**
	 * 根据参数返回html文件的对应的内容
	 * 
	 * @author xingyxa
	 * @param fileNamePath
	 *            html文件的名称，包含.html后缀
	 * @param type
	 *            类型，01 获取文件全部内容，包含头和尾，02 代表获取body中间的内容，不含<body>和</body>
	 * @return 对应的内容
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String showHtml(String fileNamePath, String type) throws IOException, FileNotFoundException {
		InputStreamReader isr = null;
		FileInputStream fs=null;
		String rerurnStr = "";
		try{
			System.out.println("完整路径：" + fileNamePath);
			fs= new FileInputStream(fileNamePath);
			isr = new InputStreamReader(fs, "UTF-8");
			BufferedReader read = new BufferedReader(isr);
			StringBuffer readStr = new StringBuffer();
			String line = null;  
			String newline = System.getProperty("line.separator");
	        while((line = read.readLine())!=null){  
	            readStr.append(line+newline);
	        }  
			if (type.equals("01")) {
				rerurnStr = readStr.toString();
			} else if (type.equals("02")) {
				int bnum1 = readStr.indexOf("<body>");
				int bnum2 = readStr.lastIndexOf("</body>");
				if (bnum1 != -1 && bnum2 != -1) {
					String bodyContent = readStr.substring(bnum1 + 6, bnum2);
					rerurnStr = bodyContent;
				} else {

				}
			}
			System.out.println(rerurnStr);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(isr != null){
					isr.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(fs != null){
					fs.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return rerurnStr;
	}

	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @author xingyxa
	 * @param sPath
	 *            要删除的目录或文件
	 * @return删除成功返回 true，否则返回 false。
	 */
	public static boolean DeleteFolder(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} /*
				 * else { // 为目录时调用删除目录方法 return deleteDirectory(sPath); }
				 */
			else {
				return flag;
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @author xingyxa
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @author xingyxa
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {
		boolean flag = false;
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// 生成html示例
		/*String content = "<h>标题</h><p>1.测试</p>";
		String value = "";
		try {
			String proPath = FileuploadEnv.getFileHtmlPath();
			value = saveHtml("02", content, "123.html", proPath);
		} catch (FileNotFoundException e) {
			// 系统找不到指定的文件
			e.printStackTrace();
		} catch (IOException e) {
			// 文件异常
			e.printStackTrace();
		}
		System.out.println("返回路径：" + value);*/
		// 获取html的body的内容。
//		
//		  try { 
//			  //获取html的body的内容。
//			  String str2 =
//			  showHtml("D:/upload/service-jkzx.html","01");
//			  System.out.println(str2); 
//		  } catch (FileNotFoundException e) { 
//			  //系统找不到指定的文件 e.printStackTrace(); 
//		  }catch (IOException e) { // 文件异常
//			  e.printStackTrace(); 
//		  }
		 
	}
}
