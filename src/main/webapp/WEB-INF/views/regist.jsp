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
    <title>注册</title>
    <script src="../js/jQuery-2.1.4.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<form action="##" method="post" id="regist" onsubmit="return false">
    <div id="login-tip">&nbsp;
    </div>
    用户名：<input type="text" name="" id="user">
    手机号：<input type="number" name="" id="phone">
    密码：<input type="password" name="" id="password">
    <input type="submit" class="btn btn-success" value="注册">
</form>

<script>
    $( function(){
        $(".btn-success").click(function(){
            var name =  $("#username").val();
            var phone = $("#phone").val();
            var passwd = $("#password").val();
            var regPhone = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0135678]|18[0-9]|14[579]|852|853)[0-9]{8}$/;
            if(null==name){
                $("#login-tip").html("请输入用户名")
            }
            if(!regPhone.test(phone)){
                $("#login-tip").html("请输入正确的手机号")
                return;
            }
            else if(passwd.length<1){
                $("#login-tip").html("请输入登录密码")
                return;
            }else {
                $("#login-tip").html("");
            }

            $.ajax({
                url:"/user/doRegist",
                data:{
                    phone:phone,
                    password:passwd,
                    userName:name
                },
                type:"POST",
                dataType:"json",
                success:function (data) {
                    if(data.success){
                        window.location = "/note/indexNote";
                    }else {
                        $("#login-tip").html(data.msg);
                    }
                },
                error:function (data) {
                    $("#login-tip").html(data.msg);
                }
            })

        });
    })
</script>
</body>
</html>
