package com.dcits.jb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.jb.util.FileSaveUtil;

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
	public String[] SseEmitter = {"",""};
    /**
	 * 文件上传
	 * @author  xingyxa 
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
    @RequestMapping(path="/uploadFile", method=RequestMethod.POST,produces = "application/json;charset=utf-8")  
    @ResponseBody
    //@CrossOrigin("*") //可跨域访问
    public String uploadFile(HttpServletRequest request) {  
    	String reResult = "";
		try {
			reResult = FileSaveUtil.uploadFile(request);
		} catch (IllegalStateException e) {
			logger.error(e,e);
		} catch (IOException e) {
			logger.error(e,e);
		} catch (Exception e) {
			logger.error(e,e);
		}
    	return reResult;
    } 
    /**
 	 * 文件上传 不改变文件名
 	 * @author  ljf
 	 * @param request
 	 * @return
 	 * @throws IllegalStateException
 	 * @throws IOException
 	 */
     @RequestMapping(path="/uploadFileByOldName", method=RequestMethod.POST,produces = "application/json;charset=utf-8")  
     @ResponseBody
     //@CrossOrigin("*") //可跨域访问
     public String uploadFileByOldName(HttpServletRequest request){  
    	 String reResult = "";
		try {
			reResult = FileSaveUtil.uploadFileByOldName(request);
		}catch (IllegalStateException e) {
			logger.error(e,e);
		} catch (IOException e) {
			logger.error(e,e);
		} catch (Exception e) {
			logger.error(e,e);
		}
        return reResult;
     } 
	
}
