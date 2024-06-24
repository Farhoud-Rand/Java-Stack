package com.example.Counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping("/")
public String index(HttpSession session) {
		if (session.getAttribute("counter")==null) {
			session.setAttribute("counter", 0);
		}
		else {
			int count =(int) session.getAttribute("counter");
			count+=1;
			session.setAttribute("counter", count);
		}
		return "index.jsp";
}
	@RequestMapping("/counter")
public String counter(HttpSession session,Model model) {
		if (session.getAttribute("counter")==null) {
			session.setAttribute("counter", 0);
			
		}
		
		model.addAttribute("count",session.getAttribute("counter"));
		
		
	return "counter.jsp";
}
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		
		session.setAttribute("counter", 0);
		return "redirect:/counter";
	}

	@RequestMapping("/counter2")
public String incrmentedByTwo(HttpSession session) {
		if (session.getAttribute("counter")==null) {
			session.setAttribute("counter", 2);
		}
		else {
			int count =(int) session.getAttribute("counter");
			count+=2;
			session.setAttribute("counter", count);
		}
		return "incremnetbytwo.jsp";
}
}
