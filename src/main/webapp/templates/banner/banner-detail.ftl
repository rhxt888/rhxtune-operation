<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>app详情-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-6">
            <h5>应用基本信息</h5>
            <hr>
            <p><span class="mrm">名称:</span>${app.name}</p>
            <p><span class="mrm">标识:</span>${app.slug}</p>
            <p><span class="mrm">状态:</span>${app.status}</p>
            <p><span class="mrm">版本:</span>${app.version}</p>
            <p><span class="mrm">创建时间:</span>${app.createdTime?number_to_date?string("MM/dd HH:mm")!} </p>
            <p><a href="/content/${app.articleId}">用户使用协议</a></p>
        </div>

        <div class="col-sm-6">
            <h5>应用联系方式</h5>
            <hr>
            <p>邮箱: ${app.contactInfo['email']}</p>
            <p>QQ: ${app.contactInfo['qq']}</p>
            <p>电话: ${app.contactInfo['phone']}</p>
        </div>
    </div>
</div>
</body>
</html>
