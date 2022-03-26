package com.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LearnerAcademy.Bean.ClassBean;
import com.LearnerAcademy.util.DBconnection;

public class ClassDao {
//----------------------------------------------
	
	public boolean InsertClass(ClassBean bean){
	boolean InsertStatus= false;
	//String query="insert into class (clid,clname,classtime,fksbid,fktchrid) values(?,?,?,?,?)";
	try {
			Connection con=DBconnection.getConnection();
			String query="insert into class (clid,clname,classtime,fksbid,fktchrid) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,bean.getClid());
			pstmt.setString(2,bean.getClname());
			pstmt.setString(3,bean.getClasstime());
			pstmt.setInt(4,bean.getFksbid());
			pstmt.setInt(5,bean.getFktchrid());
			pstmt.executeUpdate();
			//if (count>0) {
				InsertStatus=true;		
	System.out.println("rows impacte");
	}
			catch(Exception e) {
				e.printStackTrace();
				}
			return InsertStatus;
			}
		//-------------------------------------------
    public ClassBean getClassById(int clid) {
    	ClassBean bean=new ClassBean();
    	try {
    		Connection con=DBconnection.getConnection();
    		Statement stmt=con.createStatement();
    		String query="select * from class where clid="+clid;
    		ResultSet  rs=stmt.executeQuery(query);
    		if (rs.next()) {
    			bean.setClid((rs.getInt(1)));
    			bean.setClname((rs.getString(2)));
    			bean.setClasstime((rs.getString(3)));
    			bean.setFksbid((rs.getInt(4)));
    			bean.setFktchrid((rs.getInt(5)));
    		}else {
    		bean=null;
    		}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    	return bean;
}
	//------------------------------------------

    public List<ClassBean> getAllClassDetail() {
List<ClassBean> listOfClass=new ArrayList<ClassBean>();
	try{
		Connection con = DBconnection.getConnection();
	Statement stmt = con.createStatement();
	String query ="Select * from class";
	ResultSet rs  = stmt.executeQuery(query);
	while(rs.next()) {
		
	ClassBean bean=new ClassBean();
	bean.setClid((rs.getInt(1)));
	bean.setClname((rs.getString(2)));
	bean.setClasstime((rs.getString(3)));
	bean.setFksbid((rs.getInt(4)));
	bean.setFktchrid((rs.getInt(5)));
	listOfClass.add(bean);
}
    } catch (Exception e) {
    	e.printStackTrace();
    }
    return listOfClass;
    }
	//------------------------------------
    public int deleteClassById(int clid) {
    	int deleteCount=0;
    	try {
    		Connection con=DBconnection.getConnection();
    		String query="delete class where clid=?";
    		PreparedStatement pstmt=con.prepareStatement(query);
    		pstmt.setInt(1,clid);
    		deleteCount=pstmt.executeUpdate();
    		System.out.println("rows impacted: "+deleteCount);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return clid;
    	
    	
	
}
	//--------------------------------------
    public boolean updateClassById(ClassBean bean) {
    boolean updateStatus= false;
    try {
    Connection con=DBconnection.getConnection();
    String query="update class set clname=?,classtime=?,fksbid=?,fktchrid=? where clid=?";
    PreparedStatement pstmt=con.prepareStatement(query);
    pstmt.setString(1,bean.getClname());
    pstmt.setString(2,bean.getClasstime());
    pstmt.setInt(3,bean.getFksbid());
    pstmt.setInt(4,bean.getFktchrid());
    pstmt.setInt(5,bean.getClid());
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