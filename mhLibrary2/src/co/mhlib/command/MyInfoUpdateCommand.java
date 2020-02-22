package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.MemberDTO;

public class MyInfoUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String mid = request.getParameter("mid");
		MemberDTO mdto = new MemberDTO();
		mdto.setMemberId(mid);
		mdto.setMemberPw(request.getParameter("mpwNew"));
		mdto.setMemberName(request.getParameter("mname"));
		mdto.setMemberTel(request.getParameter("mtel"));
		
		MemberDAO mdao = new MemberDAO();
		int n = mdao.update(mdto);
//		String path = null;
		if(n != 0) {
			out.println("<script>alert('내 정보가 변경되었습니다.'); location.href='myInfo.do?key="+mid+"';</script>");
//			out.println("<script>alert('내 정보가 변경되었습니다.');</script>");
//			path = "myInfo.do?key="+mid;
		} else {
			out.println("<script>alert('정보 수정에 실패했습니다.'); location.href='myInfoForm.do?key="+mid+"';</script>");
//			out.println("<script>alert('정보 수정에 실패했습니다.');</script>");
//			path = "myInfoForm.do?key="+mid;
		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
		out.flush();
	}

}
