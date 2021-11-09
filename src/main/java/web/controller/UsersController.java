package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import web.model.User;
import web.service.IService;
import web.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UsersController {


	IService service;

	@Autowired
	public UsersController(IService service) {
		this.service = service;
	}

	@GetMapping(value = "/index")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Привет!");
		messages.add("Это index-page задания 2.3.1");
		messages.add("11.08.2021");
		model.addAttribute("messages", messages);

		return "index";
	}

	@GetMapping()
	public String printUsers(@RequestParam(name="count",required = false) String count,ModelMap model) {
//		Integer countInt=(Integer) model.getAttribute("count");
		List<User> users=service.getUsersList(count);
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping(value = "/new")
	public String createNewUser(@ModelAttribute("user") User user,ModelMap model) {
//		model.addAttribute("user",new User());
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		service.add(user);
		return "redirect:/users";
	}

	@GetMapping(value = "/{id}")
	public String printUser(@PathVariable("id")long id,ModelMap model) {
		model.addAttribute("user",service.getUser(id));
		return "user";
	}

	@GetMapping(value = "/{id}/edit")
	public String editUser(@PathVariable("id") long id,ModelMap model) {
		model.addAttribute("user",service.getUser(id));
		return "edit";
	}

	@PatchMapping("/{id}")
	public String edit(@ModelAttribute("user") User user,@PathVariable("id") long id){
		service.update(user);
	return "redirect:/users/"+id;
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id){
		service.delete(id);
		return "redirect:/users";
	}
}