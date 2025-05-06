<%@ page isELIgnored="false" import="java.util.*,com.nt.model.*"%>

<%
    List<Employee> list = (List<Employee>) request.getAttribute("empInfo");
    String desg = request.getParameter("desg");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
        }

        table {
            width: 90%;
            margin: 0 auto 20px auto;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #2980b9;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #eaf2f8;
        }

        .no-data {
            color: red;
            text-align: center;
            margin-top: 50px;
            font-size: 1.2em;
        }

        .print-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            font-size: 16px;
            color: #2980b9;
            text-decoration: none;
        }

        .print-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>Employee details of <%= desg %></h1>

<%
    if (list != null && !list.isEmpty()) {
%>
<table>
    <tr>
        <th>Emp No</th>
        <th>Emp Name</th>
        <th>Emp Job</th>
        <th>Salary</th>
        <th>Gross Salary</th>
        <th>Net Salary</th>
        <th>Dept No</th>
    </tr>
<%
    for (Employee emp : list) {
%>
    <tr>
        <td><%= emp.getEmpNo() %></td>
        <td><%= emp.geteName() %></td>
        <td><%= emp.getDesg() %></td>
        <td><%= emp.getSalary() %></td>
        <td><%= emp.getGrossSalary() %></td>
        <td><%= emp.getNetSalary() %></td>
        <td><%= emp.getDeptNo() %></td>
    </tr>
<%
    }
%>
</table>
<%
    } else {
%>
<div class="no-data">Employees are not found</div>
<%
    }
%>

<a href="JavaScript:doPrint()" class="print-link"> Print</a>

<script>
    function doPrint() {
        window.print();
    }
</script>

</body>
</html>
  