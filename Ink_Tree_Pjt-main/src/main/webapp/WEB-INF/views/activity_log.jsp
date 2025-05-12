<%@page import="com.boot.dto.ActivityLogDTO" %>
<%@page import="com.boot.dto.UserDTO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.boot.dto.PageDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서관리 시스템 - 활동 로그</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/admin_view.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/board_view.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    
    <style>
        .activity-filter {
            display: flex;
            gap: 15px;
            margin-bottom: 20px;
        }
        
        .filter-item {
            padding: 8px 12px;
            border-radius: 5px;
            background-color: #f0f0f0;
            cursor: pointer;
            transition: all 0.2s;
        }
        
        .filter-item.active {
            background-color: #4a6cf7;
            color: white;
        }
        
        .activity-list-full {
            margin-top: 20px;
        }
        
        .activity-item {
            display: flex;
            padding: 15px;
            border-bottom: 1px solid #eaeaea;
            align-items: flex-start;
        }
        
        .activity-item:last-child {
            border-bottom: none;
        }
        
        .activity-icon {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background-color: #f5f5f5;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-right: 15px;
            flex-shrink: 0;
        }
        
        .activity-details {
            flex-grow: 1;
        }
        
        .activity-details h4 {
            margin: 0 0 5px 0;
            font-size: 16px;
            font-weight: 600;
        }
        
        .activity-details p {
            margin: 0 0 8px 0;
            color: #555;
        }
        
        .activity-time {
            font-size: 12px;
            color: #777;
        }
        
        .activity-meta {
            display: flex;
            justify-content: space-between;
            font-size: 12px;
            color: #777;
        }
        
        .actor-info {
            color: #4a6cf7;
        }
    </style>
</head>

<body>
    <% UserDTO user = (UserDTO) session.getAttribute("loginUser"); %>
    <jsp:include page="header.jsp" />
    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <div class="sidebar-header">
                <h1>도서관리 시스템</h1>
                <p>관리자 대시보드</p>
            </div>

            <div class="admin-info">
                <div class="admin-avatar">
                    <i class="ri-user-line"></i>
                </div>
                <div class="admin-details">
                    <h3>관리자<%=user.getUserName()%></h3>
                    <p><%=user.getUserEmail()%></p>
                </div>
            </div>

            <nav class="nav-menu">
                <div class="menu-category">대시보드</div>
                <ul class="nav-list">
                    <li class="nav-item"><a href="admin_dashboard" class="nav-link active">
                        <i class="ri-dashboard-line"></i> <span>대시보드</span>
                    </a></li>
                </ul>

                <div class="menu-category">도서 관리</div>
                <ul class="nav-list">
                    <li class="nav-item"><a href="book_insert_view" class="nav-link">
                        <i class="ri-file-add-line"></i> <span>도서 등록</span>
                    </a></li>
                    <li class="nav-item"><a href="book_manage" class="nav-link">
                        <i class="ri-book-line"></i> <span>도서 관리</span>
                    </a></li>
                    <li class="nav-item"><a href="book_category" class="nav-link">
                        <i class="ri-bookmark-line"></i> <span>카테고리 관리</span>
                    </a></li>
                </ul>

                <div class="menu-category">회원 관리</div>
                <ul class="nav-list">
                    <li class="nav-item"><a href="user_manage" class="nav-link">
                        <i class="ri-user-settings-line"></i> <span>회원 관리</span>
                    </a></li>
                    <li class="nav-item"><a href="user_borrow" class="nav-link">
                        <i class="ri-file-list-3-line"></i> <span>대출/반납 관리</span>
                    </a></li>
                </ul>

                <div class="menu-category">콘텐츠 관리</div>
                <ul class="nav-list">
                    <li class="nav-item"><a href="admin_notice_write" class="nav-link">
                        <i class="ri-notification-line"></i> <span>공지사항 등록</span>
                    </a></li>
                    <li class="nav-item"><a href="notice_manage" class="nav-link">
                        <i class="ri-file-list-line"></i> <span>공지사항 관리</span>
                    </a></li>
                </ul>
            </nav>
        </aside>

        <!-- Main Content -->
        <main class="main-content">
            <div class="page-header">
                <div class="page-title">
                    <h2>활동 로그</h2>
                    <p>시스템 내 모든 활동 기록을 확인합니다.</p>
                </div>
            </div>

            <div class="activity-filter">
                <div class="filter-item <%= request.getParameter("filter") == null || "all".equals(request.getParameter("filter")) ? "active" : "" %>" data-filter="all">전체</div>
                <div class="filter-item <%= "book".equals(request.getParameter("filter")) ? "active" : "" %>" data-filter="book">도서 관련</div>
                <div class="filter-item <%= "user".equals(request.getParameter("filter")) ? "active" : "" %>" data-filter="user">회원 관련</div>
                <div class="filter-item <%= "notice".equals(request.getParameter("filter")) ? "active" : "" %>" data-filter="notice">공지사항 관련</div>
                <div class="filter-item <%= "admin".equals(request.getParameter("filter")) ? "active" : "" %>" data-filter="admin">관리자 활동</div>
                <div class="filter-item <%= "user-action".equals(request.getParameter("filter")) ? "active" : "" %>" data-filter="user-action">회원 활동</div>
            </div>

            <div class="card activity-list-full">
                <% if(request.getAttribute("logList") != null) {
                    ArrayList<ActivityLogDTO> logList = (ArrayList<ActivityLogDTO>)request.getAttribute("logList");
                    
                    // 필터 값 가져오기
                    String filterParam = request.getParameter("filter");
                    
                    // 필터링된 로그 항목 수 계산
                    int filteredCount = 0;
                    for(ActivityLogDTO activity : logList) {
                        boolean showItem = true;
                        if (filterParam != null && !filterParam.equals("all")) {
                            showItem = false;
                            
                            if (filterParam.equals("book") && activity.getActivityType().startsWith("book")) {
                                showItem = true;
                            } else if (filterParam.equals("user") && activity.getActivityType().startsWith("user")) {
                                showItem = true;
                            } else if (filterParam.equals("notice") && activity.getActivityType().startsWith("notice")) {
                                showItem = true;
                            } else if (filterParam.equals("admin") && activity.getActorType().equals("admin")) {
                                showItem = true;
                            } else if (filterParam.equals("user-action") && activity.getActorType().equals("user")) {
                                showItem = true;
                            }
                        }
                        
                        if (showItem) {
                            filteredCount++;
                        }
                    }
                    
                    if (filteredCount > 0) {
                        for(ActivityLogDTO activity : logList) { 
                            String iconClass = "";
                            
                            // 활동 유형에 따른 아이콘 설정
                            switch(activity.getActivityType()) {
                                case "book_add": iconClass = "ri-book-open-line"; break;
                                case "user_add": iconClass = "ri-user-add-line"; break;
                                case "book_borrow": iconClass = "ri-bookmark-line"; break;
                                case "notice_add": iconClass = "ri-notification-line"; break;
                                case "book_return": iconClass = "ri-book-read-line"; break;
                                case "notice_delete": iconClass = "ri-delete-bin-line"; break;
                                case "book_delete": iconClass = "ri-delete-bin-line"; break;
                                default: iconClass = "ri-information-line";
                            }
                            
                            // 활동 유형에 따른 필터 클래스 설정
                            String filterClass = "";
                            if (activity.getActivityType().startsWith("book")) {
                                filterClass += " filter-book";
                            } else if (activity.getActivityType().startsWith("user")) {
                                filterClass += " filter-user";
                            } else if (activity.getActivityType().startsWith("notice")) {
                                filterClass += " filter-notice";
                            }
                            
                            if (activity.getActorType().equals("admin")) {
                                filterClass += " filter-admin";
                            } else {
                                filterClass += " filter-user-action";
                            }
                            
                            // 필터에 따라 표시 여부 결정
                            String displayStyle = "";
                            if (filterParam != null && !filterParam.equals("all")) {
                                boolean showItem = false;
                                
                                if (filterParam.equals("book") && activity.getActivityType().startsWith("book")) {
                                    showItem = true;
                                } else if (filterParam.equals("user") && activity.getActivityType().startsWith("user")) {
                                    showItem = true;
                                } else if (filterParam.equals("notice") && activity.getActivityType().startsWith("notice")) {
                                    showItem = true;
                                } else if (filterParam.equals("admin") && activity.getActorType().equals("admin")) {
                                    showItem = true;
                                } else if (filterParam.equals("user-action") && activity.getActorType().equals("user")) {
                                    showItem = true;
                                }
                                
                                if (!showItem) {
                                    displayStyle = "display: none;";
                                }
                            }
                            
                            // 로그 시간 형식 처리
                            java.time.LocalDateTime logDate = activity.getLogDate();
                            String displayTime = "";
                            
                            java.time.LocalDateTime now = java.time.LocalDateTime.now();
                            java.time.LocalDate today = now.toLocalDate();
                            java.time.LocalDate yesterday = today.minusDays(1);
                            java.time.LocalDate logDay = logDate.toLocalDate();
                            
                            if(logDay.equals(today)) {
                                displayTime = "오늘 " + String.format("%02d:%02d", logDate.getHour(), logDate.getMinute());
                            } else if(logDay.equals(yesterday)) {
                                displayTime = "어제 " + String.format("%02d:%02d", logDate.getHour(), logDate.getMinute());
                            } else {
                                displayTime = logDate.getYear() + "년 " + logDate.getMonthValue() + "월 " + logDate.getDayOfMonth() + "일 " + 
                                              String.format("%02d:%02d", logDate.getHour(), logDate.getMinute());
                            }
                                         
                    %>
                    <div class="activity-item<%=filterClass%>" style="<%=displayStyle%>">
                        <div class="activity-icon">
                            <i class="<%=iconClass%>"></i>
                        </div>
                        <div class="activity-details">
                            <h4><%=activity.getActivityType().equals("book_add") ? "도서 등록" : 
                                   activity.getActivityType().equals("user_add") ? "회원 가입" : 
                                   activity.getActivityType().equals("book_borrow") ? "도서 대출" : 
                                   activity.getActivityType().equals("notice_add") ? "공지사항 등록" : 
                                   activity.getActivityType().equals("book_return") ? "도서 반납" : 
                                   activity.getActivityType().equals("notice_delete") ? "공지사항 삭제" : 
                                   activity.getActivityType().equals("book_delete") ? "도서 삭제" : "기타 활동" %></h4>
                            <p><%=activity.getDescription()%></p>
                            <div class="activity-meta">
                                <span class="activity-time"><%=displayTime%></span>
                                <span class="actor-info"><%=activity.getActorType().equals("admin") ? "어드민" : "회원"%> (<%=activity.getActorName()%>)</span>
                            </div>
                        </div>
                    </div>
                    <% }
                    } else { %>
                    <div class="activity-item">
                        <div class="activity-icon">
                            <i class="ri-information-line"></i>
                        </div>
                        <div class="activity-details">
                            <h4>표시할 활동 로그가 없습니다</h4>
                            <p>선택한 필터에 해당하는 활동이 없습니다.</p>
                        </div>
                    </div>
                    <% }
                } else { %>
                <div class="activity-item">
                    <div class="activity-icon">
                        <i class="ri-information-line"></i>
                    </div>
                    <div class="activity-details">
                        <h4>표시할 활동 로그가 없습니다</h4>
                        <p>시스템 활동이 기록되면 여기에 표시됩니다.</p>
                    </div>
                </div>
                <% } %>
            </div>
            
            <!-- 페이징 -->
            <% if(request.getAttribute("pageMaker") != null) { 
                PageDTO pageMaker = (PageDTO)request.getAttribute("pageMaker");
                String filterParam = request.getParameter("filter");
                String filterQueryParam = filterParam != null ? "&filter=" + filterParam : "";
                
                // 필터링된 데이터 개수에 따라 페이징 표시 여부 결정
                boolean showPaging = true;
                ArrayList<ActivityLogDTO> logList = (ArrayList<ActivityLogDTO>)request.getAttribute("logList");
                
                if (filterParam != null && !filterParam.equals("all") && logList != null) {
                    int filteredCount = 0;
                    for (ActivityLogDTO activity : logList) {
                        boolean matchesFilter = false;
                        
                        if (filterParam.equals("book") && activity.getActivityType().startsWith("book")) {
                            matchesFilter = true;
                        } else if (filterParam.equals("user") && activity.getActivityType().startsWith("user")) {
                            matchesFilter = true;
                        } else if (filterParam.equals("notice") && activity.getActivityType().startsWith("notice")) {
                            matchesFilter = true;
                        } else if (filterParam.equals("admin") && activity.getActorType().equals("admin")) {
                            matchesFilter = true;
                        } else if (filterParam.equals("user-action") && activity.getActorType().equals("user")) {
                            matchesFilter = true;
                        }
                        
                        if (matchesFilter) {
                            filteredCount++;
                        }
                    }
                    
                    int pageSize = 10; // 페이지당 기본 항목 수
                    showPaging = filteredCount > pageSize;
                }
                
                if (showPaging && pageMaker.getEndPage() > 1) {
            %>
            <div class="div_page">
                <ul>
                    <% if(pageMaker.isPrev()) { %>
                    <li class="paginate_button">
                        <a href="activity_log?page=<%=pageMaker.getStartPage()-1%><%=filterQueryParam%>">&laquo;</a>
                    </li>
                    <% } %>
                    
                    <% for(int i = pageMaker.getStartPage(); i <= pageMaker.getEndPage(); i++) { 
                        String activeClass = "";
                        if (request.getParameter("page") == null && i == 1) {
                            activeClass = "active";
                        } else if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) == i) {
                            activeClass = "active";
                        }
                    %>
                    <li class="paginate_button <%= activeClass %>">
                        <a href="activity_log?page=<%=i%><%=filterQueryParam%>"><%=i%></a>
                    </li>
                    <% } %>
                    
                    <% if(pageMaker.isNext()) { %>
                    <li class="paginate_button">
                        <a href="activity_log?page=<%=pageMaker.getEndPage()+1%><%=filterQueryParam%>">&raquo;</a>
                    </li>
                    <% } %>
                </ul>
            </div>
            <% } else { %>
            <div class="div_page">
                <ul>
                    <li class="paginate_button active">
                        <a href="activity_log?page=1<%=filterQueryParam%>">1</a>
                    </li>
                </ul>
            </div>
            <% } } %>
        </main>
    </div>
    
    <script>
        $(document).ready(function() {
            // 현재 URL에서 필터 파라미터 가져오기
            var currentFilter = getParameterByName('filter') || 'all';
            
            // URL에서 파라미터 값 추출하는 함수
            function getParameterByName(name) {
                var url = window.location.href;
                name = name.replace(/[\[\]]/g, '\\$&');
                var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
                    results = regex.exec(url);
                if (!results) return null;
                if (!results[2]) return '';
                return decodeURIComponent(results[2].replace(/\+/g, ' '));
            }
            
            // 필터 클릭 이벤트
            $('.filter-item').click(function() {
                // UI 업데이트
                $('.filter-item').removeClass('active');
                $(this).addClass('active');
                
                // 필터 값 가져오기
                var filter = $(this).data('filter');
                
                // URL 업데이트 (페이지는 1로 리셋)
                var baseUrl = window.location.pathname;
                var url = baseUrl + '?page=1';
                if (filter !== 'all') {
                    url += '&filter=' + filter;
                }
                window.location.href = url;
            });
        });
    </script>
</body>
</html> 