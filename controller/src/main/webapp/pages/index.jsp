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

		<title>个人资料</title>

		<link href="<c:url value = "//static/AmazeUI-2.4.2/assets/css/admin.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value = "//static/AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css">

		<link href="<c:url value = "//static/css/personal.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value = "//static/css/infstyle.css"/>" rel="stylesheet" type="text/css">
		<script src="<c:url value = "//static/AmazeUI-2.4.2/assets/js/jquery.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "//static/AmazeUI-2.4.2/assets/js/amazeui.js"/>" type="text/javascript"></script>
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
									<!--<a href="#" target="_top" class="h">您好，请登录</a>-->
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
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                
							</ul>
						   
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-info">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
						</div>
						<hr/>

						<!--个人信息 -->
						<div style="margin-left: 5px" class="info-main">
							<form action="${path}/account/modifyUser"  method="post" class="am-form am-form-horizontal">

								<div class="am-form-group">
									<label for="userAccount" class="am-form-label">用户名</label>
									<div class="am-form-content">
										<p id="userAccount">${user.userAccount}</p>
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-name2" class="am-form-label">姓名</label>
									<div class="am-form-content">
										<input type="text" name="userRealName" id="user-name2" placeholder="${user.userRealName}">
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-password" class="am-form-label">密码</label>
									<div class="am-form-content">
										<input type="password" name="userPassword" id="user-password" placeholder="新密码">
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-telephone" class="am-form-label">电话号码</label>
									<div class="am-form-content">
										<input type="text" name="userTelephone" id="user-telephone" placeholder="${user.userTelephone}">
									</div>
								</div>



								<div class="am-form-group">
									<label for="user-address" class="am-form-label">地址</label>
									<div class="am-form-content">
										<input name="address" id="user-address" placeholder="${user.address}" type="text">
									</div>
								</div>
								
								
								<div class="info-btn">
									<input type="submit" value="保存修改" class="am-btn am-btn-danger"/>
								</div>

							</form>
						</div>

					</div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						
					</div>
					
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