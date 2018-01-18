<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/Count/employeeSearch" method="get">
		<br /> Employee ID: <input type="text" name="empID"><br>
		<br /> <input type="submit" value="Search"> <br />
	
		<table border=1 cellpadding=5>
			<tr>
				<th>EmployeeID</th>
				<th>EmployeeNo</th>
				<th>EmployeeName</th>
				<th>EmployeeSalary</th>
				<th>EmployeeDoj</th>
				<th>EmployeeAge</th>
			</tr>
			<tr>
				<td>${empId}</td>
				<td>${empNo}</td>
				<td>${empName}</td>
				<td>${empSalary}</td>
				<td>${empDoj}</td>
				<td>${empAge}</td>
			</tr>
		</table>
		<br/>
		${notanEmployee}
	</form>

</body>
</html>