package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.IService;
import web.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
public class HelloController {


	IService service;

	@Autowired
	public HelloController(IService service) {
		this.service = service;
	}

	@GetMapping(value = "")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Привет!");
		messages.add("Это index-page задания 2.2.3");
		messages.add("11.06.2021");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/users")
	public String printUsers(@RequestParam(name="count",required = false) String count,ModelMap model) {
//		Integer countInt=(Integer) model.getAttribute("count");
		List<User> users=new ArrayList<>();
		users=service.getUsersList(count);
		model.addAttribute("users", users);
		return "users";
	}
}