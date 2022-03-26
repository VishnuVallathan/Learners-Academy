package com.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LearnerAcademy.Bean.TeacherBean;
import com.LearnerAcademy.util.DBconnection;

public class TeacherDao {
//----------------------------------------------
	public boolean InsertTeacher(TeacherBean tbean) {
	boolean insertTStatus= false;
	try {
			Connection con=DBconnection.getConnection();
			String query="insert into teacher values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,tbean.getTid());
			pstmt.setString(2,tbean.getTname());
			pstmt.setString(3,tbean.getTlname());
			int count=pstmt.executeUpdate();
			if (count>0) {
				insertTStatus=true;
			}System.out.println("rows immapcted:"+count);
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			return insertTStatus;
			}
	
	//-------------------------------------------
    public TeacherBean getTeacherByID(int tid) {
    	TeacherBean tbean=new TeacherBean();
    	try {
    		Connection con=DBconnection.getConnection();
    		Statement stmt=con.createStatement();
    		String query="select * from teacher where tid="+tid;
    		ResultSet  rs=stmt.executeQuery(query);
    		if (rs.next()) {
    			tbean.setTid((rs.getInt(1)));
    			tbean.setTname((rs.getString(2)));
    			tbean.setTlname((rs.getString(3)));
    		}else {
    		tbean=null;
    		}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    	return tbean;
}
	//------------------------------------------

    public List<TeacherBean> getAllTeacherDetail() {
List<TeacherBean> listOfTeacher=new ArrayList<TeacherBean>();
	try{
		Connection con = DBconnection.getConnection();
	Statement stmt = con.createStatement();
	String query ="Select * from teacher";
	ResultSet rs  = stmt.executeQuery(query);
	while(rs.next()) {
		
	TeacherBean tbean=new TeacherBean();
	tbean.setTid((rs.getInt(1)));
	tbean.setTname((rs.getString(2)));
	tbean.setTlname((rs.getString(3)));
	listOfTeacher.add(tbean);
}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    return listOfTeacher;
    }
	//------------------------------------
    public int deleteTeacherById(int tid) {
    	int deleteCount=0;
    	try {
    		Connection con=DBconnection.getConnection();
    		String query="delete teacher where tid=?";
    		PreparedStatement pstmt=con.prepareStatement(query);
    		pstmt.setInt(1,tid);
    		deleteCount=pstmt.executeUpdate();
    		System.out.println("rows impacted: "+deleteCount);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return tid;
    	
    	
	
}
	//--------------------------------------
    public boolean updateTeacherById(TeacherBean tbean)
    {boolean updateStatus= false;
    try {
    Connection con=DBconnection.getConnection();
    String query="update teacher set tname=?,tlname=? where tid=?";
    PreparedStatement pstmt=con.prepareStatement(query);
    pstmt.setString(1,tbean.getTname());
    pstmt.setString(2,tbean.getTlname());
    pstmt.setInt(3,tbean.getTid());
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