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
            <p><span class="mrm">所属应用:</span>${position.appInfo.name}</p>
            <p><span class="mrm">编号:</span>${position.num}</p>
            <p><span class="mrm">名称:</span>${position.name}</p>
            <p><span class="mrm">创建时间:</span>${position.createdTime?number_to_date?string("MM/dd HH:mm")!} </p>
        </div>

        <div class="col-sm-6">
            <h5>描述</h5>
            <hr>
            <div>
                ${position.description!}
            </div>
        </div>
    </div>
</div>
</body>
</html>
