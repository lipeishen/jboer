package com.dcits.jb.core.encrypt;

public interface Encryption {
	public String getEncryption(String content,String key);
	
	public String getDecryption(String content,String key);
	
	public String createKey();
}
