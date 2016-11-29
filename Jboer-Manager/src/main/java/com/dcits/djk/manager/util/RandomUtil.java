package com.dcits.djk.manager.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtil {

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
	
	public static void main(String[] args) {
		String randNum = RandomUtil.getRandNum(6);
		System.out.println(randNum);
		
	}
}
