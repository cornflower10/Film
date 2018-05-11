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

<form action="##" method="post" id="login" onsubmit="return false">
    <div id="login-tip">&nbsp;
    </div>
    <div >
        手机号：<input type="number" name="phone" id="login-phone">
    </div>
    <div >
        密码：<input type="password" name="password" id="passwd">
    </div>
    <div >
        <input type="submit" class="btn btn-success" value="登录">
    </div>

</form>

<script>
     $( function(){
     $(".btn-success").click(function(){
      var phone = $("#login-phone").val();
      var passwd = $("#passwd").val();
         var regPhone = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0135678]|18[0-9]|14[579]|852|853)[0-9]{8}$/;
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
             url:"/user/login",
             data:{
                 phone:phone,
                 password:passwd
             },
             type:"POST",
             dataType:"json",
             success:function (data) {
                 
             },
             error:function (data) {
                 
             }
         })
         
    });
    })
</script>
</body>
</html>
