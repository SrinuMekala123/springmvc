package com.surya.pojo;

import java.util.Set;



public class Doctor {

	private int did;
	private String dname;
	private Set<Pasient> pasientList;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<Pasient> getPasientList() {
		return pasientList;
	}
	public void setPasientList(Set<Pasient> pasientList) {
		this.pasientList = pasientList;
	}
	
}