package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import model.Participant;
import model.ElectricityConsumption;

@Service
public class ElectricityDbService {
	
	
	public List<ElectricityConsumption> getAllElectricityReports() {
		List<ElectricityConsumption> electricityConsumption = new ArrayList<ElectricityConsumption>();
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM electricityconsumption");
			
			while (rs.next()) {
				ElectricityConsumption electricity = new ElectricityConsumption(rs.getInt(2) , rs.getString(3) , rs.getDouble(4), rs.getDouble(5), rs.getDouble(6) , rs.getDouble(7));
				electricityConsumption.add(electricity);
			}
		
			
			return electricityConsumption;
		
		}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return electricityConsumption;
	}
	
	
	
	
	

	public boolean electricityInsert(ElectricityConsumption e) {
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
	
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO electricityconsumption (numDay, date, propFactor, billAmount, electricityUsage, carbonFootprint, participant_id , file_data) values (?,STR_TO_DATE(?, '%Y-%m-%d'),?,?,?,?,?,?)");

			stmt.setInt(1, e.getNumDay() );
			stmt.setString(2, e.getDate());
			stmt.setDouble(3, e.getPropFactor());
			stmt.setDouble(4, e.getBillAmount());
			stmt.setDouble(5, e.getElectricityUsage() );
			stmt.setDouble(6, e.getCarbonFootprint());
			stmt.setInt(7, e.getP().getId());
			stmt.setString(8, e.getFile());
			stmt.execute();
			return true;
		
		}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return false;
	}
}
