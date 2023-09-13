package org.easybooks.test.jdbc;
import java.sql.*;
public class SqlSrvDBConn {
	private Statement stmt;			// Statement������䣩
    	private Connection conn;		// Connection�������ӣ�
    	ResultSet rs;				// ResultSet���󣨽������
    	//�ڹ��췽���д������ݿ�����
    	public SqlSrvDBConn(){
    	stmt=null;
    	try{
    		/**���ز�ע�� SQLServer��JDBC����*/
    		Class.forName("com.mysql.jdbc.Driver");
    		/**��д�����ַ�������ȡ��������*/
		conn=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/J2EE","root","admin");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	rs=null;
    }
    //ִ�в�ѯ���SQL��䣬�з��ؼ�
    public ResultSet executeQuery(String sql)
    {
        try
        {
        	   stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
											,ResultSet.CONCUR_UPDATABLE);
        	   rs=stmt.executeQuery(sql);	//ִ�в�ѯ���
        }catch(SQLException e){
        	   System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;					//���ؽ����
    }
    //�رն���
    public void closeStmt()
    {
        try
        {
            stmt.close();				//�ر�Statement����
        }catch(SQLException e){
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
    public void closeConn()
    {
        try
        {
            conn.close();				//�ر�����
        }catch(SQLException e){
        	   System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
}