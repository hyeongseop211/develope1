package com.lgy.spring_ex11_3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Itaewonclass {
	@RequestMapping("actor")
	public String actor(Model model) {
		model.addAttribute("id", "박새로이");
		return "actor";
	}
	@RequestMapping("actress")
	public String actress(Model model) {
		model.addAttribute("id", "조이서");
		return "actress";
	}
}
