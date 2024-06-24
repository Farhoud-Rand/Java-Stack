package com.example.DisplayDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homaPage() {
		
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDateTime date = LocalDateTime.now();

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd,yyyy");
	String formattedDate = date.format(formatter);
	        
		model.addAttribute("date",formattedDate);
		return "date.jsp";
	}
	

	@RequestMapping("/time")
	public String time(Model model) {
		LocalDateTime time= LocalDateTime.now();

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
	String formattedtime = time.format(formatter);
	        
		model.addAttribute("time",formattedtime);
		return "time.jsp";
	}}
