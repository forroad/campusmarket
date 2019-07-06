<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%><!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>订单管理</title>

		<link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/admin.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css">

		<link href="<c:url value="//static/css/personal.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="//static//css/orstyle.css"/>" rel="stylesheet" type="text/css">

		<script src="<c:url value="//static/AmazeUI-2.4.2/assets/js/jquery.min.js"/>"></script>
		<script src="<c:url value="//static/AmazeUI-2.4.2/assets/js/amazeui.js"/>"></script>

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

					<div class="user-order">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-amount">

										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											
											<!--交易成功-->
											<div class="order-status5">
												<div class="order-title">
												<!-- 	<div class="dd-num">订单编号：<a href="javascript:;">1601430</a></div>
													<span>成交时间：2015-12-20</span> -->
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<c:forEach var="goods" items="${goodsList}">

														<div class="order-left">
															<ul class="item-list">
																<li class="td td-item">
																	<div style="vertical-align: middle;" class="item-pic">
																		<a href="#"   class="J_MakePoint">
																			<img src="${path}/img/getImg?type=1&id=${goods.goodsId}" class="itempic J_ItemImg">
																		</a>
																	</div>
																	<div style="margin-left: 195px" class="item-info">
																		<div class="item-basic-info">
																			<a href="#">
																				<p>${goods.goodsName}</p>
																				<p class="info-little">${goods.goodsContent}</p>
																			</a>
																		</div>
																	</div>
																</li>
																<li style="text-align: center" class="td td-price">
																	<div  class="item-price">${goods.goodsNowPrice}</div>
																</li>
																<li class="td td-number">
																	<div class="item-number">
																		<span>×</span>1
																	</div>
																</li>
															</ul>
														</div>
														<div class="order-right">
															<li class="td td-amount">
																<div style="text-align: center" class="item-amount">
																	<p>合计：<span>${goods.goodsNowPrice}</span></p>
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div style="text-align: center" class="item-status">
																		<p class="Mystatus">交易成功</p>
																	</div>
																</li>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
											
										</div>

									</div>

								</div>
							
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