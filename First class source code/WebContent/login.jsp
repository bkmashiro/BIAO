<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
	<title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<form action="validate.jsp" method="post">
<table>
	<caption>用户登录</caption>
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
<input type="submit" value="login"/>
<input type="reset" value="reset"/>
</form>
如果没注册单击<a href="http://localhost:8080/Test1_war_exploded/register.jsp">here</a>register！
</body>
</html>
