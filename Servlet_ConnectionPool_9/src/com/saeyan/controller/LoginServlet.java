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
		String url = "member/login.jsp"; // ȸ�� ������ ���� �Ǿ��� ��� �̵��� login.jsp �������� ����
		
		String userid = request.getParameter("userid"); // �Է��� ���̵�� ��ȣ�� ����
		String pwd = request.getParameter("pwd");
		
		MemberDao mDao = MemberDao.getInstance(); 
		int result = mDao.userCheck(userid, pwd);  
		//userCheck �޼��忡�� ���̵� �ش�Ǵ� ȸ���� �����ϴ��� ��ȸ
		//userCheck �޼ҵ带 ȣ���Ͽ� db�� ��ϵ� ȸ�������� �˻�.
		
		if(result == 1){ // 1�̸� �α��� ����
			MemberVO mvo = mDao.getMember(userid);
			HttpSession session = request.getSession(); // �α��� ���� ó���� ȸ�� ������
			session.setAttribute("loginUser", mvo); 	// �ٽ� �α������� �ʾƵ� ��� �����ϵ��� ���ǿ� ���
			request.setAttribute("message", "�α��ο� �����Ͽ����ϴ�.");
			System.out.println("��������� �ϼ�!");
			url="main.jsp";
		}else if(result == 0){
			request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�.");
		}else if(result == -1){
			request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); // �α��� �������� �ش� url�� ������ �̵�.
	}

}
