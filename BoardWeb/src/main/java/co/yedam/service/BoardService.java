package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

//목록,단건,등록,수정, 삭제
//기능 실행은 mapper 실행.

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO bno);
	boolean removeBoard(int bno);
	int boardTotal(SearchVO search);
	boolean updateBoard(BoardVO bno);
	
	//checkMember(id,pw)
	MemberVO checkMember(String id, String pw);

	List<MemberVO> memberList();
	
	boolean addMemberAjax(MemberVO mvo);
}
