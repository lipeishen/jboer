package com.dcits.jb.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;

import com.dcits.jb.core.env.SftpConfigEnv;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpUtil {
	public static int speed = 3;
	
	public static boolean uploadFile(File file,String path,String dirName){
		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		OutputStream outstream = null;
		InputStream instream = null;
		boolean flag = true;
		try {session = jsch.getSession(SftpConfigEnv.getSftpUserName(), SftpConfigEnv.getSftpIp(),SftpConfigEnv.getSftpPort());
			if(session == null){
				return false;
			}
			session.setPassword(SftpConfigEnv.getSftpHideval());
		    session.setConfig("StrictHostKeyChecking", "no");
		    session.connect(30000);
		    channel = (Channel) session.openChannel("sftp");
	        channel.connect(1000);
	        ChannelSftp sftp = (ChannelSftp) channel;
	        
	        sftp.cd(path);
	        try{
	        	Vector content = sftp.ls(path+ "/" + dirName);
	 	        if(content == null){
	 	        	sftp.mkdir(dirName);
	 	        }
	        }catch(Exception ex){
	        	sftp.mkdir(dirName);
	        }
	       
	        sftp.cd(dirName);
	        outstream = sftp.put(file.getName());
	        instream = new FileInputStream(file);
	        byte b[] = new byte[1024*speed];
	        int n;
	        while ((n = instream.read(b)) != -1) {
	            outstream.write(b, 0, n);
	        }
	         
	        outstream.flush();
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally{
			try{
				if(outstream!=null){
					outstream.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if(instream!=null){
					instream.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (session != null) {
					session.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (channel != null) {
					channel.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static boolean uploadFiles(List<File> files,String path,String dirName){
		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		OutputStream outstream = null;
		InputStream instream = null;
		boolean flag = true;
		try {
			session = jsch.getSession(SftpConfigEnv.getSftpUserName(), SftpConfigEnv.getSftpIp(),SftpConfigEnv.getSftpPort());
			if(session == null){
				return false;
			}
			session.setPassword(SftpConfigEnv.getSftpHideval());
		    session.setConfig("StrictHostKeyChecking", "no");
		    session.connect(30000);
		    channel = (Channel) session.openChannel("sftp");
	        channel.connect(1000);
	        ChannelSftp sftp = (ChannelSftp) channel;
	        
	        sftp.cd(path);
	        try{
	        	Vector content = sftp.ls(path+ "/" + dirName);
	 	        if(content == null){
	 	        	sftp.mkdir(dirName);
	 	        }
	        }catch(Exception ex){
	        	sftp.mkdir(dirName);
	        }
	        sftp.cd(dirName);
	        for(int i = 0;i < files.size();i++){
	        	try {
	        		File file = files.get(i);
		        	outstream = sftp.put(file.getName());
			        instream = new FileInputStream(file);
			        byte b[] = new byte[1024*speed];
			        int n;
			        while ((n = instream.read(b)) != -1) {
			            outstream.write(b, 0, n);
			        }
			        outstream.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(outstream != null){
							outstream.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						if(instream != null){
							instream.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	        }
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally{
			try{
				if(session != null){
					session.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if(channel != null){
					channel.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static boolean uploadFile(File file,String path){
		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		OutputStream outstream = null;
		InputStream instream = null;
		boolean flag = true;
		try {
			//System.out.println(SftpConfigEnv.getSftpUserName() + ","+ SftpConfigEnv.getSftpHideval() + "," + SftpConfigEnv.getSftpIp() + "," + SftpConfigEnv.getSftpPort());
			session = jsch.getSession(SftpConfigEnv.getSftpUserName(), SftpConfigEnv.getSftpIp(),SftpConfigEnv.getSftpPort());
			if(session == null){
				return false;
			}
			session.setPassword(SftpConfigEnv.getSftpHideval());
		    session.setConfig("StrictHostKeyChecking", "no");
		    session.connect(30000);
		    channel = (Channel) session.openChannel("sftp");
	        channel.connect(1000);
	        ChannelSftp sftp = (ChannelSftp) channel;
	        sftp.cd(path);
	        
	        outstream = sftp.put(file.getName());
	        instream = new FileInputStream(file);
	        byte b[] = new byte[1024*speed];
	        int n;
	        while ((n = instream.read(b)) != -1) {
	            outstream.write(b, 0, n);
	        }
	         
	        outstream.flush();
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally{
			try{
				if (outstream != null) {
					outstream.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (instream != null) {
					instream.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (session != null) {
					session.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (channel != null) {
					channel.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static boolean uploadFiles(List<File> files,String path){
		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		OutputStream outstream = null;
		InputStream instream = null;
		boolean flag = true;
		try {
			session = jsch.getSession(SftpConfigEnv.getSftpUserName(), SftpConfigEnv.getSftpIp(),SftpConfigEnv.getSftpPort());
			if(session == null){
				return false;
			}
			session.setPassword(SftpConfigEnv.getSftpHideval());
		    session.setConfig("StrictHostKeyChecking", "no");
		    session.connect(30000);
		    channel = (Channel) session.openChannel("sftp");
	        channel.connect(1000);
	        ChannelSftp sftp = (ChannelSftp) channel;
	        
	        sftp.cd(path);
	        for(int i = 0;i < files.size();i++){
	        	try {
	        		File file = files.get(i);
		        	outstream = sftp.put(file.getName());
			        instream = new FileInputStream(file);
			        byte b[] = new byte[1024*speed];
			        int n;
			        while ((n = instream.read(b)) != -1) {
			            outstream.write(b, 0, n);
			        }
			        outstream.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					 try{
			        	if (outstream != null) {
							outstream.close();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					try{
						if (instream != null) {
							instream.close();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
	        }
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally{
			try{
				if (session != null) {
					session.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (channel != null) {
					channel.disconnect();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
