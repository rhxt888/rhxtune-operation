<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>应用管理-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-12">
            <div class="alert alert-info" role="alert">
                <strong>应用!</strong> 包括,手机APP,TV应用,网站应用等
            </div>
            <div class="clearfix mvm">
                <div class="pull-left">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="exampleInputEmail3">状态</label>
                            <select class="c-select" name="status">
                                <option value="dev" selected>开发中</option>
                                <option value="prod">已上线</option>
                                <option value="offline">未上线</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail3">删除状态</label>
                            <select class="c-select" name="isDeleted">
                                <option value="false">否</option>
                                <option value="true">是</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">查询</button>
                    </form>
                </div>
                <div class="pull-right">
                    <a href="/app/add" class="btn btn-success-outline">添加APP</a>
                </div>

            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>别名</th>
                    <th>状态</th>
                    <th>版本</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#if appList.list?has_content>
                    <#list appList.list as app>
                    <tr>
                        <td>${app.name}</td>
                        <td>${app.slug}</td>
                        <td>${app.status}</td>
                        <td>${app.version}</td>
                        <td>
                            <#if app.createdTime?exists>
                               ${app.createdTime?number_to_date?string("MM/dd HH:mm")!}
                            </#if>
                        </td>
                        <td>
                            <a href="/app/${app.id}/update" class="btn btn-sm btn-info-outline">修改</a>
                            <a href="/app/${app.id}/del" class="btn btn-sm btn-danger-outline">删除</a>
                            <a href="/app/${app.id}" class="btn btn-sm btn-info-outline">详情</a>
                        </td>
                    </tr>
                    </#list>
                <#else>

                </#if>
                </tbody>
            </table>
        </div>

    </div>
</div>
</body>
</html>
