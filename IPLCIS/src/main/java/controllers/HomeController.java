package controllers;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;

import model.Participant;
import service.DbService;

@Controller
public class HomeController {
	DbService dbService;
	
	public HomeController() {
		dbService = new DbService();
	}
	
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	
	@PostMapping("/login")
	public String loggingIn() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return"register";
	}
	@PostMapping("/register")
	public String registering() {
		return "register";
	}
	@PostMapping("/loginRegister")
	public String loginRegister(HttpServletRequest request,Model model) {
		System.out.println("Successfully registered");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ic = request.getParameter("icNum");
		String phone = request.getParameter("phoneNum");
		long icNum = Long.parseLong(ic);
		long phoneNum = Long.parseLong(phone);
		String status = request.getParameter("status");
		String address = request.getParameter("address");
		String category = request.getParameter("category");
		
		Participant p = new Participant(email,password,icNum,phoneNum,status,address,category,0);
		boolean registered = dbService.registerUser(p);
		request.setAttribute("r", registered);
		
		if(registered == false)
		{
			return"register";
		}
		return"login";
	}
	@GetMapping("/homepage")
	public String viewHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userID") == null) {
			return "login";
		}
		System.out.println("This is homepage");
		
		return "viewHomePage";
	}
	@PostMapping("/home")
	public String processInfo(HttpServletRequest request,Model model) {
		System.out.println("Home");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		//save to db table
		Participant p = dbService.signIn(email, password);
		if (p.getEmail() == "")
		{
			return "login";
		}
		
		model.addAttribute("p", p);
		HttpSession session = request.getSession();
		session.setAttribute("userID", p.getId());
		session.setAttribute("p", p);
		
		return "viewHomePage";
	}
	
	@GetMapping("/updateprofile")
	public String updateProfile(HttpServletRequest request ,Model model) {
		System.out.println("This is UpdateProfile");
		HttpSession session = request.getSession();
		if(session.getAttribute("userID") == null) {
			return "login";
		}
		int id = (Integer)session.getAttribute("userID");
		
		Participant p = dbService.getParticipant(id);
		model.addAttribute("p", p);
		return "viewProfilePage";
	}
	
	@PostMapping("/updateprofile")
	public String updatingProfile(HttpServletRequest request ,Model model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ic = request.getParameter("icNum");
		String phone = request.getParameter("phoneNum");
		long icNum = Long.parseLong(ic);
		long phoneNum = Long.parseLong(phone);
		String status = request.getParameter("status");
		String address = request.getParameter("address");
		String category = request.getParameter("category");
		
		Participant p = new Participant(email,password,icNum,phoneNum,status,address,category, 0);
		HttpSession session = request.getSession();
		int id = (Integer)session.getAttribute("userID");
		
		boolean update = dbService.updateParticipant(p, id);
		
		if(update) {
			System.out.println("Update Successful");
		}
		
		return "viewHomePage";
	}
}
