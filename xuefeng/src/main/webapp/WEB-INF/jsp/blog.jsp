<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
		<title>blog</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">


		<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script src="http://www.xuefeng66.cn/xuefeng/resources/js/bootstrap.js"></script>
		<link href="http://www.xuefeng66.cn/xuefeng/resources/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
		<!--
	作者：表单验证
	描述：
-->
		<link href="//cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

		<script type="application/x-javascript">
			addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);

			function hideURLbar() { window.scrollTo(0, 1); }
		</script>
		<!--[if lt IE 9]>
     <script src="http://www.xuefeng66.cn/xuefeng/resources/js/html5shiv.js"></script>
     <script src="http://www.xuefeng66.cn/xuefeng/resources/js/respond.min.js"></script>
<![endif]-->
		<link href="http://www.xuefeng66.cn/xuefeng/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
		<!----font-Awesome----->
		<link rel="stylesheet" href="http://www.xuefeng66.cn/xuefeng/resources/css/font-awesome.min.css">
		<!----font-Awesome----->
		<!-- my js -->
		<script src="http://www.xuefeng66.cn/xuefeng/resources/js/myjs/contactme.js"></script>
		<!-- 博客样式 -->
		<link rel="stylesheet" type="text/css" href="http://www.xuefeng66.cn/xuefeng/resources/css/blog.css">	
    
    	<!-- 分页辅助 -->
    	<script src="${pageContext.request.contextPath}/resources/laypage/laypage.js"></script>
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
					pages :totalPage, ////通过后台拿到的总页数
					curr : pageNum,//当前页
					skip : true, //是否开启跳页
					skin : '#AF0000',
					groups : 3, //连续显示分页数
					jump : function(obj, first) { //点击页码触发的事件 
						if (first != true) { //是否首次进入页面  
							var pageNum = obj.curr; //获取点击的页码 						
							window.location.href = "${pageContext.request.contextPath}/blog/"+type+"?pageNum=" + pageNum;
						}
					}
				});
			}
			
		</script>
		
	</head>

	<body >
		<div class="header_bg" id="home">
			<!-- start header -->
			<div class="container">
				<div class="row header text-center specials">
					<div class="h_logo">
						<a href="${pageContext.request.contextPath}/info"><img src="http://www.xuefeng66.cn/xuefeng/resources/images/logo.png" alt="" class="responsive" /></a>
					</div>
					<nav class="top-nav">
						<ul class="top-nav nav_list">
							<li>
								<a href="${pageContext.request.contextPath}/project/project">作品展</a>
							</li>
							<li class="page-scroll">
								<a href="${pageContext.request.contextPath}/blog/1">博客</a>
							</li>
							<li class="logo page-scroll">
								<a title="hexa" href="${pageContext.request.contextPath}/info"><img src="http://www.xuefeng66.cn/xuefeng/resources/images/logo.png" alt="" class="responsive" /></a>
							</li>
							<li class="page-scroll">
								<a href="${pageContext.request.contextPath}/info#about">关于我</a>
							</li>
							<li class="page-scroll">
								<a href="${pageContext.request.contextPath}/info#contact">联系我</a>
							</li>
						</ul>
						<a href="#" id="pull"><img src="http://www.xuefeng66.cn/xuefeng/resources/images/nav-icon.png" title="menu" /></a>
					</nav>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="blog">
			<!-- start main -->
			<div class="container">
				<div class="main row">
					<div class="col-md-8 blog_left">
						<div class="blog_main">

						<section id="posts" class="posts-collapse">
							<div class="collection-title">
								<h3 id="type">${blogs.get(0).tag.name}<small>分类</small>
								</h3>
							</div>
							
						    <c:forEach items="${blogs}" var="blog">
								<article class="post post-type-normal" itemscope="" itemtype="http://schema.org/Article" style="opacity: 1; display: block; transform: translateY(0px);">
									<header class="post-header">
	
										<h1 class="post-title">      
	           				 	<a href="${pageContext.request.contextPath}/blog/detail?id=${blog.id}">
	             						 <span >${blog.topic}</span>
	           				 	</a>     
	      						</h1>
										<div class="post-meta">
												<time class="post-time" datetime="2015-12-31T16:00:00.000Z" itemprop="dateCreated" content="2015-12-31"> ${blog.date} </time>
										</div>
									</header>
								</article>
							</c:forEach>
						</section>							 
						   
						</div>
					</div>
					<div class="col-md-4 blog_right">
						<ul class="tag_nav list-unstyled">
							<h4>分类</h4>
							<c:forEach  items="${tags}" var="tag">
								<li>
									<a href="${pageContext.request.contextPath}/blog/${tag.id}?pageNum=1">${tag.name}</a>
								</li>
							</c:forEach>							
							<div class="clearfix"></div>
						</ul>
					</div>
					
					<div class="clearfix"></div>
				</div>
				<div id="page" class="footer" style="float:right">
						<input type="hidden" value="${blogs.get(0).tag.totalPage}" id="totalPage" >
						<input type="hidden" value="${param.pageNum}" id="pageNum" >
						<input type="hidden" value="${blogs.get(0).type}" id="blogType" >
			</div>
			</div>
		</div>
		
		<!-- end main -->
		<div class="footer1_bg">
			<!-- start footer1 -->
			<div class="container">
				<div class="row  footer">
					<div class="copy text-center">
						<p class="link"><span>鲁ICP备16038578号-1&copy; 2016 xuefeng66.com All rights reserved.</span></p>
				<a href="#home" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"> </span></a>
					</div>
				</div>
				<!---- start-smoth-scrolling---->
			</div>
		</div>
	</body>

</html>