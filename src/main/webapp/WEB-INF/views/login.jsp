<%--
  Created by IntelliJ IDEA.
  User: jiangpw
  Date: 2018/5/7
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="webctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>登录</title>
    <script src="${webctx}/js/jquery-1.11.2.js"></script>
    <link href="${webctx}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${webctx}/js/bootstrap.min.js"></script>
    <link href="${webctx}/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-4 col-centered">
            <form method="post" action="##" id="login" onsubmit="return false">
                <div class="form-group input-group-md">
                    <input type="text" class="form-control" id="login-phone" placeholder="手机号码"/>
                </div>
                <div class="form-group input-group-md">
                    <input type="password" class="form-control" id="passwd" placeholder="密码"/>
                </div>

                <div class="form-group input-group-md" id="verifycode">
                    <input type="text" name="code" class="page-input" placeholder="验证码" id="val-code"/>
                    <img src="${webctx}/validateCode" alt="" style="width: 80px;height: 35px" id="verifyCodeImg"
                         onclick='changeVerifyCode()'/>
                </div>
                <div class="input-group input-group-md pull-right">
                    <label>
                        <a id="forget" href="/user/regist">忘记密码</a>
                        <a id="regist" href="/user/regist">注册</a>
                    </label>
                </div>
                <button type="submit" class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".btn-success").click(function () {
            var phone = $("#login-phone").val();
            var passwd = $("#passwd").val();
            var val = $("#val-code").val();
            var regPhone = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0135678]|18[0-9]|14[579]|852|853)[0-9]{8}$/;
            if (!regPhone.test(phone)) {
                $("#login-tip").html("请输入正确的手机号")
                return;
            }
            else if (passwd.length < 1) {
                $("#login-tip").html("请输入登录密码")
                return;
            } else if (val.length < 1) {
                $("#login-tip").html("请输入验证码")
                return;
            }
            else {
                $("#login-tip").html("");
            }

            $.ajax({
                url: "/user/doLogin",
                data: {
                    phone: phone,
                    password: passwd,
                    val: val
                },
                type: "POST",
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        window.location = "/note/indexNote";
                    } else {
                        if (data.code == "99") {
                            window.location = "/user/check";
                        } else
                            $("#login-tip").html(data.msg);
                    }
                },
                error: function (data) {
                    $("#login-tip").html(data.msg);
                }
            })

        });
    })

    function changeVerifyCode() {
        $("#verifyCodeImg").attr("src", "${webctx}/validateCode?" + Math.random());
    }
</script>
</body>
</html>
