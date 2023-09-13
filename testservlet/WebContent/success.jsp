<%@ page import="model.message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>???</title>
</head>
<body>
<h1>???</h1>
<form action="addMessage" method="post">
    <input type="text" name="username" placeholder="?????"><br>
    <textarea name="content" cols="30" rows="10" placeholder="???????"></textarea><br>
    <input type="submit" value="??">
</form>
<hr>


<%
    List<message> list = (List<message>) request.getAttribute("messages");
    if (list == null) {
        list = new ArrayList<>();
    }
    System.out.println("list.size() = " + list.size());
    for (message msg : list) {
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
}


</body>
</html>