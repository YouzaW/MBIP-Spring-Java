<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Register Page</h1>
	<form action="loginRegister" method="post">
				Email   	    :<input type="text" name="email" placeholder="eg. bla@graduate.utm.my"><br><br>
				Password 		:<input type="text" name="password" placeholder=""><br> 
				IC Number  	    :<input type="text" name="icNum" placeholder="eg. 010120014444"><br><br>
				Phone Number 	:<input type="text" name="phoneNum" placeholder="eg. 0171119999"><br> 
				Status  		:<input type="text" name="status" placeholder="eg. Student/Employed/Unemployed"><br><br>
				Address 		:<input type="text" name="address" placeholder="eg. No.25, Block A, Taman taman"><br> 
				Category		:<input type="text" name="category" placeholder="eg. A1"><br><br>
				
				
				
				<input type="submit" value="Register">
	</form>
</body>
</html>