package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.BookDAO;
import co.mhlib.dto.BookDTO;

public class RentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String mid = request.getParameter("mid");
		String rentId = request.getParameter("bookNum");
		
		BookDTO bdto = new BookDTO();
		bdto.setBookNum(rentId);
		bdto.setMemberId(mid);
		
		BookDAO bdao = new BookDAO();
		int n = bdao.updateRent(bdto);
		
		if(n != 0) {
			out.println("<script>alert('대출이 완료되었습니다.'); location.href='searchForm.do';</script>");
		} else {
			out.println("<script>alert('대출에 실패했습니다.'); location.href='searchForm.do';</script>");
		}
		
		out.flush();

	}

}
