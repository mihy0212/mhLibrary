package co.mhlib.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mhlib.command.BookAddCommand;
import co.mhlib.command.BookAddFormCommand;
import co.mhlib.command.BookDelCommand;
import co.mhlib.command.Command;
import co.mhlib.command.IdCheckCommand;
import co.mhlib.command.IndexCommand;
import co.mhlib.command.JoinCommand;
import co.mhlib.command.JoinFormCommand;
import co.mhlib.command.LoginCommand;
import co.mhlib.command.LoginFormCommand;
import co.mhlib.command.LogoutCommand;
import co.mhlib.command.ManageMemCommand;
import co.mhlib.command.MyInfoCommand;
import co.mhlib.command.MyInfoDelCommand;
import co.mhlib.command.MyInfoFormCommand;
import co.mhlib.command.MyInfoUpdateCommand;
import co.mhlib.command.NoticeDelCommand;
import co.mhlib.command.NoticeDownCommand;
import co.mhlib.command.NoticeFormCommand;
import co.mhlib.command.NoticeInsertCommand;
import co.mhlib.command.NoticeListCommand;
import co.mhlib.command.NoticeReadCommand;
import co.mhlib.command.NoticeUpFormCommand;
import co.mhlib.command.NoticeUpdateCommand;
import co.mhlib.command.RentCommand;
import co.mhlib.command.ReturnCommand;
import co.mhlib.command.SearchFormCommand;
import co.mhlib.command.memDelCommand;
import co.mhlib.command.ManageBookCommand;

@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashMap<String, Command> map = null;
	
    public MainController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		map.put("/index.do", new IndexCommand());
		
		//로그인
		map.put("/loginForm.do", new LoginFormCommand());
		map.put("/login.do", new LoginCommand());
		map.put("/logout.do", new LogoutCommand());
		
		//회원가입
		map.put("/joinForm.do", new JoinFormCommand());
		map.put("/idCheck.do", new IdCheckCommand());
		map.put("/join.do", new JoinCommand());
		
		//내 정보 보기/수정/삭제
		map.put("/myInfo.do", new MyInfoCommand());
		map.put("/myInfoForm.do", new MyInfoFormCommand());
		map.put("/myInfoUpdate.do", new MyInfoUpdateCommand());
		map.put("/myInfoDel.do", new MyInfoDelCommand());
		
		//공지사항 조회
		map.put("/noticeList.do", new NoticeListCommand()); //전체 리스트
		map.put("/noticeRead.do", new NoticeReadCommand()); //공지사항 한 건
		map.put("/download.do", new NoticeDownCommand());
		
		//공지사항 등록
		map.put("/noticeForm.do", new NoticeFormCommand());
		map.put("/noticeInsert.do", new NoticeInsertCommand());
		
		//공지사항  수정
		map.put("/noticeUpForm.do", new NoticeUpFormCommand());
		map.put("/noticeUpdate.do", new NoticeUpdateCommand());
		
		//공지사항 삭제
		map.put("/noticeDel.do", new NoticeDelCommand());
	
		//도서 조회
		map.put("/searchForm.do", new SearchFormCommand());
		
		
		//회원 관리
		map.put("/manageMem.do", new ManageMemCommand()); //조인해서 다시 만들어야 함
		map.put("/memDel.do", new memDelCommand());
		
		//도서 관리-조회
		map.put("/manageBook.do", new ManageBookCommand());
		
		//도서 관리-입력
		map.put("/bookAddForm.do", new BookAddFormCommand());
		map.put("/bookAdd.do", new BookAddCommand());
		
		//도서 관리-수정
//		map.put("", new ());
		
		//도서 관리-삭제
		map.put("/bookDel.do", new BookDelCommand());
		
		//도서 대출/반납
		map.put("/rent.do", new RentCommand());
		map.put("/return.do", new ReturnCommand());
		
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
//		map.put("", new ());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command comm = map.get(path);
		comm.execute(request, response);
	}

}
