package in.conceptarchitect.bookmanagement.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping(path="/")
	@ResponseBody
	public String home() {
		return "welcome";
	}
	
	@GetMapping(path="/error")
	@ResponseBody
	public String error() {
		return "error";
	}
}
