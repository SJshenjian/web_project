<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
		<title>video</title>

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
     <script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
<![endif]-->
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
		<!----font-Awesome----->
		<link rel="stylesheet" href="http://www.xuefeng66.cn/xuefeng/resources/css/font-awesome.min.css">
		<!----font-Awesome----->
		<!-- my js -->
		<script src="http://www.xuefeng66.cn/xuefeng/resources/js/myjs/contactme.js"></script>

		<!-- 视频播放插件 -->
		<link href="http://vjs.zencdn.net/5.0.2/video-js.css" rel="stylesheet">
    	<script src="http://vjs.zencdn.net/ie8/1.1.0/videojs-ie8.min.js"></script>
   		 <script src="http://vjs.zencdn.net/5.0.2/video.js"></script>
	</head>

	<body>
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
					<div class="col-md-11 blog_left" style="margin-left:140px">
						<h3>${blog.topic}</h3>
						<div class="blog_main">
						    <!-- 540 264 -->
							<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="540" height="264" poster="${pageContext.request.contextPath}/resources/images/video/sister.png" data-setup="{}">
    <source src="${blog.content}" type="video/mp4">
    <!-- <source src="http://www.xuefeng66.cn/resources/video/sister.webm" type="video/webm">
    <source src="http://www.xuefeng66.cn/resources/video/sister.ogv" type="video/ogg"> -->
    <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
  							</video>
						</div>
					</div>					
					<div class="clearfix"></div>
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