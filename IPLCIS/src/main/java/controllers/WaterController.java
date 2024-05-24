package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.WaterDbService;
import model.Participant;
import model.WaterConsumption;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/water")
	public class WaterController {
	private final WaterDbService waterDbService;

    @Autowired
    public WaterController(WaterDbService waterDbService) {
        this.waterDbService = waterDbService;
    }
		@GetMapping("/fillInfo")
		public String fillInfo(HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userID") == null) {
				return "login";
			}
			return "fillWaterInfoPage";
		}
		@PostMapping("/fillInfo")
	    public String fillingInfo() {
	        return "fillWaterInfoPage";
	    }
		
		@PostMapping("/filledInfo")
		public String fillInfo(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
			int numDay = Integer.parseInt(request.getParameter("numDay"));
			String date = request.getParameter("date");
			double propFactor = Double.parseDouble(request.getParameter("propFactor"));
			double billAmount = Double.parseDouble(request.getParameter("billAmount"));
			double waterUsage = Double.parseDouble(request.getParameter("waterUsage"));
			HttpSession session = request.getSession();
			Participant p = (Participant)session.getAttribute("p");
			int id = (Integer) session.getAttribute("userID");
			
	        
			System.out.println("The id is: " + id);
		
			WaterConsumption water = new WaterConsumption(numDay, date, propFactor, billAmount, waterUsage, file , p);
		    
			
			boolean check = water.checkDate();
			water.calculateCarbonFootprint();
			System.out.println(p.getId());
			System.out.println(check);
			System.out.println(p.getId());
			
	        
	        
			if(check == false) {
				response.sendRedirect("fillInfo");
			}
			
			model.addAttribute("w", water);
			
			boolean waterDb = waterDbService.waterInsert(water);
			
			List<WaterConsumption> waterReports = waterDbService.getAllWaterReports();
			if(waterReports != null && !waterReports.isEmpty()) {
				System.out.println("There are values in the List");
			}
			else {
				System.out.println("List is empty failed to pass");
			}
			model.addAttribute("waterReports", waterReports);
			
		       
	        
			
			return "confirmWaterInfoPage";
		}

}
