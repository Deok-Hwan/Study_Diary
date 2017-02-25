package com.saeyan.controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDao;
import com.saeyan.dto.MemberVO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "member/login.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!= null){
			url = "main.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "member/login.jsp"; // 회원 인증이 실패 되었을 경우 이동할 login.jsp 페이지를 저장
		
		String userid = request.getParameter("userid"); // 입력한 아이디와 암호를 저장
		String pwd = request.getParameter("pwd");
		
		MemberDao mDao = MemberDao.getInstance(); 
		int result = mDao.userCheck(userid, pwd);  
		//userCheck 메서드에서 아이디에 해당되는 회원이 존재하는지 조회
		//userCheck 메소드를 호출하여 db에 등록된 회원인지를 검사.
		
		if(result == 1){ // 1이면 로그인 성공
			MemberVO mvo = mDao.getMember(userid);
			HttpSession session = request.getSession(); // 로그인 인증 처리된 회원 정보는
			session.setAttribute("loginUser", mvo); 	// 다시 로그인하지 않아도 사용 가능하도록 세션에 등록
			request.setAttribute("message", "로그인에 성공하였습니다.");
			System.out.println("여기까지는 완성!");
			url="main.jsp";
		}else if(result == 0){
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1){
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); // 로그인 페이지를 해당 url로 페이지 이동.
	}

}
