<%@ page contentType="text/html;charset=UTF-8" %>
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
    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }

        table tbody tr:nth-child(odd) {
            background: #F4F4F4;
        }

        table tbody td:nth-child(even) {
            color: #C00;
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="queryText" class="form-control has-success" type="text"
                                       placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="queryButton" type="button" class="btn btn-warning"><i
                                class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button id="deleteUsersButton" type="button" class="btn btn-danger"
                            style="float:right;margin-left:10px;"><i
                            class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <button type="button" class="btn btn-primary" style="float:right;"
                            onclick="window.location.href='userMaintain/addUser'">
                        <i class="glyphicon glyphicon-plus"></i> 新增
                    </button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <form id="userForm">
                            <table class="table  table-bordered">
                                <thead>
                                <tr>
                                    <th width="30">ID</th>
                                    <th width="30">
                                        <label>
                                            <input id="selectAllBox" type="checkbox">
                                        </label>
                                    </th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>创建时间</th>
                                    <th width="100">操作</th>
                                </tr>
                                </thead>
                                <tbody id="userData">
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="6" align="center">
                                        <ul id="pageNums" class="pagination">
                                        </ul>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/jquery/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/script/docs.min.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script>
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

        pageQuery(1);
        $("#queryButton").click(function () {
            pageQuery(1);
        });
    });
    $("tbody .btn-success").click(function () {
        window.location.href = "assignRole.html";
    });
    $("tbody .btn-primary").click(function () {
        window.location.href = "edit.html";
    });
    $("#selectAllBox").click(function () {
        var flag = this.checked;
        $("#userData :checkbox").each(function () {
            this.checked = flag;
        });
    });

    $("#deleteUsersButton").click(function () {
        var holder = null;
        var cnt = 0;
        $("#userData :checkbox").each(function () {
            if (this.checked === true) {
                cnt++;
            }
        });
        if (cnt === 0) {
            layer.msg("请选择需要删除的用户信息", {time: 1000, icon: 0, shift: 5});
            return;
        }
        $.ajax({
            type: "POST",
            url: "userMaintain/doDeleteUsers",
            data: $("#userForm").serialize(),
            beforeSend: function () {
                holder = layer.msg("处理中", {icon: 16});
            },
            success: function (result) {
                layer.close(holder);
                if (result === true) {
                    layer.msg("删除用户成功", {time: 1000, icon: 1, shift: 5});
                    pageQuery(1);
                } else {
                    layer.msg("删除失败，请重试", {time: 1000, icon: 5, shift: 6});
                }
            }
        });
    });

    function pageQuery(pageNum) {
        var holder = null;
        $.ajax({
            type: "POST",
            url: "userMaintain/pageQuery",
            data: {
                pageNum: pageNum,
                pageSize: 4,
                queryText: $("#queryText").val()
            },
            beforeSend: function () {
                holder = layer.msg("处理中", {icon: 16});
            },
            success: function (result) {
                layer.close(holder);
                //局部刷新获得的页面数据
                var userDataHtml = "";
                var pageNumsHtml = "";

                var dataList = result.dataList;
                var currentPage = result.currentPage;
                var totalPageCnt = result.totalPageCnt;

                $.each(dataList, function (i, user) {
                    userDataHtml += '<tr>';
                    userDataHtml += '  <td>' + user.id + '</td>';
                    userDataHtml += '  <td><input type="checkbox" name="account" value="' + user.account + '"></td>';
                    userDataHtml += '  <td>' + user.account + '</td>';
                    userDataHtml += '  <td>' + user.name + '</td>';
                    userDataHtml += '  <td>' + user.createTime + '</td>';
                    userDataHtml += '  <td>';
                    userDataHtml += '     <button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                    userDataHtml += '     <button type="button" class="btn btn-primary btn-xs" onclick="window.location.href=\'userMaintain/updateUser?account=' + user.account + '\'"><i class=" glyphicon glyphicon-pencil"></i></button>';
                    userDataHtml += '	  <button type="button" class="btn btn-danger btn-xs" onclick=deleteUser("' + user.account + '")><i class=" glyphicon glyphicon-remove"></i></button>';
                    userDataHtml += '  </td>';
                    userDataHtml += '</tr>';
                });

                if (currentPage > 1) {
                    pageNumsHtml += '<li><a onclick="pageQuery(' + (currentPage - 1) + ')">上一页</a></li>';
                }

                for (var i = 1; i <= totalPageCnt; i++) {
                    if (i === currentPage) {
                        pageNumsHtml += '<li class="active"><a  href="#">' + i + '</a></li>';
                    } else {
                        pageNumsHtml += '<li ><a onclick="pageQuery(' + i + ')">' + i + '</a></li>';
                    }
                }

                if (currentPage < totalPageCnt) {
                    pageNumsHtml += '<li><a onclick="pageQuery(' + (currentPage + 1) + ')">下一页</a></li>';
                }


                $("#userData").html(userDataHtml);
                $("#pageNums").html(pageNumsHtml);
            }
        });
    }

    function deleteUser(account) {
        var holder = null;
        $.ajax({
            type: "POST",
            url: "userMaintain/doDeleteUser",
            data: {
                account: account
            },
            beforeSend: function () {
                holder = layer.msg("处理中", {icon: 16});
            },
            success: function (result) {
                layer.close(holder);
                if (result === true) {
                    layer.msg("删除用户成功", {time: 1000, icon: 1, shift: 5});
                    window.location.href = "${pageContext.request.contextPath}/admin/userMaintain";
                } else {
                    layer.msg("删除失败，请重试", {time: 1000, icon: 5, shift: 6});
                }
            }
        })
    }
</script>
</body>
</html>

