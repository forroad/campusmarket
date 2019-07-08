<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>
<%
pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="<c:url value= "//static/AmazeUI-2.4.2/assets/css/amazeui.css"/>" />
		<link href="<c:url value= "//static/css/dlstyle.css"/>" rel="stylesheet" type="text/css">
		<%--提示信息--%>
		<script type="application/javascript">
			if("${result}".length != 0){
				alert("${result}")
			}
		</script>
		<script type="application/javascript">
			function getSysCode() {
				var img = document.getElementById("sysCode");
				img.src="${path}/img/getSyscode?param=" + Math.random();
			}
		</script>
	</head>

	<body>

		<div class="login-boxtitle">
			<!--<a href="/home/home.html"><img alt="logo" src="/images/logobig.png" /></a>-->
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="<c:url value= "//static/images/big.jpg"/>" /></div>
				<form action="${path}/account/login" method="post">
				<div class="login-box">

							<h3 class="title">登录</h3>

							<div class="clear"></div>
						
						<div class="login-form">
							<div class="user-name">
								    <label for="email"><i class="am-icon-user"></i></label>
								    <input type="text" name="userAccount" id="email" placeholder="请输入账号">
                 </div>
                 <div class="user-pass">
					<label for="password"><i class="am-icon-lock"></i></label>
					<input type="password" name="userPassword" id="password" placeholder="请输入密码">
                 </div>

				 <div class="user-pass">
				 	 <label for="sysCode_input"><i class="am-icon-lock"></i></label>
				 	 <input type="text" style="width: 60%;float: left" name="sysCode" id="sysCode_input" placeholder="请输入验证码">
					 <img id="sysCode" style="margin-left: 20px" class="sysCode" alt="sysCode" src="${path}/img/getSyscode" onclick="getSysCode()" >
				 </div>
           </div>
            
            <div class="login-links">
            </div>
					<div class="am-cf">
						<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
					</div>
					<div class="am-cf">
						<input type="button" onclick="location.href='${path}/view/register';" name="" value="注册" class="am-btn am-btn-primary am-btn-sm">
					</div>
			</div>
				</form>
			</div>
		</div>
	</body>
</html>