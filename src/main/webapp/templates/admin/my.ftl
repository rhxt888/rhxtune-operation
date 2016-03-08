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
        <div class="col-sm-6">
            <div class="jumbotron">
                <h1 class="display-3">Hello, world!</h1>
                <p class="lead">欢迎! 来到神秘的领地,在这里你可以干不为用户所知道的事情噢! 记得保密! </p>
                <hr class="m-y-md">
                <p>你的一举一动正在被监控,注意言行操作. 不行点击下面的按钮看看</p>
                <p class="lead">
                    <a class="btn btn-primary btn-lg" href="#" role="button">去瞅瞅</a>
                </p>
            </div>
        </div>
        <div class="col-sm-6">
            <h5>登陆日志</h5>
            <blockquote class="blockquote text-muted">
                <#list signinLogList as log>
                    <p>${log.signinTime?number_to_datetime} ip:${log.ip}  ${log.remark}</p>
                </#list>
            </blockquote>
        </div>
    </div>
</div>
</body>
</html>
