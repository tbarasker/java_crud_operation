package com.student.service;

import java.util.List;

import com.student.dto.StudentRequestDto;

public interface StudentService {

	StudentRequestDto createStudentData(StudentRequestDto dto);

	List<StudentRequestDto> getAllStudentsData();

	StudentRequestDto getStudentById(Long studentid);

	StudentRequestDto updateStudentData(StudentRequestDto dto);

	public void deleteStudentData(Long studentid);

}
