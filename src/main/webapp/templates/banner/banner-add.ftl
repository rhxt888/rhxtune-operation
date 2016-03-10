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
            <h5>添加Banner内容</h5>
            <form action="/banner/add" method="post">
                <fieldset class="form-group">
                    <label for="exampleInputEmail1">app</label>
                    <select class="form-control c-select" id="exampleSelect2" name="role">
                        <option value="admin" selected>甜园生活</option>
                        <option value="operation">甜园TV</option>
                    </select>
                    <small class="text-muted">.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="name">运营位</label>
                    <select class="form-control c-select" id="exampleSelect2" name="role">
                        <option value="admin" selected>首页顶部</option>
                        <option value="operation">邻里页中部</option>
                    </select>
                    <small class="text-muted">这个banner将显示于运营位上.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">小区(可选)</label>
                    <select class="form-control c-select" id="exampleSelect2" name="role">
                        <option value="admin" selected>管理员</option>
                        <option value="operation">运营</option>
                    </select>
                </fieldset>

                <fieldset class="form-group">
                    <label>标题</label>
                    <input type="text" class="form-control">
                </fieldset>
                <fieldset class="form-group">
                    <label>主图</label>
                    <input type="text" class="form-control">
                    <small class="text-muted">banner显示时的主要图片.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label>外部URL连接</label>
                    <input type="text" class="form-control">
                    <small class="text-muted">点击后将跳转到该连接(如果同时选择了内容连接,将被替换).</small>
                </fieldset>
                <fieldset class="form-group">
                    <label for="exampleSelect2">内容连接</label>
                    <select class="form-control c-select" id="exampleSelect2" name="role">
                        <option value="admin" selected>afasdfasdfasdf</option>
                        <option value="operation">alfdjasdfk</option>
                    </select>
                </fieldset>

                <fieldset class="form-group">
                    <label for="exampleSelect2">起始时间</label>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="exampleInputName2">开始时间</label>
                            <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">结束时间</label>
                            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
                        </div>
                    </div>
                    <small class="text-muted">展示多长时间,如果时间很长,需要设置很大一个结束时间</small>
                </fieldset>

                <fieldset class="form-group">
                    <label>描述</label>
                    <textarea class="form-control" name="remark"  rows="3"></textarea>
                    <small class="text-muted">描述.</small>
                </fieldset>
                <fieldset class="form-group">
                    <label>备注</label>
                    <textarea class="form-control" name="remark"  rows="3"></textarea>
                    <small class="text-muted">主要用于内部标注描述.</small>
                </fieldset>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 同时推送消息
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
