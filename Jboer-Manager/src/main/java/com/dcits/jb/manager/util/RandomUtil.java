package com.dcits.jb.manager.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtil {
	
	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";


	public static String getRandNum(int charCount) {
		String charValue = "";
		for (int i = 0; i < charCount; i++) {
			char c = (char) (randomInt(0, 10) + '0');
			charValue += String.valueOf(c);
		}
		return charValue;

	}

	
	public static int randomInt(int from, int to) {
		Random r = new SecureRandom();
		return from + r.nextInt(to - from);
	}
	/**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     * 
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }
	
	//生成产品编码
	public static String getProCode(int len){
		Date date=new Date();
		SimpleDateFormat smf=new SimpleDateFormat("YYYYMMddHHmmss");
		StringBuffer sb= new StringBuffer();
		sb.append(smf.format(date));
		//生成16位随机数
		sb.append(generateString(len));
		return sb.toString();
		
		
	}
	
	public static void main(String[] args) {
		String daa=getProCode(16);
		System.out.println(daa);
		
	}
}
