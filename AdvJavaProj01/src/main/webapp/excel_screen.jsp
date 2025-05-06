<!--excel_screen.jsp -->
<%@ page isELIgnored="false" import="java.util.*,com.nt.model.*"%>

<%
		List<Employee> list = (List<Employee>)request.getAttribute("empInfo");
		String desg = request.getParameter("desg");
		//set content type as excel to display
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;fileName=empInfo.xls");
%>
<h1 style="color: red;text-align: center;">Employee details of <%=desg%> </h1>
<%
	if(list!=null && list.size()!=0){
%>
<table align="center" border="1">
<tr>
<th>Emp No</th><th>Emp Name</th><th>Emp Job</th><th>Salary</th><th>Gross Salary</th><th>Net Salary</th><th>DeptNo</th>
</tr>
<%
	for(Employee emp:list){
%>
<tr>
	<td><%=emp.getEmpNo() %></td>
	<td><%=emp.geteName() %></td>
	<td><%=emp.getDesg()%></td>
	<td><%=emp.getSalary()%></td>
	<td><%=emp.getGrossSalary() %></td>
	<td><%=emp.getNetSalary()%></td>
	<td><%=emp.getDeptNo()%></td>
</tr>
<%
} 
%>
</table>
<%
     }
	else {
%>
<h2 style="color: red;text-align: center;">Employee are not found</h2>
<% } %>
