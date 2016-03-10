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
                            <label class="sr-only" for="exampleInputEmail3">状态</label>
                            <select class="c-select">
                                <option selected="">状态</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">查询</button>
                    </form>
                </div>
                <div class="pull-right">
                    <a href="/content/add" class="btn btn-success-outline">添加APP</a>
                </div>

            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>#编号</th>
                    <th>名称</th>
                    <th>别名</th>
                    <th>状态</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#if articleList?has_content>
                    <#list articleList.list?exists as article>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                        <td>@mdo</td>
                        <td>
                            <a href="/${article.id}/update" class="btn btn-sm btn-info-outline">修改</a>
                            <a href="/${article.id}/del" class="btn btn-sm btn-info-outline">删除</a>
                            <a href="/${article.id}" class="btn btn-sm btn-info-outline">详情</a>
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
