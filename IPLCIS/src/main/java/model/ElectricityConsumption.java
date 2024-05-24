package model;
import java.io.Serializable;
import model.Participant;
import java.text.SimpleDateFormat;  
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;  // Import MultipartFile

public class ElectricityConsumption implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int numDay;
	private String date;
	private double propFactor;
	private double billAmount;
	private double electricityUsage;
	private double carbonFootprint;
	private Participant p;
	private MultipartFile file;
	
	public ElectricityConsumption() {
		
	}
	
	public ElectricityConsumption(int numDay, String date, double propFactor, double billAmount, double electricityUsage,  MultipartFile file,  Participant p) {
		this.numDay = numDay;
		this.date = date;
		this.propFactor = propFactor;
		this.billAmount = billAmount;
		this.electricityUsage = electricityUsage;
		this.file = file;
		this.p = p;
	}
	
	public ElectricityConsumption(int numDay, String date, double propFactor, double billAmount, double electricityUsage, double carbonFootprint) {
		this.numDay = numDay;
		this.date = date;
		this.propFactor = propFactor;
		this.billAmount = billAmount;
		this.electricityUsage = electricityUsage;
		this.carbonFootprint = carbonFootprint; 
	}
	
	public boolean checkDate()
	{
		 try {
		        boolean check = date.matches("\\d{4}-\\d{2}-\\d{2}");
		        if (check != true)
		        {
		        	System.out.println(date);
		        	return false;
		        }
		        
		        
		        System.out.println(date);
		        
		        return true;
		    } catch (java.time.format.DateTimeParseException e) {
		        return false;
		    }
	}
	
	public void calculateCarbonFootprint() {
		carbonFootprint = electricityUsage * 0.584;
		String temp = String.format("%.2f", carbonFootprint);
		carbonFootprint = Double.parseDouble(temp);
	}
	
	public String getFile() {
	       return file.getOriginalFilename();
	    }

		public void setFile(MultipartFile file) {
			this.file = file;
		}
	
	public Participant getP() {
		return p;
	}

	public void setP(Participant p) {
		this.p = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumDay() {
		return numDay;
	}

	public void setNumDay(int numDay) {
		this.numDay = numDay;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPropFactor() {
		return propFactor;
	}

	public void setPropFactor(double propFactor) {
		this.propFactor = propFactor;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getElectricityUsage() {
		return electricityUsage;
	}

	public void setElectricityUsage(double electricityUsage) {
		this.electricityUsage = electricityUsage;
	}

	public double getCarbonFootprint() {
		return carbonFootprint;
	}

	public void setCarbonFootprint(double carbonFootprint) {
		this.carbonFootprint = carbonFootprint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
