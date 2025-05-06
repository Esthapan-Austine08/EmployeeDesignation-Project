package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMP_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB=?";
	
	private Connection makeConnection()throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
		return con;
	}

	@Override
	public List<Employee> serachEmployeeByDesg(String desg) throws Exception {
	   List<Employee> list=null;
	   try(Connection con=makeConnection();
			   PreparedStatement ps = con.prepareStatement(GET_EMP_DESG);) {
		   ps.setString(1, desg);
		   try(ResultSet rs = ps.executeQuery()){
			    list=new ArrayList<Employee>();
			  while(rs.next()) {
				  Employee emp = new Employee();
				  emp.setEmpNo(rs.getInt(1));
				  emp.seteName(rs.getString(2));
				  emp.setDesg(rs.getString(3));
				  emp.setSalary(rs.getDouble(4));
				  emp.setDeptNo(rs.getInt(5));
				list.add(emp)	;	  
		   }
		  }
	   }
	   catch(SQLException se) {
		   throw se;
	   }
	   catch(Exception e) {
		   throw e;
	   }
	   return list;
	}

}
