<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
	<h1>homepage</h1>
	<%
		int id = (Integer) session.getAttribute("userID");
	%>
	<h3> <%=id %></h3>
	<div style="width: 80vw; height: 80vh;margin:0; display:flex; flex-direction:row;">
		<div style="border: 4px solid black; width: 20vw; height: 80vh; margin:0;">
		<button onclick="location.href = 'water/fillInfo';" style = "width: 15svw; height: 10vh;"> Fill Water Consumption</button>
		<button onclick="location.href = 'electricity/fillInfo';" style = "width: 15svw; height: 10vh;"> Fill Electricity Consumption</button>
	    <button onclick="location.href = 'recycle/fillInfo';" style = "width: 15svw; height: 10vh;"> Fill Recycle Activity</button>
		</div>
		
		<div style="border: 4px solid blue; width: 60vw; height: 80vh;margin:0;">
		<button onclick="location.href = 'updateprofile';" style = "width: 15svw; height: 10vh;"> Profile Page</button>
		
		</div>
	</div>
</body>
</html>