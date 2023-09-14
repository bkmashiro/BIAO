package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.message;
import org.easybooks.test.jdbc.SqlSrvDBConn;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class getMessages extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");                //…Ë÷√«Î«Û±‡¬Î
        String uname = request.getParameter("username");
        String content = request.getParameter("content");
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();

        String insertSql = "insert into comment(sentBy, content) values('" + uname + "', '" + content + "')";

        sqlsrvdb.executeUpdate(insertSql);


        sqlsrvdb.closeStmt();
        sqlsrvdb.closeConn();


        response.sendRedirect("success.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
