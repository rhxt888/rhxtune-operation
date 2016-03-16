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
                   <a class="nav-link" role="tab" href="/message"  data-toggle="tab">推送记录</a>
               </li>
               <li class="nav-item">
                   <a class="nav-link active" role="tab" data-toggle="tab">tag</a>
               </li>
               <li class="nav-item">
                   <a class="nav-link" href="/message/token" role="tab" data-toggle="tab">token</a>
               </li>
           </ul>

           <!-- Tab panes -->
           <#--<div class="tab-content">-->
               <#--<div role="tabpanel" class="tab-pane active" id="tag">-->

               <#--</div>-->
           <#--</div>-->
           <div class="tab-content">
               <div role="tabpanel" class="tab-pane active">
                   <div class="clearfix mvm">
                       <div class="pull-left">
                           <form class="form-inline">
                               <div class="form-group">
                                   <label class="sr-only" for="exampleInputEmail3">tag</label>
                                   <select class="c-select">
                                       <option selected="">运营位</option>
                                       <option value="1">One</option>
                                       <option value="2">Two</option>
                                       <option value="3">Three</option>
                                   </select>
                               </div>
                               <div class="form-group">
                                   <label class="sr-only" for="exampleInputPassword3">小区</label>
                                   <select class="c-select">
                                       <option selected="">小区</option>
                                       <option value="1">One</option>
                                       <option value="2">Two</option>
                                       <option value="3">Three</option>
                                   </select>
                               </div>
                               <button type="submit" class="btn btn-primary">查询</button>
                           </form>
                       </div>
                       <div class="pull-right">
                           <a href="/tag/add" class="btn btn-success-outline">添加tag</a>
                       </div>

                   </div>
                   <table class="table table-bordered">
                       <thead>
                       <tr>
                           <th>#编号</th>
                           <th>标题</th>
                           <th>状态</th>
                           <th>阅读数</th>
                           <th>起始时间</th>
                           <th>结束时间</th>
                           <th>操作</th>
                       </tr>
                       </thead>
                       <tbody>

                       <#if bannerList?has_content>
                           <#list bannerList.list as banner>
                           <tr>
                               <th scope="row">1</th>
                               <td>${banner.title}</td>
                               <td>
                                   <#if banner.status == 'draft'>
                                       草稿
                                   <#elseif banner.status == 'online'>
                                       已发布上线
                                   <#elseif banner.status == 'offline'>
                                       已下线
                                   </#if>
                               </td>
                               <td>${banner.viewCount}</td>
                               <td>
                                   <#if banner.startTime?exists>
                                        ${banner.startTime?number_to_date?string("MM/dd HH:mm")!}
                                    </#if>
                               </td>
                               <td>
                                   <#if banner.endTime?exists>
                                        ${banner.endTime?number_to_date?string("MM/dd HH:mm")!}
                                    </#if>
                               </td>
                               <td>
                                   <a href="/banner/${banner.id}/update" class="btn btn-sm btn-info-outline">修改</a>
                                   <a href="/banner/${banner.id}/del" class="btn btn-sm btn-info-outline">删除</a>
                                   <a href="/banner/${banner.id}" class="btn btn-sm btn-info-outline">详情</a>
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
