<%@ page language="java" pageEncoding="gb2312" import="java.sql.*,org.easybooks.test.jdbc.SqlSrvDBConn"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    </head>
    <body>
        <%
        	   request.setCharacterEncoding("gb2312");			//设置请求编码
            String usr=request.getParameter("username");			//获取提交的用户名
            String pwd=request.getParameter("password");		//获取提交的密码
            boolean validated=false;						//验证成功标识
            SqlSrvDBConn SqlSrvDB=new SqlSrvDBConn();
            //查询userTable表中的记录
            String sql="select * from userTable";
            ResultSet rs=SqlSrvDB.executeQuery(sql);	//取得结果集
            while(rs.next())
            {
                if((rs.getString("username").trim().compareTo(usr)==0)
							&&(rs.getString("password").compareTo(pwd)==0))
                {
                    validated=true;						//标识为true表示验证成功通过
                }
            }
            rs.close();
            SqlSrvDB.closeStmt();					//关闭语句
            SqlSrvDB.closeConn();					//关闭连接
            if(validated)
            {
                //验证成功跳转到main.jsp
        %>
                <jsp:forward page="main.jsp"/>
        <%
            }
            else
            {
                //验证失败跳转到error.jsp
        %>
                <jsp:forward page="error.jsp"/>
        <%
            }
        %>
    </body>
</html>
