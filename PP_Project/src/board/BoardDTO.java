package board;

public class BoardDTO {
	private int board_cnum;			// 글 번호
	private String title;			// 글 제목
	private int empno;				// 글 작성자 사원번호
	private String ename;			// 글 작성자
	private String category;		// 글 분류
	private String content;			// 글 내용
	private String write_date;		// 글 작성일
	private int readnum;			// 글 조회수
	private String pw;				// 비밀번호
    
	
	public BoardDTO(int board_cnum){
		this.board_cnum = board_cnum;
	}
	
	public BoardDTO(String title, String content, String category, int empno, String pw){
		this.title = title;
		this.content = content;
		this.category = category;
		this.empno = empno;
		this.pw = pw;
	}
	
	// 게시물 보기
	public BoardDTO(int board_cnum, String title, String write_date, String category, String ename, int readnum, String content) {
		this.title = title;
		this.write_date = write_date;
		this.category = category;
		this.ename = ename;
		this.readnum = readnum;
		this.content = content;
	}
	
	// 게시글 작성
	public BoardDTO(String title, int empno, String category, String content) {
		this.title = title;
		this.empno = empno;
		this.category = category;
		this.content = content;
	}
	
	// 수정 
	public BoardDTO( String title, String category, String content, int board_cnum) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.board_cnum = board_cnum;
	}
	
	// 게시글 리스트
	public BoardDTO(int board_cnum, String category, String title, int empno, String ename, String write_date, int readnum) {
		this.board_cnum = board_cnum;
		this.category = category;
		this.title = title;
		this.empno = empno;
		this.ename = ename;
		this.write_date = write_date;
		this.readnum = readnum;
	}

	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBoard_cnum() {
		return board_cnum;
	}
	public void setBoard_cnum(int board_cnum) {
		this.board_cnum = board_cnum;
	}
	public int getReadnum() {
		return readnum;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_day(String write_date) {
		this.write_date = write_date;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "BoardDTO [board_cnum=" + board_cnum + ", title=" + title + ", empno=" + empno + ", ename=" + ename + ", category=" + category
				+ ", content=" + content + ", write_date=" + write_date + ", readnum=" + readnum
				+ "]";
	}
	
}
