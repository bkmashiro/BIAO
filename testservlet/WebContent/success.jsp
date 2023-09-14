<%@ page import="model.message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="org.easybooks.test.jdbc.SqlSrvDBConn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Comment Board</title>
</head>
<body>
<h1>Comment Board</h1>
<form action="addMessage" method="post">
    <input type="text" name="username" placeholder="display name"><br>
    <textarea name="content" cols="30" rows="10" placeholder="comment"></textarea><br>
    <input type="submit" value="submit">
</form>
<hr>


<%
    List<message> messages = new ArrayList<>();
    String sql = "select * from comment";
    SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
    ResultSet rs = sqlsrvdb.executeQuery(sql);

    try {
        while (rs.next()) {
            message msg = new message();
            msg.setId(rs.getInt(1));
            msg.setSentBy(rs.getString(2));
            msg.setContent(rs.getString(3));
            messages.add(msg);
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    sqlsrvdb.closeStmt();
    sqlsrvdb.closeConn();

    System.out.println("messages.size() = " + messages.size());
    for (message msg : messages) {
%>
<div>
    <h3>
        <%=msg.getSentBy()%>
    </h3>
    <p>
        <%=msg.getContent()%>
    </p>
</div>
<%
    }
%>



</body>
</html>