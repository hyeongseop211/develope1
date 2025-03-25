<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="javax.swing.text.DefaultTextUI"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="magic.board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean class="magic.board.BoardBean" id="board"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>
<%
	//파일업로드 처리
	/*
	SmartUpload upload = new SmartUpload();
	//업로드할 파일이 있으면 비움
	upload.initialize(pageContext);
	//	업로드 준비
	upload.upload();
	String fName="";
	int fileSize=0;
	
	File file = upload.getFiles().getFile(0);
//		파일이 존재하면
	if(!file.isMissing()){
		fName = file.getFileName();
		file.saveAs("/upload/"+file.getFileName());
		fileSize = file.getSize();
	}
	*/
	String path = request.getRealPath("upload");
	int size = 1024 * 1024;
	int fileSize=0;
	String file="";
	String orifile="";
	
// 	DefaultFileRenamePolicy : 파일명 넘버링 처리
	MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
// 	파일명 가져오기
	Enumeration files = multi.getFileNames();
	String str = files.nextElement().toString();
// 	file : 넘버링 처리된 파일명
	file = multi.getFilesystemName(str);

	if(file != null){
// 		orifile : 실제 파일명
		orifile = multi.getOriginalFileName(str);
		fileSize = file.getBytes().length;
	}
%>
<%
	//오늘날짜 추가
	board.setB_date(new Timestamp(System.currentTimeMillis()));

//	자바 클래스 이용해서 ip 추가
	InetAddress address = InetAddress.getLocalHost();
// 	getHostAddress() : ip 주소 가져오는 메소드
	String ip = address.getHostAddress();
	
// 	ip 추가(0:0:0:0:0:0:0:1)
//	board.setB_ip(request.getRemoteAddr());
	board.setB_ip(ip);//192.168.10.2

	//파일업로드 처리
	/*
	board.setB_name(upload.getRequest().getParameter("b_name"));
	board.setB_email(upload.getRequest().getParameter("b_email"));
	board.setB_title(upload.getRequest().getParameter("b_title"));
	board.setB_content(upload.getRequest().getParameter("b_content"));
	board.setB_pwd(upload.getRequest().getParameter("b_pwd"));
	
	board.setB_fname(fName);
	board.setB_fsize(fileSize);
	*/
	board.setB_name(multi.getParameter("b_name"));
	board.setB_email(multi.getParameter("b_email"));
	board.setB_title(multi.getParameter("b_title"));
	board.setB_content(multi.getParameter("b_content"));
	board.setB_pwd(multi.getParameter("b_pwd"));
	
	//파일 업로드 추가후 답변글 달면 새글로 인식 해결
	board.setB_id(Integer.parseInt(multi.getParameter("b_id")));
	board.setB_ref(Integer.parseInt(multi.getParameter("b_ref")));
	board.setB_step(Integer.parseInt(multi.getParameter("b_step")));
	board.setB_level(Integer.parseInt(multi.getParameter("b_level")));
	
	board.setB_date(new Timestamp(System.currentTimeMillis()));
	board.setB_ip(ip);
	
	if(file != null){
		board.setB_fname(file);
		board.setB_fsize(fileSize);
		board.setB_rfname(orifile);
	}

	BoardDBBean db = BoardDBBean.getInstance();
	//db.insertBoard(board);
	
	if(db.insertBoard(board) == 1){//글쓰기가 정상적으로 완료시
		response.sendRedirect("list.jsp");
	}else{//글쓰기가 실패시
		response.sendRedirect("write.jsp");
	}
%>






