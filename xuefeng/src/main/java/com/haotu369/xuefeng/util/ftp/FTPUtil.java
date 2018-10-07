package com.haotu369.xuefeng.util.ftp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;
 
public class FTPUtil {
     
	private static final String HOSTNAME="115.159.201.119";
	private static final int PORT=21;
	private static final String USERNAME="201419223";
	private static final String PASSWORD="852100";
	private static final String PATHNAME=File.separator+"var"+File.separator+"ftp"+File.separator+"homework";
	
	private static FTPClient ftpClient=new FTPClient();	
	
	
	/**文件上传**/
	//沈健6.4
    public static synchronized void  uploadFile(MultipartFile[] files){
    	
    	ftpLogin();
    	
    	try {
    		
    		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.changeWorkingDirectory(PATHNAME);
			for(MultipartFile file:files){
				ftpClient.storeFile(file.getOriginalFilename(), file.getInputStream());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ftpClose();
		}
    }
    
	/**打开连接并登陆**/
	private static boolean ftpLogin(){
		
		if(ftpClient.isConnected()){  
    		return true;
    	}
		
		try {
			
			ftpClient.setConnectTimeout(1000*10);//连接超时时间10秒
			ftpClient.setControlEncoding("UTF-8");//解决乱码
			
			ftpClient.connect(HOSTNAME, PORT);
			
		    int reply=ftpClient.getReplyCode();//验证连接是否成功
		    if(!FTPReply.isPositiveCompletion(reply)){
		    	ftpClient.disconnect();
		    }
		    
			ftpClient.login(USERNAME, PASSWORD);
			
			return true;
		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
	}
	
	/**退出登录并关闭连接**/
	private static boolean ftpClose(){
		if(!ftpClient.isConnected()){
			return true;
		}
		try {
			ftpClient.logout();
			ftpClient.disconnect();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}	
}