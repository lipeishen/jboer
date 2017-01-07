package com.dcits.jb.manager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.dcits.jb.manager.env.FileuploadEnv;

/** 
  * @author  xingyxa 
  * @date 创建时间：2016年3月10日 下午2:40:13 
  * @version 1.0 
  * @since  1.8 
*/
public class PublishFileUtil {
	public static void main(String args[]) throws IOException {
//		String oldPath = "D:/upload/doctor/1812e2c8be0549b1b3cff65d053bef35.html";
		/*String newPath = "D:/upload/test";
		copyFile(oldPath, newPath,"test125.html");*/
//		String oldPath = "<!DOCTYPE HTML><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>模板Html</title></head><body>模板Html<br/>${content}</body></html>";
//		File oldfile = new File(oldPath);
//		SftpUtil.uploadFile(oldfile, FileuploadEnv.getSftpPath());
//		int num1 = "12loi测试were彩色发".indexOf("${content}");
		
//		StringBuffer sBuffer = new StringBuffer();
//		sBuffer.append("<p>").append("<img width='300' src='http://172.16.200.35/img/image/showPic.do?ppath=/html/cf942be14d0f4862ba1bdcf53dd58472.jpg' title='1457774822026029496.jpg' alt='00293dc6d91a4823a1cc273135662ae9.jpg'/>");
//		sBuffer.append("</p>");
//		sBuffer.append("<p>");
//		sBuffer.append("<img width='300' src='http://172.16.200.35/img/image/showPic.do?ppath=/html/ffd220eee8804039a0f490bfb907b36d.jpg' title='1457775373554006015.jpg' alt='755d66d5eee34bcc967f38a8b50d5f82.jpg'/><img width='300' src='http://172.16.200.35/img/image/showPic.do?ppath=/html/61015eb877434b84a65a64274fc39668.jpg' title='1457775380781090899.jpg' alt='86717a7393cd41d3900b1aa136e20bbd.jpg'/>");
//		sBuffer.append("</p>");
//		System.out.println(replaceImgUrl(sBuffer.toString()));

	}
	/**
	 * 复制单个文件
	 * @author xingyxa
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static void copyFile(String oldPath, String newPath,String newName) {
		InputStream inStream=null;
		FileOutputStream fs=null;
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				File newFile = new File(newPath);
				if (!newFile.exists()) { 
					newFile.mkdirs();// 如果一级不存在，则创建一级文件夹
					System.out.println("mkdirs现在路径---->"+newPath);
				}
				 inStream = new FileInputStream(oldPath); // 读入原文件
				 fs = new FileOutputStream(newPath+"/"+newName);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				
			}else{
				System.out.println("文件不存在");
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}finally {
			try {
				if (inStream!=null) {
					inStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (fs!=null) {
					fs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * 将文档中的图片的路径替换为域名路径
	 * @author  xingyxa 
	 * @param content
	 * @return 替换路径后的内容
	 */
	public static String replaceImgUrl(String content){
		//获取访问图片的域名URL
		String imgPublishShowUrl = FileuploadEnv.getImgPublishShowUrl();
		//获取访问图片的内网URL
		String imgShowUrl = FileuploadEnv.getImgShowUrl();
		//查找内容中是否包括内网URL
		int indexNum = content.indexOf(imgShowUrl);
		if (indexNum != -1) {
			//替换内容，组合新的内容
			content = content.replace(imgShowUrl, imgPublishShowUrl);
		}
		return content;
	}
}
