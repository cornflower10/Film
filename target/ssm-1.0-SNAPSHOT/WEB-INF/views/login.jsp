<%--
  Created by IntelliJ IDEA.
  User: jiangpw
  Date: 2018/5/7
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="../js/jQuery-2.1.4.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>

<form action="/user/login" method="post">
    手机号：<input type="number" name="phone">
    密码：<input type="password" name="password">
    <input type="submit" class="btn btn-success" value="登录">
</form>

</body>
</html>
