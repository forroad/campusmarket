<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>index</title>
    <script type="application/javascript">

    </script>
</head>
<body>
<h2>Hello World!</h2>
<a href="${path}/view/login">登录</a>
</body>
</html>
