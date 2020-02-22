package co.mhlib.dto;

import java.sql.Date;

public class NoticeDTO implements DTO {

	private String noticeNum;
	private String memberId;
	private String memberName;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private String noticeHit;
	private String noticeFileName;
	
	public NoticeDTO() {}

	public NoticeDTO(String noticeNum, String memberId, String memberName, String noticeTitle, String noticeContent,
			Date noticeDate, String noticeHit, String noticeFileName) {
		super();
		this.noticeNum = noticeNum;
		this.memberId = memberId;
		this.memberName = memberName;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeHit = noticeHit;
		this.noticeFileName = noticeFileName;
	}

	public String getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeHit() {
		return noticeHit;
	}

	public void setNoticeHit(String noticeHit) {
		this.noticeHit = noticeHit;
	}

	public String getNoticeFileName() {
		return noticeFileName;
	}

	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	
	
}
