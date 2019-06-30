<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19-6-25
  Time: 下午4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>智慧水务云平台</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <%--<script>--%>
        <%--window.onload=function () {--%>
            <%--function f1() {--%>
                <%--this.href = ""--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
    <style>
        td{
            border: 1px solid green;
            background-color: #9acfea;
            text-align: center;
            width: 150px;
            height: 35px;
        }
        /*tr{*/
            /*border: 1px solid green;*/
            /*width: 1000px;*/
            /*height: 60px;*/
            /*!*background-color: darkseagreen;*!*/
            /*text-align: center;*/
        /*}*/
    </style>
</head>
<body>
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        站点监控
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="#">设备操作</a></li>
        <li><a href="#">实时视频</a></li>
    </ul>
</div>
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        警报管理
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
        <li><a href="#">告警管理</a></li>
    </ul>
</div>
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        运行报表
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
        <li><a href="#">水质监测录入</a></li>
        <li><a href="#">考勤记录</a></li>
        <li><a href="#">水质检测</a></li>
        <li><a href="#">设备运行报表</a></li>
    </ul>
</div>
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        站点管理
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
        <li><a href="/selectServlet">站点统计</a></li>
        <li><a href="/listServlet?currentPage=1&pageSize=5">站点维护</a></li>
    </ul>
</div>
<div>
    <%--<table>--%>
        <%--<caption><h2>站点统计</h2></caption>--%>
        <%--<tr>--%>
            <%--<td><input type="checkbox"></td>--%>
            <%--<td>站点创建时间</td>--%>
            <%--<td>站点编号</td>--%>
            <%--<td>站点区域</td>--%>
            <%--<td>站点名称</td>--%>
            <%--<td>站点描述</td>--%>
            <%--<td>站点日处理量</td>--%>
            <%--<td>站点通信方式</td>--%>
            <%--<td>站点经度</td>--%>
            <%--<td>站点纬度</td>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${users}" varStatus="s" var="user">--%>
            <%--<tr>--%>
            <%--<td><input type="checkbox"></td>--%>
            <%--<td>${user.siteTime}</td>--%>
            <%--<td>${user.siteNum}</td>--%>
            <%--<td>${user.siteLocation}</td>--%>
            <%--<td>${user.siteName}</td>--%>
            <%--<td>${user.siteDescription}</td>--%>
            <%--<td>${user.siteDayHandle}</td>--%>
            <%--<td>${user.siteCommWay}</td>--%>
            <%--<td>${user.siteLong}</td>--%>
            <%--<td>${user.siteLat}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%@include file="map.jsp"%>

    </table>

</div>

</body>
</html>
