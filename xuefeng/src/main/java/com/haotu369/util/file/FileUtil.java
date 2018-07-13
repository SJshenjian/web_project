package com.haotu369.util.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
    
	private static final String DEFAULT_PATH="resources"+File.separator+"images"+File.separator;
	
	/**保存文件到指定目录，并返回保存地址**/
	public static String saveFile(HttpServletRequest request,MultipartFile file,String purpose){
		
		if("项目背景".equals(purpose)){
			
			String originalFileName=file.getOriginalFilename();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmss");
			Date date=new Date();	
			String newFileName=sdf.format(date)+"_"+originalFileName;				
			String path=request.getServletContext().getRealPath("/")+DEFAULT_PATH+"project";
			
		    File newFile=new File(path,newFileName);
		    
		    if(!newFile.exists()){
		    	try {
					newFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		  
		    try {
				file.transferTo(newFile);
			}catch (IOException e) {
				e.printStackTrace();
			}
		   
		    String temp="http://www.haotu369.com"+File.separator+DEFAULT_PATH+"project"+File.separator+newFileName;
		
		    return temp.replace(File.separator, "/");
		}
		
		return "error";
	}

}
