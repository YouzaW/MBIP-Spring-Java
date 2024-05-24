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
import model.RecycleConsumption;

@Service
public class RecycleDbService {
	
	
	public List<RecycleConsumption> getAllRecycleReports() {
		List<RecycleConsumption> recycleConsumption = new ArrayList<RecycleConsumption>();
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM recycleconsumption");
			
			while (rs.next()) {
				RecycleConsumption recycle = new RecycleConsumption(rs.getInt(2) , rs.getString(3) , rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
				recycleConsumption.add(recycle);
			}
		
			
			return recycleConsumption;
		
		}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return recycleConsumption;
	}
	
	

	public boolean recycleInsert(RecycleConsumption r) {
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
	
		
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO recycleconsumption (numDay, date, propFactor, billAmount, recycleUsage, carbonFootprint, participant_id , file_data) values (?,STR_TO_DATE(?, '%Y-%m-%d'),?,?,?,?,?,?)");

			stmt.setInt(1, r.getNumDay() );
			stmt.setString(2, r.getDate());
			stmt.setDouble(3, r.getPropFactor());
			stmt.setDouble(4, r.getBillAmount());
			stmt.setDouble(5, r.getRecycleUsage() );
			stmt.setDouble(6, r.getCarbonFootprint());
			stmt.setInt(7, r.getP().getId());
			stmt.setString(8, r.getFile());
			stmt.execute();
			return true;
		
		}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return false;
	}
}
