
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>博客编辑</title>

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
				<li id="tab_postedit" style="" class="active"><a href="${pageContext.request.contextPath}/blog/index"><span>发表文章</span></a></li>
				<li><a href="${pageContext.request.contextPath}/blog/list"><span>文章管理</span></a></li>
				<li><a href="#"><span>类别管理</span></a></li>
				<li><a href="#"><span>评论管理</span></a></li>
				<li><a href="${pageContext.request.contextPath}/project/list"><span>项目管理</span></a></li>
			</ul>
		</div>

		<form action="${pageContext.request.contextPath}/blog/add" method="post" >
		<div id="editType" style="display:none">0</div>
		<p class="subtit">文章标题</p>
		<div>
			<input type="text" name="topic"
				style="width: 560px; height: 20px; background-color: rgb(242, 242, 242);"
				maxlength="100">
		</div>


		<p class="subtit">文章内容</p>
		<div style="height:2px;"></div>

		<div style="width:700px">
		
		<!-- 加载编辑器的容器 -->
			<script id="container" name="content" type="text/plain">
				
			</script>
		
			<!-- 配置文件 -->
			<!-- <script type="text/javascript"
				src="http://www.xuefeng66.cn/xuefeng/resources/ueditor/ueditor.config.js"></script> -->
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
			
			<!-- 编辑器源码文件 -->
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.js"></script>
			<!-- 实例化编辑器 -->			
		    <script type="text/javascript">
		        var ue = UE.getEditor('container'); 
		    </script>
		</div>
		<div id="moreDiv">
			<p>
				文章分类 [<a href="#" target="_blank">编辑分类</a>]
			</p>
			<div class="radioBox channel" style="margin-top:4px">
				<c:forEach var="tag" items="${tags}">								
					<input type="radio" name="type"  value="${tag.id}"><label>${tag.name}</label>
				</c:forEach>
			</div>

		</div>

		<div style="height:10px;"></div>
		<div>
			<input type="submit" value="发表文章" title="保存并跳转">
		</div>
		
		<div class="clear"></div>

		<div style="height:60px;"></div>
		</form>
	</div>
</body>
</html>