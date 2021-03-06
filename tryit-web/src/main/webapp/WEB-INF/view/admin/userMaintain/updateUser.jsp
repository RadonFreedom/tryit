<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/doc.min.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }
    </style>
    <title>用户维护 tryit</title>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:22px;" href="">tryit 用户管理系统 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle"
                                data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> ${userInfo.name} <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/logout"><i
                                    class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="查询">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul style="padding-left:0px;" class="list-group">
                    <li class="list-group-item tree-closed">
                        <a href="${pageContext.request.contextPath}/admin"><i class="glyphicon glyphicon-dashboard"></i>
                            控制面板</a>
                    </li>
                    <li class="list-group-item">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge"
                                                                                             style="float:right">3</span></span>
                        <ul style="margin-top:10px;">
                            <li style="height:30px;">
                                <a href="${pageContext.request.contextPath}/admin/userMaintain" style="color:red;"><i
                                        class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="role.html"><i class="glyphicon glyphicon-king"></i> 角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/admin">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/userMaintain">数据列表</a></li>
                <li class="active">修改</li>
            </ol>
            <div class="panel-body">
                <form id="userDataForm" role="form">
                    <div class="form-group">
                        <label>用户名称</label>
                        <input type="text" class="form-control" id="name" placeholder="请输入用户名称">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" class="form-control" id="password" placeholder="请输入用户名称">
                    </div>
                    <button id="updateUserButton" type="button" class="btn btn-success"><i
                            class="glyphicon glyphicon-plus"></i> 修改
                    </button>
                    <button id="resetButton" type="button" class="btn btn-danger" href=""><i class="glyphicon glyphicon-refresh"></i> 重置
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">帮助</h4>
            </div>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/jquery/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/script/docs.min.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>

<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });

        $("#resetButton").click(function () {
            $("#userDataForm")[0].reset();
        });

        $("#updateUserButton").click(function () {
            var holder = null;

            var name = $("#name").val();
            if (name === "") {
                layer.msg("用户名不能为空，请输入", {time: 1000, icon: 0, shift: 5});
                return;
            }
            var password = $("#password").val();
            if (password === "") {
                layer.msg("登录密码不能为空，请输入", {time: 1000, icon: 0, shift: 5});
                return;
            }

            $.ajax({
                type: "POST",
                url: "doUpdateUser",
                data: {
                    account: "${account}",
                    name: name,
                    password: password
                },
                beforeSend: function () {
                    holder = layer.msg("处理中", {icon: 16});
                },
                success: function (result) {
                    layer.close(holder);
                    if (result === true) {
                        layer.msg("修改用户成功", {time: 1000, icon: 1, shift: 5});
                        window.location.href = "${pageContext.request.contextPath}/admin/userMaintain";
                    } else {
                        layer.msg("用户账户不存在", {time: 1000, icon: 2, shift: 6});
                    }
                }
            })
        });
    });
</script>

</body>
</html>

