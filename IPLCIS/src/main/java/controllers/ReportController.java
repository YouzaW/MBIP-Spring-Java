//package controllers;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import service.WaterDbService;
//import service.RecycleDbService;
//import service.ElectricityDbService;
//import model.Participant;
//import model.WaterConsumption;
//import model.ElectricityConsumption;
//import model.RecycleConsumption;
//
//@Controller
//@RequestMapping("/report")
//	public class ReportController  {
//	@Autowired
//	private WaterDbService waterDbService;
//
//	@Autowired
//	private ElectricityDbService electricityDbService;
//
//	@Autowired
//	private RecycleDbService recycleDbService;
//	
//	
//	
////	@Autowired
////	public ReportController(WaterDbService waterDbService, ElectricityDbService electricityDbService, RecycleDbService recycleDbService) {
////	    this.waterDbService = waterDbService;
////	    this.electricityDbService = electricityDbService;
////	    this.recycleDbService = recycleDbService;
////	}
//
//
//		
//		@PostMapping("/getall")
//	    public String getAll(Model model) {
//			
////			List<WaterConsumption> waterReports = waterDbService.getAllWaterReports();
////			if(waterReports != null && !waterReports.isEmpty()) {
////				System.out.println("There are values in the List");
////			}
////			else {
////				System.out.println("List is empty failed to pass");
////			}
////			model.addAttribute("waterReports", waterReports);
//		
//			System.out.println("Hello from rport");
//			
////			List<ElectricityConsumption> electricityReports = electricityDbService.getAllElectricityReports();
////			if(electricityReports != null && !electricityReports.isEmpty()) {
////				System.out.println("There are values in the List");
////			}
////			else {
////				System.out.println("List is empty failed to pass");
////			}
////			model.addAttribute("electricityReports", electricityReports);
////			
////			List<RecycleConsumption> recycleReports = recycleDbService.getAllRecycleReports();
////			if(recycleReports != null && !recycleReports.isEmpty()) {
////				System.out.println("There are values in the List");
////			}
////			else {
////				System.out.println("List is empty failed to pass");
////			}
////			model.addAttribute("recycleReports", recycleReports);
////			
//			return "listAll2";
//	    }
//		
//		
//}