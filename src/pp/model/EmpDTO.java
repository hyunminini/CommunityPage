package pp.model;

public class EmpDTO {
	private int empno;
	private int deptno;
	private String pw;
	private String ename;
	private String grade;
	private int mgr;
	public EmpDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDTO(int empno, int deptno, String pw, String ename, String grade, int mgr) {
		super();
		this.empno = empno;
		this.deptno = deptno;
		this.pw = pw;
		this.ename = ename;
		this.grade = grade;
		this.mgr = mgr;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", deptno=" + deptno + ", pw=" + pw + ", ename=" + ename + ", grade=" + grade
				+ ", mgr=" + mgr + "]";
	}
	
	

	
}
