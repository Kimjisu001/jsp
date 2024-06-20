package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.ReplyMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.Student;
import co.yedam.vo.ReplyVO;

public class AppTest {

	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋 하겠습니다.
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.selectList(20241125).forEach(reply -> System.out.println(reply));
		
		
		
		/*
		ReplyVO rvo = new ReplyVO();
		rvo.setReply("댓글작성테스트");
		rvo.setReplyer("admin");
		rvo.setBoardNo(201);
		
		try {
		if(mapper.insertReply(rvo)==1) {
			System.out.println("입력성공");
		}
		}catch (Exception e) {
			System.out.println("예외발생");
		}
		 */

		
		
		
		//BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		//SearchVO search = new SearchVO(1, "TW", "02");
		//mapper.boardListPaging(search).forEach(bvo -> System.out.println(bvo));		
		
	

	}
}
