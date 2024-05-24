<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.WaterConsumption" %>
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
			<th>Water Usage (m^3)</th>
			<th>Carbon Footprint (kgCO2)</th>
		</tr>

<% 
                List<WaterConsumption> waterList = (List<WaterConsumption>) request.getAttribute("waterReports");
                if (waterList != null && !waterList.isEmpty()) {
                    for (WaterConsumption waterConsumption : waterList) {
            %>
		<tr>
			<td><%= waterConsumption.getNumDay() %></td>
			<td><%= waterConsumption.getDate() %></td>
			<td><%= waterConsumption.getPropFactor() %></td>
			<td><%= waterConsumption.getBillAmount() %></td>
			<td><%= waterConsumption.getWaterUsage() %></td>
			<td><%= waterConsumption.getCarbonFootprint() %></td>
			
			
		</tr>
	<%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="3">No products available.</td>
                    </tr>
            <%
                }
            %>
	</table>
	<br><br>
	
	
	<button onclick="window.location.href = '/IPLCIS/homepage';" style = "width: 20vw; height: 10vh;"> Return to Homepage</button>
	
</body>
</html>