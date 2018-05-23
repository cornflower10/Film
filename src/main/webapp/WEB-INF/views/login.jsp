<%--
  Created by IntelliJ IDEA.
  User: jiangpw
  Date: 2018/5/7
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="../../js/jquery-1.11.2.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
    <link href="../../css/login.css" rel="stylesheet">
</head>
<body>
<div class="center">
    <form class="form-horizontal" role="form" action="##" method="post" id="login" onsubmit="return false">
       <div class="form-group">
           <div class="col-sm-10" id="login-tip">
           </div>
       </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="text" class="form-control" id="login-phone" placeholder="手机号码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10">
                <input type="password" class="form-control" id="passwd" placeholder="密码">
            </div>
        </div>
        <div class="form-group"  id = "verifycode" >

                <input type="text" name="code" class="page-input" placeholder="验证码"  style="padding-left:6px;width: 270px;margin-left: 16px"
                       value=""  id="val-code"/>
                <img src="/validateCode" alt="" style="width: 80px;height: 35px" id="verifyCodeImg" onclick='changeVerifyCode()'/>
                <a id="changeVerifyCode" href='JavaScript:' onclick='changeVerifyCode()' >换一张</a>



        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <a id="forget" href="/user/regist">忘记登录密码</a>
                        <a id="regist" href="/user/regist">注册</a>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-success btn btn-primary">登录</button>
            </div>
        </div>
    </form>

</div>
<script>
     $(function(){
     $(".btn-success").click(function(){
      var phone = $("#login-phone").val();
      var passwd = $("#passwd").val();
      var val = $("#val-code").val();
         var regPhone = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0135678]|18[0-9]|14[579]|852|853)[0-9]{8}$/;
         if(!regPhone.test(phone)){
             $("#login-tip").html("请输入正确的手机号")
             return;
         }
         else if(passwd.length<1){
         $("#login-tip").html("请输入登录密码")
             return;
         }else if(val.length<1){
             $("#login-tip").html("请输入验证码")
             return;
         }
         else {
             $("#login-tip").html("");
         }

         $.ajax({
             url:"/user/doLogin",
             data:{
                 phone:phone,
                 password:passwd,
                 val:val
             },
             type:"POST",
             dataType:"json",
             success:function (data) {
                 if(data.success){
                     window.location = "/note/indexNote";
                 }else {
                     if(data.code=="99"){
                         window.location = "/user/check";
                     }else
                     $("#login-tip").html(data.msg);
                 }
             },
             error:function (data) {
                 $("#login-tip").html(data.msg);
             }
         })
         
    });
    })

     function changeVerifyCode() {
         $("#verifyCodeImg").attr("src","/validateCode?"+Math.random());
     }
</script>
</body>
</html>
