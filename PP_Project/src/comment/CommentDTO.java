package comment;


public class CommentDTO {
	private int co_no;			// 댓글 번호 pk
	private String ename;		// 댓글 작성자
	private int board_cnum;		// 게시판 번
	private String co_content;	// 댓글 내용
	private String co_write_date;	// 댓글 작성날짜
	public int getCo_no() {
		return co_no;
	}

	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getBoard_cnum() {
		return board_cnum;
	}

	public void setBoard_cnum(int board_cnum) {
		this.board_cnum = board_cnum;
	}

	public String getCo_content() {
		return co_content;
	}

	public void setCo_content(String co_content) {
		this.co_content = co_content;
	}

	public String getCo_write_date() {
		return co_write_date;
	}

	public void setCo_write_date(String co_write_date) {
		this.co_write_date = co_write_date;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	private int empno;  // 사원번호

	// 댓글 전체보기
	public CommentDTO(int co_no,  String ename, int board_cnum, String co_content, String co_write_date){
		this.co_no = co_no;
		this.ename = ename;
		this.board_cnum = board_cnum;
		this.co_content = co_content;
		this.co_write_date = co_write_date;
	}

	// 댓글 작성 
	public CommentDTO(String ename, int board_cnum, String co_content){
		this.ename = ename;
		this.board_cnum = board_cnum;
		this.co_content = co_content;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [co_no=" + co_no + ", ename=" + ename + ", board_cnum=" + board_cnum + ", co_content="
				+ co_content + ", co_write_date=" + co_write_date + ", empno=" + empno + "]";
	}

	public CommentDTO(int board_cnum, String ename, String co_content, int empno) {
		this.board_cnum = board_cnum;
		this.ename = ename;
		this.co_content = co_content;
		this.empno = empno;
	};
	
	public CommentDTO(int board_cnum, String ename, String co_content) {
		this.board_cnum = board_cnum;
		this.ename = ename;
		this.co_content = co_content;
	};
	
}
