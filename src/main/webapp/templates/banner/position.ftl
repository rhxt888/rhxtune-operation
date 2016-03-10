<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>运营位-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-12">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link" href="/banner" role="tab" data-toggle="tab">运营位内容</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link  active"  role="tab" data-toggle="tab">运营位</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active">
                    <div class="clearfix mvm">
                        <div class="pull-left">
                            <form class="form-inline">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputEmail3">APP</label>
                                    <select class="c-select">
                                        <option selected="">APP</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">查询</button>
                            </form>
                        </div>
                        <div class="pull-right">
                            <a href="/banner/position/add" class="btn btn-success-outline">添加运营位</a>
                        </div>

                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#编号</th>
                            <th>名称</th>
                            <th>别名(标识)</th>
                            <th>启用状态</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if positionList?has_content>
                            <#list positionList.list?exists as position>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>
                                    <a href="/${position.id}/update" class="btn btn-sm btn-info-outline">修改</a>
                                    <a href="/${position.id}/del" class="btn btn-sm btn-info-outline">删除</a>
                                    <a href="/${position.id}" class="btn btn-sm btn-info-outline">详情</a>
                                </td>
                            </tr>
                            </#list>
                        <#else>

                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
