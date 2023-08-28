package com.surya.pojo;

import java.math.BigDecimal;

public class Doctor1 {

	private BigDecimal did;
	private String dname;
	private BigDecimal Pid;
	private String pname;
	private String address;
	public BigDecimal getDid() {
		return did;
	}
	public void setDid(BigDecimal did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public BigDecimal getPid() {
		return Pid;
	}
	public void setPid(BigDecimal pid) {
		Pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Doctor1 [did=" + did + ", dname=" + dname + ", Pid=" + Pid + ", pname=" + pname + ", address=" + address
				+ "]";
	}
	
	
}
