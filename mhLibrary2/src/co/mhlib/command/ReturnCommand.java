package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.BookDAO;
import co.mhlib.dto.BookDTO;

public class ReturnCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String mid = request.getParameter("mid");
		String retId = request.getParameter("bookNum");
		
		BookDTO bdto = new BookDTO();
		bdto.setBookNum(retId);
		bdto.setMemberId(mid);
		
		BookDAO bdao = new BookDAO();
		int n = bdao.updateReturn(bdto);
		
		if(n != 0) {
			out.println("<script>alert('반납이 완료되었습니다.'); location.href='searchForm.do';</script>");
		} else {
			out.println("<script>alert('반납에 실패했습니다.'); location.href='searchForm.do';</script>");
		}
		
		out.flush();

	}

}
