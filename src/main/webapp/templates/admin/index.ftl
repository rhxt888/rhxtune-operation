<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>管理员列表-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-10">
            <div>
                <a href="/admin/save" class="btn btn-success">添加管理员</a>
            </div>
            <table class="table table-bordered mtm">
                <thead>
                <tr>
                    <th>昵称</th>
                    <th>邮箱</th>
                    <th>角色</th>
                    <th>添加时间</th>
                    <th>最后登陆时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list adminList.list as admin>

                <tr>
                    <td>${admin.screenName}</td>
                    <td>${admin.email}</td>
                    <td>
                        <#switch admin.role>
                            <#case "admin">
                                管理员
                                <#break >
                            <#case "operation">
                                运营
                                <#break >
                            <#case "super">
                                超级管理员
                                <#break >

                        </#switch>
                    </td>
                    <td>
                        <#if admin.createdTime?exists>
                       ${admin.createdTime?number_to_date?string("MM/dd HH:mm")!}
                        </#if>
                    </td>
                    <td>
                        <#if admin.lastSigninTime?exists>
                           ${admin.lastSigninTime?number_to_date?string("MM/dd HH:mm")!}
                        </#if >
                    </td>
                    <td>
                        <#if admin.role != "super">
                            <a href="/admin/save?id=${admin.id}" class="btn btn-sm btn-info-outline">修改</a>
                            <a href="/admin/${admin.id}/del" class="btn btn-sm btn-danger-outline mlm">删除</a>
                            <a href="/admin/update/password?id=${admin.id}" class="btn btn-sm btn-info-outline">修改密码</a>
                        <#else >
                            不可操作
                        </#if>

                    </td>
                </tr>

                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-6">

        </div>
    </div>
</div>
</body>
</html>
