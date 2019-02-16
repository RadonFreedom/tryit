<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <style>

    </style>
    <title>用户登录 tryit</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index" style="font-size:22px;">tryit 用户管理系统</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <form id="loginForm" class="form-signin" role="form">
        <h3 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i>用户登录</h3>
        <div class="form-group has-success has-feedback">

            <%--下面的两个input标签必须同时有相同的id（为了在JS中使用）和name（为了能构成报文中的键值对）属性--%>
            <input type="text" class="form-control" name="account" id="account" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入登录密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <label>
                <select class="form-control">
                    <option value="member">用户</option>
                    <option value="user">管理员</option>
                </select>
            </label>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()"> 登录</a>
    </form>

</div>
<script src="${pageContext.request.contextPath}/jquery/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script>
    function dologin() {
        //字符串非空校验
        var account = $("#account").val();
        if (account === "") {
            layer.msg("用户账号不能为空，请输入", {time: 1000, icon: 0, shift: 5});
            return;
        }
        var password = $("#password").val();
        if (password === "") {
            layer.msg("登录密码不能为空，请输入", {time: 1000, icon: 0, shift: 5});
            return;
        }

        var holder = null;
        //提交表单
        $.ajax({
            type: "POST",
            url: "doAjaxLogin",
            data: {
                account: account,
                password: password
            },
            beforeSend: function () {
                holder = layer.msg("处理中", {icon: 16});
            },
            success: function (result) {
                layer.close(holder);
                if (result.success === true) {
                    window.location.href = "admin";
                } else {
                    layer.msg("用户信息不存在或密码错误", {time: 1000, icon: 2, shift: 6});
                }
            }
        });
    }
</script>
</body>
</html>
