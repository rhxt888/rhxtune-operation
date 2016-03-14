<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>运营位-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-12">
            <div class="clearfix mvm">
                <div class="pull-left">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="exampleInputEmail3">状态</label>
                            <select class="c-select" name="status">
                                <option value="online">已经发布</option>
                                <option value="draft">草稿</option>
                                <option value="offline">已经下线</option>
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
                    <a href="/content/add" class="btn btn-success-outline">添加内容</a>
                </div>

            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>状态</th>
                    <th>阅读数</th>
                    <th>模板</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#if articleList.list?has_content>
                    <#list articleList.list as article>
                    <tr>
                        <td>${article.title}</td>
                        <td>
                            <#if article.status == 'draft'>
                                草稿
                            <#elseif article.status == 'online'>
                                已发布上线
                            <#elseif article.status == 'offline'>
                                已下线
                            </#if>

                        </td>
                        <td>${article.viewCount}</td>
                        <td>
                               <#if article.template == 'default'>
                                   默认
                               <#elseif article.template== 'agreement'>
                                   用户协议
                               </#if>
                        </td>
                        <td>
                            <#if article.createdTime?exists>
                               ${article.createdTime?number_to_date?string("MM/dd HH:mm")!}
                            </#if>
                        </td>
                        <td>
                            <a href="/content/${article.id}/update" class="btn btn-sm btn-info-outline">修改</a>
                            <a href="/content/${article.id}/del" class="btn btn-sm btn-danger-outline">删除</a>
                            <a href="/content/${article.id}" class="btn btn-sm btn-info-outline">详情</a>
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
