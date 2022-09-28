package board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

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
	private String co_write_date;   // 댓글 작성 날
	private int like_count; 			// 좋아요 갯수
	
    
	
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
	
}
