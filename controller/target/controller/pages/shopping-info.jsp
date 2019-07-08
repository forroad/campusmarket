<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>商品详情</title>
    <link rel="icon" href="<c:url value="//static-2/img/page_icon.png"/>"/>
    <link type="text/css" href="<c:url value="//static/static2/css/home_page/header_and_nav.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="//static/static2/css/product/product_info.css"/>" rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value="//static/static2/js/jquery-1.12.4.js"/>"></script>
    <script type="text/javascript" src="<c:url value="//static/static2/js/home/header_model_js.js"/>"></script>
    <script type="text/javascript" src="<c:url value="//static/static2/js/publish/product_info.js"/>"></script>
    <link href="<c:url value="//static/AmazeUI-2.4.2/assets/css/admin.css>"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="//static//AmazeUI-2.4.2/assets/css/amazeui.css"/>" rel="stylesheet" type="text/css">

    <link href="<c:url value="//static//css/personal.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="//static//css/colstyle.css"/>" rel="stylesheet" type="text/css">

    <%--提示信息--%>
    <script type="application/javascript">
        if("${result}".length != 0){
            alert("${result}")
        }
    </script>
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
</div>
<header th:include="header :: copy"></header>
<div class="top_content">
    <div class="publish_product_div">
        <div class="product_img_div">
            <img src="${path}/img/getImg?type=1&id=${goods.goodsId}" class="product_img" th:src=""/>
        </div>
        <div class="product_info_div">
            <span class="what_info">商品名：</span>
            <input type="hidden" th:value="1" class="id"/>
            <span class="info_content">${goods.goodsName}</span><br/>
            <span class="what_info">数量：</span>
            <span class="info_content" th:text="">${goods.goodsNumber}</span><br/>
            <span class="what_info">售价：</span>
            <span class="info_content" th:text="">${goods.goodsNowPrice}</span><br/>
            <span class="what_info">详情：</span>
            <span class="info_content" th:text="">${goods.goodsContent}</span><br/>
            <div>
                <a href="${path}/detail/enshire?goodsId=${goods.goodsId}" style="float: left;" class="submit am-btn" th:value="">加入购物车</a>
                <a href="${path}/detail/purchase?goodsId=${goods.goodsId}" style="float: right;" class="submit am-btn" th:value="">直接购买</a>
            </div>
        </div>
        <form action="${path}/message/addmessage" method="post">
        <div class="publish_comment">
            <span>留言：</span><br/><br/>
            <input type="hidden" name="goodsId" value="${goods.goodsId}" class="token"/>
            <textarea class="comment_textarea" maxlength="122" placeholder="请输入留言内容" name="messageContent"></textarea>
            <button type="submit" class="send_comment_button">发表</button>
        </div>
        </form>
        <div class="comment_content">
            <c:forEach var="message" items="${messageList}">
                <div class="one_comment">
                <span class="username" >用户：${message.userId}</span>
                <span class="time">发表于：${message.messageTime}</span>
                <p class="content">${message.messageContent}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>