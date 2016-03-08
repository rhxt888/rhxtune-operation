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
            <h5>修改管理员密码</h5>
            <form action="/admin/update/password" method="post">
                <input type="hidden" name="id" value="${RequestParameters["id"]}">
                <fieldset class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input type="password" min="6" class="form-control" id="exampleInputPassword1" name="password" placeholder="密码">
                </fieldset>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
