package comm;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class DbConnect {
	public static Connection Connection() throws Exception {
		return DriverManager.getConnection 
				("jdbc:oracle:thin:@//localhost:1521/orcl","c##java","1234");
	}
	
	public static Connection mysqlConnect() throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection
				("jdbc:mysql://localhost:3306/apple1004?useUnicode=true&characterEncoding=utf8","test1004","1234");
	}
}