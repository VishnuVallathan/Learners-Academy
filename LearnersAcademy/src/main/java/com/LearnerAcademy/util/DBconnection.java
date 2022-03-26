package com.LearnerAcademy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	public static  Connection getConnection() {
		Connection con=null;
		try {
Class.forName("com.mysql.cj.jdbc.Driver");
 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","Hind@123");
	
		}
		catch (Exception e) {
			System.out.print(e);
		}
	return con;
}
}
