<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>退换货</title>

		<link href="<c:url value= "//static/AmazeUI-2.4.2/assets/css/admin.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value= "//static/AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css">

		<link href="<c:url value= "//static/css/personal.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value= "//static/css/refstyle.css"/>" rel="stylesheet" type="text/css">

		<script src="<c:url value= "//static/AmazeUI-2.4.2/assets/js/jquery.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value= "//static/AmazeUI-2.4.2/assets/js/amazeui.js"/>" type="text/javascript"></script>


		<%--提示信息--%>
		<script type="application/javascript">
			if("${result}".length != 0){
				alert("${result}")
			}
		</script>
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
							</div></ul>
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
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">发布商品</strong><small></small></div>
					</div>
					<hr/>
					<div class="comment-list">
					<!--进度条-->
					
					
					
				<form enctype="multipart/form-data" method="post" action="${path}/goods/addGoods">
						<div class="refund-main">
							<div class="item-comment">
								<div class="am-form-group">
									<label for="goods-name" class="am-form-label">商品名称<span></span></label>
									<div class="am-form-content">
										<input id="goods-name" type="text" name="goodsName"/>
									</div>
								</div>
								<div class="am-form-group">
									<label for="goods-type" class="am-form-label">商品类型<span></span></label>
									<div class="am-form-content">
										<select id="goods-type" style="width: 100%;min-height: 32px;" name="typeName">
											<option value="手机">手机</option>
											<option value="电脑">电脑</option>
											<option value="配件">配件</option>
											<option value="电器">电器</option>
											<option value="书籍">书籍</option>
											<option value="娱乐">娱乐</option>
											<option value="运动">运动</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label for="goods-number" class="am-form-label">商品数量<span></span></label>
									<div class="am-form-content">
										<input id="goods-number" type="text" name="goodsNumber">
									</div>
								</div>

								<div class="am-form-group">
									<label for="refund-money" class="am-form-label">商品价格<span></span></label>
									<div class="am-form-content">
										<input id="refund-money" type="text" name="goodsNowPrice">
									</div>
								</div>
								<div class="am-form-group">
									<label for="goods-info" class="am-form-label">商品介绍<span></span></label>
									<div class="am-form-content">
										<textarea id="goods-info" placeholder="" name="goodsContent"></textarea>
									</div>
								</div>
								<div class="am-form-group">
									<label for="goods-img" class="am-form-label">商品图片<span></span></label>
									<div class="am-form-content">
										<input id="goods-img" type="file" name="file">
									</div>
								</div>
							</div>
<%--							<div class="refund-tip">--%>
<%--								<div class="filePic">--%>
<%--									<input type="file" class="inputPic" value="选择图片" name="file" max="5" maxsize="5120" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">--%>
<%--									<img src="<c:url value="//static/images/image.jpg"/>" alt="" name="photo">--%>
<%--								</div>--%>
<%--								<span class="desc">上传商品图片</span>--%>
<%--							</div>--%>
							<div class="info-btn">
								<button type="submit" class="am-btn am-btn-danger">发布</button>
							</div>
						</div>
				</form>
					</div>

					<div class="clear"></div>
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