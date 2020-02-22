package co.mhlib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.mhlib.dto.BookDTO;
import co.mhlib.dto.DTO;

public class BookDAO extends DAO {

	public static BookDAO instance = new BookDAO();

	public static BookDAO getInstance(){
		return instance;
	}
	
	//도서 전권 조회
	public List<BookDTO> selectAll(){
		List<BookDTO> list = new ArrayList<BookDTO>();
		BookDTO bdto;
		String sql = "select * from mh_lib_book order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				bdto = new BookDTO();
				bdto.setBookNum(rs.getString("lib_book_num"));				//1
				bdto.setBookId(rs.getString("lib_book_id"));				//2
				bdto.setBookTitle(rs.getString("lib_book_title"));			//3
				bdto.setBookDupl(rs.getString("lib_book_dupl"));			//4
				bdto.setBookAuthor(rs.getString("lib_book_author"));		//5
				bdto.setBookPublisher(rs.getString("lib_book_publisher"));	//6
				bdto.setBookRegidate(rs.getDate("lib_book_regidate"));	//7
				bdto.setBookOutday(rs.getDate("lib_minfo_outday"));		//8
				bdto.setBookDueday(rs.getDate("lib_minfo_dueday"));		//9
				bdto.setBookInday(rs.getDate("lib_minfo_inday"));			//10
				bdto.setMemberId(rs.getString("lib_member_id"));			//11
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	//특정 조건 조회1
	public List<BookDTO> select(String where, String condition){
		List<BookDTO> list = new ArrayList<BookDTO>();
		BookDTO bdto;
		String sql = null;
		System.out.println(where + "웨어");
		System.out.println(condition + "조건");
		if(where.equals("bookNum")) {
			sql = "select * from mh_lib_book where lib_book_num like ? order by 1";
			System.out.println("1");
		} else if(where.equals("bookId")) {
			sql = "select * from mh_lib_book where lib_book_id like ? order by 1";
			System.out.println("2");
		} else if(where.equals("bookTitle")) {
			sql = "select * from mh_lib_book where lib_book_title like ? order by 1";
			System.out.println("3");
		} else if(where.equals("bookAuthor")) {
			sql = "select * from mh_lib_book where lib_book_author like ? order by 1";
			System.out.println("4");
		} else if(where.equals("bookPublisher")) {
			sql = "select * from mh_lib_book where lib_book_publisher like ? order by 1";
			System.out.println("5");
		} else if(where.equals("bookRegidate")) {
			sql = "select * from mh_lib_book where lib_book_regidate like ? order by 1";
			System.out.println("6");
		} else if(where.equals("bookOutday")) {
			sql = "select * from mh_lib_book where lib_minfo_outday like ? order by 1";
			System.out.println("7");
		} else if(where.equals("bookDueday")) {
			sql = "select * from mh_lib_book where lib_minfo_dueday like ? order by 1";
			System.out.println("8");
		} else if(where.equals("bookInday")) {
			sql = "select * from mh_lib_book where lib_minfo_inday like ? order by 1";
			System.out.println("9");
		} else if(where.equals("memberId")) {
			sql = "select * from mh_lib_book where lib_member_id like ? order by 1";
			System.out.println("10");
		}
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+condition+"%");
			rs = psmt.executeQuery();
			while(rs.next()) {
				bdto = new BookDTO();
				bdto.setBookNum(rs.getString("lib_book_num"));				//1
				bdto.setBookId(rs.getString("lib_book_id"));				//2
				bdto.setBookTitle(rs.getString("lib_book_title"));			//3
				bdto.setBookDupl(rs.getString("lib_book_dupl"));			//4
				bdto.setBookAuthor(rs.getString("lib_book_author"));		//5
				bdto.setBookPublisher(rs.getString("lib_book_publisher"));	//6
				bdto.setBookRegidate(rs.getDate("lib_book_regidate"));	//7
				bdto.setBookOutday(rs.getDate("lib_minfo_outday"));		//8
				bdto.setBookDueday(rs.getDate("lib_minfo_dueday"));		//9
				bdto.setBookInday(rs.getDate("lib_minfo_inday"));			//10
				bdto.setMemberId(rs.getString("lib_member_id"));			//11
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		close();
		System.out.println("akwlakr");
		return list;
	}
	
	//특정 조건 조회2(전체 검색)
	public List<BookDTO> select2(String condition){
		List<BookDTO> list = new ArrayList<BookDTO>();
		BookDTO bdto;
		String sql = "select * from mh_lib_book"
				+ " where lib_book_id like ? or lib_book_title like ? or lib_book_author like ? or lib_book_publisher like ?"
				+ " order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+condition+"%");
			psmt.setString(2, "%"+condition+"%");
			psmt.setString(3, "%"+condition+"%");
			psmt.setString(4, "%"+condition+"%");
			rs = psmt.executeQuery();
			while(rs.next()) {
				bdto = new BookDTO();
				bdto.setBookNum(rs.getString("lib_book_num"));				//1
				bdto.setBookId(rs.getString("lib_book_id"));				//2
				bdto.setBookTitle(rs.getString("lib_book_title"));			//3
				bdto.setBookDupl(rs.getString("lib_book_dupl"));			//4
				bdto.setBookAuthor(rs.getString("lib_book_author"));		//5
				bdto.setBookPublisher(rs.getString("lib_book_publisher"));	//6
				bdto.setBookRegidate(rs.getDate("lib_book_regidate"));	//7
				bdto.setBookOutday(rs.getDate("lib_minfo_outday"));		//8
				bdto.setBookDueday(rs.getDate("lib_minfo_dueday"));		//9
				bdto.setBookInday(rs.getDate("lib_minfo_inday"));			//10
				bdto.setMemberId(rs.getString("lib_member_id"));			//11
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}
//	 else if(where == "selectAll") {
//			sql = "select * from mh_lib_book where lib_member_id=? or lib_book_id=? or lib_book_author=? or lib_book_publisher=? order by 1";
//		}
	
	//도서 중복 체크???
	@Override
	public DTO selectOne(DTO dto) {
		BookDTO bdto = (BookDTO)dto;
		String sql = "select * from mh_lib_book where lib_book_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bdto.getBookNum());
			rs = psmt.executeQuery();
			bdto = null;
			if(rs.next()) {
				bdto = new BookDTO();
				bdto.setBookNum(rs.getString("lib_book_num"));
				bdto.setBookId(rs.getString("lib_book_id"));
				bdto.setBookTitle(rs.getString("lib_book_title"));
				bdto.setBookDupl(rs.getString("lib_book_dupl"));
				bdto.setBookAuthor(rs.getString("lib_book_author"));
				bdto.setBookPublisher(rs.getString("lib_book_publisher"));
				bdto.setBookRegidate(rs.getDate("lib_book_regidate"));	//7
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return bdto;
	}

	//책 첫 등록(관리자용)
	@Override
	public int insert(DTO dto) {
		int n = 0;
		BookDTO bdto = (BookDTO)dto;
		int dupl = Integer.parseInt(bdto.getBookDupl());
		for(int i=1; i<=dupl; i++) {
			String sql = "insert into mh_lib_book ("
					+ " lib_book_num,"
					+ " lib_book_id,"
					+ " lib_book_title,"
					+ " lib_book_dupl,"
					+ " lib_book_author,"
					+ " lib_book_publisher,"
					+ " lib_book_regidate) values"
					+ " (mh_lib_book_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bdto.getBookId()+"="+i);
				psmt.setString(2, bdto.getBookTitle());
				psmt.setString(3, bdto.getBookDupl());
				psmt.setString(4, bdto.getBookAuthor());
				psmt.setString(5, bdto.getBookPublisher());
				n = psmt.executeUpdate();
				System.out.println(n + "건의 도서 등록 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return n;
	}
	
	//책 추가 등록(관리자용)
	public int insert(DTO dto, int plusDupl) {
		int n = 0;
		BookDTO bdto = (BookDTO)dto;
		int dupl = Integer.parseInt(bdto.getBookDupl())+1;
		int enddupl = dupl+plusDupl-1;
		for(; dupl <= plusDupl; dupl++) {
			String sql = "insert into mh_lib_book ("
					+ " lib_book_num,"
					+ " lib_book_id,"
					+ " lib_book_title,"
					+ " lib_book_dupl,"
					+ " lib_book_author,"
					+ " lib_book_publisher,"
					+ " lib_book_regidate) values"
					+ " (mh_lib_book_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bdto.getBookId()+"="+dupl);
				psmt.setString(2, bdto.getBookTitle());
				psmt.setInt(3, enddupl);
				psmt.setString(4, bdto.getBookAuthor());
				psmt.setString(5, bdto.getBookPublisher());
				n = psmt.executeUpdate();
				System.out.println(n + "건의 도서 등록 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return n;
	}

	//도서 정보 수정(관리자용)
	@Override
	public int update(DTO dto) {
		int n = 0;
		BookDTO bdto = (BookDTO)dto;
		String sql = "update mh_lib_book set"
				+ " lib_book_id=?,"
				+ " lib_book_title=?,"
				+ " lib_book_author=?,"
				+ " lib_book_publisher=?"
				+ " where lib_book_title=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bdto.getBookId());
			psmt.setString(2, bdto.getBookTitle());
			psmt.setString(3, bdto.getBookAuthor());
			psmt.setString(4, bdto.getBookPublisher());
			psmt.setString(5, bdto.getBookTitle());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 도서 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}
	
	//도서 정보 수정(대출하기)
		public int updateRent(BookDTO bdto) {
			int n = 0;
			String sql = "update mh_lib_book set"
					+ " lib_minfo_outday=sysdate,"
					+ " lib_minfo_dueday=sysdate+(INTERVAL '15' DAY),"
					+ " lib_minfo_inday=null,"
					+ " lib_member_id=?"
					+ " where lib_book_num=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bdto.getMemberId());
				psmt.setString(2, bdto.getBookNum());
				n = psmt.executeUpdate();
				System.out.println(n + "건의 도서 대출 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
			return n;
		}
		
	//도서 정보 수정(반납하기)
	public int updateReturn(BookDTO bdto) {
		int n = 0;
		String sql = "update mh_lib_book set"
				+ " lib_minfo_inday=sysdate"
				+ " where lib_book_num=? and lib_member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bdto.getBookNum());
			psmt.setString(2, bdto.getMemberId());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 도서 반납 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	//도서 삭제
	@Override
	public int delete(DTO dto) {
		int n = 0;
		BookDTO bdto = (BookDTO)dto;
		String sql = "delete from mh_lib_book where lib_book_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bdto.getBookNum());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 도서 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}
	

}
