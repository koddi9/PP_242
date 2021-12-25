package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import web.model.Role;
import web.model.User;
import web.service.UserService;
import web.service.RoleService;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class UsersController {


	UserService service;
	RoleService roleService;

	@Autowired
	public UsersController(UserService service, RoleService roleService) {
		this.service = service;
		this.roleService=roleService;
	}


	@GetMapping("admin/users")
	public String printUsers(@RequestParam(name="count",required = false) String count,ModelMap model) {
//		Integer countInt=(Integer) model.getAttribute("count");
		List<User> users=service.getUsersList(count);
		model.addAttribute("users", users);
		return "users.html";
	}

	@GetMapping(value = "admin/users/new")
	public String createNewUser(@ModelAttribute("user") User user,ModelMap model) {
//		model.addAttribute("user",new User());
		List<Role> roles = roleService.findAll();
		model.addAttribute("allRoles",roles);
		return "new";
	}

	@PostMapping("admin/users")
	public String create(@ModelAttribute("user") User user) {
		Set<Role> newRoles = user.getRoles().stream()
				.map(role->roleService.getRole(Integer.parseInt(role.getRole())))
				.collect(Collectors.toSet());
		System.out.println(newRoles);
		user.setRoles(newRoles);
		service.add(user);
		return "redirect:/admin/users";
	}

	@GetMapping(value = "admin/users/{id}")
	public String printUser(@PathVariable("id")long id,ModelMap model) {
		model.addAttribute("user",service.getUser(id));
		return "user";
	}

	@GetMapping(value = "admin/users/{id}/edit")
	public String editUser(@PathVariable("id") long id,ModelMap model) {
		model.addAttribute("user",service.getUser(id));
		return "edit";
	}

	@PatchMapping("admin/users/{id}")
	public String edit(@ModelAttribute("user") User user,@PathVariable("id") long id){
		user.setRoles(service.getUser(id).getRoles());
		service.update(user);
	return "redirect:/admin/users/"+id;
	}
	@DeleteMapping("admin/users/{id}")
	public String delete(@PathVariable("id") long id){
		service.delete(id);
		return "redirect:/admin/users";
	}

	@GetMapping(value = "/user")
	public String myUser(ModelMap model, Principal principal) {
		System.out.println(principal.getName());
		User user = service.getUserByName(principal.getName());
		System.out.println("User FROM PRINCIPAL: "+user);
		model.addAttribute("user",user);
		return "user";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}


}