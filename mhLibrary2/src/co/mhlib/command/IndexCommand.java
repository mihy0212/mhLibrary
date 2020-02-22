package co.mhlib.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.NoticeDAO;
import co.mhlib.dto.NoticeDTO;

public class IndexCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		NoticeDAO ndao = new NoticeDAO();
		list = ndao.selectAll();
		
		request.setAttribute("nlist", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

}
