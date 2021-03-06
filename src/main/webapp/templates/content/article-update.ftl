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
            <h5>修改运营内容</h5>

            <form action="/content/${article.id}/update" method="post">
                <input type="hidden" name="id" value="${article.id}">
                <fieldset class="form-group">
                    <label for="exampleInputEmail1">标题</label>
                    <input type="text" required class="form-control" value="${article.title}" id="exampleInputEmail1" name="title"
                           placeholder="运营位名称">
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">状态</label>
                    <select class="form-control c-select" id="exampleSelect2" name="status">
                        <option value="draft" <#if article.status == 'draft'>selected</#if>>草稿</option>
                        <option value="online" <#if article.status == 'online'>selected</#if>>已发布</option>
                        <option value="offline" <#if article.status == 'offline'>selected</#if>>已下线</option>
                    </select>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">模板</label>
                    <select class="form-control c-select" id="exampleSelect2" name="template">
                        <option value="default" <#if article.template == 'default'>selected</#if>>默认</option>
                        <option value="agreement"  <#if article.template== 'agreement'>selected</#if>>用户协议</option>
                    </select>
                </fieldset>

                <fieldset class="form-group">
                    <label>内容</label>
                    <textarea class="form-control pln ptn" name="content" id="ueditor" rows="3">${article.content}</textarea>
                </fieldset>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/javascript/jquery.min.js"></script>
<script type="text/javascript" src="/static/javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/static/ueditor/ueditor.all.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('ueditor');
</script>
</body>
</html>
