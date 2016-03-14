<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>添加APP-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <form action="/app/${app.id}/update" method="post">
        <div class="row">
            <div class="col-sm-6">
                <h5 class="mbml">修改应用信息</h5>
                <fieldset class="form-group">
                    <label for="exampleInputEmail1">APP名称</label>
                    <input type="text" required value="${app.name}" class="form-control" id="exampleInputEmail1" name="name"
                           placeholder="APP名称">
                </fieldset>
                <fieldset class="form-group">
                    <label for="name">别名</label>
                    <input type="text" required class="form-control" value="${app.slug}" name="slug" id="name" placeholder="别名">
                    <small class="text-muted">别名必须是英文字母.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">状态</label>
                    <select class="form-control c-select" id="exampleSelect2" name="status">
                        <option value="dev" <#if app.status == 'dev'>selected</#if> >开发中</option>
                        <option value="prod"  <#if app.status == 'prod'>selected</#if> >已上线</option>
                        <option value="offline"  <#if app.status == 'offline'>selected</#if> >未上线</option>
                    </select>
                </fieldset>

                <fieldset class="form-group">
                    <label for="exampleSelect2">用户协议</label>
                    <select class="form-control c-select" id="exampleSelect2" name="articleId">
                    <#list artileList as article >
                        <option value="${article.id}"    >${article.title}</option>
                    </#list>
                    </select>
                </fieldset>

                <fieldset class="form-group">
                    <label>描述</label>
                    <textarea class="form-control" name="description" rows="3">${app.description}</textarea>
                    <small class="text-muted">应用的简单描述</small>
                </fieldset>
            </div>
            <div class="col-sm-6">
                <h5 class="mbml">应用联系方式</h5>
                <hr>
                <p class="help-block">会在手机app的关于里显示出来</p>
                <fieldset class="form-group">
                    <label>邮箱</label>
                    <input type="text" required class="form-control" name="contactInfo['email']" value="${app.contactInfo['email']}"  placeholder="邮箱">
                    <small class="text-muted">别名必须是英文字母.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label>电话</label>
                    <input type="text" required class="form-control" name="contactInfo['phone']" value="${app.contactInfo['phone']}"  placeholder="电话">
                    <small class="text-muted">别名必须是英文字母.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label >QQ群</label>
                    <input type="text" required class="form-control" name="contactInfo['qq']" value="${app.contactInfo['qq']}"  placeholder="QQ">
                    <small class="text-muted">别名必须是英文字母.</small>
                </fieldset>

            </div>

        </div>
        <div class="row text-center">
            <button type="submit" class="btn btn-primary">保存</button>
        </div>
    </form>
</div>
</body>
</html>
