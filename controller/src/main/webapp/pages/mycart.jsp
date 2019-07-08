<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>购物车页面</title>

	<link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="//static/basic/css/demo.css"/>"rel="stylesheet" type="text/css" />
	<link href="<c:url value="//static/css/cartstyle.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="//static/css/optstyle.css"/>" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="<c:url value="//static/js/jquery.js"/>"></script>

	<%--提示信息--%>
	<script type="application/javascript">
		if("${result}".length != 0){
			alert("${result}")
		}
	</script>
</head>

<body>

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
	<div class="logo"><img src="<c:url value="//static/images/logo.png"/>" /></div>
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

<!--购物车 -->
<div class="concent">
	<div id="cartTable">
		<div class="cart-table-th">
			<div class="wp">
				<div class="th th-chk">
					<div id="J_SelectAll1" class="select-all J_SelectAll">

					</div>
				</div>
				<div class="th th-sum">
					<div class="td-inner">商品信息</div>
				</div>
				<div class="th th-sum">
					<div class="td-inner">金额</div>
				</div>
				<div class="th th-op">
					<div class="td-inner">操作</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>


		<div class="clear"></div>

		<tr class="item-list">
			<div class="bundle  bundle-last ">
				<div class="bundle-hd">
					<div class="bd-promos">

						<span class="list-change theme-login">编辑</span>
					</div>
				</div>
				<div class="clear"></div>
				<div class="bundle-main">

					<c:forEach var="enshrine" items="${enshrineList}">
						<p>${enshrine.goodsId}</p>
						<ul class="item-content clearfix">
							<li class="td td-chk">
								<div class="cart-checkbox ">
									<input class="check" id="J_CheckBox_170769542747" name="items[]" value="170769542747" type="checkbox">
									<label for="J_CheckBox_170769542747"></label>
								</div>
							</li>
							<li class="td td-item">
								<div class="item-pic">
									<a href="#" target="_blank" data-title="" class="J_MakePoint" data-point="tbcart.8.12">
										<img src="${path}/img/getImg?type=1&id=${enshrine.goodsId}" class="itempic J_ItemImg"></a>
								</div>
								<div class="item-info">
									<div class="item-basic-info">
										<a href=""  class="item-title J_MakePoint" data-point="tbcart.8.11">${enshrine.goodsName}</a>
									</div>
								</div>
							</li>

							<li class="td td-price">
								<div class="item-price price-promo-promo">
									<div class="price-content">

										<div class="price-line">
											<em class="J_Price price-now" tabindex="0" >${enshrine.goodsNowPrice}</em>
										</div>
									</div>
								</div>
							</li>

							<li class="td td-op">
								<div class="td-inner">
									<a style="color: red" href="${path}/Enshrine/delEnshrineGoods?goodsId=${enshrine.goodsId}"  class="delete">删除</a>
								</div>
							</li>
							<li class="td td-op">
								<div class="td-inner">
									<a style="color: green" href="${path}/goods/buyGoods?goodsId=${enshrine.goodsId}">结算</a>
								</div>
							</li>


						</ul>
					</c:forEach>

				</div>
			</div>
		</tr>
	</div>
	<div class="clear"></div>

	<div class="float-bar-wrapper">
		<div id="J_SelectAll2" class="select-all J_SelectAll">
			<div class="cart-checkbox">
				<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
				<label for="J_SelectAllCbx2"></label>
			</div>
			<!-- <span>全选</span> -->
		</div>
		<div class="operations">
			<!-- <a href="#" hidefocus="true" class="deleteAll">删除</a> -->
			<!-- <a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a> -->
		</div>
		<div class="float-bar-right">
			<div class="amount-sum">
				<!-- <span class="txt">已选商品</span> -->
				<!-- <em id="J_SelectedItemsCount">0</em><span class="txt">件</span> -->
				<div class="arrow-box">
					<span class="selected-items-arrow"></span>
					<span class="arrow"></span>
				</div>
			</div>
			<div class="price-sum">
				<!-- <span class="txt">合计:</span> -->
				<!-- <strong class="price">¥<em id="J_Total">0.00</em></strong> -->
			</div>
			<div class="btn-area">
				<a onclick="fun()" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
					<span>结&nbsp;算</span></a>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		function fun() {
			var flag = confirm("是否确认购买？");
			if (flag==true){
				location.href = '${path}/pages/shopping';
			}
		}

	</script>

	<div class="footer">

	</div>

</div>

<!--操作页面-->




</body>

</html>