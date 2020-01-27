<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String errMsg = (String) request.getAttribute("errMsg");
    String msg = (String) request.getAttribute("msg");
%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<fieldset>
		<legend>Add Employee Details</legend>
		<form action="./addEmployee" method="post">
		<label>Id :</label>
        <input type="text" name="empId" required><br><br>
        <label>Name :</label>
        <input type="text" name="name" required><br><br>
        <label>Mobile Number :</label>
        <input type="tel" name="mobileNum" required><br><br>
        <label>Email :</label>
        <input type="email" name="maildId" required><br><br>
        <label>BirthDate :</label>
        <input type="date" name="birthDate" required><br><br>
        <label>JoiningDate :</label>
        <input type="date" name="joiningDate" required><br><br>
        <label>Designation :</label>
        <input type="text" name="designation" required><br><br>
        <label>Blood Group :</label>
        <input type="text" name="bloodGroup" required><br><br>
        <label>salary :</label>
        <input type="text" name="salary" required><br><br>
        <label>Department Id :</label>
        <input type="number" name="deptId" required><br><br>
        <label>Manager Id :</label>
        <input type="number" name="mgrId" required><br><br>
        <label>Password :</label>
        <input type="text" name="password" required><br><br>
        <br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="ADD" >		
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