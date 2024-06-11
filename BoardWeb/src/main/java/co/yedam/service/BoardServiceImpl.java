package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

//업무 프로세스를 따라 실행하기 위한 서비스

public class BoardServiceImpl implements BoardService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //자동 커밋 하겠습니다.
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	
	@Override
	public List<BoardVO> boardList() {
		// 매퍼에 등록된 기능 활용.
		return mapper.boardList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBoard(BoardVO bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}