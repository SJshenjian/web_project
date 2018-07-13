<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>homework</title>
       	<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script src="http://www.xuefeng66.cn/xuefeng/resources/js/bootstrap.js"></script>
		<link href="http://www.xuefeng66.cn/xuefeng/resources/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
   		<link href="http://www.xuefeng66.cn/xuefeng/resources/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />       
        <script src="${pageContext.request.contextPath}/resources/js/fileinput.js" type="text/javascript"></script>
        <script src="http://www.xuefeng66.cn/xuefeng/resources/js/zh.js" type="text/javascript"></script>
  	
    </head>
     <body>
        <div class="container kv-main">                         
	        <form enctype="multipart/form-data">                                          
	              <input id="file-zh" name="file-zh[]" type="file" multiple />                        
	        </form>
        </div>
    </body>
<script>
  
    $('#file-zh').fileinput({
        language: 'zh',
        uploadUrl: '${pageContext.request.contextPath}/homework/upload',
        allowedFileExtensions : ['doc', 'docx','zip','rar'],
        maxFileSize: 10000,
        maxFilesNum: 10,
        
    });
	</script>
</html>