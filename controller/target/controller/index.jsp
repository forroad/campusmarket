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
<%
    pageContext.forward("login.jsp");
%>
</body>
</html>
