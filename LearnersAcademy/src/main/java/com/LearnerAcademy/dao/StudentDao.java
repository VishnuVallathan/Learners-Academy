package com.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LearnerAcademy.Bean.StudentBean;
import com.LearnerAcademy.util.DBconnection;

public class StudentDao {
//----------------------------------------------
	public boolean InsertStudent(StudentBean bean) {
	boolean insertStatus= false;
	try {
			Connection con=DBconnection.getConnection();
			String query="insert into student values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,bean.getSid());
			pstmt.setString(2,bean.getSname());
			pstmt.setString(3,bean.getSlname());
			pstmt.setInt(4,bean.getFkclsid());
			
			int count=pstmt.executeUpdate();
			if (count>0) {
				insertStatus=true;
			}System.out.println("rows immapcted:"+count);
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			return insertStatus;
			}
	
	//-------------------------------------------
    public StudentBean getStudentByiD(int sid) {
    	StudentBean bean=new StudentBean();
    	try {
    		Connection con=DBconnection.getConnection();
    		Statement stmt=con.createStatement();
    		String query="select * from student where sid="+sid;
    		ResultSet  rs=stmt.executeQuery(query);
    		if (rs.next()) {
    			bean.setSid((rs.getInt(1)));
    			bean.setSname((rs.getString(2)));
    			bean.setSlname((rs.getString(3)));
    			bean.setFkclsid((rs.getInt(4)));
    		
    		}else {
    		bean=null;
    		}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    	return bean;
}
	//------------------------------------------

    public List<StudentBean> getAllStudentDetail() {
List<StudentBean> listOfStudent=new ArrayList<StudentBean>();
	try{
		Connection con = DBconnection.getConnection();
	Statement stmt = con.createStatement();
	String query ="Select * from student";
	ResultSet rs  = stmt.executeQuery(query);
	while(rs.next()) {
		
	StudentBean bean=new StudentBean();
	bean.setSid((rs.getInt(1)));
	bean.setSname((rs.getString(2)));
	bean.setSlname((rs.getString(3)));
	bean.setFkclsid((rs.getInt(4)));

	listOfStudent.add(bean);
}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    return listOfStudent;
    }
	//------------------------------------
    public int deleteStudentById(int sid) {
    	int deleteCount=0;
    	try {
    		Connection con=DBconnection.getConnection();
    		String query="delete student where sid=?";
    		PreparedStatement pstmt=con.prepareStatement(query);
    		pstmt.setInt(1,sid);
    		deleteCount=pstmt.executeUpdate();
    		System.out.println("rows impacted: "+deleteCount);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return sid;
    	
    	
	
}
	//--------------------------------------
    public boolean updateStudentById(StudentBean bean)
    {boolean updateStatus= false;
    try {
    Connection con=DBconnection.getConnection();
    String query="update class set Sname=?,Slname=?,fkFkclsid=?, where sid=?";
    PreparedStatement pstmt=con.prepareStatement(query);
    pstmt.setString(1,bean.getSname());
    pstmt.setString(2,bean.getSlname());
    pstmt.setInt(3,bean.getFkclsid());
  
    pstmt.setInt(4,bean.getSid());
    int count=pstmt.executeUpdate();
    if (count>0) {
    	updateStatus=true;
    }
    System.out.println("rows impacte:"+count);
    } catch (Exception e) {
    	e.printStackTrace();
    }
    return updateStatus;
}
}