<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>我发布的商品</title>

		<link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/admin.css>"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="//static//AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css">

		<link href="<c:url value="//static//css/personal.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="//static//css/colstyle.css"/>" rel="stylesheet" type="text/css">

	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<!--<a href="#" target="_top" class="h">亲，请登录</a>-->
									<!--<a href="#" target="_top">免费注册</a>-->
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="${path}/view/shopping" target="_top" class="h">二手交易首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="${path}/view/index" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="${path}/view/mycart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span></a></div>
							</div>
							</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<!-- <li><img src="/images/logobig.png" /></li> -->
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-collection">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我发布的商品</strong></div>
						</div>
						<hr/>

						<div class="you-like">
						<div class="s-content">
							<c:forEach var="goods" items="${goodsList}">
								<div class="s-item-wrap">
									<div class="s-item">

										<div class="s-pic">
											<a href="#" class="s-pic-link">
												<img src="${path}/img/getImg?type=1&id=${goods.goodsId}"  alt="" title="" class="s-pic-img s-guess-item-img">
											</a>
										</div>
										<div class="s-info">
											<div style="text-align: center" class="s-title"><a href="#" title="" >${goods.goodsName}</a></div>
											<div class="s-price-box">
												<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">${goods.goodsNowPrice}</em></span>
											</div>
										</div>

									</div>
								</div>
							</c:forEach>
						</div>
						</div>

					</div>

				</div>
				<!--底部-->
				<div class="footer">
					
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="${path}/view/index">个人资料</a>
					</li>
					<li class="person">
						<a href="${path}/view/addshopping">发布商品</a>

					</li>
					<li class="person">
						<a href="${path}/view/myshopping">我的发布</a>

					</li>
					<li class="person">
						<a href="${path}/view/myorder">我的购买</a>

					</li>

					<li class="person">
						<a href="${path}/view/mycart">我的购物车</a>

					</li>
					

				</ul>

			</aside>
		</div>

	</body>

</html>