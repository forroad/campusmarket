<%@ page import="com.zhongruan.bean.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.springframework.ui.Model" %>
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
	<marquee style="margin-left: 20%;width: 60%;"><span style="font-weight: bolder;font-size: 18px;color: black;">${notice.noticeContent}</span></marquee>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo"><img src="<c:url value="//static/images/logo.png"/>" /></div>
		<div class="logoBig">
			<!-- <li><img src="../images/logobig.png" /></li> -->
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form action="${path}/shop/shopping">
				<input id="searchInput" name="goodsName" type="text" placeholder="搜索" autocomplete="off">
				<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
			</form>
		</div>
	</div>

	<div class="clear"></div>
</div>
<div class="shopMainbg">
	<div class="am-container ">
		<div class="shopTitle ">
			<h4><a href="${path}/view/shopping">全部商品</a></h4>
			<ul class="sss" style="line-height: 40px; margin-left: 20px; float: left;">
				<li><a href="${path}/goods/findGoodsByType?typeName=手机">手机</a></li>
				<li><a href="${path}/goods/findGoodsByType?typeName=电脑">电脑</a> </li>
				<li><a href="${path}/goods/findGoodsByType?typeName=配件">配件</a> </li>
				<li><a href="${path}/goods/findGoodsByType?typeName=电器">电器</a> </li>
				<li><a href="${path}/goods/findGoodsByType?typeName=书籍">书籍</a> </li>
				<li><a href="${path}/goods/findGoodsByType?typeName=娱乐">娱乐</a> </li>
				<li><a href="${path}/goods/findGoodsByType?typeName=运动">运动</a> </li>
			</ul>

			<span>
				价格排序
				<a href="${path}/goods/findByGoodsPriceDesc"><p>↓</p></a>
				<a href="${path}/goods/findByGoodsPriceAsc"><p>↑</p></a>
			</span>
			<span><a href="${path}/goods/findByGoodsPopularityDesc"> 热度排序💕</a></span>
		</div>
	</div>
	<div class="am-g am-g-fixed flood method3 ">
		<ul class="am-thumbnails ">
			<c:forEach var="goods" items="${goodsList}">
				<li class="list ">
					<a href="${path}/view/shopping-info?goodsId=${goods.goodsId}">
						<img src="${path}/img/getImg?type=1&id=${goods.goodsId}"/>
						<div class="good-title ">${goods.goodsName}</div>
						<span class="e-price " >￥<span>${goods.goodsNowPrice}</span></span>
						<br/><span>热度：<span></span>💕${goods.goodsPopularity}</span>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div style="margin-left: 46%;margin-bottom: 6px;">
		<a style="font-size: 20px;color:deeppink;" href="${path}/goods/page?pageNum=${pageNum - 1}">上一页</a>
		<a style="font-size: 20px;color:deeppink;" href="${path}/goods/page?pageNum=${pageNum + 1}">下一页</a>
	</div>
</div>
<script type="text/javascript" src="<c:url value="//static/basic/js/jquery.min.js "/>"></script>
<script type="text/javascript " src="<c:url value="//static/basic/js/quick_links.js "/>"></script>
</body>

</html>