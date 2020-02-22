package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.NoticeDAO;
import co.mhlib.dto.NoticeDTO;

public class NoticeUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		NoticeDTO ndto = new NoticeDTO();
		ndto.setNoticeNum(request.getParameter("key"));
		ndto.setNoticeTitle(request.getParameter("title"));
		ndto.setNoticeContent(request.getParameter("content"));
		ndto.setNoticeDate(Date.valueOf(request.getParameter("wdate")));
		ndto.setNoticeFileName(request.getParameter("fileName"));
		
		NoticeDAO ndao = new NoticeDAO();
		int n = ndao.update(ndto);
		
		String path = null;
		if(n != 0) {
			out.println("<script>alert('공지 사항이 수정되었습니다.');</script>");
			path = "noticeRead.do";
		} else {
			out.println("<script>alert('공지 사항 수정에 실패했습니다.');</script>");
			path = "noticeUpForm.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		out.flush();
	}

}
