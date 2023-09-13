<%@ page language="java" pageEncoding="gb2312" import="java.sql.*,org.easybooks.test.jdbc.SqlSrvDBConn" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
</head>
<body>
<%
    request.setCharacterEncoding("gb2312");
    String usr = request.getParameter("username");
    String pwd = request.getParameter("password");

    SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();


    String sql = String.format(
            "INSERT INTO `j2ee`.`usertable` (`username`, `password`) VALUES ('%s', '%s')",
            usr, pwd
    );
    int res = SqlSrvDB.executeUpdate(sql);
    SqlSrvDB.closeStmt();
    SqlSrvDB.closeConn();
if (res == 1) {
%>

<jsp:forward page="main.jsp"/>

<%

} else {

%>

<jsp:forward page="error.jsp"/>

<%
}
%>

</body>
</html>
