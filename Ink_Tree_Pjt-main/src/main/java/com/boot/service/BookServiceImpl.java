package com.boot.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.BookDAO;
import com.boot.dao.NoticeDAO;
import com.boot.dao.UserDAO;
import com.boot.dto.BookDTO;
import com.boot.dto.BookRecordDTO;
import com.boot.dto.NoticeCriteriaDTO;
import com.boot.dto.ReviewDTO;
import com.boot.dto.ReviewHelpfulDTO;
import com.boot.dto.SearchBookCriteriaDTO;
import com.boot.dto.UserBookBorrowingCriteriaDTO;
import com.boot.dto.UserDTO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession session;
	@Autowired
	private ActivityLogService activityLogService;

	@Override
	public void insertBook(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

		if (loginUser.getUserAdmin() == 1) {
			dao.insertBook(param);
			
			// 활동 로그 추가
			String bookTitle = param.get("bookTitle");
			String description = "\"" + bookTitle + "\" 도서가 등록되었습니다.";
			activityLogService.createActivityLog(
				"book_add", 
				"admin", 
				loginUser.getUserNumber(), 
				loginUser.getUserName(), 
				bookTitle, 
				description
			);
		} else {
			System.out.println("Not Admin access");
		}
	}

	@Override
	public void updateBook(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

		if (loginUser.getUserAdmin() == 1) {
			dao.updateBook(param);
			
			// 활동 로그 추가
			String bookTitle = param.get("bookTitle");
			String description = "\"" + bookTitle + "\" 도서가 수정되었습니다.";
			activityLogService.createActivityLog(
				"book_modify", 
				"admin", 
				loginUser.getUserNumber(), 
				loginUser.getUserName(), 
				bookTitle, 
				description
			);
		} else {
			System.out.println("Not Admin access");
		}
	}

	@Override
	public ArrayList<BookDTO> mainBookInfo() {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		ArrayList<BookDTO> list = dao.mainBookInfo();
		return list;
	}

	@Override
	public int getSearchBookTotalCount(SearchBookCriteriaDTO criteria, String majorCategory, String subCategory) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.getSearchBookTotalCount(criteria, majorCategory, subCategory);
	}

	@Override
	public ArrayList<BookDTO> searchBookInfo(SearchBookCriteriaDTO criteria, String majorCategory, String subCategory) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.searchBookInfo(criteria, majorCategory, subCategory);
	}

	@Override
	public BookDTO bookDetailInfo(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		BookDTO dto = dao.bookDetailInfo(param);
		return dto;
	}

	@Override
	public void bookBorrow(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		dao.bookBorrow(param);

		// 활동 로그 추가
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		
		// 도서 정보 가져오기
		String bookNumber = param.get("bookNumber");
		HashMap<String, String> bookParam = new HashMap<>();
		bookParam.put("bookNumber", bookNumber);
		BookDTO book = dao.bookDetailInfo(bookParam);
		
		if (book != null) {
			String bookTitle = book.getBookTitle();
			String userName = loginUser.getUserName();
			String description = userName + " 회원이 \"" + bookTitle + "\" 도서를 대출했습니다.";
			
			String actorType = loginUser.getUserAdmin() == 1 ? "admin" : "user";
			activityLogService.createActivityLog(
				"book_borrow", 
				actorType, 
				loginUser.getUserNumber(), 
				loginUser.getUserName(), 
				bookTitle, 
				description
			);
		}

	}

	@Override
	public void bookReturn(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		dao.bookReturn(param);

		// 활동 로그 추가
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		
		// 도서 정보 가져오기
		String bookNumber = param.get("bookNumber");
		HashMap<String, String> bookParam = new HashMap<>();
		bookParam.put("bookNumber", bookNumber);
		BookDTO book = dao.bookDetailInfo(bookParam);
		
		if (book != null) {
			String bookTitle = book.getBookTitle();
			String userName = loginUser.getUserName();
			String description = userName + " 회원이 \"" + bookTitle + "\" 도서를 반납했습니다.";
			
			String actorType = loginUser.getUserAdmin() == 1 ? "admin" : "user";
			activityLogService.createActivityLog(
				"book_return", 
				actorType, 
				loginUser.getUserNumber(), 
				loginUser.getUserName(), 
				bookTitle, 
				description
			);
		}
	}

	@Override
	public ArrayList<BookRecordDTO> bookBorrowed(UserBookBorrowingCriteriaDTO userBookBorrowingCriteriaDTO,
			HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.bookBorrowed(userBookBorrowingCriteriaDTO, param);
	}

	@Override
	public ArrayList<BookRecordDTO> bookRecord(UserBookBorrowingCriteriaDTO userBookBorrowingCriteriaDTO,
			HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.bookRecord(userBookBorrowingCriteriaDTO, param);
	}

	@Override
	public void deleteBook(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		
		// 도서 정보 가져오기
		String bookNumber = param.get("bookNumber");
		HashMap<String, String> bookParam = new HashMap<>();
		bookParam.put("bookNumber", bookNumber);
		BookDTO book = dao.bookDetailInfo(bookParam);
		
		// 도서 삭제
		dao.deleteBook(param);
		
		// 활동 로그 추가
		if (book != null) {
			String bookTitle = book.getBookTitle();
			String description = "\"" + bookTitle + "\" 도서가 삭제되었습니다.";
			activityLogService.createActivityLog(
				"book_delete", 
				"admin", 
				loginUser.getUserNumber(), 
				loginUser.getUserName(), 
				bookTitle, 
				description
			);
		}

	}

	@Override
	public int getBorrowedTotalCount(UserBookBorrowingCriteriaDTO userBookBorrowingCriteriaDTO, int userNumber) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		int total = dao.getBorrowedTotalCount(userBookBorrowingCriteriaDTO, userNumber);
		return total;
	}

	@Override
	public int getRecordTotalCount(UserBookBorrowingCriteriaDTO userBookBorrowingCriteriaDTO, int userNumber) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		int total = dao.getRecordTotalCount(userBookBorrowingCriteriaDTO, userNumber);
		return total;
	}

	@Override
	public int insertReview(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.insertReview(param);
	}

	@Override
	public int updateReview(ReviewDTO reviewDTO) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.updateReview(reviewDTO);
	}

	@Override
	public int deleteReview(ReviewDTO reviewDTO) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.deleteReview(reviewDTO);
	}

	@Override
	public ArrayList<ReviewDTO> getReview(NoticeCriteriaDTO criteria, HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.getReview(criteria, param);
	}

	@Override
	public int getReviewCount(NoticeCriteriaDTO criteria, HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		int total = dao.getReviewCount(criteria, param);
		return total;
	}

	@Override
	public int checkReview(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.checkReview(param);
	}

	@Override
	public ReviewDTO getReviewById(int reviewId) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.getReviewById(reviewId);
	}

	@Override
	public ArrayList<ReviewDTO> getAllReviewsByBookNumber(int bookNumber) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.getAllReviewsByBookNumber(bookNumber);
	}

	@Override
	public boolean addReviewHelpful(int reviewId, int userNumber) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);

		// 이미 도움됨 표시를 했는지 확인
		ReviewHelpfulDTO checkDTO = new ReviewHelpfulDTO();
		checkDTO.setReviewId(reviewId);
		checkDTO.setUserNumber(userNumber);

		if (dao.checkReviewHelpful(checkDTO) > 0) {
			return false; // 이미 도움됨 표시를 한 경우
		}

		// 도움됨 추가
		ReviewHelpfulDTO helpfulDTO = new ReviewHelpfulDTO();
		helpfulDTO.setReviewId(reviewId);
		helpfulDTO.setUserNumber(userNumber);

		return dao.addReviewHelpful(helpfulDTO) > 0;
	}

	@Override
	public boolean removeReviewHelpful(int reviewId, int userNumber) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);

		ReviewHelpfulDTO helpfulDTO = new ReviewHelpfulDTO();
		helpfulDTO.setReviewId(reviewId);
		helpfulDTO.setUserNumber(userNumber);

		return dao.removeReviewHelpful(helpfulDTO) > 0;
	}

	@Override
	public boolean checkReviewHelpful(int reviewId, int userNumber) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);

		ReviewHelpfulDTO helpfulDTO = new ReviewHelpfulDTO();
		helpfulDTO.setReviewId(reviewId);
		helpfulDTO.setUserNumber(userNumber);

		return dao.checkReviewHelpful(helpfulDTO) > 0;
	}

	@Override
	public int getReviewHelpfulCount(int reviewId) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		return dao.getReviewHelpfulCount(reviewId);
	}
	
	@Override
	public ArrayList<BookDTO> Top5Recommend(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		ArrayList<BookDTO> list = dao.Top5Recommend(param);
		return list;
	}
	@Override
	public ArrayList<BookDTO> Top3Borrow() {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		ArrayList<BookDTO> list = dao.Top3Borrow();
		return list;
	}

	@Override
	public ArrayList<BookDTO> Top5Random(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		ArrayList<BookDTO> list = dao.Top5Random(param);
		return list;
	}

	@Override
	public String CategoryNum(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		String categoryNum = dao.CategoryNum(param);
		return categoryNum;
	}
}
