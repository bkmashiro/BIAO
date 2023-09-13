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
        request.setCharacterEncoding("gb2312");                //�����������
        String usr = request.getParameter("username");            //��ȡ�ύ���û���
        String pwd = request.getParameter("password");            //��ȡ�ύ������
        userTable user = new userTable();
        user.setUsername(usr);
        user.setPassword(pwd);
        boolean validated = false;                            //��֤�ɹ���ʶ
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from userTable";
        ResultSet rs = sqlsrvdb.executeQuery(sql);                //ȡ�ý����
        try {
            while (rs.next()) {
                if ((rs.getString("username").trim().compareTo(usr) == 0) && (rs.getString("password").
                        compareTo(pwd) == 0)) {
                    user.setId(rs.getInt(1));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    validated = true;                //��ʶΪtrue��ʾ��֤�ɹ�ͨ��
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
            //��֤ʧ����ת��error.jsp
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
