package com.LearnerAcademy.Bean;

public class ClassBean {
private int clid;
private String clname;
private String Classtime;
private int fksbid;
private int fktchrid;

public ClassBean() {
	super();
	// TODO Auto-generated constructor stub
}
public ClassBean(String clname, String classtime, int fksbid, int fktchrid) {
	super();
	this.clname = clname;
	Classtime = classtime;
	this.fksbid = fksbid;
	this.fktchrid = fktchrid;
}
public ClassBean(int clid, String clname, String classtime, int fksbid, int fktchrid) {
	super();
	this.clid = clid;
	this.clname = clname;
	Classtime = classtime;
	this.fksbid = fksbid;
	this.fktchrid = fktchrid;
}
@Override
public String toString() {
	return "ClassBean [clid=" + clid + ", clname=" + clname + ", Classtime=" + Classtime + ", fksbid=" + fksbid
			+ ", fktchrid=" + fktchrid + "]";
}
public int getClid() {
	return clid;
}
public void setClid(int clid) {
	this.clid = clid;
}
public String getClname() {
	return clname;
}
public void setClname(String clname) {
	this.clname = clname;
}
public String getClasstime() {
	return Classtime;
}
public void setClasstime(String classtime) {
	this.Classtime = classtime;
}
public int getFksbid() {
	return fksbid;
}
public void setFksbid(int fksbid) {
	this.fksbid = fksbid;
}
public int getFktchrid() {
	return fktchrid;
}
public void setFktchrid(int fktchrid) {
	this.fktchrid = fktchrid;
}

}
