package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.RecycleDbService;
import service.ElectricityDbService;
import model.Participant;
import model.ElectricityConsumption;
import model.RecycleConsumption;


@Controller
@RequestMapping("/electricity")
	public class ElectricityController {
	

	ElectricityDbService electricityDbService;
	
		public ElectricityController() {
			electricityDbService = new ElectricityDbService();
		}
		
		@GetMapping("/fillInfo")
		public String fillInfo(HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userID") == null) {
				return "login";
			}
			return "fillElectricityInfoPage";
		}
		@PostMapping("/fillInfo")
		public String fillingInfo() {
			return "fillElectricityInfoPage";
		}
		
		@PostMapping("/filledInfo")
		public String fillInfo(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
			int numDay = Integer.parseInt(request.getParameter("numDay"));
			String date = request.getParameter("date");
			double propFactor = Double.parseDouble(request.getParameter("propFactor"));
			double billAmount = Double.parseDouble(request.getParameter("billAmount"));
			double electricityUsage = Double.parseDouble(request.getParameter("electricityUsage"));
			HttpSession session = request.getSession();
			Participant p = (Participant)session.getAttribute("p");
			int id = (Integer) session.getAttribute("userID");
			System.out.println(id);
		
			ElectricityConsumption electricity = new ElectricityConsumption(numDay, date, propFactor, billAmount, electricityUsage, file , p);
			boolean check = electricity.checkDate();
			electricity.calculateCarbonFootprint();
			System.out.println(p.getId());
			System.out.println(check);
			System.out.println(p.getId());
			if(check == false) {
			}
			
			model.addAttribute("e", electricity);
			boolean electricityDb = electricityDbService.electricityInsert(electricity);
			
			List<ElectricityConsumption> electricityReports = electricityDbService.getAllElectricityReports();
			if(electricityReports != null && !electricityReports.isEmpty()) {
				System.out.println("There are values in the List");
			}
			else {
				System.out.println("List is empty failed to pass");
			}
			model.addAttribute("electricityReports", electricityReports);
			
		
			
			return "confirmElectricityInfoPage";
		}
		
		
		
}
