<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="enu-kr">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <title>배너 유형02</title>
        <style>
            
            /* reset */
            * {
                margin: 0;
                padding: 0;
            }
            a {
                text-decoration: none;
                color: #000;
            }
            li {
                list-style: none;
            }
            em, address {
                font-style: normal;
            }
            .ir_so {
                overflow: hidden;
                position: absolute;
                width: 0;
                height: 0;
                line-height: 0;
                text-indent: -9999px;
            }
            .ir_pm {
                display: inline-block;
                overflow: hidden;
                font-size: 0;
                line-height: 0;
                text-indent: -9999px;
            }
    
            /* common */
            .gray {
                background-color: #F6F8FD;
            }
            .container {
                width: 100%;
                margin: 0 auto;
                padding: 0 20px;
                /* background: rgba(0,0,0,0.3); */
            }
            .section {
                margin-top: 30px;
                padding: 30px 0;
                text-align: center;
            }
            .section > h2 {
                font-size: 50px;
                font-weight: 500;
                margin-bottom: 20px;
                line-height: 1;
            }
            .section > p {
                font-size: 22px;
                font-weight: 300;
                margin-bottom: 70px;
                line-height: 1.5;
                color: #777;
            }
            .section__desc em {
                font-style: normal;
                text-decoration: underline;
                text-underline-position: under;
            }
    
            /* textType */
            .footer__inner {
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap;
                text-align: left;
            }
            .footer__logo {
                width: 30%;
            }
            .footer__logo h3 {
                font-size: 18px;
                font-weight: 500;
                margin-bottom: 20px;
            }
            .footer__logo p {
                font-size: 14px;
                line-height: 1.6;
                margin-bottom: 20px;
            }
            .footer__logo .sns ul {
                display: flex;
            }
            .footer__logo .sns li {
                margin-right: 5px;
            }
            .footer__logo .sns li a {
                display: inline-block;
                width: 45px;
                height: 45px;
                background-color: #F5F5F5;
                border-radius: 50%;
                background-image: url(https://webstoryboy.github.io/web2022/webs_img/footer02_icon.svg);
            }
            .footer__logo .sns li:nth-child(2) a {
                background-position: -45px 0;
            }
            .footer__logo .sns li:nth-child(3) a {
                background-position: -90px 0;
            }
            .footer__logo .sns li:nth-child(4) a {
                background-position: -135px 0;
            }
            .footer__logo .sns li:nth-child(5) a {
                background-position: -180px 0;
            }
            .footer__menu {
                width: 70%;
                display: flex;
                justify-content: space-between;
            }
            .footer__menu h3 {
                font-size: 18px;
                font-weight: 500;
                margin-bottom: 20px;
            }
            .footer__menu li a {
                display: inline-block;
                font-size: 14px;
                font-weight: 300;
                margin-bottom: 7px;
            }
            .footer__right {
                margin-top: 30px;
                width: 100%;
                text-align: center;
                font-size: 14px;
                font-weight: 300;
            }
        </style>
    </head>
    <body>
        <footer id="footerType" class="footer__wrap section gmarket gray">
            <h2 class="ir_so">푸터 영역</h2>
            <div class="footer__inner container">
                <div class="footer__logo">
                    <h3>InkTree</h3>
                    <p>
                        안녕하세요!<br>
                        문의사항은 메일로 부탁드립니다.<br>
                        <a href="mailto:InkTree@naver.com">InkTree@naver.com</a>
                    </p>
                    <div class="sns">
                        <ul>
                            <li><a href="#"><span class="ir_pm">페이스북</span></a></li>
                            <li><a href="#"><span class="ir_pm">인스타</span></a></li>
                            <li><a href="#"><span class="ir_pm">유튜브</span></a></li>
                            <li><a href="#"><span class="ir_pm">깃헙</span></a></li>
                            <li><a href="#"><span class="ir_pm">디스코드</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="footer__menu">
                    <div>
                        <h3>도서관련</h3>
                        <ul>
                            <li><a href="../book_search_view">도서 검색하기📖</a></li>
                            <li><a href="../user_book_recommend">추천 도서💡</a></li>
                            <li><a href="../book_search_view">도서 찜하기💖</a></li>
                            <li><a href="/user_book_borrowing">도서 대출하기🔖</a></li>
                            <li><a href="/user_book_borrowing">도서 반납하기🔖</a></li>
                        </ul>
                    </div>
                    <div>
                        <h3>게시판 가기</h3>
                        <ul>
                            <li><a href="/board_view">게시판 구경가기📌</a></li>
                            <li><a href="/board_write">게시글 작성하기💬</a></li>
                            <li><a href="/board_view">인기 게시판🔥</a></li>
                        </ul>
                    </div>
                    <div>
                        <h3>공지사항</h3>
                        <ul>
                            <li><a href="/admin_notice">필독! 공지사항📢</a></li>
                            <li><a href="/admin_notice">업데이트 안내🔊</a></li>
                            <li><a href="/admin_notice">이벤트 공지🎉</a></li>
                            <li><a href="#">자주 묻는 질문💬</a></li>
                            <li><a href="#">공지사항 더보기</a></li>
                        </ul>
                    </div>
                    <div>
                        <h3>도서 시장</h3>
                        <ul>
                            <li><a href="/trade_post_write">도서 판매하기💰</a></li>
                            <li><a href="/trade_post_view">도서 구매하기💰</a></li>
                            <li><a href="/trade_post_view">구매 예약하기🔖</a></li>
                            <li><a href="#">거래 후기 보기💬</a></li>
                        </ul>
                    </div>
                    <div>
                        <h3>마이페이지</h3>
                        <ul>
                            <li><a href="/mypage">마이페이지 보기💬</a></li>
                            <li><a href="/book_wishlist">찜한 도서 보기💖 </a></li>
                            <li><a href="/user_book_borrowing">대출 내역 보기🔖</a></li>
                            <li><a href="/mypage">회원 정보 수정🔒</a></li>
                        </ul>
                    </div>
                </div>
                <address class="footer__right">
                    ©2022 InkTree. All rights reserved.
                </address>
            </div>
        </footer>
        <!-- //푸터 영역(유형2) -->
    </body>
</html>