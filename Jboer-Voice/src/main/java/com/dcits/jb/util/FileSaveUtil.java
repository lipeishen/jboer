package com.dcits.jb.util;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.core.util.UuidUtil;
import com.dcits.jb.env.FileDealEnv;

import net.sf.json.JSONObject;

/**
 * @author xingyxa
 * @date 创建时间：2016年3月2日 上午11:34:25
 * @version 1.0
 * @since 1.8
 */
public class FileSaveUtil {
	private final static String OPENPREPATHALLOW = ",manager,consult,jyweb,";

	/**
	 * 上传其他文件
	 * 
	 * @author xingyxa
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String uploadFile(HttpServletRequest request) throws IllegalStateException, IOException {
		boolean flag = false;
		Map<String, Object> result = new HashMap<String, Object>();

		String prePath = request.getParameter("prePath");
		if (StringUtil.getNullStr(prePath).equals("") || StringUtil.getNullStr(prePath).equals("null")) {
			result.put("state", "false");
			result.put("msg", "文件存放前置路径不可为空！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		String filePath = FileDealEnv.getFileVoicePath();
		String path = "";
		String suffix = "";
		// 当前上传文件的文件名称
		String myFileName = "";
		// 文件大小
		long size = 0;
		// 重命名上传后的文件名
		String fileName = "";
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null && !file.isEmpty()) {
					// 取得当前上传文件的文件名称
					myFileName = file.getOriginalFilename();
					// 获取文件后缀
					suffix = FileType.getSuffixByFilename(myFileName);
					// 判断是否是图片
					CommonsMultipartFile cf = (CommonsMultipartFile) file;
					// 获取文件大小
					size = file.getSize();
					if (size > 20240000) {
						result.put("state", "false");
						result.put("msg", "文件过大！");
						JSONObject jo = JSONObject.fromObject(result);
						return jo.toString();
					}
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						fileName = UuidUtil.get32Uuid() + suffix;
						// 从配置文件获得上传路径
						path = filePath + "/" + prePath + "/" + fileName;
						File localFile = new File(path);
						if (localFile.exists()) { // 如果一级文件夹存在，则检测二级文件夹
							localFile = new File(path);
						} else { // 如果一级不存在，则创建一级文件夹
							localFile.mkdirs();
							localFile = new File(path);
						}
						file.transferTo(localFile);
						flag = true;
					}
				} else {
					result.put("state", "false");
					result.put("msg", "上传失败：文件为空！");
					JSONObject jo = JSONObject.fromObject(result);
					return jo.toString();
				}
			}
		}

		if (flag) {
			result.put("state", "SUCCESS");
			result.put("msg", "操作成功！");
			result.put("url", prePath + "/" + fileName); // 文件保存路径
			result.put("original", myFileName);// 取得当前上传文件的文件名称
			result.put("size", "");
			result.put("type", suffix); // 文件后缀，如.jpg
			result.put("title", fileName); // 保存后的文件名称
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
		result.put("state", "false");
		result.put("msg", "上传失败！");
		JSONObject jo = JSONObject.fromObject(result);
		return jo.toString();
	}

	/**
	 * 上传其他文件 不对文件重命名
	 * 
	 * @author ljf
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String uploadFileByOldName(HttpServletRequest request) throws IllegalStateException, IOException {
		boolean flag = false;
		Map<String, Object> result = new HashMap<String, Object>();

		String prePath = request.getParameter("prePath");
		if (StringUtil.getNullStr(prePath).equals("") || StringUtil.getNullStr(prePath).equals("null")) {
			result.put("state", "false");
			result.put("msg", "文件存放前置路径不可为空！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		String filePath = FileDealEnv.getFileVoicePath();
		String path = "";
		String suffix = "";
		// 当前上传文件的文件名称
		String myFileName = "";
		// 文件大小
		long size = 0;
		// 重命名上传后的文件名
		String fileName = "";
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null && !file.isEmpty()) {
					// 取得当前上传文件的文件名称
					myFileName = file.getOriginalFilename();
					// 获取文件后缀
					suffix = FileType.getSuffixByFilename(myFileName);
					// 判断是否是图片
					CommonsMultipartFile cf = (CommonsMultipartFile) file;
					// 获取文件大小
					size = file.getSize();
					if (size > 20240000) {
						result.put("state", "false");
						result.put("msg", "文件过大！");
						JSONObject jo = JSONObject.fromObject(result);
						return jo.toString();
					}
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						// fileName = UuidUtil.get32Uuid() + suffix;
						// 从配置文件获得上传路径
						path = filePath + "/" + prePath + "/" + myFileName;
						File localFile = new File(path);
						if (localFile.exists()) { // 如果一级文件夹存在，则检测二级文件夹
							localFile = new File(path);
						} else { // 如果一级不存在，则创建一级文件夹
							localFile.mkdirs();
							localFile = new File(path);
						}
						file.transferTo(localFile);
						flag = true;
					}
				} else {
					result.put("state", "false");
					result.put("msg", "上传失败：文件为空！");
					JSONObject jo = JSONObject.fromObject(result);
					return jo.toString();
				}
			}
		}

		if (flag) {
			result.put("state", "SUCCESS");
			result.put("msg", "操作成功！");
			result.put("url", prePath + "/" + fileName); // 文件保存路径
			result.put("original", myFileName);// 取得当前上传文件的文件名称
			result.put("size", "");
			result.put("type", suffix); // 文件后缀，如.jpg
			result.put("title", fileName); // 保存后的文件名称
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
		result.put("state", "false");
		result.put("msg", "上传失败！");
		JSONObject jo = JSONObject.fromObject(result);
		return jo.toString();
	}

}
