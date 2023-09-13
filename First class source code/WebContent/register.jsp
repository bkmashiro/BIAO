<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
    <title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<form action="registerUser.jsp" method="post">
    <table>
        <caption>用户注册</caption>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" size="20"/>
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <input type="password" name="password" size="21"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="register"/>
    <input type="reset" value="reset"/>
</form>
已经注册？单击<a href="">here</a>login！
</body>
</html>
