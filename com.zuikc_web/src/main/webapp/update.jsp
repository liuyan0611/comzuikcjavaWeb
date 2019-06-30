<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19-6-26
  Time: 下午3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="f2" method="post" action="/updateServlet">
    <div style="text-align: center">
        <input type="hidden" name="id" value="${user.id}">
        <h3>站点信息修改</h3>
        站点创建时间:<input type="text" name="siteTime" value="${user.siteTime}" placeholder="111"><br>
        站点编号:<input type="text" name="siteNum" value="${user.siteNum}"><br>
        <%--<input type="text" name="siteLocation" placeholder="请输入站点区域"><br>--%>
        站点区域:<select name="siteLocation">
        <option>海宁</option>
        <option>平湖</option>
        <option>昆山</option>
    </select><br>
        站点名称:<input type="text" name="siteName" value="${user.siteName}"><br>
        站点描述:<input type="text" name="siteDescription" value="${user.siteDescription}"><br>
        站点联系人:<input type="text" name="siteLinker" value="${user.siteLinker}"><br>
        站点日处理量:<input type="text" name="siteDayHandle" value="${user.siteDayHandle}"><br>
        站点通信方式:<input type="text" name="siteCommWay" value="${user.siteCommWay}"><br>
        站点经度:<input type="text" name="siteLong" value="${user.siteLong}"><br>
        站点纬度:<input type="text" name="siteLat" value="${user.siteLat}"><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </div>



</form>
</body>
</html>
