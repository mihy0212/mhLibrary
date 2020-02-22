package co.mhlib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.mhlib.dto.DTO;
import co.mhlib.dto.MemberDTO;

public class MemberDAO extends DAO {

	//회원 전체 조회(관리자용) : 받는 값 없음 -> MemberDTO 값 돌려줌
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO mdto;
		String sql = "select * from mh_lib_member order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				mdto = new MemberDTO();
				mdto.setMemberId(rs.getString("lib_member_id"));
				mdto.setMemberPw(rs.getString("lib_member_pw"));
				mdto.setMemberName(rs.getString("lib_member_name"));
				mdto.setMemberTel(rs.getString("lib_member_tel"));
				mdto.setMemberGrant(rs.getString("lib_member_grant"));
				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	//회원 1명 조회(회원용) : MemberDTO -> MemberDTO 값 돌려줌
	//회원 등록을 위한 ID 중복 체크 : MemberDTO -> MemberDTO 값이 없으면 등록 가능
	@Override
	public DTO selectOne(DTO dto) {
		MemberDTO mdto = (MemberDTO)dto;
		String sql = "select * from mh_lib_member where lib_member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mdto.getMemberId());
			rs = psmt.executeQuery();
			mdto = null;
			if(rs.next()) {
				mdto = new MemberDTO();
				mdto.setMemberId(rs.getString("lib_member_id"));
				mdto.setMemberPw(rs.getString("lib_member_pw"));
				mdto.setMemberName(rs.getString("lib_member_name"));
				mdto.setMemberTel(rs.getString("lib_member_tel"));
				mdto.setMemberGrant(rs.getString("lib_member_grant"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return mdto;
	}

	//회원 등록(회원용) : 회원 정보 입력(MemberDTO) -> int 값 돌려줌 
	@Override
	public int insert(DTO dto) {
		int n = 0;
		MemberDTO mdto = (MemberDTO)dto; //dto 형변환
		String sql = "insert into mh_lib_member ("
				+ "lib_member_id, "
				+ "lib_member_pw, "
				+ "lib_member_name, "
				+ "lib_member_tel "
				+ ") values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mdto.getMemberId());
			psmt.setString(2, mdto.getMemberPw());
			psmt.setString(3, mdto.getMemberName());
			psmt.setString(4, mdto.getMemberTel());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 회원정보 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n; //0이면 등록 실패, 1이면 등록 성공
	}

	//회원 수정(회원용) : 아이디를 이용해서 정보 수정(MemberDTO) -> int 값 돌려줌
	@Override
	public int update(DTO dto) {
		int n = 0;
		MemberDTO mdto = (MemberDTO)dto;
		String sql = "update mh_lib_member set"
				+ " lib_member_pw=?,"
				+ " lib_member_name=?,"
				+ " lib_member_tel=?"
				+ " where lib_member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mdto.getMemberPw());
			psmt.setString(2, mdto.getMemberName());
			psmt.setString(3, mdto.getMemberTel());
			psmt.setString(4, mdto.getMemberId());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 회원정보 수정 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n; //0이면 수정 실패, 1이면 수정 성공
	}

	//회원 삭제(관리자용) : 아이디를 이용해서 정보 삭제(MemberDTO) -> int 값 돌려줌
	@Override
	public int delete(DTO dto) {
		int n = 0;
		MemberDTO mdto = (MemberDTO)dto;
		String sql = "delete from mh_lib_member where lib_member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mdto.getMemberId());
			n = psmt.executeUpdate();
			System.out.println(n + "건의 회원정보 삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}
	
	//로그인 : 아이디와 비번이 일치하는지 확인(String값 mid, mpw) -> dto 값 돌려줌
	public MemberDTO login(String mid, String mpw) {
		MemberDTO mdto = null;
		String sql = "select * from mh_lib_member where"
				+ " lib_member_id=? and lib_member_pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mid);
			psmt.setString(2, mpw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDTO();
				mdto.setMemberId(rs.getString("lib_member_id"));
				mdto.setMemberPw(rs.getString("lib_member_pw"));
				mdto.setMemberName(rs.getString("lib_member_name"));
				mdto.setMemberGrant(rs.getString("lib_member_grant"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		close();
		return mdto;
	}

}
