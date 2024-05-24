<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.RecycleConsumption" %>
     <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Recycle Confirm Page</h1>
	
	
	<table border = "1" cellpadding = "5" cellspacing = "0" style ="text-align:center; color: "blue"">
		<tr>
			<th>Number of Days</th>
			<th>Date</th>
			<th>Proportional Factor </th>
			<th>Bill Amount (RM)</th>
			<th>Recycle Activity (kg)</th>
			<th>Carbon Footprint (kgCO2)</th>
		</tr>

<% 
                List<RecycleConsumption> recycleList = (List<RecycleConsumption>) request.getAttribute("recycleReports");
                if (recycleList != null && !recycleList.isEmpty()) {
                    for (RecycleConsumption recycleConsumption : recycleList) {
            %>
		<tr>
			<td><%= recycleConsumption.getNumDay() %></td>
			<td><%= recycleConsumption.getDate() %></td>
			<td><%= recycleConsumption.getPropFactor() %></td>
			<td><%= recycleConsumption.getBillAmount() %></td>
			<td><%= recycleConsumption.getRecycleUsage() %></td>
			<td><%= recycleConsumption.getCarbonFootprint() %></td>
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