package co.mhlib.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.mhlib.dao.NoticeDAO;
import co.mhlib.dto.NoticeDTO;

public class NoticeInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String file1 = "fileName";
		System.out.println(file1);
		String upFilePath = request.getSession().getServletContext().getRealPath("uploadFile");
		int fileSize = 10*1024*1024;
		
		MultipartRequest mul = new MultipartRequest(request, upFilePath, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
		NoticeDTO ndto = new NoticeDTO();
		ndto.setMemberId(mul.getParameter("mid")); //작성자 아이디
		ndto.setMemberName(mul.getParameter("writer")); //작성자 이름
		ndto.setNoticeTitle(mul.getParameter("title"));//글 제목
		ndto.setNoticeContent(mul.getParameter("content"));//글 내용
		ndto.setNoticeDate(Date.valueOf(mul.getParameter("wdate")));//글쓴 일자
		ndto.setNoticeFileName(mul.getOriginalFileName(file1));//첨부파일명
		
		NoticeDAO ndao = new NoticeDAO();
		int n = ndao.insert(ndto);
		
		String path;
		if(n != 0) {
			path = "noticeList.do";
		} else {
			path = "noticeForm.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
