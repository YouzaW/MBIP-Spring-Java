<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="display:flex; justify-content: center; align-items: center; background-color:lightblue">
		<div style="border: 5px solid black;border-radius: 50px;width: 50vw; height: 50vh; display:flex; justify-content: center; align-items: center; flex-direction:column;">
			<h1>Login Page</h1>
			
			<form action="home" method="post">
				Email    :<input type="text" name="email" placeholder="eg. bla@graduate.utm.my"><br><br>
				Password :<input type="password" name="password" placeholder=""><br> 

				
				<input type="submit" value="Login">
			</form>
			
			<button onclick="document.location='register'">Register User</button>
		</div>
	</div>
</body>
</html>