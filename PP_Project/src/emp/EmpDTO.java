package emp;

import java.io.Serializable;

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

public class EmpDTO implements Serializable {
	private int empno;
	private String pw;
	private String ename;
	private String admin_authority;
	

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


	
}
