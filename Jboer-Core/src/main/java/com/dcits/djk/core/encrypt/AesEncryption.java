package com.dcits.djk.core.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import com.dcits.djk.core.util.ObjectUtil;

public class AesEncryption implements Encryption{

	public String getEncryption(String content, String key) {
		String resultStr = "";
		try{
			Cipher cipher = Cipher.getInstance("AES");
			byte[] keyBytes = ObjectUtil.StringToByteIn64Bin(key);
			Key keyObj = (Key)ObjectUtil.ByteToObject(keyBytes);
			cipher.init(Cipher.ENCRYPT_MODE, keyObj);
			byte[] resultByte = cipher.doFinal(content.getBytes());
			resultStr = ObjectUtil.ByteToStringIn64Bin(resultByte);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultStr;
	}
	
	public String getDecryption(String content, String key) {
		String resultStr = "";
		try{
			Cipher cipher = Cipher.getInstance("AES");
			byte[] keyBytes = ObjectUtil.StringToByteIn64Bin(key);
			Key keyObj = (Key)ObjectUtil.ByteToObject(keyBytes);
			cipher.init(Cipher.DECRYPT_MODE, keyObj);
			byte[] contentByte = ObjectUtil.StringToByteIn64Bin(content);
			byte[] resultByte = cipher.doFinal(contentByte);
			resultStr = new String(resultByte);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultStr;
	}
	
	

	public String createKey() {
		String key = "";
		try {
			Key secretKey = KeyGenerator.getInstance("AES").generateKey();
			byte[] b = ObjectUtil.ObjectToByte(secretKey);
			String base64str = ObjectUtil.ByteToStringIn64Bin(b);
			return base64str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}
	
//	public static void main(String[] arg){
//		String key = "rO0ABXNyAB9qYXZheC5jcnlwdG8uc3BlYy5TZWNyZXRLZXlTcGVjW0cLZuIwYU0CAAJMAAlhbGdvcml0aG10ABJMamF2YS9sYW5nL1N0cmluZztbAANrZXl0AAJbQnhwdAADQUVTdXIAAltCrPMX+AYIVOACAAB4cAAAABDF3+gld/yaGAKXkHJsTB7V";
//		Encryption enc = new AesEncryption();
//		String encstr = enc.getEncryption("侯克威你好", key);
//		System.out.println(encstr);
//		String dencstr= enc.getDecryption(encstr, key);
//		System.out.println(dencstr);
//	
//	}
}
