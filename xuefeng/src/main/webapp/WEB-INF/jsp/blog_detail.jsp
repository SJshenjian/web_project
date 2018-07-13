<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html >

	<head>
		
		<link rel="stylesheet" type="text/css" href="http://www.xuefeng66.cn/xuefeng/resources/css/detail.css">
	 	<link rel="shorticon icon" type="image/x-icon" href="!">
		<style>
			html,
			* {
				-webkit-user-select: text!important;
				-moz-user-select: text!important;
			}
		</style>

		<title>沈健的博客</title>
		<style type="text/css">
			.fancybox-margin {
				margin-right: 17px;
			}
		</style>
	</head>

	<body lang="zh-Hans" style="background-color: rgb(242, 242, 242);">
		<!--[if lte IE 8]>
  <div style=' clear: both; height: 59px; padding:0 0 0 15px; position: relative;margin:0 auto;'>
    <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
      <img src="http://7u2nvr.com1.z0.glb.clouddn.com/picouterie.jpg" border="0" height="42" width="820"
           alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today or use other browser ,like chrome firefox safari."
           style='margin-left:auto;margin-right:auto;display: block;'/>
    </a>
  </div>
<![endif]-->

		<div class="container one-column page-post-detail">
			
			<main id="main" class="main">
				<div class="main-inner">
					<div id="content" class="content">
						<div id="posts" class="posts-expand">
							<article class="post post-type-normal" itemscope="" itemtype="http://schema.org/Article" style="opacity: 1; display: block; transform: translateY(0px);">
								<header class="post-header">
									<h1 class="post-title" itemprop="name headline">${blog.topic}</h1>
									<div class="post-meta" style="margin-top:8px;">
										<span class="post-time">发表于<time itemprop="dateCreated" datetime="2015-10-30T00:00:00+08:00" content="2015-10-30">${blog.date}</time>
          </span><span class="post-category">
              &nbsp; | &nbsp; 分类于
                  <a href="${pageContext.request.contextPath}/blog/${blog.type}" itemprop="url" rel="index">
                    <span itemprop="name">${blog.tag.name}</span>
										</a>
										</span>
										</span>
										<span class="post-comments-count">
                &nbsp; | &nbsp;              
										</span>
										<span id="">
        &nbsp; | &nbsp; 阅读量: ${blog.count}</span>
									</div>
								</header>

								<div class="post-body">
									<span ><p>${blog.content}</p></span>
								</div>

						<footer class="post-footer">
							<div class="post-tags">
								<a href="${pageContext.request.contextPath}/blog/${blog.type}" rel="tag">#${blog.tag.name}</a>
							</div>

						</footer>
						</article>
						
					</div>
				</div>	
				</div>
			</main>
			</div>
	</body>

</html>