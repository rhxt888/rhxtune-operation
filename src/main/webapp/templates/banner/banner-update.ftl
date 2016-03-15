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
            <form action="/banner/position/${banner.id}/update" method="post">
                <fieldset class="form-group">
                    <label for="exampleSelect2">应用</label>
                    <select class="form-control c-select" id="exampleSelect2" name="appId">
                    <#list appList as app >
                        <option value="${app.id}" <#if banner.appInfo.id = app.id>selected</#if> >${app.name}</option>
                    </#list>
                    </select>
                    <input name="id" value="${banner.id}" type="hidden">
                </fieldset>
                <#--<fieldset class="form-group">-->
                    <#--<label for="exampleInputEmail1">运营位标题</label>-->
                    <#--<input type="text" required class="form-control" id="title" value="${banner.title}" name="title" placeholder="运营位名称">-->
                <#--</fieldset>-->
                <#--<fieldset class="form-group">-->
                    <#--<label for="name">编号</label>-->
                    <#--<input type="text" required class="form-control" name="num"  placeholder="编号" value="${banner.num}">-->
                    <#--<small class="text-muted">运营位在一个应用中的位置编号.</small>-->
                <#--</fieldset>-->
                <#--<fieldset class="form-group">-->
                    <#--<label>描述</label>-->
                    <#--<textarea class="form-control"  name="description" rows="3">${banner.description!}</textarea>-->
                    <#--<small class="text-muted">运营位的简单描述</small>-->
                <#--</fieldset>-->
                <fieldset class="form-group">
                    <label for="exampleSelect1">banner显示的位置</label>

                    <select class="form-control c-select" id="exampleSelect1" name="position.id">
                    <#list positionList as pos >
                        <option value="${pos.id}" <#if banner.position.id = pos.id>selected</#if> >${pos.name}</option>
                    </#list>
                    </select>
                    <small class="text-muted">.</small>
                </fieldset>
                <#--<fieldset class="form-group">-->
                    <#--<label for="exampleSelect2">小区(可选)</label>-->
                    <#--<select class="form-control c-select" id="exampleSelect2" name="community.id">-->
                        <#--<option value="1">管理员</option>-->
                        <#--<option value="2">运营</option>-->
                    <#--</select>-->
                <#--</fieldset>-->

                <fieldset class="form-group">
                    <label>标题</label>
                    <input type="text" class="form-control" name="title" value="${banner.title}">
                </fieldset>
                <fieldset class="form-group">
                    <label>编号</label>
                    <input type="text" class="form-control" name="num" value="${banner.num}">
                </fieldset>
                <fieldset class="form-group">
                    <label>主图</label>
                    <input type="text" class="form-control" name="masterImg" value="${banner.masterImg}">
                    <small class="text-muted">banner显示时的主要图片.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label>外部URL连接</label>
                    <input type="text" class="form-control" name="url" value="${banner.url}">
                    <small class="text-muted">点击后将跳转到该连接(如果同时选择了内容连接,将被替换).</small>
                </fieldset>
                <fieldset class="form-group">
                    <label>文章内容</label>
                    <input type="text" class="form-control" name="articleId" value="${banner.articleId}">
                    <small class="text-muted">点击后将跳转到该连接(如果同时选择了内容连接,将被替换).</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect1">状态</label>
                    <select class="form-control c-select" id="status" name="status" >
                        <option value="draft" selected>草图</option>
                        <option value="online">在线</option>
                        <option value="offline">离线</option>
                    </select>
                    <small class="text-muted">.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">起始时间</label>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="">开始时间</label>
                            <input type="date" class="form-control" id="startTime"  name="startTimeStr">
                        </div>
                        <div class="form-group">
                            <label for="">结束时间</label>
                            <input type="date" class="form-control" id="endTime"  name="endTimeStr">
                        </div>
                    </div>
                    <small class="text-muted">展示多长时间,如果时间很长,需要设置很大一个结束时间</small>
                </fieldset>

                <fieldset class="form-group">
                    <label>描述</label>
                    <textarea class="form-control" name="description"  rows="3" ></textarea>
                    <small class="text-muted">描述.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label>备注</label>
                    <textarea class="form-control" name="remark"  rows="3" ></textarea>
                    <small class="text-muted">主要用于内部标注描述.</small>
                </fieldset>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
