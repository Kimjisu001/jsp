package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.Student;

public class AppTest {

	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋 하겠습니다.
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);


		SearchVO search = new SearchVO(1, "TW", "02");
		
		mapper.boardListPaging(search)//
		        .forEach(bvo -> System.out.println(bvo));
		
		

	}
}
