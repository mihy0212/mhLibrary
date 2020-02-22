package co.mhlib.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.BookDAO;
import co.mhlib.dto.BookDTO;

public class SearchFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String where = request.getParameter("where");
		String condition = request.getParameter("condition");
		
		List<BookDTO> list = new ArrayList<BookDTO>();
		BookDAO bdao = new BookDAO();
		if(where == null) {
			list = bdao.select2(condition);
		} else if(where.equals("selectAll")){
			list = bdao.select2(condition);
			System.out.println("11");
		} else {
			list = bdao.select(where, condition);
		}
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/searchList.jsp");
		dispatcher.forward(request, response);

	}

}
