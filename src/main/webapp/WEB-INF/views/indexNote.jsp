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
    <script src="../js/jQuery-2.1.4.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <link href="../css/indexNote.css" rel="stylesheet">
</head>
<body>
<c:forEach items="${notes}" var="n" varStatus="status">
    <div class="panel panel-info">
        <div class="panel-body">
            <img src="${n.imgs[0].url}" alt="..." class="img-thumbnail">
        </div>
        <div class="panel-footer">
            <label class="content">${n.content}</label>
            <div>
                <div class="user">
                    <span><img src="${n.user.img}" alt="..." class="head img-circle"></span>
                    <span>${n.user.username}</span>
                </div>
                <div class="favor">
                    <span> <img src="../img/favor.png" alt="..." class="favor_icon"></span>
                    <span>${n.favor.likecount}</span>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
