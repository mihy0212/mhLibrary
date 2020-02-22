package co.mhlib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.mhlib.dto.DTO;
import co.mhlib.dto.NoticeDTO;

public class NoticeDAO extends DAO {

	//공지사항 전체 조회(회원용)
	public List<NoticeDTO> selectAll() {
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		NoticeDTO ndto;
		String sql = "select * from mh_lib_notice order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ndto = new NoticeDTO();
				ndto.setNoticeNum(rs.getString("lib_notice_num"));
				ndto.setMemberId(rs.getString("lib_member_id"));
				ndto.setMemberName(rs.getString("lib_member_name"));
				ndto.setNoticeTitle(rs.getString("lib_notice_title"));
				ndto.setNoticeContent(rs.getString("lib_notice_content"));
				ndto.setNoticeDate(rs.getDate("lib_notice_date"));
				ndto.setNoticeHit(rs.getString("lib_notice_hit"));
				ndto.setNoticeFileName(rs.getString("lib_notice_filename"));
				list.add(ndto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	//공지사항 게시글 한 건 조회(회원용)
	@Override
	public DTO selectOne(DTO dto) {
		NoticeDTO ndto = (NoticeDTO)dto;
		String sql = "select * from mh_lib_notice where lib_notice_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ndto.getNoticeNum());
			rs = psmt.executeQuery();
			ndto = null;
			if(rs.next()) {
				ndto = new NoticeDTO();
				ndto.setNoticeNum(rs.getString("lib_notice_num"));
				ndto.setMemberId(rs.getString("lib_member_id"));
				ndto.setMemberName(rs.getString("lib_member_name"));
				ndto.setNoticeTitle(rs.getString("lib_notice_title"));
				ndto.setNoticeContent(rs.getString("lib_notice_content"));
				ndto.setNoticeDate(rs.getDate("lib_notice_date"));
				ndto.setNoticeHit(rs.getString("lib_notice_hit"));
				ndto.setNoticeFileName(rs.getString("lib_notice_filename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return ndto;
	}

	//공지사항 등록(관리자용)
	@Override
	public int insert(DTO dto) {
		int n = 0;
		NoticeDTO ndto = (NoticeDTO)dto;
		String sql = "insert into mh_lib_notice ("
				+ " lib_notice_num,"
				+ " lib_member_id,"
				+ " lib_member_name,"
				+ " lib_notice_title,"
				+ " lib_notice_content,"
				+ " lib_notice_date,"
				+ " lib_notice_hit,"
				+ " lib_notice_filename) values"
				+ " (mh_lib_notice_seq.nextval, ?, ?, ?, ?, ?, 0, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ndto.getMemberId());
			psmt.setString(2, ndto.getMemberName());
			psmt.setString(3, ndto.getNoticeTitle());
			psmt.setString(4, ndto.getNoticeContent());
			psmt.setDate(5, ndto.getNoticeDate());
			psmt.setString(6, ndto.getNoticeFileName());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 공지사항 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	//공지사항 수정(관리자용)
	@Override
	public int update(DTO dto) {
		int n = 0;
		NoticeDTO ndto = (NoticeDTO)dto;
		String sql = "update mh_lib_notice set"
				+ " lib_notice_title=?,"
				+ " lib_notice_content=?,"
				+ " lib_notice_date=?,"
				+ " lib_notice_filename=?"
				+ " where lib_notice_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ndto.getNoticeTitle());
			psmt.setString(2, ndto.getNoticeContent());
			psmt.setDate(3, ndto.getNoticeDate());
			psmt.setString(4, ndto.getNoticeFileName());
			psmt.setString(5, ndto.getNoticeNum());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 공지사항 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	//공지사항 삭제(관리자용)
	@Override
	public int delete(DTO dto) {
		int n = 0;
		NoticeDTO ndto = (NoticeDTO)dto;
		String sql = "delete from mh_lib_notice where lib_notice_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ndto.getNoticeNum());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 공지사항 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return 0;
	}
	
	//글 조회마다 조회수 올려주기
	public void readCount(String key) {
		String sql = "update mh_lib_notice set"
				+ " lib_notice_hit=lib_notice_hit+1 where lib_notice_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, key);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
