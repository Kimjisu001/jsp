package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

//업무 프로세스를 따라 실행하기 위한 서비스

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋 하겠습니다.
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchVO search) {
		// 매퍼에 등록된 기능 활용.
		return mapper.boardListPaging(search);

	}

	@Override
	public int boardTotal(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.getTotalConut(search);
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bno) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(bno) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoard(BoardVO bno) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(bno) == 1;

	}

	@Override
	public MemberVO checkMember(String id, String pw) {
		// TODO Auto-generated method stub
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return mapper.memberList();
	}

	@Override
	public boolean addMemberAjax(MemberVO mvo) {
		return mapper.insertMemberAjax(mvo) == 1;

	}

	@Override
	public boolean addMemberImage(MemberVO mvo) {
		return mapper.insertMemberImage(mvo) == 1;
	}

}
