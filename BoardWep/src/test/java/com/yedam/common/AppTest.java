package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.StudentMapper;
import com.yedam.vo.Student;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstace();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//interface - 구현객체.
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student std = new Student();
		std.setStdNo("S0011");
		std.setStdName("김지수");
		std.setPhone("010-1234-6666");
		std.setBldType("0");
		
		//메소드 방식으로 처리하는데 안됨
		mapper.updateStudent(std);
		//sqlSession.update("com.yedam.mapper.StudentMapper.updateStudent", std);
		sqlSession.commit();
		
		List<Student> list = 
		mapper.selectBlog();
		//sqlSession.selectList("com.yedam.mapper.StudentMapper.selectBlog");
		for(Student std1 : list) {
			System.out.println(std1.toString());
		}
	}

}
