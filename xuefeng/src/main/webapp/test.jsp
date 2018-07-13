<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<html>
  <head>
    
    <title>My JSP 'test.jsp' starting page</title>
 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="${pageContext.request.contextPath}/blog/index">测试富文本编辑</a>
    <a href="${pageContext.request.contextPath}/blog/detail?id=46">测试请求次数</a>   
    <a href="">测试项目下载</a>
    <a href="${pageContext.request.contextPath}/blog/list?type=1&pageNum=1">测试文章管理</a>
  	<a href="${pageContext.request.contextPath}/project/list?pageNum=1">测试项目管理</a>
  	
  	<a href="${pageContext.request.contextPath}/homework/uploadIndex">测试文件上传</a>
  </body>
</html>
