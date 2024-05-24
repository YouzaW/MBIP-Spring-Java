<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fill Electricity Info</title>
</head>
<body>
<h1>Fill Electricity Info Page</h1>
	<div style="display:flex; justify-content: center; align-items: center; background-color:lightgrey">
	<form action="filledInfo" method="post" enctype="multipart/form-data">
				Number of Days  	   :<input type="text" name="numDay" placeholder="eg. 31"><br><br>
				Date            	   :<input type="text" name="date" placeholder="eg. 2000-01-30"><br><br>
				Proportional Factor	   :<input type="text" name="propFactor" placeholder=""><br> <br>
			    Bill Amount(RM)    	   : RM <input type="text" name="billAmount" placeholder="eg. 20"><br><br>
				Electricity Usage(kWh) :<input type="text" name="electricityUsage" placeholder="eg. 30"><br> <br>
			    File Upload     :<input type="file" name="file"><br><br>
			
				<br><br>
				
				
				
				<input type="submit" value="Submit">
	</form>
	</div>	

</body>
</html>