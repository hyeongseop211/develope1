package com.boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.WishlistDAO;
import com.boot.dto.BookDTO;
import com.boot.dto.WishlistCriteriaDTO;

@Service
public class WishlistServiceImpl implements WishlistService {
    @Autowired
    private WishlistDAO wishlistDao;

    @Override
    public String addWishlist(int userNumber, int bookNumber) {
            if (wishlistDao.isAlreadyInWishlist(userNumber, bookNumber)) {
                return "already";
            }
            wishlistDao.addToWishlist(userNumber, bookNumber);
            return "Success";
    }

    @Override
    public List<BookDTO> Wishlist(int userNumber, int page) {
            WishlistCriteriaDTO criteria = new WishlistCriteriaDTO();
            criteria.setPage(page);
            HashMap<String, Object> param = new HashMap<>();
            param.put("userNumber", userNumber);
            return wishlistDao.getWishlist(criteria, param);
    }

    @Override
    public int WishlistCount(int userNumber) {
            HashMap<String, Object> param = new HashMap<>();
            param.put("userNumber", userNumber);
            return wishlistDao.getWishlistCount(param);
    }

}
