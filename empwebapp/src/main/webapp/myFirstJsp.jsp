<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!private int a = 10;

	public void setA(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public String name = "Alex";

	public String getName() {
		return name;
	}

	public String getName(String name) {
		return name;
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: orange;">Welcome to JSP</h1>
	a =
	<%=a%><br> a =
	<%=getA()%><br>
	<%
		setA(100);
	%>
	a =
	<%=getA()%><br>
	<br> Name =
	<%=name%><br> Name =
	<%=getName()%><br> Name =
	<%=getName("James")%><br><br><br>

	<%
		for (int i = 0; i < 5; i++) {
	%>
	<%=name%><br>
	<%
		}
	%>
	<%-- <jsp:forward page="./date.html"/>  --%>  <!-- static resource -->
	<%-- <jsp:forward page="./currentDate"> --%>  <!-- dynamic  resource -->
	<%-- <jsp:forward page="./mySecondJsp.jsp"> --%>  <!--  jsp dynamic  resource -->
	<%-- <jsp:forward page="./searchEmp">
	<jsp:param name="empId" value="1212"/>  <!-- dynamic resource with param value -->
	</jsp:forward> --%>
	
	
	

</body>
</html>

<%-- <jsp:include page="./date.html"/>  --%>  <!-- static resource -->
  <%--  <jsp:include page="/currentDate"> --%>  <!-- dynamic  resource -->
	<%-- <jsp:include page="./mySecondJsp.jsp"> --%>  <!--  jsp dynamic  resource -->
	<%--  <jsp:include page="/searchEmp">
	<jsp:param name="empId" value="112"/>  <!-- dynamic resource with param value -->
	</jsp:include>  --%>

<%-- <%@ include file = "date.html" %> --%>








