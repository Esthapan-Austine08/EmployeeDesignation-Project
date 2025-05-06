package com.nt.service;

import java.util.List;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	private IEmployeeDAO empDAO;
	public EmployeeMgmtServiceImpl() {
		empDAO=new EmployeeDAOImpl();
	}

	@Override
	public List<Employee> fetchEmployeeByDesg(String desg) throws Exception {
		List<Employee> list = empDAO.serachEmployeeByDesg(desg);
		for(Employee emp:list) {
			  Double grossSalary = emp.getSalary()+(emp.getSalary()*0.3);
			  Double netSalary = grossSalary-(grossSalary*0.1);
			  		emp.setGrossSalary(grossSalary);
			  		emp.setNetSalary(netSalary);
		}
		return list;
	}
}
