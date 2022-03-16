<%--
  Created by IntelliJ IDEA.
  User: 13017
  Date: 2022/3/16
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="<c:url value='/login'/>">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
<a href="${pageContext.request.contextPath}/insertPage" rel="external nofollow" >注册</a>
</body>
</html>
