package emp;

public class EmpDTO {
	private Integer empno;
	private String pw;
	private String ename;
	private String grade;
	private Integer mgr;
	private String admin_authority;
	
	public EmpDTO() {}

	public EmpDTO(Integer empno, String pw) {
		super();
		this.empno = empno;
		this.pw = pw;
	}

	public EmpDTO(Integer empno, String pw, String ename, String grade, Integer mgr, String admin_authority) {
		super();
		this.empno = empno;
		this.pw = pw;
		this.ename = ename;
		this.grade = grade;
		this.mgr = mgr;
		this.admin_authority = admin_authority;
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

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public String getAdmin_authority() {
		return admin_authority;
	}

	public void setAdmin_authority(String admin_authority) {
		this.admin_authority = admin_authority;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", pw=" + pw + ", ename=" + ename + ", grade=" + grade + ", mgr=" + mgr
				+ ", admin_authority=" + admin_authority + "]";
	}

	
}
