package com.boot.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boot.dto.BookDTO;
import com.boot.dto.WishlistCriteriaDTO;

@Repository
public class WishlistDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 // 이미 위시리스트에 있는지 확인
    public boolean isAlreadyInWishlist(int userNumber, int bookNumber) {
        String sql = "SELECT COUNT(*) FROM BOOK_WISHLIST WHERE userNumber = ? AND bookNumber = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userNumber, bookNumber);
        return count != null && count > 0;
    }

    // 위시리스트에 추가
    public void addToWishlist(int userNumber, int bookNumber) {
        String sql = "INSERT INTO BOOK_WISHLIST (userNumber, bookNumber) VALUES (?, ?)";
        jdbcTemplate.update(sql, userNumber, bookNumber);
    }

    public List<BookDTO> getWishlist(WishlistCriteriaDTO criteria, HashMap<String, Object> param) {
        int userNumber = (int) param.get("userNumber");

        String sql = """
            SELECT b.bookNumber, b.bookTitle, b.bookWrite, b.bookPub, b.bookMajorCategory
            FROM BOOKINFO b
            JOIN BOOK_WISHLIST w ON b.bookNumber = w.bookNumber
            WHERE w.userNumber = ?
            ORDER BY b.bookTitle
            OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BookDTO book = new BookDTO();
            book.setBookNumber(rs.getInt("bookNumber"));
            book.setBookTitle(rs.getString("bookTitle"));
            book.setBookWrite(rs.getString("bookWrite"));
            book.setBookPub(rs.getString("bookPub"));
            book.setBookMajorCategory(rs.getString("bookMajorCategory"));
            return book;
        }, userNumber, criteria.getStartRow(), criteria.getAmount());
    }

    public int getWishlistCount(HashMap<String, Object> param) {
        int userNumber = (int) param.get("userNumber");
        String sql = "SELECT COUNT(*) FROM BOOK_WISHLIST WHERE userNumber = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, userNumber);
    }
}
