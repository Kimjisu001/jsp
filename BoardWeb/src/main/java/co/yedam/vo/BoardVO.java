package co.yedam.vo;

import java.util.Date;

import co.yedam.vo.BoardVO;
import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int clickCnt;
	private Date creationDate;
}
