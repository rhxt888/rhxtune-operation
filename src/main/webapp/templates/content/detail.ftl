<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>添加管理员-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-6">
            <h5>${article.title}</h5>

            <p class="mtm text-muted small clearfix">
                <span>${article.adminUser.screenName}</span>
                <span class="mlm">${article.createdTime?number_to_date?string("MM/dd HH:mm")!}</span>
                <span class="mlm">阅读数:${article.viewCount}</span>
                <span class="mlm">模板:
                <#if article.template == 'default'>
                    默认
                <#elseif article.template== 'agreement'>
                    用户协议
                </#if>
                </span>
                <span class="mlm">状态:
                <#if article.status == 'draft'>
                    草稿
                <#elseif article.status == 'online'>
                    已发布上线
                <#elseif article.status == 'offline'>
                    已下线
                </#if>
                </span>
                <a href="/content/${article.id}/update" class="btn btn-sm btn-success-outline pull-right">修改</a>
            </p>
            <hr class=""></hr>
            <div class="mtl">
            ${article.content}
            </div>
        </div>
    </div>
</div>
</body>
</html>
