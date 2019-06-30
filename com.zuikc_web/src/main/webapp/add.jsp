<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19-6-26
  Time: 上午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
</head>
<body>
<form name="f1" method="post" action="/addServlet">
    <div style="text-align: center">
        <h3>站点信息添加</h3>
        站点创建时间:<input type="text" name="siteTime" placeholder="请输入站点创建时间"><br>
        站点编号:<input type="text" name="siteNum" placeholder="请输入站点编号（格式**-**，允许字母和数字）"><br>
    <%--<input type="text" name="siteLocation" placeholder="请输入站点区域"><br>--%>
        站点区域:<select name="siteLocation">
            <option>海宁</option>
            <option>平湖</option>
            <option>昆山</option>
        </select><br>
        站点名称:<input type="text" name="siteName" placeholder="请输入站点名称"><br>
        站点描述:<input type="text" name="siteDescription" placeholder="请输入站点描述"><br>
        站点联系人:<input type="text" name="siteLinker" placeholder="请输入站点联系人"><br>
        站点日处理量:<input type="text" name="siteDayHandle" placeholder="请输入站点日处理量"><br>
        站点通信方式:<input type="text" name="siteCommWay" placeholder="请输入站点通信方式"><br>
        站点经度:<input type="text" name="siteLong" placeholder="请输入站点经度"><br>
        站点纬度:<input type="text" name="siteLat" placeholder="请输入站点纬度"><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </div>



</form>
</body>
</html>
