<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>Home</title>

		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">

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
		<link rel="stylesheet" href="http://www.xuefeng66.cn/xuefeng/resources/fonts/css/font-awesome.min.css">
		<!----font-Awesome----->
		<!-- my js -->
		<script src="http://www.xuefeng66.cn/xuefeng/resources/js/myjs/contactme.js"></script>
		<script src="http://www.xuefeng66.cn/xuefeng/resources/layer/layer.js"></script>
		<script src="http://www.xuefeng66.cn/xuefeng/resources/laypage/laypage.js"></script>
		<script type="text/javascript">
			function tip() {
					var tips = $('#tips').val();
					if(tips.length > 2){	
						layer.msg(tips, {
			 			 offset: 't',
			 		 	anim: 10
						}); 
					}
				}
		</script>
		
	</head>

	<body onload="tip()">
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
								<a href="${pageContext.request.contextPath}/project/project?pageNum=1">作品展</a>
							</li>
							<li class="page-scroll">
								<a href="${pageContext.request.contextPath}/blog/1?pageNum=1">博客</a>
							</li>
							<li class="logo page-scroll">
								<a title="hexa" href="${pageContext.request.contextPath}/info"><img src="http://www.xuefeng66.cn/xuefeng/resources/images/logo.png" alt="" class="responsive" /></a>
							</li>
							<li class="page-scroll">
								<a href="#about">关于我</a>
							</li>
							<li class="page-scroll">
								<a href="#contact">联系我</a>
							</li>
						</ul>
						<a href="#" id="pull"><img src="http://www.xuefeng66.cn/xuefeng/resources/images/nav-icon.png" title="menu" /></a>
					</nav>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="slider_bg">
			<!-- start slider -->
			<div class="container">
				<div class="row slider">
					<div class="wmuSlider example1">
						<!-- start wmuSlider example1 -->
						<div class="wmuSliderWrapper">
							<article style="position: absolute; width: 100%; opacity: 0;">
								<div class="slider_img text-center">
								    <input type="hidden" value="${success}" id="tips" />
									<ul class="list-unstyled list_imgs">
										<li><img src="http://www.xuefeng66.cn/xuefeng/resources/images/slider.jpg" alt="" class="responsive" /></li>
									</ul>
								</div>
							</article>
							<article style="position: relative; width: 100%; opacity: 1;">
								<div class="slider_img text-center">
									<input type="hidden" value="${success}" id="tips" />
									<ul class="list-unstyled list_imgs">
										<li><img src="http://www.xuefeng66.cn/xuefeng/resources/images/slider1.jpg" alt="" class="responsive" /></li>
									</ul>
								</div>
							</article>
						</div>
						<ul class="wmuSliderPagination">
							<li>
								<a href="#" class="">0</a>
							</li>
							<li>
								<a href="#" class="">1</a>
							</li>
						</ul>
						<script src="http://www.xuefeng66.cn/xuefeng/resources/js/jquery.wmuSlider.js"></script>
						<script>
							$('.example1').wmuSlider();
						</script>
					</div>
					<!-- end wmuSlider example1 -->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="main_bg" id="about">
			<!-- start about us -->
			<div class="container">
				<div class="row about">
					<div class="col-md-3 about_img">
						<img src="http://www.xuefeng66.cn/xuefeng/resources/images/user.jpg" alt="" class="responsive" />
					</div>
					<div class="col-md-9 about_text">
						<h3>${user.name}</h3>
						<h4>${user.signature}</h4>
						<p>${user.resume}</p>
						<p>联系方式:&nbsp;&nbsp;${user.mobile} &nbsp;&nbsp; 电子邮箱:&nbsp;&nbsp;${user.email}</p>
						<div class="soc_icons navbar-right">
							<ul class="list-unstyled text-center">
								<!-- <li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
					<li><a href="#"><i class="fa fa-pinterest"></i></a></li> 
					<li><a href="tencent://AddContact/?fromId=45&fromSubId=1&subcmd=all&uin=1515345281"><i class="fa fa-linkedin"></i></a></li>
					<li><a href="#"><i class="fa fa-dribbble"></i></a></li>-->
								<li>
									<a href="tencent://AddContact/?fromId=45&fromSubId=1&subcmd=all&uin=1515345281"><i class="fa fa-qq"><img alt="" src="http://www.xuefeng66.cn/xuefeng/resources/images/qq.jpg"></i></a>
								</li>
								<!-- <li><a href="#"><i class="fa fa-qq"><img alt="" src="images/weixin.jpg"></i></a></li> -->
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer_bg" id="contact">
			<!-- start footer -->
			<div class="container">
				<div class="row footer">
					<div class="col-md-8 contact_left">
						<h3>联系我</h3>
						<p>如果您有什么想法，欢迎和我讨论:</h4>
							<form method="post" action="${pageContext.request.contextPath}/contact">
								<div class="form-group">
									<input class="form-control" type="text" placeholder="您的姓名" name="name" />
								</div>
								<div class="form-group">
									<input class="form-control" type="text" placeholder="您的电子邮箱" name="email" />
								</div>
								<div class="form-group">
									<input class="form-control" type="text" placeholder="主题" name="subject" />
								</div>
								<div class="form-group">
									<textarea class="form-control" placeholder="您的留言。。。" name="content"></textarea>
								</div>
								<div class="form-group">
									<span class="pull-right"><input class="btn btn-primary" type="submit" value="发送"></span>
								</div>
							</form>
					</div>
					<div class="col-md-4  contact_right">
						<!--<p><span>Lorem Ipsum is simply dummy text: </span> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. </p>-->
						<!--<ul class="list-unstyled address">
				<li><i class="fa fa-map-marker"></i><span>500 Lorem Ipsum Dolor Sit,</span></li>
				<li><i class="fa fa-phone"></i><span>(00) 222 666 444</span></li>
				<li><i class="fa fa-envelope"></i><a href="mailto:info@mycompany.com">info(at)mycompany.com</a></li>-->
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="footer1_bg">
			<!-- start footer1 -->
			<div class="container">
				<div class="row  footer">
					<div class="copy text-center">
						<p class="link"><span>鲁ICP备16038578号-1&copy; 2016 xuefeng66.com All rights reserved.</p>
				<a href="#home" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"> </span></a>
					</div>
				</div>
				<!--<script type="text/javascript">
					$(function() {
						$('a[href*=#]:not([href=#])').click(function() {
							if(location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {

								var target = $(this.hash);
								target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
								if(target.length) {
									$('html,body').animate({
										scrollTop: target.offset().top
									}, 1000);
									return false;
								}
							}
						});
					});
				</script>-->
				<!---- start-smoth-scrolling---->
			</div>
		</div>

	</body>

</html>

</html>