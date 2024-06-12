package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;

//목록,단건,등록,수정, 삭제
//기능 실행은 mapper 실행.

public interface BoardService {
	List<BoardVO> boardList(int page);
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO bno);
	boolean removeBoard(int bno);
	int boardTotal();
}
