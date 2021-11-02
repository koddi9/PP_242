package web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model,@RequestParam(name="count",required = false) String count) {
		List<Car> cars = new ArrayList<>();
		Integer countInt=(Integer) model.getAttribute("count");
		cars.add(new Car("BMW",5,"gray"));
		cars.add(new Car("2",2,"black"));
		cars.add(new Car("3",3,"white"));
		cars.add(new Car("4",4,"green"));
		cars.add(new Car("5",5,"red"));
		cars=cars.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
		model.addAttribute("cars", cars);
		return "cars";
	}
	
}