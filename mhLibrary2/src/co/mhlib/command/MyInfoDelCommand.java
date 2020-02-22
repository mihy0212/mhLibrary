package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.MemberDTO;

public class MyInfoDelCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String mid = (String)request.getParameter("key");
		System.out.println(mid);
		
		MemberDTO mdto = new MemberDTO();
		mdto.setMemberId(mid);
		
		MemberDAO mdao = new MemberDAO();
		int n = mdao.delete(mdto);
		
		if(n != 0) {
			out.println("<script>alert('탈퇴가 완료되었습니다.'); location.href='index.do';</script>");
			HttpSession session = request.getSession(false);
			session.invalidate();
		} else {
			out.println("<script>alert('탈퇴에 실패했습니다. 자세한 사항은 관리자에게 문의해 주시기 바랍니다.');</script>");
		}
		out.flush();
	}

}
