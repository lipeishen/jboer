package com.dcits.djk.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dcits.djk.env.FileDealEnv;

/**
 * @author xingyxa
 * @date 创建时间：2016年3月7日 下午4:11:25
 * @version 1.0
 * @since 1.8
 */
@Controller
@RequestMapping("/downFile")
public class DownFileController {
	
	private Logger logger = Logger.getLogger(DownFileController.class);
	/**
	 * 下载功能
	 * 
	 * @author xingyxa
	 * @param request
	 * @return
	 */
	@RequestMapping("/downFile")
	// @ResponseBody
	public void downFile(HttpServletRequest request, HttpServletResponse response) {
		String fileName = request.getParameter("filename");
		String path = request.getParameter("filePath");
		String prePath = FileDealEnv.getFileVoicePath();
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
			response.reset();
			// response.setContentType("application/vnd.ms-excel");
			// 设置响应头，控制浏览器下载该文件
			// 第一个值项是attachment，设定了这个值，浏览器就会显示另存为对话框，如果设成inline，则无论怎样浏览器都会自动打开文件
			if (request.getHeader("User-Agent").contains("Firefox")) {
				response.addHeader("content-disposition", "attachment;filename=" + request.getParameter("fileName"));
			} else if (request.getHeader("User-Agent").contains("MSIE")) {
				response.addHeader("content-disposition",
						"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
			} else {
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			}
			response.addHeader("Cache-Control", "no-cache");
			// 读取要下载的文件，保存到文件输入流
			inputStream = new FileInputStream(prePath + "/" + path + "/" + fileName);
			outStream = response.getOutputStream();
			byte[] buffer = new byte[512];
			int index = -1;
			while ((index = inputStream.read(buffer, 0, buffer.length)) > -1) {
				outStream.write(buffer, 0, index);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e,e);
		} catch (FileNotFoundException e) {
			logger.error(e,e);
		} catch (IOException e) {
			logger.error(e,e);
		} finally {
			try {
				if (outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				logger.error(e,e);
			}
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error(e,e);
			}
		}
	}


	/**
	 * 下载远程文件并保存到本地
	 * 
	 * @param remoteFilePath
	 *            远程文件路径
	 * @param localFilePath
	 *            本地文件路径
	 */
	public void downloadFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			// bis.close();
			// httpUrl.disconnect();
		} catch (Exception e) {
			logger.error(e,e);
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				logger.error(e,e);
			}
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				logger.error(e,e);
			}
			try {
				if (httpUrl != null) {
					httpUrl.disconnect();
				}
			} catch (Exception e) {
				logger.error(e,e);
			}
		}
	}

}
