package com.LearnerAcademy.controller;

import java.io.IOException;
import java.util.List;

import com.LearnerAcademy.Bean.ClassBean;
import com.LearnerAcademy.Bean.StudentBean;
import com.LearnerAcademy.Bean.SubjectBean;
import com.LearnerAcademy.Bean.TeacherBean;
import com.LearnerAcademy.Bean.UserBean;

import LearnerAcademy.service.AdminService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
AdminService service=new AdminService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String buttonValue =request.getParameter("button");
	if(buttonValue.equalsIgnoreCase("save")) 
	{
		int clid=Integer.parseInt(request.getParameter("clid"));
		String clname=request.getParameter("clname");
		String classtime=request.getParameter("classtime");
		int fksbid=Integer.parseInt(request.getParameter("fksbid"));
		int fktchrid=Integer.parseInt(request.getParameter("fktchrid"));
		
		ClassBean bean= new ClassBean();
		bean.setClid(clid);
		bean.setClname(clname);
		bean.setClasstime(classtime);
		bean.setFksbid(fksbid);
		bean.setFktchrid(fktchrid);
		boolean InsertStatus =service.SaveClass(bean);
		
		if  (InsertStatus) {
			RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
			rd.forward(request,response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
		}
		//------------------------update-class---------------------------
	}
	else if (buttonValue.equalsIgnoreCase("Update"))
	{
		
			int clid=Integer.parseInt(request.getParameter("clid"));
			String clname=request.getParameter("clname");
			String classtime=request.getParameter("classtime");
			int fksbid=Integer.parseInt(request.getParameter("fksbid"));
			int fktchrid=Integer.parseInt(request.getParameter("fktchrid"));
			
			ClassBean bean= new ClassBean();
			bean.setClid(clid);
			bean.setClname(clname);
			bean.setClasstime(classtime);
			bean.setFksbid(fksbid);
			bean.setFktchrid(fktchrid);
			boolean UpdateStatus =service.updateClass(bean);
			
			if  (UpdateStatus) {
				RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
				rd.forward(request,response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
				rd.forward(request, response);
			}
		
		//-----------------------delete-class----------------
	}else if (buttonValue.equalsIgnoreCase("Delete")) {
		int clid=Integer.parseInt(request.getParameter("clid"));
		int value=service.deleteClass(clid);
		if(value>0) {
			RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
		}
		//---------------------------------------class list----------
	}else if (buttonValue.equalsIgnoreCase("FindAll")) {
			List<ClassBean> list=service.FindAllClasses();
		if(list==null) {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
		}else {
			request.setAttribute("listofclobj", list);
			RequestDispatcher rd=request.getRequestDispatcher("/ViewClassAllDetail.jsp");
		rd.forward(request, response);
		
		}
		//-----------------------------------------find class by id-------------
	}else if (buttonValue.equalsIgnoreCase("Find")) {
		int clid=Integer.parseInt(request.getParameter("clid"));
	ClassBean bean =service.FindClassById(clid);
	if(bean==null) {
		RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
	}else {
		request.setAttribute("clobj", bean);
		RequestDispatcher rd=request.getRequestDispatcher("/ViewClassDetail.jsp");
	rd.forward(request, response);
	}
	}else if (buttonValue.equalsIgnoreCase("tFindAll")) {
		List<TeacherBean> tlist=service.FindAllTeacher();
	if(tlist==null) {
		RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
	}else {
		request.setAttribute("listoftchrobj", tlist);
		RequestDispatcher rd=request.getRequestDispatcher("/ViewTeacherAllDetail.jsp");
	rd.forward(request, response);
	}
	}//-----------------------------------------find teacher by id--------------
	else if (buttonValue.equalsIgnoreCase("tFind")) {
		int tid=Integer.parseInt(request.getParameter("tid"));
	TeacherBean tbean =service.FindTeacherById(tid);
	if(tbean==null) {
		RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
	}else {
		request.setAttribute("tchrobj", tbean);
		RequestDispatcher rd=request.getRequestDispatcher("/ViewTeacherDetail.jsp");
	rd.forward(request, response);
	}
	
//================================teacher save=================
	}if(buttonValue.equalsIgnoreCase("tsave")) 
	{
		int tid=Integer.parseInt(request.getParameter("tid"));
		String tname=request.getParameter("tname");
		String tlname=request.getParameter("tlname");
		
		TeacherBean tbean= new TeacherBean();
		tbean.setTid(tid);
		tbean.setTname(tname);
		tbean.setTlname(tlname);
		boolean InsertTStatus =service.saveTeacher(tbean);
		
		if  (InsertTStatus) {
			RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
			rd.forward(request,response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
		}
		//------------------------update teacher----------------------------
	}
	else if (buttonValue.equalsIgnoreCase("tUpdate"))
	{
		
			int tid=Integer.parseInt(request.getParameter("tid"));
			String tname=request.getParameter("tname");
			String tlname=request.getParameter("tlname");
			
			TeacherBean tbean= new TeacherBean();
			tbean.setTid(tid);
			tbean.setTname(tname);
			tbean.setTlname(tlname);
			boolean UpdateStatus =service.editTeacher(tbean);
			
			if  (UpdateStatus) {
				RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
				rd.forward(request,response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
				rd.forward(request, response);
			}
		
		//-----------------------delete-  teacher--------------------
	}else if (buttonValue.equalsIgnoreCase("tDelete")) {
		int tid=Integer.parseInt(request.getParameter("tid"));
		int value=service.deleteTeacher(tid);
		if(value>0) {
			RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
		}
	}
	
	//----------------subject operation--------------
		if(buttonValue.equalsIgnoreCase("Sbsave")) 
		{
			int sbid=Integer.parseInt(request.getParameter("sbid"));
			String sbname=request.getParameter("sbname");
		
			
			SubjectBean sbbean= new SubjectBean();
			sbbean.setSbid(sbid);
			sbbean.setSbname(sbname);
			
			boolean InsertStatus =service.saveSubject(sbbean);
			
			if  (InsertStatus) {
				RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
				rd.forward(request,response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
				rd.forward(request, response);
			}
			//------------------------update-subject---------------------------
		}
		else if (buttonValue.equalsIgnoreCase("SbUpdate"))
		{
			
				int sbid=Integer.parseInt(request.getParameter("sid"));
				String sbname=request.getParameter("sbname");
				
				SubjectBean sbbean= new SubjectBean();
				sbbean.setSbid(sbid);
				sbbean.setSbname(sbname);
				boolean UpdateStStatus =service.updateSubject(sbbean);
				
				if  (UpdateStStatus) {
					RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
					rd.forward(request,response);
				}else {
					RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
					rd.forward(request, response);
				}
			
			//-----------------------delete-subbject--------------------
		}else if (buttonValue.equalsIgnoreCase("sbDelete")) {
			int sbid=Integer.parseInt(request.getParameter("sbid"));
			
			int value=service.deleteSubject(sbid);
			if(value>0) {
				RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
			}
			//---------------------------------------findall-subject-----------
		}else if (buttonValue.equalsIgnoreCase("SbFindAll")) {
				List<SubjectBean> sblist=service.FindAllSubject();
			if(sblist==null) {
				RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
				rd.forward(request, response);
			}else {
				request.setAttribute("listofsubjobj", sblist);
				RequestDispatcher rd=request.getRequestDispatcher("/ViewSubjectAllDetail.jsp");
			rd.forward(request, response);
			
			}
			//-----------------------------------------findbyid--subject------------
		}else if (buttonValue.equalsIgnoreCase("sbFind")) {
			int sbid=Integer.parseInt(request.getParameter("sbid"));
		SubjectBean sbbean =service.FindSubjectById(sbid);
		if(sbbean==null) {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
		}else {
			request.setAttribute("subjobj", sbbean);
			RequestDispatcher rd=request.getRequestDispatcher("/ViewSubjectDetail.jsp");
		rd.forward(request, response);
		}
//----------------student operation--------------
	if(buttonValue.equalsIgnoreCase("Stsave")) 
	{
		int sid=Integer.parseInt(request.getParameter("sid"));

		String sname=request.getParameter("sname");
		String slname=request.getParameter("slname");
		int fkclsid=Integer.parseInt(request.getParameter("fkclsid"));

		
		StudentBean stbean= new StudentBean();
		stbean.setSid(sid);
		stbean.setSname(sname);
		stbean.setSlname(slname);
		stbean.setFkclsid(fkclsid);
		
		boolean InsertStatus =service.saveStudent(stbean);
		
		if  (InsertStatus) {
			RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
			rd.forward(request,response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
		}
		//------------------------update-student---------------------------
	}
	else if (buttonValue.equalsIgnoreCase("StUpdate"))
	{
		
			int sid=Integer.parseInt(request.getParameter("sid"));
			String sname=request.getParameter("sname");
			String slname=request.getParameter("slname");
			int fkclsid=Integer.parseInt(request.getParameter("fkclsid"));
			
			StudentBean stbean= new StudentBean();
			stbean.setSid(sid);
			stbean.setSname(sname);
			stbean.setSlname(slname);
			stbean.setFkclsid(fkclsid);
			boolean UpdateStStatus =service.updateStudent(stbean);
			
			if  (UpdateStStatus) {
				RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
				rd.forward(request,response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
				rd.forward(request, response);
			}
		
		//-----------------------delete-student--------------------
	}else if (buttonValue.equalsIgnoreCase("stDelete")) {
		int sid=Integer.parseInt(request.getParameter("sid"));
		int value=service.deleteStudent(sid);
		if(value>0) {
			RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
		}
		//---------------------------------------findall-student-----------
	}else if (buttonValue.equalsIgnoreCase("StFindAll")) {
			List<StudentBean> stlist=service.FindAllStudent();
		if(stlist==null) {
			RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
			rd.forward(request, response);
		}else {
			request.setAttribute("listofstudobj", stlist);
			RequestDispatcher rd=request.getRequestDispatcher("/ViewStudentAllDetail.jsp");
		rd.forward(request, response);
		
		}
		//-----------------------------------------findbyid--student------------
	}else if (buttonValue.equalsIgnoreCase("stFind")) {
		int sid=Integer.parseInt(request.getParameter("sid"));
	StudentBean stbean =service.FindStudentById(sid);
	if(stbean==null) {
		RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
	}else {
		request.setAttribute("studobj", stbean);
		RequestDispatcher rd=request.getRequestDispatcher("/ViewStudentDetail.jsp");
	rd.forward(request, response);
	}
	//----------------------------teacher list------------
	}else if (buttonValue.equalsIgnoreCase("tFindAll")) {
		List<TeacherBean> tlist=service.FindAllTeacher();
	if(tlist==null) {
		RequestDispatcher rd=request.getRequestDispatcher("/Fail.html");
		rd.forward(request, response);
	}else {
		request.setAttribute("listoftchrobj", tlist);
		RequestDispatcher rd=request.getRequestDispatcher("/ViewTeacherAllDetail.jsp");
	rd.forward(request, response);
	}
	}}
	}
	//------------------dopostfor login -----
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int username =Integer.parseInt(request.getParameter("UserName"));
	String password =request.getParameter("password");
	
	UserBean beanFromUser=new UserBean();
	beanFromUser.setUserName(username);
	beanFromUser.setPassword(password);
	
	AdminService service = new AdminService();
	String type =service.login(beanFromUser);
	
	HttpSession session=request.getSession();
	
	if (type==null)
	{
		RequestDispatcher rd=request.getRequestDispatcher("/LoginError.html");
	rd.forward(request,response);
	}
	else if (type.equals("admin"))
	{	session.setAttribute("UserName",username);
		RequestDispatcher rd=request.getRequestDispatcher("/AdminHomepage.html");
	rd.forward(request, response);
	}
	}} 
