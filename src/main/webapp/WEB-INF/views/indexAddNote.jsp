<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jiangpw
  Date: 2018/5/10
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加笔记</title>
    <link href="../css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all"
          rel="stylesheet" type="text/css"/>
    <link href="../themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="../js/jQuery-2.1.4.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <link href="../css/indexAddNote.css" rel="stylesheet">
    <script src="../js/plugins/sortable.js" type="text/javascript"></script>
    <script src="../js/fileinput.js" type="text/javascript"></script>
    <script src="../js/locales/fr.js" type="text/javascript"></script>
    <script src="../js/locales/es.js" type="text/javascript"></script>
    <script src="../js/locales/zh.js" type="text/javascript"></script>
    <script src="../themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="../themes/fa/theme.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="form-group">
        <label for="content" class="col-sm-2 control-label">内容</label>
        <div class="col-sm-10">
            <textarea class="form-control" rows="3" id="content" placeholder="内容"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="category" class="col-sm-2 control-label">类别</label>
        <div class="col-sm-10">
            <select class="form-control" id="category">
                <C:forEach items="${categories}" var="c" varStatus="status">
                    <option name="${c.id}" value="${c.id}">${c.name}</option>
                </C:forEach>
            </select>
        </div>
    </div>
    <div class="form-group upload">
        <label for="file-fr" class="col-sm-2 control-label">图片</label>
        <div class="col-sm-10">
            <input id="file-fr" name="file" type="file" multiple>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="submit" class="btn btn-success">发布</button>
        </div>
    </div>
</div>

<script>

    var noteId;

    $(function () {
        $('#file-fr').fileinput({
            theme: 'fa',
            language: 'zh',
            uploadUrl: '/note/upload',
            allowedFileExtensions: ['jpg', 'png', 'gif'],
            showUpload: false,
            showPreview: true,
            showCaption: false,
            uploadExtraData: function () {
                return {'noteId': noteId};
            },
            layoutTemplates: {
                actionUpload: '',//去除上传预览缩略图中的上传图片；
                actionZoom:
                    ''   //去除上传预览缩略图中的查看详情预览的缩略图标。
            }
            ,
        }).on("fileuploaded", function (e, data) {
            if (data.response.success) {
                window.location = "/note/indexNote";
            } else {

            }
        });
    })

    $("#submit").click(function () {
        if ($("#content").val() == "") {
            alert("请填写内容");
            return;
        } else {

        }

        if ($("#file-fr").val() != "") {
            $.ajax({
                type: "POST",
                url: "/note/addNote",
                data: {content: $("#content").val(), categoryid: $("#category option:selected").val()},
                dataType: "json",
                success: function (data) {
                    if (data.code == '0') {
                        noteId = data.data;
                        $('#file-fr').fileinput('upload');
                    }
                }
            })
        } else {
            alert("请选择图片");
            return;
        }
    })
</script>
</body>
</html>
