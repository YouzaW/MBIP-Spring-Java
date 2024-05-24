package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import model.Participant;
import model.WaterConsumption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import model.WaterConsumption;

@Service
public class WaterDbService {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;
    
    
	public List<WaterConsumption> getAllWaterReports() {
		List<WaterConsumption> waterConsumption = new ArrayList<WaterConsumption>();
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM waterconsumption");
			
			while (rs.next()) {
				WaterConsumption water = new WaterConsumption(rs.getInt(2) , rs.getString(3) , rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
				waterConsumption.add(water);
			}
		
			
			return waterConsumption;
		
		}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return waterConsumption;
	}

	public boolean waterInsert(WaterConsumption w) {
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
	
		
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO waterconsumption (numDay, date, propFactor, billAmount, waterUsage, carbonFootprint, participant_id) values (?,STR_TO_DATE(?, '%Y-%m-%d'),?,?,?,?,?)");

			stmt.setInt(1, w.getNumDay() );
			stmt.setString(2, w.getDate());
			stmt.setDouble(3, w.getPropFactor());
			stmt.setDouble(4, w.getBillAmount());
			stmt.setDouble(5, w.getWaterUsage() );
			stmt.setDouble(6, w.getCarbonFootprint());
			stmt.setInt(7, w.getP().getId());
			stmt.execute();
			return true;
		
		}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return false;
	}
	
    
    
    /*public boolean waterInsert(WaterConsumption w) throws IOException {
        System.out.println(w.getNumDay());
        System.out.println(w.getDate());
        System.out.println(w.getPropFactor());
        System.out.println(w.getBillAmount());
        System.out.println(w.getWaterUsage());
        System.out.println(w.getCarbonFootprint());
        System.out.println(w.getP().getId());

        int rowAffected = 1;
        String sql = "INSERT INTO waterconsumption (numDay, date, propFactor, billAmount, waterUsage, carbonFootprint, participant_id, file_data) values (?,STR_TO_DATE(?, '%Y-%m-%d'),?,?,?,?,?,?)";

        try {
            if (w != null && w.getP() != null) {
                SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = inputDateFormat.parse(w.getDate());
                SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = outputDateFormat.format(date);

                jdbcTemplate.update(
                        sql,
                        w.getNumDay(),
                        formattedDate,
                        w.getPropFactor(),
                        w.getBillAmount(),
                        w.getWaterUsage(),
                        w.getCarbonFootprint(),
                        w.getP().getId(),
                        w.getFile()
                );
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return rowAffected > 0;
    }
    
    */
    
}
