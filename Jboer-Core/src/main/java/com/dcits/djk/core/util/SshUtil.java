package com.dcits.djk.core.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshUtil {
	private String host;
	private String userName;
	private int port;
	private String passwd;
	
	private SshUtil(){
		this.host = "10.0.5.22";
		this.userName = "dajiankang";
		this.port = 22;
		this.passwd = "Y1ws2222";
	}
	
	public SshUtil(String host,String userName,int port,String passwd){
		this.host = host;
		this.userName = userName;
		this.port = port;
		this.passwd = passwd;
		
	}
	
	public String exceCmd(String cmd,String charset){
		StringBuffer resultStr = new StringBuffer("");
		InputStreamReader isr = null;
		InputStream in = null;
		BufferedReader br  = null;
		ChannelExec channelExec = null;
		Session session = null;
		try{
			JSch jsch = new JSch();
			session = jsch.getSession(this.userName,this.host,this.port);
			session.setPassword(this.passwd);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(30000);
			channelExec = (ChannelExec) session.openChannel("exec");
			channelExec.setErrStream(System.err);
			channelExec.setInputStream(null);
			channelExec.setCommand(cmd);
			in = channelExec.getInputStream();
			channelExec.connect();
			
			isr = new InputStreamReader(in,Charset.forName(charset));
			br = new BufferedReader(isr);
			String lineStr = "";
			while ((lineStr = br.readLine()) != null){
				if(resultStr.toString().equals("")){
					resultStr.append(lineStr);
				}else{
					resultStr.append("\n" + lineStr);
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br != null){
					br.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(isr != null){
					isr.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(in != null){
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(channelExec != null){
					channelExec.disconnect();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(session != null){
					session.disconnect();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return resultStr.toString();
	}
	
	public void killProcessByName(String processName,String charset){
		try{
			String cmd = "kill -9 $(ps -ef|grep "+processName+"|gawk '$0 !~/grep/ {print $2}' |tr -s '\\n' ' ')";
			this.exceCmd(cmd,charset);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		SshUtil su = new SshUtil();
		//su.killProcessByName("apache-tomcat-8-selftest", "utf-8");
		System.out.println(su.exceCmd("/home/dajiankang/service/apache-tomcat-8-selftest/bin/startup.sh","utf-8"));
		//System.out.println(su.exceCmd("ps -ef|grep java","utf-8"));
	}
}
