package com.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LearnerAcademy.Bean.SubjectBean;
import com.LearnerAcademy.util.DBconnection;

public class SubjectDao {
//----------------------------------------------
	public boolean InsertSubject(SubjectBean sbbean) {
	boolean insertStatus= false;
	try {
			Connection con=DBconnection.getConnection();
			String query="insert into subject values(?,?,)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,sbbean.getSbid());
			pstmt.setString(2,sbbean.getSbname());
			
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
    public SubjectBean getSubjectByiD(int sbid) {
    	SubjectBean sbbean=new SubjectBean();
    	try {
    		Connection con=DBconnection.getConnection();
    		Statement stmt=con.createStatement();
    		String query="select * from subject where sbid="+sbid;
    		ResultSet  rs=stmt.executeQuery(query);
    		if (rs.next()) {
    			sbbean.setSbid((rs.getInt(1)));
    			sbbean.setSbname((rs.getString(2)));
    		
    		}else {
    		sbbean=null;
    		}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    	return sbbean;
}
	//------------------------------------------

    public List<SubjectBean> getAllSubjectDetail() {
List<SubjectBean> listOfSubject=new ArrayList<SubjectBean>();
	try{
		Connection con = DBconnection.getConnection();
	Statement stmt = con.createStatement();
	String query ="Select * from subject";
	ResultSet rs  = stmt.executeQuery(query);
	while(rs.next()) {
		
	SubjectBean sbbean=new SubjectBean();
	sbbean.setSbid((rs.getInt(1)));
	sbbean.setSbname((rs.getString(2)));

	listOfSubject.add(sbbean);
}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    return listOfSubject;
    }
	//------------------------------------
    public int deleteSubjectById(int sbid) {
    	int deleteCount=0;
    	try {
    		Connection con=DBconnection.getConnection();
    		String query="delete subject where sbid=?";
    		PreparedStatement pstmt=con.prepareStatement(query);
    		pstmt.setInt(1,sbid);
    		deleteCount=pstmt.executeUpdate();
    		System.out.println("rows impacted: "+deleteCount);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return sbid;	
}
	//--------------------------------------
    public boolean updateSubjectById(SubjectBean sbbean)
    {boolean updateStatus= false;
    try {
    Connection con=DBconnection.getConnection();
    String query="update subject set Sbname=?, where sbid=?";
    PreparedStatement pstmt=con.prepareStatement(query);
    pstmt.setString(1,sbbean.getSbname());
  
    pstmt.setInt(2,sbbean.getSbid());
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