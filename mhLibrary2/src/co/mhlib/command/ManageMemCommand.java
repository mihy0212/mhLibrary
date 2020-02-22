package co.mhlib.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.MemberDTO;

public class ManageMemCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDAO mdao = new MemberDAO();
		list = mdao.selectAll();
		
		request.setAttribute("mlist", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/manageMember.jsp");
		dispatcher.forward(request, response);
	}

}
