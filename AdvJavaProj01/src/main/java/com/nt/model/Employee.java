package com.nt.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private Integer empNo;
	private String ename;
	private String desg;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;
	private Integer deptNo;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return ename;
	}
	public void seteName(String eName) {
		this.ename = eName;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	public Double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
}
