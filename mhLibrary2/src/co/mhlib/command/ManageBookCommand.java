/**
 * 
 */
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

public class ManageBookCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BookDTO> list = new ArrayList<BookDTO>();
		BookDAO bdao = new BookDAO();
		list = bdao.selectAll();
		
		request.setAttribute("blist", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/manageBook.jsp");
		dispatcher.forward(request, response);

	}

}
