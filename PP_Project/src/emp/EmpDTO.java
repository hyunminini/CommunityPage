package emp;

public class EmpDTO {
	private int empno;
	private String pw;
	
	public EmpDTO() {}

	public EmpDTO(Integer empno, String pw) {
		super();
		this.empno = empno;
		this.pw = pw;
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
		return "EmpDAO [empno=" + empno + ", pw=" + pw + "]";
	}
	
	
}
