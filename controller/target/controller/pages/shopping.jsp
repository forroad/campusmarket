<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns:th="http://www.thymeleaf.org">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>首页</title>
		<link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/admin.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value="//static/basic/css/demo.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value="//static/css/hmstyle.css"/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value="//static/AmazeUI-2.4.2/assets/js/jquery.min.js"/>"> </script>
		<script type="text/javascript" src="<c:url value="//static/AmazeUI-2.4.2/assets/js/amazeui.min.js"/>"></script>
	</head>
	<body>
		<div class="hmtop">
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
					<div class="logo"><img src="<c:url value="//static/images/logo.png"/>" /></div>
					<div class="logoBig">
						<!-- <li><img src="../images/logobig.png" /></li> -->
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
			<div class="shopMainbg">
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>全部商品</h4>
						</div>
					</div>
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li th:each="line : ${list}">
								<div class="list ">
									<a >
										<img src="" th:src="${line.photo}" />
										<div class="pro-title " th:text="${line.title}">萨拉米 1+1小鸡腿</div>
										<span class="e-price " >￥<span th:text="${line.money}"></span></span><br>
										<a href="" th:href="'/index/addcart?id='+${line.id}" class="e-price ">添加到购物车</a>
									</a>
								</div>
							</li>
						</ul>
					</div>
					<div class="footer ">
					</div>
				</div>
		<script type="text/javascript" src="<c:url value="//static/basic/js/jquery.min.js "/>"></script>
		<script type="text/javascript " src="<c:url value="//static/basic/js/quick_links.js "/>"></script>
	</body>

</html>