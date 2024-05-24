<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.WaterConsumption" %>
     <%@ page import="model.ElectricityConsumption" %>
     <%@ page import="model.RecycleConsumption" %>
     <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List All Page</h1>
	
	
	<table border = "1" cellpadding = "5" cellspacing = "0" style ="text-align:center; color: "blue"">
		<tr>
			<th>Number of Days</th>
			<th>Date</th>
			<th>Proportional Factor </th>
			<th>Bill Amount (RM)</th>
			<th>Electricity Usage (kWh)</th>
			<th>Carbon Footprint (kgCO2)</th>
		</tr>

<% 
                List<ElectricityConsumption> electricityList = (List<ElectricityConsumption>) request.getAttribute("electricityReports");
                if (electricityList != null && !electricityList.isEmpty()) {
                    for (ElectricityConsumption electricityConsumption : electricityList) {
            %>
		<tr>
			<td><%= electricityConsumption.getNumDay() %></td>
			<td><%= electricityConsumption.getDate() %></td>
			<td><%= electricityConsumption.getPropFactor() %></td>
			<td><%= electricityConsumption.getBillAmount() %></td>
			<td><%= electricityConsumption.getElectricityUsage() %></td>
			<td><%= electricityConsumption.getCarbonFootprint() %></td>
		</tr>
	<%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="6">No products available.</td>
                    </tr>
            <%
                }
            %>
	</table>
	
	
	<br><br>
	
	<button onclick="window.location.href = '/IPLCIS/homepage';" style = "width: 20vw; height: 10vh;"> Return to Homepage</button>
</body>
</html>