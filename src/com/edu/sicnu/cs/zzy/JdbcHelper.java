package com.edu.sicnu.cs.zzy;

import java.sql.*;
public class JdbcHelper {
	private String ClassName="com.mysql.cj.jdbc.Driver";
	private String usr="root";
	private String password="root";
	private String url="jdbc:mysql://localhost:3306/first_db";
	//定义数据库连接对象
    private Connection conn;
    //SQL语句执行的容器对象
    private Statement stmt;
    
    public JdbcHelper() {
    	try {
    		//加载数据库连接的驱动程序类
			Class.forName(ClassName);
		    System.out.println("Success loading Mysql Driver!");
			//实例化连接对象
			conn = (Connection)DriverManager.getConnection(url, usr, password);
		    System.out.println("Success connect Mysql server!");
			//实例化SQL语句执行的容器对象
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Loading or connect is wrong!!!");
		}
    }//构造函数
    
    
    //根据参数SQL执行数据修改命令
    public long Update(String SQL){
        try {
            long result=stmt.executeUpdate(SQL);
            System.out.println("Success to Update!!!");
            return result;
        } catch (Exception e) {
            return -1;
        }
    }
    //根据参数SQL执行查询数据命令
    public ResultSet Query(String SQL){
       ResultSet rs;
		try {
			rs =  stmt.executeQuery(SQL);
			while(rs.next()) {
		        System.out.print(rs.getString(1));
		        System.out.println(rs.getString(2));
			}
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Fail to query!!!");
			return null;
		}
    }
}
