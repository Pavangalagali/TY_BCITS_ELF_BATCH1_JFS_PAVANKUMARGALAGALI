<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String errMsg = (String) request.getAttribute("errMsg");
    String msg = (String) request.getAttribute("msg");
    Integer empId = (Integer) request.getAttribute("empId");
    
%>
    
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<fieldset>
		<legend>Employee Details</legend>
		<form action="./updateEmp" method="post">
		<label>Id : <%=empId%> </label>
        <input type="hidden" name="empId" value="<%=empId%>" ><br><br>
        <label>Name :</label>
        <input type="text" name="name" ><br><br>
        <label>Mobile Number :</label>
        <input type="tel" name="mobileNum" ><br><br>
        <label>Email :</label>
        <input type="email" name="maildId" ><br><br>
        <label>BirthDate :</label>
        <input type="date" name="birthDate" ><br><br>
        <label>JoiningDate :</label>
        <input type="date" name="joiningDate" ><br><br>
        <label>Designation :</label>
        <input type="text" name="designation" ><br><br>
        <label>Blood Group :</label>
        <input type="text" name="bloodGroup" ><br><br>
        <label>salary :</label>
        <input type="text" name="salary" ><br><br>
        <label>Department Id :</label>
        <input type="number" name="deptId" ><br><br>
        <label>Manager Id :</label>
        <input type="number" name="mgrId" ><br><br>
        <label>Password :</label>
        <input type="password" name="password" ><br><br>
        <br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Upadte" >		
		</form>
	</fieldset>
<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2 style="color: red;">
		<%=errMsg%></h2>

	<%
		}
	%>
		<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h2 style="color: blue;">
		<%=msg%></h2>

	<%
		}
	%>
</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>