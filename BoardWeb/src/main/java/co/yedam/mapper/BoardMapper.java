package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

//목록, 등록, 수정, 삭제, 단건조회 만들어서 
//넘겨주기위한 클래스

public interface BoardMapper {
	List<BoardVO> boardList();
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);
}
