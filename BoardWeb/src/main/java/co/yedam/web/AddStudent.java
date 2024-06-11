package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AddStudent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

		req.setCharacterEncoding("UTF-8");
		Student std = new Student();
		
		std.setStdNo(req.getParameter("sno"));
		std.setStdName(req.getParameter("sname"));
		std.setPhone(req.getParameter("phone"));
		std.setBldType(req.getParameter("bldType"));
		
		mapper.insertStudent(std);
		sqlSession.commit();
		
		req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);
		
	}

}
