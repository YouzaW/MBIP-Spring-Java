<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	<jsp:useBean id="p" class="model.Participant" scope="request" />
	<h1>Profile Page</h1>
	<form action="updateprofile" method="post">
				Email   	    :<input type="text" name="email" placeholder="eg. bla@graduate.utm.my" value=<jsp:getProperty name = "p" property = "email"/>><br><br>
				Password 		:<input type="text" name="password" placeholder="" value=<jsp:getProperty name = "p" property = "password"/>><br> 
				IC Number  	    :<input type="text" name="icNum" placeholder="eg. 010120014444" value=<jsp:getProperty name = "p" property = "icNum"/>><br><br>
				Phone Number 	:<input type="text" name="phoneNum" placeholder="eg. 0171119999" value=<jsp:getProperty name = "p" property = "phoneNum"/>><br> 
				Status  		:<input type="text" name="status" placeholder="eg. Student/Employed/Unemployed" value=<jsp:getProperty name = "p" property = "status"/>><br><br>
				Address 		:<input type="text" name="address" placeholder="eg. No.25, Block A, Taman taman" value=<jsp:getProperty name = "p" property = "address"/>><br> 
				Category		:<input type="text" name="category" placeholder="eg. A1" value=<jsp:getProperty name = "p" property = "category"/>><br><br>
				
				
				
				<input type="submit" value="Update Profile">
	</form>
</body>
</html>