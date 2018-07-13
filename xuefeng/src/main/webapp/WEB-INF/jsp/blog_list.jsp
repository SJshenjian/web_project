
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>博客编辑</title>

	<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<link type="text/css" rel="Stylesheet"
		href="http://www.xuefeng66.cn/xuefeng/resources/css/admin_main.css">
	<!--new top-->
	<link rel="stylesheet"
		href="http://www.xuefeng66.cn/xuefeng/resources/css/index.css">
	<!--new top-->
	<!-- 分页辅助 -->
	<script
		src="http://www.xuefeng66.cn/xuefeng/resources/laypage/laypage.js"></script>
	<script>	
		$(function() {
			page();
		})
	
		function page() {
			var totalPage = $("#totalPage").val();
			var pageNum = $("#pageNum").val();
			var type = $("#blogType").val();
			laypage({
				cont : $('#page'), //容器。值支持id名、原生dom对象，jquery对象,
				pages : totalPage, ////通过后台拿到的总页数
				curr : pageNum, //当前页
				skip : true, //是否开启跳页
				skin : '#AF0000',
				groups : 3, //连续显示分页数
				jump : function(obj, first) { //点击页码触发的事件 
					if (first != true) { //是否首次进入页面  
						var pageNum = obj.curr; //获取点击的页码 						
						window.location.href = "${pageContext.request.contextPath}/blog/list?type="+type+"&pageNum=" + pageNum;
					}
				}
			});
		}
		
		function listBlog(){
			var type=$("#selType").val();
			window.location.href = "${pageContext.request.contextPath}/blog/list?type="+type+"&pageNum=1";
		} 
		 
	</script>

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
				<li id="tab_postedit" style="" class="active"><a href="${pageContext.request.contextPath}/blog/list?type=1&pageNum=1"><span>文章管理</span></a></li>
				<li><a href="#"><span>类别管理</span></a></li>
				<li><a href="#"><span>评论管理</span></a></li>
				<li><a href="${pageContext.request.contextPath}/project/list"><span>项目管理</span></a></li>
			</ul>
		</div>

		<div id="sel_div" class="h_status">
			类别：<select id="selType" style="background-color: rgb(242, 242, 242);" onchange="listBlog()">
				<c:forEach items="${tags}" var="tag">
					<c:choose>
						<c:when test="${tag.id == param.type}">
							<option	value="${tag.id}" selected="selected">${tag.name}&nbsp;&nbsp;&nbsp;&nbsp;</option>	
						</c:when>
						<c:otherwise>
							<option	value="${tag.id}" >${tag.name}&nbsp;&nbsp;&nbsp;&nbsp;</option>	
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>

		</div>
		<table id="lstBox" cellspacing="0">
			<tbody>
				<tr class="over">
					<th class="tdleft">标题</th>
					<th style="width:50px;">状态</th>
					<th style="width:50px;">阅读</th>
					<th style="width:50px;">评论</th>
					<th style="width:170px;">操作</th>
				</tr>
				
					<c:forEach items="${blogs}" var="blog">
						<tr class="">
							<td class="tdleft"><a href="${pageContext.request.contextPath}/blog/detail?id=${blog.id}" target="_blank">${blog.topic}</a><span
								class="gray">（${blog.date}）</span></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${blog.count}</td>
							<td>0</td>
							<td><a href="${pageContext.request.contextPath}/blog/modify?id=${blog.id}">编辑</a> | <a href="${pageContext.request.contextPath}/blog/delete?id=${blog.id}&type=${blog.type}" name="del">删除</a></td>
						</tr>
					</c:forEach>
		
			</tbody>
		</table>
		<div id="page" class="footer" style="float:right">
			<input type="hidden" value="${blogs.get(0).tag.totalPage}"
				id="totalPage"> <input type="hidden"
				value="${param.pageNum}" id="pageNum"> <input type="hidden"
				value="${blogs.get(0).type}" id="blogType">
		</div>
	</div>
</body>
</html>