package co.yedam.common;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper; 
public class AppTest {

	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋 하겠습니다.

		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		mapper.selectListPaging(1, 1).forEach(reply -> System.out.println(reply));

	}
}
