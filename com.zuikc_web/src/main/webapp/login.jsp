<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19-6-25
  Time: 下午4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>站点登录</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        // $(function () {
        //     $("#checkCode").click(function () {
        //         alert(this)
        //         $(this).src="/checkCodeServlet?time="+new Date()
        //     })
        // })
        window.onload = function () {
            document.getElementById("check_Code").onclick = function () {

                this.src = "/checkCodeServlet?time="+new Date()
            }
        }

    </script>
    <style>
        #firstDiv{
            /*border: 1px solid blue;*/
            width: 100%;
            margin: 0 auto;
            text-align: center;
            background-color: lavender;
            margin-top: 100px;
        }

    </style>
    <script>
        $(function () {
            $("#checkCode").blur(function () {
                var checkCode = $(this).val();
                $.get("loginCheckCodeAjaxServlet",{"checkCode":checkCode},function (data) {
                    var span_checkCode = $("#span_checkCode")
                    if (data.exsit){
                        span_checkCode.css("color","green")
                        span_checkCode.html(data.msg)

                    } else {
                        span_checkCode.css("color","red")
                        span_checkCode.html(data.msg)

                    }
                },"json")
            })
        })
    </script>
</head>
<body>
<div id="firstDiv">
    <div><h2>智慧水务云平台登录系统</h2></div>
    <form method="post" action="/loginServlet">
        <div>用户名：<input type="text"name="username" placeholder="请输入用户名"></div><span id="span_username"></span>
        <div>密码&nbsp;：&nbsp;&nbsp;&nbsp;<input type="password" name="password" placeholder="请输入密码"></div><span id="span_password"></span>
        <%--<div>邀请码：<input type="text" name="inviteCode" placeholder="请输入四位邀请码"></div><span id="span_inviteCode"></span>--%>
        <div>验证码：<input type="text" name="checkCode" id="checkCode" placeholder="请输入下方验证码"><span id="span_checkCode"></span></div>
        <div><img src="/checkCodeServlet" id="check_Code"> </div>
        <div><input type="submit" value="登录"><input type="reset" value="重置"></div>
        <div><a href="regist.jsp">注册界面</a></div>
        <div><span id="message">${msg}</span></div>
    </form>
</div>
</body>
</html>
