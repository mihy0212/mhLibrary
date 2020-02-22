package co.mhlib.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.MemberDAO;
import co.mhlib.dto.DTO;
import co.mhlib.dto.MemberDTO;

public class MyInfoFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("key").toString(); //로그인 아이디
		
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();
		mdto.setMemberId(mid);
		
		DTO dto = mdao.selectOne(mdto);
		mdto = (MemberDTO)dto;
		request.setAttribute("mlist", mdto);
//		System.out.println(mdto.getMemberId());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/myInfoForm.jsp");
		dispatcher.forward(request, response);
	}

}
