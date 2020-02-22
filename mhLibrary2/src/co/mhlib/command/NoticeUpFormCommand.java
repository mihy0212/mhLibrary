package co.mhlib.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.NoticeDAO;
import co.mhlib.dto.DTO;
import co.mhlib.dto.NoticeDTO;

public class NoticeUpFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDTO ndto = new NoticeDTO();
		ndto.setNoticeNum(request.getParameter("key"));
		
		NoticeDAO ndao = new NoticeDAO();
		DTO dto = ndao.selectOne(ndto);
		ndto = (NoticeDTO)dto;
		
		request.setAttribute("ndto", ndto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/noticeChange.jsp");
		dispatcher.forward(request, response);
	}

}
