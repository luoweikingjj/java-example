<%--
  Created by IntelliJ IDEA.
  User: luowe
  Date: 2020/10/7
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
</head>
<body>
    <form action="loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="check_code"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="checkCodeServlet"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>

<div>
    <%
        if (request.getAttribute("req_error") != null) {
            response.getWriter().write(request.getAttribute("req_error").toString());
        }
    %>
</div>
</body>
</html>
