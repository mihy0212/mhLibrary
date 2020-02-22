package co.mhlib.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.DTO;
import co.mhlib.dto.MemberDTO;

public class IdCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO mdto = new MemberDTO();
		mdto.setMemberId(request.getParameter("mid"));
		
		MemberDAO mdao = new MemberDAO();
		DTO dto = mdao.selectOne(mdto);

		String path = null;
		if(dto==null) {
			path = "jsp/idOk.jsp";
		} else {
			path = "jsp/idNo.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
