<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: jiangpw
  Date: 2018/5/17
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>笔记详情</title>
    <script src="../js/jQuery-2.1.4.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <link href="../css/noteDetail.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div id="myCarousel" class="carousel slide col-xs-6 col-md-6">
            <!-- 轮播（Carousel）指标 -->
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <c:forEach items="${imgs}" var="i" varStatus="status">
                    <c:choose>
                        <c:when test="${status.first}">
                            <div class="item active">
                                <img src="${i.url}">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="item">
                                <img src="${i.url}">
                            </div>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <img src="../img/left.png" alt="" class="tip">
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <img src="../img/next.png" alt="" class="tip">
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="tip col-xs-4 col-md-4">
            <div class="user">
                <div><h3>笔记作者</h3></div>
                <div class="line" style="border-bottom:1px solid #CCC"></div>
                <div class="userinfo">
                    <img class="head img-circle" src="${user.img}">
                    <div>${user.username}</div>
                </div>
            </div>
            <div class="other">
                <div><h3>相关笔记</h3></div>
                <div class="line" style="border-bottom:1px solid #CCC"></div>
            </div>
        </div>
    </div>
    <div><h3 style="font-weight: bold">笔记评论</h3></div>
    <div>
        <c:forEach items="${comments}" var="c" varStatus="status">
            <div class="row">
                <div class="item col-xs-6 col-md-6">
                    <div class="headIcon">
                        <img src="${c.user.img}" class="head img-circle">
                    </div>
                    <div class="commentMessage">
                        <div class="username">${c.user.username}</div>
                        <div class="createtime">${c.createtime}</div>
                        <div class="content">${c.content}</div>
                    </div>
                </div>
            </div>
            <div class="line" style="border-bottom:1px solid #CCC"></div>
        </c:forEach>
    </div>
</div>
</body>
</html>
