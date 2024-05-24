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
import model.Participant;
import model.RecycleConsumption;

@Controller
@RequestMapping("/recycle")
	public class RecycleController {
	RecycleDbService recycleDbService;
	
		public RecycleController() {
			
			recycleDbService = new RecycleDbService();
		}
		
		@GetMapping("/fillInfo")
		public String fillInfo(HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userID") == null) {
				return "login";
			}
			return "fillRecycleInfoPage";
		}
		@PostMapping("/fillInfo")
		public String fillingInfo() {
			return "fillRecycleInfoPage";
		}
		
		@PostMapping("/filledInfo")
		public String fillInfo(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
			int numDay = Integer.parseInt(request.getParameter("numDay"));
			String date = request.getParameter("date");
			double propFactor = Double.parseDouble(request.getParameter("propFactor"));
			double billAmount = Double.parseDouble(request.getParameter("billAmount"));
			double recycleUsage = Double.parseDouble(request.getParameter("recycleUsage"));
			HttpSession session = request.getSession();
			Participant p = (Participant)session.getAttribute("p");
			int id = (Integer) session.getAttribute("userID");
			System.out.println(id);
		
			RecycleConsumption recycle = new RecycleConsumption(numDay, date, propFactor, billAmount, recycleUsage ,file , p);
			boolean check = recycle.checkDate();
			recycle.calculateCarbonFootprint();
			System.out.println(p.getId());
			System.out.println(check);
			System.out.println(p.getId());
			if(check == false) {
				response.sendRedirect("fillInfo");
			}
			
			model.addAttribute("r", recycle);
			
			boolean recycleDb = recycleDbService.recycleInsert(recycle);
			
			List<RecycleConsumption> recycleReports = recycleDbService.getAllRecycleReports();
			if(recycleReports != null && !recycleReports.isEmpty()) {
				System.out.println("There are values in the List");
			}
			else {
				System.out.println("List is empty failed to pass");
			}
			model.addAttribute("recycleReports", recycleReports);
			
			
			return "confirmRecycleInfoPage";
		}
}
