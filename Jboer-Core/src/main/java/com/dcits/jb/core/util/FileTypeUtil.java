package com.dcits.jb.core.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public final class FileTypeUtil {
	/** * Constructor */  
	private FileTypeUtil() {}  
	/** * 将文件头转换成16进制字符串 * * @param 原生byte * @return 16进制字符串 */  
	private static String bytesToHexString(byte[] src) {  
		StringBuilder stringBuilder = new StringBuilder();  
		if (src == null || src.length <= 0) {  
			return null;  
		}  
		for (int i = 0; i < src.length; i++) {  
			int v = src[i] & 0xFF;  
			String hv = Integer.toHexString(v);  
			if (hv.length() < 2) {  
				stringBuilder.append(0);  
			}  
			stringBuilder.append(hv);  
		}  
		return stringBuilder.toString();  
	}
	
	/** * 得到文件头 * * @param filePath * 文件路径 * @return 文件头 * @throws IOException */  
	private static String getFileContent(InputStream is) throws IOException {
		byte[] b = new byte[28];
		is.read(b, 0, 28);
		return bytesToHexString(b);
	}
	
	private static FileTypeEnum getType(InputStream is) throws IOException {  
		String fileHead = getFileContent(is);  
		if (fileHead == null || fileHead.length() == 0) {  
			return null;
		}
		fileHead = fileHead.toUpperCase(Locale.ENGLISH);  
		FileTypeEnum[] fileTypes = FileTypeEnum.values();  
		for (FileTypeEnum type : fileTypes) {  
			if (fileHead.startsWith(type.getValue())) {  
				return type;
			}
		}
		return null;
	}
	
	private static FileTypeEnum getType(byte[] src) throws IOException {  
		String fileHead = bytesToHexString(src);  
		if (fileHead == null || fileHead.length() == 0) {  
			return null;
		}
		fileHead = fileHead.toUpperCase(Locale.ENGLISH);  
		FileTypeEnum[] fileTypes = FileTypeEnum.values();  
		for (FileTypeEnum type : fileTypes) {  
			if (fileHead.startsWith(type.getValue())) {  
				return type;
			}
		}
		return null;
	}
	
	public static String getSuffix(InputStream is){
		String suffix = "";
		try{
			FileTypeEnum fte = getType(is);
			if(fte.name().equals("JPEG")){
				suffix = ".jpg";
			}else if(fte.name().equals("XLSX_DOCX")){
				suffix = ".doc";
			}else if(fte.name().equals("XLS_DOC")){
				suffix = ".docx";
			}else{
				suffix = "."+fte.name().toLowerCase();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return suffix;
	}
	
	public static String getSuffix(File file){
		String suffix = "";
		BufferedInputStream bis = null;
		try{
			bis = new BufferedInputStream(new FileInputStream(file));
			FileTypeEnum fte = getType(bis);
			if(fte == null){
				return "";
			}
			if(fte.name().equals("JPEG")){
				suffix = ".jpg";
			}else if(fte.name().equals("XLSX_DOCX")){
				suffix = ".doc";
			}else if(fte.name().equals("XLS_DOC")){
				suffix = ".docx";
			}else{
				suffix = "."+fte.name().toLowerCase();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (bis!=null) {
				 bis.close();
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return suffix;
	}
	public static String getSuffix(byte[] src){
		String suffix = "";
		try{
			FileTypeEnum fte = getType(src);
			if(fte == null){
				return "";
			}
			if(fte.name().equals("JPEG")){
				suffix = ".jpg";
			}else if(fte.name().equals("XLSX_DOCX")){
				suffix = ".doc";
			}else if(fte.name().equals("XLS_DOC")){
				suffix = ".docx";
			}else{
				suffix = "."+fte.name().toLowerCase();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		return suffix;
	}
}
