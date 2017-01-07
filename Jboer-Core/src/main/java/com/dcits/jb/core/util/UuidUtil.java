package com.dcits.jb.core.util;

import java.util.UUID;

public class UuidUtil {
	public static String get32Uuid(){
		String uuid = UUID.randomUUID().toString().trim().replace("-","");
		return uuid;
	}
	
	public static void main(String[] arg) {
		for(int i = 0;i < 20;i++){
			System.out.println(UuidUtil.get32Uuid());
		}
	}
}
