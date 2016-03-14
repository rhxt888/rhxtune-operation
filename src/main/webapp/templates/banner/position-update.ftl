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
            <form action="/banner/position/${position.id}/update" method="post">
                <fieldset class="form-group">
                    <label for="exampleSelect2">应用</label>
                    <select class="form-control c-select" id="exampleSelect2" name="appId">
                        <#list appList as app >
                            <option value="${app.id}" <#if position.appInfo.id = app.id>selected</#if> >${app.name}</option>
                        </#list>
                    </select>
                    <input name="id" value="${position.id}" type="hidden">
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleInputEmail1">运营位名称</label>
                    <input type="text" required class="form-control" id="exampleInputEmail1" value="${position.name}" name="name" placeholder="运营位名称">
                </fieldset>
                <fieldset class="form-group">
                    <label for="name">编号</label>
                    <input type="text" required class="form-control" name="num"  placeholder="编号" value="${position.num}">
                    <small class="text-muted">运营位在一个应用中的位置编号.</small>
                </fieldset>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="isEnable" <#if position.isEnable??> checked</#if>> 启用
                    </label>
                </div>
                <fieldset class="form-group">
                    <label>描述</label>
                    <textarea class="form-control"  name="description" rows="3">${position.description!}</textarea>
                    <small class="text-muted">运营位的简单描述</small>
                </fieldset>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
