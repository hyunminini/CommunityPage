package emp;

import java.io.Serializable;

public class EmpDTO implements Serializable {
	private int empno;
	private String pw;
	private String ename;
	private String admin_authority;
	
	public EmpDTO() {}

	public EmpDTO(Integer empno, String pw) {
		super();
		this.empno = empno;
		this.pw = pw;
	}
	
	public EmpDTO(Integer empno, String pw, String ename, String admin_authority) {
		this.empno = empno;
		this.ename = ename;
		this.pw = pw;
		this.admin_authority = admin_authority;
		
	}
	
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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
		return "EmpDTO [empno=" + empno + ", pw=" + pw + ", ename=" + ename + ", admin_authority=" + admin_authority
				+ "]";
	}


	
}
