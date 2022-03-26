package com.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.LearnerAcademy.Bean.UserBean;
import com.LearnerAcademy.util.DBconnection;

public class UserDao {

	public UserBean  getUserByUserName(int username) {
		UserBean bean =new UserBean();
		try {
			Connection con=DBconnection.getConnection();
			
			String Query="select * from emp_login where username= "+username;	
			PreparedStatement pstmt=con.prepareStatement(Query);
			ResultSet rs =pstmt.executeQuery(Query);
			if (rs.next()) {
				bean.setUserName((rs.getInt(1)));
				bean.setPassword((rs.getString(2)));
				bean.setType(rs.getString(3));
			}else {
				bean=null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} return bean;
	
	}
}
