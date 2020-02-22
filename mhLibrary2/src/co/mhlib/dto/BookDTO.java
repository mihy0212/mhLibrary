package co.mhlib.dto;

import java.sql.Date;

public class BookDTO implements DTO {

	private String bookNum;			//1
	private String bookId;			//2
	private String bookTitle;		//3
	private String bookDupl;		//4
	private String bookAuthor;		//5
	private String bookPublisher;	//6
	private Date bookRegidate;		//7
	
	private Date bookOutday;		//8
	private Date bookDueday;		//9
	private Date bookInday;			//10
	private String memberId;		//11
	
	public BookDTO() {}

	public BookDTO(String bookNum, String bookId, String bookTitle, String bookDupl, String bookAuthor,
			String bookPublisher, Date bookRegidate, Date bookOutday, Date bookDueday, Date bookInday,
			String memberId) {
		super();
		this.bookNum = bookNum;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookDupl = bookDupl;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookRegidate = bookRegidate;
		this.bookOutday = bookOutday;
		this.bookDueday = bookDueday;
		this.bookInday = bookInday;
		this.memberId = memberId;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookDupl() {
		return bookDupl;
	}

	public void setBookDupl(String bookDupl) {
		this.bookDupl = bookDupl;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Date getBookRegidate() {
		return bookRegidate;
	}

	public void setBookRegidate(Date bookRegidate) {
		this.bookRegidate = bookRegidate;
	}

	public Date getBookOutday() {
		return bookOutday;
	}

	public void setBookOutday(Date bookOutday) {
		this.bookOutday = bookOutday;
	}

	public Date getBookDueday() {
		return bookDueday;
	}

	public void setBookDueday(Date bookDueday) {
		this.bookDueday = bookDueday;
	}

	public Date getBookInday() {
		return bookInday;
	}

	public void setBookInday(Date bookInday) {
		this.bookInday = bookInday;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
