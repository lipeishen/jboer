package com.dcits.djk.env;

import com.dcits.djk.core.util.PropertyUtil;

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
