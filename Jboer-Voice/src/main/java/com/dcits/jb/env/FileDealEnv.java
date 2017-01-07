package com.dcits.jb.env;

import com.dcits.jb.core.util.PropertyUtil;

public class FileDealEnv {
	private static String fileVoicePath;
	

	public static String getFileVoicePath() {
		return fileVoicePath;
	}

	static{
		
		if(fileVoicePath == null || "".equals(fileVoicePath)){
			FileDealEnv.fileVoicePath = PropertyUtil.getPropertyManager("file").getProperty("fileVoicePath");
		}
	}
	

}
