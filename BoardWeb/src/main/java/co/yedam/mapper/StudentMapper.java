package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;
import co.yedam.vo.Student;

public interface StudentMapper {
	public List<Student> selectBlog();
	//List<BoardVO> boardListPaging
	public Student getStudent(String stdNo);
	public int insertStudent(Student student);
	public int updateStudentPhone(Student student);
	public int deleteStudent(Student student);
	public List<BoardVO> boardList();

	
}
