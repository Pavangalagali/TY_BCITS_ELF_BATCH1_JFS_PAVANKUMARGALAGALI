<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="post" action="./generateBill">
			<label>RR Number:</label>
			<input type="text" name="rr" placeholder="RR Number" /><br>
			<label>initial reading</label>
			<input	type="text" name="inl" placeholder="initial reading" /><br>	
			<label>final reading</label>
 			<input type="text" name="fnl" placeholder="final reading" /><br>
 			<label>total Consumption</label>
			<input type="text"name="total" placeholder="total Consumption" /> <br>
			<label>Reading taken on </label>
			<input type="date" name="date" placeholder="Date" /> <br>
			<label>Due date</label>
			<input type="date" name="dueDate" placeholder="Date" /> <br>
			<button type="submit" >Generate</button>
			</form>
</body>
</html>