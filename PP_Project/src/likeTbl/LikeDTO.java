package likeTbl;

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

public class LikeDTO {
	private int like_no;
	private int like_count;
	private int board_cnum;
	private int empno;
};

