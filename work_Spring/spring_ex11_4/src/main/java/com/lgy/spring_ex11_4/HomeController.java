package com.lgy.spring_ex11_4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("portpolio/airbnb")
//	public String title() {
	public String airbnb(Model model) {
		model.addAttribute("title", "숙소예약");
		return "portpolio/airbnb";
	}
	@RequestMapping("portpolio/universityManager")
//	public String title() {
	public String university(Model model) {
		model.addAttribute("title", "학사관리");
		return "portpolio/universityManager";
	}
	@RequestMapping("portpolio/bookManager")
//	public String title() {
	public String bookManager(Model model) {
		model.addAttribute("title", "도서관리");
		return "portpolio/bookManager";
	}
}
