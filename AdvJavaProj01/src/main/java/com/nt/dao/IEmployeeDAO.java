package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
		public List<Employee> serachEmployeeByDesg(String desg)throws Exception;
}
