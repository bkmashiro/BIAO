package servlet;

import model.userTable;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import org.easybooks.test.jdbc.SqlSrvDBConn;


public class _2_3hello extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");                //设置请求编码
        String usr = request.getParameter("username");            //获取提交的用户名
        String pwd = request.getParameter("password");            //获取提交的密码
        userTable user = new userTable();
        user.setUsername(usr);
        user.setPassword(pwd);
        boolean validated = false;                            //验证成功标识
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from userTable";
        ResultSet rs = sqlsrvdb.executeQuery(sql);                //取得结果集
        try {
            while (rs.next()) {
                if ((rs.getString("username").trim().compareTo(usr) == 0) && (rs.getString("password").
                        compareTo(pwd) == 0)) {
                    user.setId(rs.getInt(1));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    validated = true;                //标识为true表示验证成功通过
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlsrvdb.closeStmt();
        sqlsrvdb.closeConn();
        if (validated) {
            response.sendRedirect("success.jsp");
        } else {
            //验证失败跳转到error.jsp
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
