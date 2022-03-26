package LearnerAcademy.service;

import java.util.List;

import com.LearnerAcademy.Bean.ClassBean;
import com.LearnerAcademy.Bean.StudentBean;
import com.LearnerAcademy.Bean.SubjectBean;
import com.LearnerAcademy.Bean.TeacherBean;
import com.LearnerAcademy.Bean.UserBean;
import com.LearnerAcademy.dao.ClassDao;
import com.LearnerAcademy.dao.StudentDao;
import com.LearnerAcademy.dao.SubjectDao;
import com.LearnerAcademy.dao.TeacherDao;
import com.LearnerAcademy.dao.UserDao;

public class AdminService {
	ClassDao clsDao = new ClassDao();
	UserDao userDao = new UserDao();
	TeacherDao tchrDao=new TeacherDao();
	StudentDao stDao=new StudentDao();
	SubjectDao sbDao=new SubjectDao();
	//===============================================
	public String login(UserBean BeanFromUser)	{
		String type=null;
		UserBean beanFromDB =userDao.getUserByUserName(BeanFromUser.getUserName());
		if(beanFromDB!=null) {
		if  (BeanFromUser.getUserName()==beanFromDB.getUserName()&& BeanFromUser.getPassword().equals(beanFromDB.getPassword())) {
				type=beanFromDB.getType();	}
		}	return type;	}
	//===========================================
		public void logout(){
		}
	//=================class=================
	public boolean SaveClass(ClassBean bean)  {
			return clsDao.InsertClass(bean); }
	//-----------------------------------
	public int deleteClass(int clid) 		 {
		return clsDao.deleteClassById(clid);	}
	//-------------------------------------------
	public ClassBean FindClassById(int clid) {
		return clsDao.getClassById(clid);	}
	//-----------------------------------
	public List<ClassBean>FindAllClasses()	{
		return clsDao.getAllClassDetail();	}
	//---------------------------------------
	public boolean editClass (ClassBean bean)	 {
		return clsDao.updateClassById(bean);	}
	//-------------------------------------------
	public boolean updateClass(ClassBean bean) {
		return clsDao.updateClassById(bean);	}
	//-------================teacher============================================
public boolean saveTeacher(TeacherBean tbean) {
		return tchrDao.InsertTeacher(tbean);	}
//-----------------------------------
public int deleteTeacher(int tid)  			{
	return tchrDao.deleteTeacherById(tid);	}
//-------------------------------------------
public TeacherBean FindTeacherById(int tid) {
	return tchrDao.getTeacherByID(tid);	}
//-----------------------------------
public List<TeacherBean>FindAllTeacher()	{
	return tchrDao.getAllTeacherDetail();	}
//---------------------------------------
public boolean editTeacher (TeacherBean tbean) {
	return tchrDao.updateTeacherById(tbean);	}
//-------------------------------------------
public boolean updateTeacher(TeacherBean tbean) {
	return tchrDao.updateTeacherById(tbean);	}
//=====================student============================
public boolean saveStudent(StudentBean stbean) {
	return stDao.InsertStudent(stbean);	}
//-----------------------------------
public int deleteStudent(int sid)  			{
return stDao.deleteStudentById(sid);	}
//-------------------------------------------
public StudentBean FindStudentById(int sid) {
return stDao.getStudentByiD(sid);	}
//-----------------------------------
public List<StudentBean>FindAllStudent()	{
return stDao.getAllStudentDetail();	}
//---------------------------------------
public boolean editStudent (StudentBean stbean) {
return stDao.updateStudentById(stbean);	}
//-------------------------------------------
public boolean updateStudent(StudentBean stbean) {
return stDao.updateStudentById(stbean);	}

//====================subject service=============================
public boolean saveSubject(SubjectBean sbbean) {
	return sbDao.InsertSubject(sbbean);	}
//-----------------------------------
public int deleteSubject(int sbid)  			{
return sbDao.deleteSubjectById(sbid);	}
//-------------------------------------------
public SubjectBean FindSubjectById(int sbid) {
return sbDao.getSubjectByiD(sbid);	}
//-----------------------------------
public List<SubjectBean>FindAllSubject()	{
return sbDao.getAllSubjectDetail();	}
//---------------------------------------
public boolean editSubject (SubjectBean sbbean) {
return sbDao.updateSubjectById(sbbean);	}
//-------------------------------------------

public boolean updateSubject(SubjectBean sbbean) {
return sbDao.updateSubjectById(sbbean);	}
//=================================================

}