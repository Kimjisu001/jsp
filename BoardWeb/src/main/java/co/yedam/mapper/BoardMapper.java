package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

//목록, 등록, 수정, 삭제, 단건조회 만들어서 
//넘겨주기위한 클래스

public interface BoardMapper {
	List<BoardVO> boardList(); //전체 목록 출력해주는것을 다섯개씩 잘라서 보여주려고 함
	List<BoardVO> boardListPaging(SearchVO search);//페이지별로 5건씩
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	//BoardVO selectBoard(int bno);
	int getTotalConut(SearchVO search);   
	BoardVO selectBoard(int bno);// 단건조회
	
	//등록기능
	List<MemberVO> memberList();
	int insertMemberAjax(MemberVO mvo);
	
	
	//회원 ID, 회원비번
	MemberVO selectMember(@Param("id")String id, @Param("pw") String pw);
	
	int insertMemberImage(MemberVO mvo);
	
	
}
