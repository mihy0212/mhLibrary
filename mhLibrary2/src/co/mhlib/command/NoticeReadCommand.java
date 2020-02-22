package co.mhlib.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mhlib.dao.NoticeDAO;
import co.mhlib.dto.DTO;
import co.mhlib.dto.NoticeDTO;

public class NoticeReadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nNum = request.getParameter("key");
		
		NoticeDTO ndto = new NoticeDTO();
		ndto.setNoticeNum(nNum);
		
		//글 작성자가 조회할 경우에는 조회수를 올리지 않음.
		HttpSession session = request.getSession(false);		
		
		String sid;
		if(session.getAttribute("id") == null) {
			sid = "guest";
		} else {
			sid = session.getAttribute("id").toString();
		}
		String mid = request.getParameter("key2");
		
		NoticeDAO ndao = new NoticeDAO();
		if(sid != mid) {
			ndao.readCount(nNum);
		}
		DTO dto = ndao.selectOne(ndto);
		ndto = (NoticeDTO)dto;
		
		request.setAttribute("ndto", ndto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/noticeOne.jsp");
		dispatcher.forward(request, response);

	}

}
