package com.example.NinjaGold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class MainController {
	// Initialized the session and render the JSP file
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("total_golds") == null) {
			session.setAttribute("total_golds", 0); // Total number of golds the user has
		}
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", new ArrayList<>()); // List of user submission activities
		}
		if (session.getAttribute("show_alert") == null) {
			session.setAttribute("show_alert", false); // Show alert flag
		}
		if (session.getAttribute("attempts") == null) {
			session.setAttribute("attempts", 10);      // Number of attempts allowed
		}
		if (session.getAttribute("target_gold") == null) {
			session.setAttribute("target_gold", 100);  // Target gold to reach
		}
		if (session.getAttribute("message") == null) {
			session.setAttribute("message", "");       // Message in alert
		}
		if (session.getAttribute("result") == null) {
			session.setAttribute("result", "");        // Type of alert
		}
		if (session.getAttribute("random_number") == null) {
			session.setAttribute("random_number", 0);  // Random number
		}
		if (session.getAttribute("formatted_date_time") == null) {
			session.setAttribute("formatted_date_time", ""); // Formatted date and time
		}
		// Send needed data to the JSP file by model
		model.addAttribute("total_golds",session.getAttribute("total_golds"));
		model.addAttribute("activities",session.getAttribute("activities"));
		model.addAttribute("show_alert",session.getAttribute("show_alert"));
		model.addAttribute("message",session.getAttribute("message"));
		model.addAttribute("result",session.getAttribute("result"));
		return "index.jsp";
	}
	//________________________________________________________________________________________________________________________________________
	// This route called when we submit any form, it will:
	//	 * choose a random number (according to the submitted form)
	//	 * Calculate the total number of golds
	//	 * Add the new activity
	//	 * redirect the root route
	@PostMapping("/process_money")
	public String process_money(@RequestParam(value="min") int min, @RequestParam(value="max") int max, @RequestParam(value="form") String form, HttpSession session) {
		chooseRandomNumber(min,max,session);
		formatDateTime(session);
		writeOutputString(form,session);
		checkTarget(session);
		return "redirect:/";
	}
	//________________________________________________________________________________________________________________________________________
	// Function to select random number in specific range
	private void chooseRandomNumber(int min, int max, HttpSession session) {
		// create instance of Random class
		Random rand = new Random();
		int random_number = rand.nextInt(max - min + 1) + min; // Choose a random number
		session.setAttribute("random_number", random_number);  // Random number

		if (session.getAttribute("total_golds") == null) {
			session.setAttribute("total_golds", random_number); // Total number of golds the user has
		} else {
			Integer total = (Integer)session.getAttribute("total_golds");
			total += random_number;
			session.setAttribute("total_golds", total); // Total number of golds the user has
		}
	}
	//________________________________________________________________________________________________________________________________________
	// Function to get and format date & time
	public void formatDateTime(HttpSession session) {
		// Get current date and time
		LocalDateTime currentDateTime = LocalDateTime.now();
		// Format the time as hours:minutes AM/PM and date as year-month-day
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
		String formattedDateTime = currentDateTime.format(formatter);
		// Store the formatted date and time in the session
		session.setAttribute("formatted_date_time", formattedDateTime);
	}
	//________________________________________________________________________________________________________________________________________
	// Function to write the output string about the activity
	public void writeOutputString(String form,HttpSession session) {
		String output;
		MessageOutput item = new MessageOutput();
		if (session.getAttribute("random_number") != null && (int)session.getAttribute("random_number") > 0) {
			output = String.format("Earned %d golds from the %s! (%s)",(int) session.getAttribute("random_number"),form,session.getAttribute("formatted_date_time"));
			item.setOutput(output);
			item.setColor("green");
		} else {
			output = String.format("Entered a casino and lost %d golds... Ouch.. (%s)", Math.abs((int) session.getAttribute("random_number")),session.getAttribute("formatted_date_time"));
			item.setOutput(output);
			item.setColor("red");
		}
		// Ensure the 'activities' session attribute is initialized as a list
		ArrayList<MessageOutput> activities = (ArrayList<MessageOutput>) session.getAttribute("activities");
		if (activities == null) {
			activities = new ArrayList<>();
		}

		// Insert the output at the beginning of the activities list
		activities.add(0, item);

		// Update the session with the modified activities list
		session.setAttribute("activities", activities);
		// Decrease the number of attempts
		// Retrieve the current attempts from the session
		Integer attempts = (Integer) session.getAttribute("attempts");

		// If attempts is null, initialize it to 0 (or handle as needed)
		if (attempts == null) {
			attempts = 0;
		}
		else {
			// Decrement attempts by 1
			attempts--;
		}

		// Update the session with the new attempts value
		session.setAttribute("attempts", attempts);
	}
	//________________________________________________________________________________________________________________________________________
	// Function to check if the user get the target number of golds or not
	public void checkTarget(HttpSession session) {
		// Check if the user reached the target gold
		Integer totalGolds = (Integer) session.getAttribute("total_golds");
		Integer targetGold = (Integer) session.getAttribute("target_gold");
		Integer attempts = (Integer) session.getAttribute("attempts");

		if (totalGolds >= targetGold) {
			session.setAttribute("show_alert", true);
			session.setAttribute("message", "Congratulations! You have reached 100 gold!");
			session.setAttribute("result", "success");
		} else if (attempts == 0 && totalGolds < targetGold) {
			session.setAttribute("show_alert", true);
			session.setAttribute("message", "Oops! You have run out of attempts. Try again!");
			session.setAttribute("result", "error");
		}
	}
	//________________________________________________________________________________________________________________________________________
	// Function to clean the session
	@RequestMapping("/destroy_session")
	public String clean(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
