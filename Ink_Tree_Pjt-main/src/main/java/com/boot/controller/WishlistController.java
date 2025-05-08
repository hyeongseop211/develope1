package com.boot.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.WishlistDAO;
import com.boot.dto.BookDTO;
import com.boot.dto.PageDTO;
import com.boot.dto.UserDTO;
import com.boot.dto.WishlistCriteriaDTO;
import com.boot.service.WishlistServiceImpl;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private WishlistServiceImpl wishlistService;

	@PostMapping("/add_wishlist")
	public String addToWishlist(@RequestParam("bookNumber") int bookNumber, HttpSession session) {
		Object object = session.getAttribute("loginUser");
		System.out.println("세션 ID: " + session.getId());
		if (object == null) {
			return "Not_login";
		}
		int userNumber = ((UserDTO) object).getUserNumber();

		return wishlistService.addWishlist(userNumber, bookNumber);
	}

@GetMapping("/wishlist/list")
public String wishlistList(@RequestParam(defaultValue = "1") int page,
                           HttpSession session, Model model) {
    UserDTO user = (UserDTO) session.getAttribute("loginUser");
    if (user == null) return "redirect:/loginView";

    WishlistCriteriaDTO criteria = new WishlistCriteriaDTO();
    criteria.setPage(page);

    HashMap<String, Object> param = new HashMap<>();
    param.put("userNumber", user.getUserNumber());

    List<BookDTO> wishlist = WishlistDAO.getWishlist(criteria, param);
    int total = WishlistDAO.getWishlistCount(param);

    PageDTO pageMaker = new PageDTO(criteria.getPage(), criteria.getAmount(), total);

    model.addAttribute("wishlist", wishlist);
    model.addAttribute("pageMaker", pageMaker);
    return "wishlist_list";
}

}
