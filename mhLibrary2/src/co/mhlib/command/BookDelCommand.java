package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.BookDAO;
import co.mhlib.dto.BookDTO;

public class BookDelCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		BookDTO bdto = new BookDTO();
		bdto.setBookNum(request.getParameter("key"));
		
		BookDAO bdao = new BookDAO();
		int n = bdao.delete(bdto);
		
		if(n != 0) {
			out.println("<script>alert('삭제가 완료되었습니다.');</script>");
		} else {
			out.println("<script>alert('삭제하지 못했습니다.');</script>");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("manageBook.do");
		dispatcher.forward(request, response);
		out.flush();

	}

}
