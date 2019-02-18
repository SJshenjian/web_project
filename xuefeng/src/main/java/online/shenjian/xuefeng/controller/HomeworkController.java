package online.shenjian.xuefeng.controller;

import online.shenjian.xuefeng.util.ftp.FTPUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
	
	
	
	/**作业下载页面获取**/
	@RequestMapping("/downloadIndex")
	public String getDownloadIndex(){
		return "homework_download";
	}
	
	/**作业批量下载**/
	//沈健6.4
	@RequestMapping("/download")
	public String downloadHomework(){
		//FTPUtil.downloadFiles(HOSTNAME, PORT, USERNAME, PASSWORD, PATHNAME,"E://temp");
		return "homework_download";
	}
	
	/**作业上传页面**/
	@RequestMapping("/uploadIndex")
	public String getUploadIndex(){
		
		return "homework_upload";
	}
	
	

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public  String uploadHomework(@RequestParam("file-zh[]")  MultipartFile[] multipartFiles,Model model){
	    
		FTPUtil.uploadFile(multipartFiles);
		
		return "true";//必须为true,否则会报SyntaxError: Unexpected token < in JSON at position 2.
	}
    
}
