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
            <h5>添加运营位</h5>
            <form action="/admin/save" method="post">
                <fieldset class="form-group">
                    <label for="exampleSelect2">应用</label>
                    <select class="form-control c-select" id="exampleSelect2" name="role">
                        <option value="admin" selected>管理员</option>
                        <option value="operation">运营</option>
                    </select>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleInputEmail1">运营位名称</label>
                    <input type="text" required class="form-control" id="exampleInputEmail1" name="name" placeholder="运营位名称">
                </fieldset>
                <fieldset class="form-group">
                    <label for="name">编号</label>
                    <input type="text" required class="form-control" name="screenName" id="name" placeholder="编号">
                    <small class="text-muted">运营位在一个应用中的位置编号.</small>
                </fieldset>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 启用
                    </label>
                </div>
                <fieldset class="form-group">
                    <label>描述</label>
                    <textarea class="form-control" name="remark"  rows="3"></textarea>
                    <small class="text-muted">运营位的简单描述</small>
                </fieldset>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
