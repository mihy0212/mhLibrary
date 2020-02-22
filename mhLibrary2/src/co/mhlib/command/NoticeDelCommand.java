package co.mhlib.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.dao.NoticeDAO;
import co.mhlib.dto.NoticeDTO;

public class NoticeDelCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		NoticeDTO ndto = new NoticeDTO();
		ndto.setNoticeNum(request.getParameter("key"));
		
		NoticeDAO ndao = new NoticeDAO();
		int n = ndao.delete(ndto);
		System.out.println(n +"호가인");
//		String path;
		if(n != 0) {
			out.println("<script>alert('삭제가 완료되었습니다.'); location.href='noticeList.do';</script>");
//			out.println("<script>alert('삭제가 완료되었습니다.');</script>");
//			"<script>alert('삭제가 완료되었습니다.'); location.href='noticeList.do';</script>"
//			path = "noticeList.do";
		} else {
			out.println("<script>alert('삭제하지 못했습니다.'); location.href='noticeList.do';</script>");
//			out.println("<script>alert('삭제하지 못했습니다.');</script>");
//			path = "noticeList.do";
		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
		out.flush();

	}

}
