package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.MemberDTO;

public class memDelCommand implements Command {

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
			out.println("<script>alert('회원 삭제가 완료되었습니다.'); location.href='manageMem.do';</script>");
		} else {
			out.println("<script>alert('회원 삭제에 실패했습니다.'); location.href='manageMem.do';</script>");
		}
		out.flush();

	}

}
