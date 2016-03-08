<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/spaces.css">
    <title>消息-瑞华信通运营系统</title>
</head>
<body>
<#include "../fragment/navbar.html">
<div class="container-fluid mtm">
    <div class="row">
        <div class="col-sm-10">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" role="tab" data-toggle="tab">推送记录</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/message/tag" role="tab" data-toggle="tab">tag</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/message/token" role="tab" data-toggle="tab">token</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>类型</th>
                            <th>消息标题</th>
                            <th>发送时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list messageList.list?exists as message>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>
                                <#--<a href="/${message.id}" class="btn btn-sm btn-info-outline">详情</a>-->
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
