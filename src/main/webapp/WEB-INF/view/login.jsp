<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2021/1/26
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        .wrapper {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <form action="login" method="post">
            <label>用户ID：<input type="text" name="id"></label>
            <br><br>
            <label>密&nbsp;&nbsp;&nbsp;码: <input type="password" name="password"></label>
            <br><br>
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
