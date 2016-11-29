package com.dcits.djk.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class ObjectUtil {
	
	public static byte[] ObjectToByte(Object obj){
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try{
			bo = new ByteArrayOutputStream();  
			oo = new ObjectOutputStream(bo);  
			oo.writeObject(obj);  
			byte[] bytes = bo.toByteArray();
			return bytes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			safeClose(bo);
			safeClose(oo);
		}
	}
	
	public static Object ByteToObject(byte[] bytes){
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try{
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);
			Object obj = oi.readObject();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			safeClose(bi);
			safeClose(oi);
		}
	}
	
	public static byte[] StringToByteIn64Bin(String baseStr){
		byte[] b = Base64.getDecoder().decode(baseStr);
		return b;
	}
	
	public static String ByteToStringIn64Bin(byte[] b){
		byte[] baseStrByte = Base64.getEncoder().encode(b);
		String baseStr = "";
		try {
			baseStr = new String(baseStrByte,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseStr;
	}
	
	/**
	 * 安全的关闭可关闭对象，忽略异常
	 * 
	 * @param closeable
	 */
    public static final void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Exception ignore) {}
        }
    }
}
