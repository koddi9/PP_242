package web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceImpl;

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
	public String printCars(@RequestParam(name="count",required = false) String count,ModelMap model) {
//		Integer countInt=(Integer) model.getAttribute("count");
		ServiceImpl service = new ServiceImpl();
		List<Car> cars;

		if (count==null){
			count="5";
		}
		cars=service.getCarsList(Integer.parseInt(count));

		model.addAttribute("cars", cars);
		return "cars";
	}
}