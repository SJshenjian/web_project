
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>项目修改</title>

<link type="text/css" rel="Stylesheet"
	href="http://www.xuefeng66.cn/xuefeng/resources/css/admin_main.css">
<!--new top-->
<link rel="stylesheet"
	href="http://www.xuefeng66.cn/xuefeng/resources/css/index.css">
<!--new top-->

</head>

<body style="background-color: rgb(242, 242, 242);">


	<div id="wrap">

		<div class="head">

			<div class="user_info">
				<dl>
					<dt>
						<a href="#"><img
							src="http://www.xuefeng66.cn/xuefeng/resources/images/3_sjshenjian.jpg"
							alt="SJshenjian"></a>
					</dt>
					<dd>
						<ul>
							<li class="user_name"><a href="#" class="user_name">SJshenjian</a><span>SJshenjian的博客</span></li>
							<li class="feed_link"><a href="#">个人主页</a>|<a href="#">我的博客</a></li>
						</ul>
					</dd>
				</dl>
			</div>

			<div style="float:right; margin-top:20px; color:Red;"></div>
		</div>


		<div class="tabs_header">
			<ul id="ul_tab" class="tabs" style="width:120%">
				<li><a href="${pageContext.request.contextPath}/blog/index"><span>发表文章</span></a></li>
				<li><a href="${pageContext.request.contextPath}/blog/list"><span>文章管理</span></a></li>				
				<li><a href="#"><span>类别管理</span></a></li>
				<li><a href="#"><span>评论管理</span></a></li>
				<li><a href="${pageContext.request.contextPath}/project/list"><span>项目管理</span></a></li>
				<li class="active"><a href="#"><span>修改项目</span></a></li>
			</ul>
		</div>

		<form action="${pageContext.request.contextPath}/project/update" method="post" >
		<input type="hidden" name="id" value="${project.id}">
		<div id="editType" style="display:none">0</div>
		<p class="subtit">项目名称</p>
		<div>
			<input type="text" name="name" value="${project.name}"
				style="width: 560px; height: 20px; background-color: rgb(242, 242, 242);"
				maxlength="100">
		</div>
		<p class="subtit">项目简介(20字以内最佳)</p>
		<div>
			<input type="text" name="descript" value="${project.descript}"
				style="width: 560px; height: 20px; background-color: rgb(242, 242, 242);"
				maxlength="100">
		</div>
		<p class="subtit">项目URL</p>
		<div>
			<input type="text" name="url" value="${project.url}"
				style="width: 560px; height: 20px; background-color: rgb(242, 242, 242);"
				maxlength="100">
		</div>
		<p class="subtit">项目总结</p>
		<div style="height:2px;"></div>

		<div style="width:700px">
		
		<!-- 加载编辑器的容器 -->
			<script id="container" name="problem" type="text/plain">
				${project.problem}
			</script>
		
			<!-- 配置文件 -->
			<script type="text/javascript"
				src="http://www.xuefeng66.cn/xuefeng/resources/ueditor/ueditor.config.js"></script>
			<!-- 编辑器源码文件 -->
			<script type="text/javascript"
				src="http://www.xuefeng66.cn/xuefeng/resources/ueditor/ueditor.all.js"></script>
			<!-- 实例化编辑器 -->			
		    <script type="text/javascript">
		        var ue = UE.getEditor('container'); 
		    </script>
		</div>
				
		<div style="height:10px;"></div>
		
		<div>
			<input type="submit" value="修改项目" title="保存并跳转">
		</div>
		
		<div class="clear"></div>

		<div style="height:60px;"></div>
		</form>
	</div>
</body>
</html>