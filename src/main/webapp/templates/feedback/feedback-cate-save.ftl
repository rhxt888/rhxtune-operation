<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>添加/修改意见反馈分类-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-6">
            <h5>添加/修改管理员信息</h5>
            <form action="/admin/save" method="post">
                <fieldset class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" required class="form-control" name="screenName" id="name" placeholder="姓名">
                    <small class="text-muted">管理员姓名.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" required class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter email">
                    <small class="text-muted">.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input type="password" required min="6" class="form-control" id="exampleInputPassword1" name="password" placeholder="密码">
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">角色</label>
                    <select class="form-control c-select" id="exampleSelect2" name="role">
                        <option value="admin" selected>管理员</option>
                        <option value="operation">运营</option>
                    </select>
                </fieldset>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
