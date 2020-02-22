package co.mhlib.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeDownCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//다운로드할 파일의 경로를 구해서 파일 객체 생성하기
		String fileName = request.getParameter("fileName");//borderRead.jsp의 함수 function에서 넘어온 값 filename을 구함.
		ServletContext context = request.getServletContext();
		String downloadPath = context.getRealPath("uploadFile"); //file이 존재하는 폴더 값 찾기 
		String filePath = downloadPath + "\\" + fileName; //다운로드할 파일의 경로 구하기
		System.out.println(filePath);
		File file = new File(filePath);
		
		//MIMETYPE설정
		String mimeType = request.getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		
		//다운로드 설정 및 한글 파일명 깨지는 것 방지
		String encoding = new String(fileName.getBytes("utf-8"), "8859_1");
		response.setHeader("Content-disposition", "attachment; fileName="+encoding);
		
		//요청 파일을 읽어서 클라이언트에 전송
		FileInputStream in = new FileInputStream(file);
		ServletOutputStream outStream = response.getOutputStream();
		
		byte b[] = new byte[4096];
		int data = 0;
		while( (data = in.read(b, 0, b.length)) != -1) {
			outStream.write(b, 0, data);
		}
		
		outStream.flush();
		outStream.close();
		in.close();

	}

}
