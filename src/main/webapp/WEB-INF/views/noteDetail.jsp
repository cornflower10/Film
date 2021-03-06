<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="../../js/jQuery-2.1.4.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
    <link href="../../css/noteDetail.css" rel="stylesheet">
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
                <img src="../../img/left.png" alt="" class="tipfangxiang">
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <img src="../../img/next.png" alt="" class="tipfangxiang">
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="tip col-xs-4 col-md-4">
            <div class="user">
                <div style="margin: 10px"><h3>笔记作者</h3></div>
                <div class="line" style="border-bottom:1px solid #CCC"></div>
                <div class="userinfo">
                    <img class="head img-circle" src="${user.img}">
                    <div>${user.username}</div>
                </div>
            </div>
            <div class="other">
                <div style="margin: 10px"><h3>相关笔记</h3></div>
                <div class="line" style="border-bottom:1px solid #CCC"></div>
                <c:forEach items="${notes}" var="s" varStatus="ssta">
                    <div class="otherNote" onclick="toDetail('${s.id}','${user.id}')">
                        <div><img src="${s.imgs[0].url}" class="otherNoteImg thumbnail"></div>
                        <div class="otherNoteContent">${s.content}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div><h3 style="font-weight: bold">笔记内容</h3></div>
    <div class="noteContent">
        ${note.content}
    </div>
    <div><h3 style="font-weight: bold">笔记评论</h3></div>
    <div class="reply_area">
        <img src="${user.img}" class="currentUser img-circle">
        <div class="col-sm-10">
            <textarea class="form-control" rows="4" id="replyContent" placeholder="写下你的评论"></textarea>
        </div>
        <div class="replySend">
            <div class="cancel">取消</div>
            <div class="send" onclick="sendComment('${note.id}')">发送</div>
        </div>
    </div>
</div>
<div class="container">
    <c:forEach items="${comments}" var="c" varStatus="status">
        <div class="row">
            <div class="item col-xs-6 col-md-6">
                <div class="headIcon">
                    <img src="${c.user.img}" class="head img-circle">
                </div>
                <div class="commentMessage">
                    <div class="username">${c.user.username}</div>
                    <div class="createtime"><fmt:formatDate value="${c.createtime}"
                                                            pattern="yyyy/MM/dd HH:mm:SS"/></div>
                    <div class="content">${c.content}</div>
                    <div class="replyArea" onclick="reply(${c.id},'${c.user.username}', '${c.user.id}')"><img
                            src="../../img/reply.png"
                            class="img-circle"> 回复
                    </div>
                </div>
            </div>
        </div>
        <c:forEach items="${c.replies}" var="r" varStatus="rsta">
            <div class="reply">
                <div class="replyuser">${r.user.username}回复${r.user1.username}:</div>
                <div class="replycontent">${r.replaycontent}</div>
            </div>
            <div class="replyArea reply_other" onclick="reply(${c.id} ,'${r.user.username}', '${r.user.id}')"><img
                    src="../../img/reply.png"
                    class="img-circle">
                回复
            </div>
        </c:forEach>

        <div class="reply_area_other" id="${c.id}" style="display: none">
            <div class="col-sm-10">
                <textarea class="form-control" rows="2" id="${c.id}ReplyOtherContent"></textarea>
                <input type="text" style="visibility: hidden" id="${c.id}Hid">
            </div>
            <div class="replySendOther">
                <div class="cancel">取消</div>
                <div class="send" onclick="sendReply('${c.id}')">发送</div>
            </div>
        </div>
        <div class="line" style="border-bottom:1px solid #CCC"></div>
    </c:forEach>
</div>
</div>
<script>
    $(function () {
        $('#replyContent').focus(function () {
            $(".replySend").hide();
        }).blur(function () {
            $(".replySend").show();
        });
    })

    function sendComment(noteid) {
        var content = $("#replyContent").val();

        if (content.length < 1) {
            alert("请输入回复内容");
        } else {
            $.ajax({
                url: "/comment/addComment",
                data: {
                    noteId: noteid,
                    content: content,
                },
                type: "POST",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    if (data.success) {
                        window.location.reload();
                    } else {

                    }
                },
                error: function (data) {

                }
            })
        }
    }

    function sendReply(commentId) {
        var toUserId = $('#' + commentId + 'Hid').val();
        var content = $('#' + commentId + 'ReplyOtherContent').val();

        if (content.length < 1) {
            alert("请输入回复内容");
        } else {
            $.ajax({
                url: "/reply/addReply",
                data: {
                    commentId: commentId,
                    toUserId: toUserId,
                    content: content
                },
                type: "POST",
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        window.location.reload();
                    } else {

                    }
                },
                error: function (data) {

                }
            })
        }
    }

    function reply(id, username, toUserId) {
        if ($('#' + id).is(":hidden")) {
            $('#' + id).show();
            $('#' + id + 'ReplyOtherContent').attr('placeholder', "回复" + username);
            $('#' + id + 'Hid').val(toUserId);
        } else {
            $('#' + id).hide();
            $('#' + id + 'ReplyOtherContent').attr('placeholder', "");
        }

    }

    function toDetail(id, userid) {
        location.href = "noteDetail?id=" + id + "&userid=" + userid;
    }
</script>
</body>
</html>
