package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Participant;

public class DbService {
	public Participant signIn(String email,String password) {
		Participant participant = new Participant();
		// steps to use database

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * " + 
					"FROM participant " + 
					"WHERE email = '" + email +"' AND password = '" + password + "'");
			
			while (rs.next()) {
				Participant p = new Participant(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				p.setId(rs.getInt(1));
				System.out.println("id : " + rs.getInt(1));
				System.out.println("email : " + rs.getString(2));
				System.out.println("password : " + rs.getString(3));
				System.out.println("icNo : " + rs.getInt(4));
				participant = p;
				return p;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return participant;

	}
	
	public boolean registerUser(Participant p) {
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
	
		
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO participant (email, password, icNum, phoneNum, status, address, category, accessLevel) values (?,?,?,?,?,?,?,?)");

			stmt.setString(1, p.getEmail() );
			stmt.setString(2, p.getPassword());
			stmt.setLong(3, p.getIcNum());
			stmt.setLong(4, p.getPhoneNum());
			stmt.setString(5, p.getStatus() );
			stmt.setString(6, p.getAddress());
			stmt.setString(7, p.getCategory());
			stmt.setInt(8, p.getAccessLevel());
			stmt.execute();
			return true;
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	return false;
	}
	
	public Participant getParticipant(int id) {
		Participant participant = new Participant();
		// steps to use database

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * " + 
					"FROM participant " + 
					"WHERE id = '" + id + "'");
			
			while (rs.next()) {
				Participant p = new Participant(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				p.setId(rs.getInt(1));
				
				participant = p;
				return p;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return participant;
	}
	
	public boolean updateParticipant(Participant p, int id) {
		try {
			System.out.println("Db register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplcis", "root", "");
	
		

			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * " + 
					"FROM participant WHERE id='" +id+"'");
			
			while (rs.next()) {
				System.out.println("Club found");
				PreparedStatement studResult = connection.prepareStatement("UPDATE participant SET email=?, password=?, icNum=?, phoneNum=?, status=?, address=?, category=? WHERE id = ?");
				studResult.setString(1, p.getEmail() );
				studResult.setString(2, p.getPassword());
				studResult.setLong(3, p.getIcNum());
				studResult.setLong(4, p.getPhoneNum());
				studResult.setString(5, p.getStatus() );
				studResult.setString(6, p.getAddress());
				studResult.setString(7, p.getCategory());
				studResult.setInt(8, id);
				studResult.execute();

			}

			
			return true;
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
}