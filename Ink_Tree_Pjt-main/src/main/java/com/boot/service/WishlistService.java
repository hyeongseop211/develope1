package com.boot.service;

import java.util.List;

import com.boot.dto.BookDTO;

public interface WishlistService {
	public String addWishlist(int userNumber, int bookNumber);
	
	public List<BookDTO> Wishlist(int userNumber, int page);
	
	public int WishlistCount(int userNumber);
}
