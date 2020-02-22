package co.mhlib.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.MemberDTO;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = null;
		String mid = request.getParameter("loginid");
		String mpw = request.getParameter("loginpw");
		
		//로그인
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();
		mdto = mdao.login(mid, mpw);
		
		//세션
		HttpSession session = request.getSession(false);
		if(mdto != null) {
			session.setAttribute("id", mdto.getMemberId());
			session.setAttribute("name", mdto.getMemberName());
			session.setAttribute("grant", mdto.getMemberGrant());
			session.setAttribute("login", "loginSuccess");
			path = "index.do";
		} else {
			path = "loginForm.do";
			session.setAttribute("login", "loginFail");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
