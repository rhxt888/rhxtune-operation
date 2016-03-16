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
            <h5>运营位基本信息</h5>
            <hr>
            <p><span class="mrm">标题:</span>${banner.title}</p>
            <p><span class="mrm">位置:</span>${banner.position.name}</p>
            <p><span class="mrm">状态:</span>${banner.status}</p>
            <p><span class="mrm">编号:</span>${banner.num}</p>
            <p><span class="mrm">主图:</span>${banner.masterImg}</p>
            <p><span class="mrm">url:</span>${banner.url}</p>
            <p><span class="mrm">描述:</span>${banner.description}</p>
            <p><span class="mrm">阅读数:</span>${banner.viewCount}</p>
            <p><span class="mrm">管理员:</span>${banner.adminUser.name}</p>
            <p><span class="mrm">所属小区:</span>${banner.community.name}</p>
            <p><span class="mrm">所属应用:</span>${banner.appInfo.name}</p>

            <p><span class="mrm">起始时间:</span>${banner.startTime?number_to_date?string("MM/dd HH:mm")!} </p>
            <p><span class="mrm">结束时间:</span>${banner.endTime?number_to_date?string("MM/dd HH:mm")!} </p>
            <p><span class="mrm">创建时间:</span>${banner.createdTime?number_to_date?string("MM/dd HH:mm")!} </p>
            <#--<p><a href="/content/${app.articleId}">用户使用协议</a></p>-->
        </div>

        <#--<div class="col-sm-6">-->
            <#--<h5>应用联系方式</h5>-->
            <#--<hr>-->
            <#--<p>邮箱: ${app.contactInfo['email']}</p>-->
            <#--<p>QQ: ${app.contactInfo['qq']}</p>-->
            <#--<p>电话: ${app.contactInfo['phone']}</p>-->
        <#--</div>-->
    </div>
</div>
</body>
</html>
