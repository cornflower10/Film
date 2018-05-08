<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: jiangpw
  Date: 2018/5/7
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>笔记列表</title>
</head>
<body>
<c:forEach items="${notes}" var="n" varStatus="status">
    <tr>
        <td>${n.id}</td>
        <td>${n.userid}</td>
        <td>${n.content}</td>
        <td>${n.imgid}</td>
        <td>${n.likeid}</td>
    </tr>
</c:forEach>
</body>
</html>
