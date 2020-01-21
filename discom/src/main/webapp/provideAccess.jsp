<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <form method="post" action="./addEmp">
		<label>Id:</label>
			<input type="text" name="id" placeholder="ID" /><br>
			<label>Name</label>
			<input	type="text" name="name" placeholder="Name:" /><br>
			
			<label>Email</label>
 			<input type="text" name="eMail" placeholder="Email:" /><br>
 			<label>Designation</label>
			<input type="text"name="role" placeholder="Designation:" /> <br>
			<label>Region</label>
			<input type="text" name="region" placeholder="Region" /> <br>
			<label>Password</label>
			<input type="Password" name="password" placeholder="Password:" /> <br>
			<button type="submit" >add</button>
			</form>

</body>
</html>