<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.3.4"></script>
    <script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
</head>
<body>
<div class="container" id="app">
    <ul class="nav nav-tabs nav-pills nav-justified" role="tablist" id="index-note-tab">
        <li role="presentation" class="active">
            <a href="#recommend" name="1" aria-controls="recommend" role="tab" data-toggle="tab">推荐</a>
        </li>
        <li role="presentation">
            <a href="#fashion" name="2" aria-controls="fashion" role="tab" data-toggle="tab">时尚</a>
        </li>
        <li role="presentation">
            <a href="#makeups" name="3" aria-controls="makeups" role="tab" data-toggle="tab">美妆</a>
        </li>
        <li role="presentation">
            <a href="#food" name="4" aria-controls="food" role="tab" data-toggle="tab">美食</a>
        </li>
        <li role="presentation">
            <a href="#movement" name="5" aria-controls="movement" role="tab" data-toggle="tab">运动</a>
        </li>
        <li role="presentation">
            <a href="#video" name="6" aria-controls="video" role="tab" data-toggle="tab">影音</a>
        </li>
        <li role="presentation">
            <a href="#travel" name="7" aria-controls="travel" role="tab" data-toggle="tab">旅行</a>
        </li>
        <li role="presentation">
            <a href="#beauty" name="8" aria-controls="beauty" role="tab" data-toggle="tab">美女</a>
        </li>
        <li role="presentation">
            <a href="#reading" name="9" aria-controls="reading" role="tab" data-toggle="tab">阅读</a>
        </li>
    </ul>
    <div class="tab-content row">
        <div role="tabpanel" class="tab-pane fade in active" id="recommend">
            <div class="panel panel-info col-xs-6 col-md-3" v-for="n in notes">
                <div class="panel-body">
                    <img :src="n.imgs[0].url" class="img-thumbnail">
                </div>
                <div class="panel-footer">
                    <label class="content">{{n.content}}</label>
                    <div>
                        <div class="user">
                            <span><img :src="n.user.img" class="head img-circle"></span>
                            <span>{{n.user.username}}</span>
                        </div>
                        <div class="favor">
                            <span> <img src="../img/favor.png" alt="..." class="favor_icon"></span>
                            <span>{{n.favor.likecount}}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:forEach items="${categorys}" var="c" varStatus="status">
            <div role="tabpanel" class="tab-pane fade" id="${c}">
                <div class="panel panel-info col-xs-6 col-md-3" v-for="n in notes">
                    <div class="panel-body">
                        <img v-bind:src="n.imgs[0].url" class="img-thumbnail">
                    </div>
                    <div class="panel-footer">
                        <label class="content">{{n.content}}</label>
                        <div>
                            <div class="user">
                                <span><img v-bind:src="n.user.img" class="head img-circle"></span>
                                <span>{{n.user.username}}</span>
                            </div>
                            <div class="favor">
                                <span> <img src="../img/favor.png" alt="..." class="favor_icon"></span>
                                <span>{{n.favor.likecount}}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div>
        <button type="button" class="btn btn-success btn-circle" id="add">添加</button>
    </div>

    <script>
        var vm = new Vue({
            el: "#app",
            data: {
                notes: [],
            },

            created: function () {
                this.$http.get('getNotesByCategory', {}).then(function (res) {
                    vm.notes = res.data;
                    console.log(vm.notes[0].imgs[0].url);
                }, function (res) {
                    vm.notes = res.data;
                });
            },
            methods: {}
        })

        $('#index-note-tab a').click(function (e) {
            console.log(e.target.name);
            var id = e.target.name;
            vm.$http.get('getNotesByCategory', {params: {id}}).then(function (res) {
                console.log(res.data[0]);
                vm.notes = res.data;
            }, function (res) {
                vm.notes = res.data;
            });
        })

        $(function () {
            $('.tab-pane').masonry({
                // options...
                itemSelector: '.panel',
                columnWidth: 200,
            });
        })

        $('#add').click(function () {
            location.href = 'indexAddNote';
        })
    </script>
</div>
</body>
</html>
