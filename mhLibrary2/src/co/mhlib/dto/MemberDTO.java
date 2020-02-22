package co.mhlib.dto;

public class MemberDTO implements DTO {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberTel;
	private String memberGrant;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String memberId, String memberPw, String memberName, String memberTel, String memberGrant) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberTel = memberTel;
		this.memberGrant = memberGrant;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberGrant() {
		return memberGrant;
	}
	public void setMemberGrant(String memberGrant) {
		this.memberGrant = memberGrant;
	}
	
	

	
}
