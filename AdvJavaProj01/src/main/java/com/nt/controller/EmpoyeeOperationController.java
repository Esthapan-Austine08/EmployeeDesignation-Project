package com.nt.controller;

import java.io.IOException;
import java.util.List;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class EmpoyeeOperationController extends HttpServlet {
	private IEmployeeMgmtService empService;

	@Override
	public void init() throws ServletException {
		empService=new EmployeeMgmtServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deg = req.getParameter("desg");
		String caption = req.getParameter("s1");
	try{
		List<Employee> list = empService.fetchEmployeeByDesg(deg);
		req.setAttribute("empInfo", list);
	 if(caption.equalsIgnoreCase("HTML")) {
		   RequestDispatcher rd = req.getRequestDispatcher("html_screen.jsp");
		   rd.forward(req, resp);
	 }
	 else {
		 RequestDispatcher rd = req.getRequestDispatcher("excel_screen.jsp");
		   rd.forward(req, resp);
	 }
	}
	catch (Exception e) {
		 e.printStackTrace();
		 RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
		   rd.forward(req, resp);
	    }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
