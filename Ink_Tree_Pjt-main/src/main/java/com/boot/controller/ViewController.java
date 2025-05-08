package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.controller.util.ConnectionTracker;
import com.boot.service.BookService;
import com.boot.service.UtilService;



@Controller
public class ViewController {
	@Autowired
	private UtilService utilService;
	@Autowired
	private BookService bookSerivce;

	@RequestMapping("/")
	public String getMainBookInfo(Model model) {
		model.addAttribute("totalBooks", utilService.getTotalBooks());
		model.addAttribute("totalUsers", utilService.getTotalUsers());
		model.addAttribute("borrowedBooks", utilService.getBorrowedBooks());
		model.addAttribute("overdueBooks", utilService.getOverdueBooks());
		model.addAttribute("bookList", bookSerivce.mainBookInfo());
		model.addAttribute("currentPage", "main"); // 헤더 식별용
		return "main";
	}

	@RequestMapping("/loginForm")
	public String loginPage(HttpServletRequest request) {
		String clientIp = getClientIp(request);
		ConnectionTracker.addIp(clientIp);

		request.getSession().setAttribute("clientIp", clientIp);

		System.out.println(clientIp + " online");
		return "login";
	}

	@RequestMapping("/disconnect")
	@ResponseBody
	public void disconnect(HttpServletRequest request) {
		String clientIp = getClientIp(request);
//		ConnectionTracker.removeIp(clientIp);
//		System.out.println("off : " + clientIp);
	}

	@RequestMapping("/joinForm")
	public String join() {
		return "join";
	}

	// board
	@RequestMapping("/board_write")
	public String boardViewWrite() {
		return "board_write";
	}

	private String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr(); // ���� fallback
		}

		if (ip != null && ip.contains(",")) {
			ip = ip.split(",")[0];
		}

		return ip;
	}
}
