package com.dcits.djk.manager.env;

import com.dcits.djk.core.util.PropertyUtil;

/** 
  * @author  xingyxa 
  * @date 创建时间：2016年3月8日 下午4:52:17 
  * @version 1.0 
  * @since  1.8 
*/
public class FileuploadEnv {
	private static String fileHtmlPath;       //获取资讯内容的html的路径
	private static String uploaddir;
	private static String imgUploadUrlForServer;	//通过百度编辑器上传图片的路径。	  
	private static String imgUploadUrlForClient;		  //图片上传路径
	private static String imgShowUrl;         //通过内网显示图片的路径
	private static String htmlImgShowUrl;     //Html中读取本地显示图片的路径
	private static String imgPublishShowUrl;  //通过域名显示图片的路径
	private static String sftpPath;            //资讯手机端html上传到远程服务器的路径
	private static String sftpPCPath;            //资讯PC端html上传到远程服务器的路径
	private static String sftpWhyQuestionPath; //有问有答html上传到远程服务器的路径
	private static String sftpDiseasePath;     //疾病html上传到远程服务器的路径
	private static String selftestMouldHtml;     
	private static String whyQuestionMouldHtml;     //有问有答Html模板的路径
	private static String misArticlePhoneMouldHtml;  //资讯手机端模板
	private static String misArticlePCMouldHtml;     //资讯PC端模板
	private static String misJtPhoneMouldHtml;  //健康讲堂手机端模板
	private static String misJtPCMouldHtml;     //健康讲堂PC端模板
	private static String tempUrl;              //上传图片的本地临时文件夹
	private static String questionItemUrl;
	private static String indexModuldHtml;      //手机端首页模板
	private static String sftIndexHtmlpPath;            //手机端首页发布地址
	private static String vedioUploadUrl;            //上传视频的服务器地址
	private static String indexFgsPath;                   //分公司首页模板
	private static String indexZgsPath;                   //总公司首页模板
	private static String appIdPath;                   //公共号id
	private static String topPath;                   //轮播图
	private static String temPath;						//上传临时路径
	private static String accessKey;						//公钥
	private static String secretKey;						//私钥
	private static String bucketName;						//空间名
	private static String backUrl;						//返回地址
	
	static{
		if(fileHtmlPath == null || fileHtmlPath.equals("")){
			FileuploadEnv.fileHtmlPath = PropertyUtil.getPropertyManager("fileupload").getProperty("fileHtmlPath");
		}
		if(uploaddir == null || uploaddir.equals("")){
			FileuploadEnv.uploaddir = PropertyUtil.getPropertyManager("fileupload").getProperty("uploaddir");
		}
		if(imgUploadUrlForServer == null || imgUploadUrlForServer.equals("")){
			FileuploadEnv.imgUploadUrlForServer = PropertyUtil.getPropertyManager("fileupload").getProperty("imgUploadUrlForServer");
		}
		if(imgUploadUrlForClient == null || imgUploadUrlForClient.equals("")){
			FileuploadEnv.imgUploadUrlForClient = PropertyUtil.getPropertyManager("fileupload").getProperty("imgUploadUrlForClient");
		}
		if(imgShowUrl == null || imgShowUrl.equals("")){
			FileuploadEnv.imgShowUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("imgShowUrl");
		}
		if(htmlImgShowUrl == null || htmlImgShowUrl.equals("")){
			FileuploadEnv.htmlImgShowUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("htmlImgShowUrl");
		}
		if(imgPublishShowUrl == null || imgPublishShowUrl.equals("")){
			FileuploadEnv.imgPublishShowUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("imgPublishShowUrl");
		}
		if(sftpPath == null || sftpPath.equals("")){
			FileuploadEnv.sftpPath = PropertyUtil.getPropertyManager("fileupload").getProperty("sftpPath");
		}
		if(sftpPCPath == null || sftpPCPath.equals("")){
			FileuploadEnv.sftpPCPath = PropertyUtil.getPropertyManager("fileupload").getProperty("sftpPCPath");
		}
		if(sftpWhyQuestionPath == null || sftpWhyQuestionPath.equals("")){
			FileuploadEnv.sftpWhyQuestionPath = PropertyUtil.getPropertyManager("fileupload").getProperty("sftpWhyQuestionPath");
		}
		if(sftpDiseasePath == null || sftpDiseasePath.equals("")){
			FileuploadEnv.sftpDiseasePath = PropertyUtil.getPropertyManager("fileupload").getProperty("sftpDiseasePath");
		}
		if(selftestMouldHtml == null || selftestMouldHtml.equals("")){
			FileuploadEnv.selftestMouldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("selftestMouldHtml");
		}
		if(whyQuestionMouldHtml == null || whyQuestionMouldHtml.equals("")){
			FileuploadEnv.whyQuestionMouldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("whyQuestionMouldHtml");
		}
		if(misArticlePhoneMouldHtml == null || misArticlePhoneMouldHtml.equals("")){
			FileuploadEnv.misArticlePhoneMouldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("misArticlePhoneMouldHtml");
		}
		if(misArticlePCMouldHtml == null || misArticlePCMouldHtml.equals("")){
			FileuploadEnv.misArticlePCMouldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("misArticlePCMouldHtml");
		}
		if(misJtPhoneMouldHtml == null || misJtPhoneMouldHtml.equals("")){
			FileuploadEnv.misJtPhoneMouldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("misJtPhoneMouldHtml");
		}
		if(misJtPCMouldHtml == null || misJtPCMouldHtml.equals("")){
			FileuploadEnv.misJtPCMouldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("misJtPCMouldHtml");
		}
		if(tempUrl == null || tempUrl.equals("")){
			FileuploadEnv.tempUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("tempUrl");
		}
		if(questionItemUrl == null || "".equals(questionItemUrl)){
			FileuploadEnv.questionItemUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("questionItemUrl");
		}
		if(indexModuldHtml == null || indexModuldHtml.equals("")){
			FileuploadEnv.indexModuldHtml = PropertyUtil.getPropertyManager("fileupload").getProperty("indexModuldHtml");
		}
		if(sftIndexHtmlpPath == null || sftIndexHtmlpPath.equals("")){
			FileuploadEnv.sftIndexHtmlpPath = PropertyUtil.getPropertyManager("fileupload").getProperty("sftIndexHtmlpPath");
		}
		if(vedioUploadUrl == null || vedioUploadUrl.equals("")){
			FileuploadEnv.vedioUploadUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("vedioUploadUrl");
		}
		if(indexZgsPath == null || indexZgsPath.equals("")){
			FileuploadEnv.indexZgsPath = PropertyUtil.getPropertyManager("fileupload").getProperty("indexZgsPath");
		}
		if(indexFgsPath == null || indexFgsPath.equals("")){
			FileuploadEnv.indexFgsPath = PropertyUtil.getPropertyManager("fileupload").getProperty("indexFgsPath");
		}
		if(appIdPath == null || appIdPath.equals("")){
			FileuploadEnv.appIdPath = PropertyUtil.getPropertyManager("fileupload").getProperty("appIdPath");
		}
		if(temPath == null || temPath.equals("")){
			FileuploadEnv.temPath = PropertyUtil.getPropertyManager("fileupload").getProperty("temPath");
		}
		if(topPath == null || topPath.equals("")){
			FileuploadEnv.topPath = PropertyUtil.getPropertyManager("fileupload").getProperty("topPath");
		}
		if(accessKey == null || accessKey.equals("")){
			FileuploadEnv.accessKey = PropertyUtil.getPropertyManager("fileupload").getProperty("accessKey");
		}
		if(secretKey == null || secretKey.equals("")){
			FileuploadEnv.secretKey = PropertyUtil.getPropertyManager("fileupload").getProperty("secretKey");
		}
		if(bucketName == null || bucketName.equals("")){
			FileuploadEnv.bucketName = PropertyUtil.getPropertyManager("fileupload").getProperty("bucketName");
		}
		if(backUrl == null || backUrl.equals("")){
			FileuploadEnv.backUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("backUrl");
		}
	}
	/**
	 * 获取资讯内容的Html路径
	 * @author  xingyxa 
	 * @return
	 */
	public static String getFileHtmlPath() {
		return FileuploadEnv.fileHtmlPath;
	}
	/**
	 * 获取资讯模板的Html路径
	 * @author  xingyxa 
	 * @return
	 */
	public static String getUploaddir() {
		return FileuploadEnv.uploaddir;
	}
	/**
	 * 获取通过百度编辑器上传图片的路径
	 * @author  xingyxa 
	 * @return imgUploadUrlForServer
	 */
	public static String getImgUploadUrlForServer() {
		return FileuploadEnv.imgUploadUrlForServer;
	}
	/**
	 * 获取远程保存图片的URL
	 * @author  xingyxa 
	 * @return imgUploadUrlForClient
	 */
	public static String getImgUploadUrlForClient() {
		return FileuploadEnv.imgUploadUrlForClient;
	}
	/**
	 * 获取展示图片的URL
	 * @author  xingyxa 
	 * @return
	 */
	public static String getImgShowUrl() {
		return FileuploadEnv.imgShowUrl;
	}
	/**
	 * Html中获取图片的URL
	 * @author  xingyxa 
	 * @return htmlImgShowUrl
	 */
	public static String getHtmlImgShowUrl() {
		return htmlImgShowUrl;
	}
	/**
	 * 获取访问图片的域名URL
	 * @author  xingyxa 
	 * @return
	 */
	public static String getImgPublishShowUrl() {
		return FileuploadEnv.imgPublishShowUrl;
	}
	/**
	 * 获取远程发布Html的URL
	 * @author  xingyxa 
	 * @return
	 */
	public static String getSftpPath() {
		return FileuploadEnv.sftpPath;
	}
	/**
	 * 获取远程发布资讯PC端Html的URL
	 * @author  xingyxa 
	 * @return
	 */
	public static String getSftpPCPath() {
		return sftpPCPath;
	}
	/**
	 * 手机端Html模板的路径
	 * @author  xingyxa 
	 * @return
	 */
	public static String getMisArticlePhoneMouldHtml() {
		return misArticlePhoneMouldHtml;
	}
	/**
	 * PC端Html模板的路径
	 * @author  xingyxa 
	 * @return
	 */
	public static String getMisArticlePCMouldHtml() {
		return misArticlePCMouldHtml;
	}
	/**
	 * 健康讲堂手机端模板
	 * @author  xingyxa 
	 * @return 健康讲堂手机端模板
	 */
	public static String getMisJtPhoneMouldHtml() {
		return misJtPhoneMouldHtml;
	}
	/**
	 * 上传视频的服务器地址
	 * @return
	 */
	public static String getVedioUploadUrl() {
		return vedioUploadUrl;
	}
	/**
	 * 健康讲堂PC端模板
	 * @author  xingyxa 
	 * @return 健康讲堂PC端模板
	 */
	public static String getMisJtPCMouldHtml() {
		return misJtPCMouldHtml;
	}
	/**
	 * 有问有答Html路径
	 */
	public static String getSftpWhyQuestionPath() {
		return sftpWhyQuestionPath;
	}
	/**
	 * 疾病Html路径
	 */
	public static String getSftpDiseasePath() {
		return sftpDiseasePath;
	}
	/**
	 * 获取疾病自查界面模板的路径
	 * @author  xingyxa 
	 * @return
	 */
	public static String getSelftestMouldHtml() {
		return FileuploadEnv.selftestMouldHtml;
	}
	/**
	 * 获取有问有答界面模板的路径
	 * @author  xingyxa 
	 * @return
	 */
	public static String getWhyQuestionMouldHtml() {
		return FileuploadEnv.whyQuestionMouldHtml;
	}
	/**
	 * 上传图片的本地临时文件夹
	 * @author cuiwt
	 * @return
	 */
	public static String gettempUrl() {
		return FileuploadEnv.tempUrl;
	}

	public static String getQuestionItemUrl(){
		return FileuploadEnv.questionItemUrl;
	}
	public static String getIndexModuldHtml() {
		return FileuploadEnv.indexModuldHtml;
	}
	public static String getIndexHtml() {
		return FileuploadEnv.sftIndexHtmlpPath;
	}
	
	public static String getIndexZgsPath() {
		return indexZgsPath;
	}
	public static void setIndexZgsPath(String indexZgsPath) {
		FileuploadEnv.indexZgsPath = indexZgsPath;
	}
	public static String getIndexFgsPath() {
		return indexFgsPath;
	}
	public static void setIndexFgsPath(String indexFgsPath) {
		FileuploadEnv.indexFgsPath = indexFgsPath;
	}
	public static String getAppIdPath() {
		return appIdPath;
	}
	public static void setAppIdPath(String appIdPath) {
		FileuploadEnv.appIdPath = appIdPath;
	}
	public static String getTemPath(){
		return FileuploadEnv.temPath;
	}
	public static String getTopPath() {
		return topPath;
	}
	public static void setTopPath(String topPath) {
		FileuploadEnv.topPath = topPath;
	}
	/**
	 * 获取公钥
	 * @return
	 */
	public static String getAccessKey() {
		return accessKey;
	}
	/**
	 * 获取私钥
	 * @return
	 */
	public static String getSecretKey() {
		return secretKey;
	}
	/**
	 * 空间名称
	 * @return
	 */
	public static String getBucketName() {
		return bucketName;
	}
	/**
	 * 返回路径
	 * @return
	 */
	public static String getBackUrl() {
		return backUrl;
	}
	
}
