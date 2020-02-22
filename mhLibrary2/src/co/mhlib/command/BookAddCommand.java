package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.BookDAO;
import co.mhlib.dto.BookDTO;

public class BookAddCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		BookDTO bdto = new BookDTO();
		bdto.setBookId(request.getParameter("bookId"));
		bdto.setBookTitle(request.getParameter("bookTitle"));
		bdto.setBookAuthor(request.getParameter("bookAuthor"));
		bdto.setBookPublisher(request.getParameter("bookPublisher"));
		bdto.setBookDupl(request.getParameter("bookDupl"));
		
		BookDAO bdao = new BookDAO();
		int result = bdao.insert(bdto);
		System.out.println(result);
		
		String path = null;
		if(result != 0) {
			out.println("<script>alert('도서 등록이 완료되었습니다.');</script>");
			path = "manageBook.do";
			System.out.println("1");
		} else {
			out.println("<script>alert('도서 등록에 실패했습니다.');</script>");
			path = "bookAddForm.do";
			System.out.println("2");
		}
		System.out.println("aaa");
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		out.flush();
	}

}
