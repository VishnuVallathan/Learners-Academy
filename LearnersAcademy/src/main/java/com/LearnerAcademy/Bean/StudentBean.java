package com.LearnerAcademy.Bean;

public class StudentBean {

	private int sid;
	private String Sname;
	private String Slname;
	private int fkclsid;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSlname() {
		return Slname;
	}
	public void setSlname(String slname) {
		Slname = slname;
	}
	public int getFkclsid() {
		return fkclsid;
	}
	public void setFkclsid(int fkclsid) {
		this.fkclsid = fkclsid;
	}
}
