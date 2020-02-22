package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.MemberDTO;

public class JoinCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MemberDTO mdto = new MemberDTO();
		mdto.setMemberId(request.getParameter("mid"));
		mdto.setMemberPw(request.getParameter("mpw"));
		mdto.setMemberName(request.getParameter("mname"));
		mdto.setMemberTel(request.getParameter("mtel"));
		
		MemberDAO mdao = new MemberDAO();
		int result = mdao.insert(mdto);
		
//		String path = null;
		PrintWriter out = response.getWriter();

//		String path;
		response.setContentType("text/html; charset=UTF-8");
		if(result != 0) {
			out.println("<script>alert('회원 등록이 완료되었습니다.'); location.href='loginForm.do';</script>");
//			out.println("<script>alert('회원 등록이 완료되었습니다.');</script>");
//			path = "loginForm.do";
		} else {
			out.println("<script>alert('회원 가입에 실패했습니다.'); location.href='joinForm.do';</script>");
//			out.println("<script>alert('회원 가입에 실패했습니다.');</script>");
//			path = "joinForm.do";
		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
		out.flush();

	}

}
