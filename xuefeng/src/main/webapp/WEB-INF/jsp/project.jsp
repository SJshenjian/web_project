<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Hexa</title>
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="utf-8">

<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="http://www.xuefeng66.cn/xuefeng/resources/js/bootstrap.js"></script>
<link href="http://www.xuefeng66.cn/xuefeng/resources/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!--
	作者：表单验证
	描述：
-->
<link
	href="//cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"
	rel="stylesheet">
<script
	src="//cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

<script type="application/x-javascript">
	
			addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);

			function hideURLbar() { window.scrollTo(0, 1); }
		
</script>
<!--[if lt IE 9]>
     <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
<![endif]-->
<link href="http://www.xuefeng66.cn/xuefeng/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!----font-Awesome----->
<link rel="stylesheet" href="http://www.xuefeng66.cn/xuefeng/resources/css/font-awesome.min.css">
<!----font-Awesome----->
<!-- my js -->
<script src="http://www.xuefeng66.cn/xuefeng/resources/js/myjs/contactme.js"></script>
<!-- start light_box -->
<link rel="stylesheet" type="text/css" href="http://www.xuefeng66.cn/xuefeng/resources/css/jquery.fancybox.css"
	media="screen" />
<script type="text/javascript" src="http://www.xuefeng66.cn/xuefeng/resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="http://www.xuefeng66.cn/xuefeng/resources/js/jquery.fancybox-1.2.1.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$("div.fancyDemo a").fancybox();
		});
	</script>

</head>
<body>
	<div class="header_bg" id="home">
		<!-- start header -->
		<div class="container">
			<div class="row header text-center specials">
				<div class="h_logo">
					<a href="${pageContext.request.contextPath}/info">
						<img src="http://www.xuefeng66.cn/xuefeng/resources/images/logo.png" alt="" class="responsive" />
					</a>
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
					<a href="#" id="pull">
						<img src="http://www.xuefeng66.cn/xuefeng/resources/images/nav-icon.png" title="menu" />
					</a>
				</nav>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="container">
		<!-- start main -->
		<div class="main row">
			<h2 class="style">项目列表</h2>
			<div class="grids_of_4 row">				
			   <c:forEach items="${projects}" var="project">
					<div class="col-md-3 images_1_of_4">
						<div class="fancyDemo">
							<a rel="group" title="" href="">
								<img src="${project.img}" alt="" class="img-responsive" style="height:250px;width:250px" />
							</a>
						</div>
						<h3>
							<a href="${pageContext.request.contextPath}/project/detail?id=${project.id}">活久见!一键拥有玛莎拉蒂!</a>
						</h3>
						<p class="para">${project.descript}</p>
						<h4>
							<a href="${project.url}">查看演示</a>
						</h4>
					</div>
					<div class="clear"></div>	
				</c:forEach>				
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
					<a href="#home" id="toTop" style="display: block;">
						<span id="toTopHover" style="opacity: 1;"> </span>
					</a>
				</div>
			</div>
			
			<!---- start-smoth-scrolling---->
		</div>
	</div>

</body>
</html>