package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	public static Connection oracleCon() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","c##java","1234");
			
		} catch(Exception e) {
			System.out.println("DB 연결 실패");
		}
		return connection;
	}
}