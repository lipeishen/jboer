package com.dcits.jb.manager.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.jb.manager.util.FileSaveUtil;

import net.sf.json.JSONObject;

/**
 * @author xingyxa
 * @date 创建时间：2016年2月22日 上午10:40:13
 * @version 1.0
 * @since 1.8
 */
@Controller
@RequestMapping("/file")
public class FileController {
	private Logger logger = Logger.getLogger(FileController.class);

	/**
	 * 图片用流解析
	 * 
	 * @author xingyxa
	 * @2016年2月22日10:45:19
	 * 
	 */
	@RequestMapping("/showPic")
	public void showPic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String imgFileUrl = request.getParameter("ppath");
		if (!imgFileUrl.equals("") && !imgFileUrl.equals("/")) {
			this.getImagFileInputStream(imgFileUrl, response);
		}

	}

	/**
	 * 设置流
	 * 
	 * @param imgFileUrl
	 * @param response
	 */
	public void getImagFileInputStream(String imgFileUrl, HttpServletResponse response) {
		if (!imgFileUrl.equals("") && !imgFileUrl.equals("/")) {
			FileInputStream hFile = null;
			OutputStream toClient = null;
			try {
				hFile = new FileInputStream(imgFileUrl); // 以byte流的方式打开文件
																			// d:\1.gif
				int i = hFile.available(); // 得到文件大小
				byte data[] = new byte[i];
				hFile.read(data); // 读数据
				response.setContentType("image/*"); // 设置返回的文件类型
				toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
				toClient.write(data); // 输出数据
				toClient.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}finally{
				try{
					if (hFile!= null){
						hFile.close();
					}				
				}catch (IOException e){
					logger.error(e,e);
				}
				try{
					if (toClient!= null){
						toClient.close();
					}				
				}catch (IOException e){
					logger.error(e,e);
				}
			}
		} else {
			return;
		}
	}
	
	// 保存字符串到文件中
	@RequestMapping("/saveAsFile")
	@ResponseBody
	public String saveAsFileWriter(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		String content = request.getParameter("context");
		try {
			FileSaveUtil.saveHtml("02",content,"123.html");
		} catch (Exception e) {
			logger.error(e,e);
		}
		result.put("success", "true");
		JSONObject jo = JSONObject.fromObject(result);
		return jo.toString();
	}

	@RequestMapping("file/download")
    public void fileDownload(HttpServletRequest request,HttpServletResponse response){
        //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
        String path = request.getParameter("localPath");

        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
        response.setHeader("Content-Disposition", "attachment;fileName="+"a.pdf");
        ServletOutputStream out = null;
        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)
        File file = new File(path + "download/" + "download.pdf");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);

            //3.通过response获取ServletOutputStream对象(out)
            out = response.getOutputStream();

            int b = 0;
            byte[] buffer = new byte[512];
            while (b != -1){
                b = inputStream.read(buffer);
                //4.写到输出流(out)中
                out.write(buffer,0,b);
            }
            out.flush();

        } catch (IOException e) {
            logger.error(e,e);
        }finally {
			try {
				if(inputStream != null){
					inputStream.close();
				}
			} catch (Exception e) {
				logger.error(e,e);
			}
			try {
				if(out != null){
					out.close();
				}
			} catch (Exception e) {
				logger.error(e,e);
			}
		}
    }

}
