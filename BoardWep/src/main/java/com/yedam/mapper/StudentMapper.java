package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.Student;

public interface StudentMapper {
	public List<Student> selectBlog();
	public int insertStudent(Student student);
	public int updateStudent(Student student);
}
