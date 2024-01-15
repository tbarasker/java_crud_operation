package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentRequestDto;
import com.student.entities.StudentEntity;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentRequestDto createStudentData(StudentRequestDto dto) {
		
		StudentEntity studentEntity = modelMapper.map(dto, StudentEntity.class);
		StudentEntity saveEntity = studentRepository.save(studentEntity);
		
		StudentRequestDto studentRequestDto = modelMapper.map(saveEntity, StudentRequestDto.class);
		return studentRequestDto;
	}

	@Override
	public List<StudentRequestDto> getAllStudentsData() {
		return (List<StudentRequestDto>) studentRepository.findAll().stream().map(allStudentsData -> 
		modelMapper.map(allStudentsData, StudentRequestDto.class)).collect(Collectors.toList());
	}

	@Override
	public StudentRequestDto getStudentById(Long studentid) {
		Optional<StudentEntity> optional = studentRepository.findById(studentid);
		StudentEntity studentEntity = optional.get();
		StudentRequestDto studentRequestDto = modelMapper.map(studentEntity, StudentRequestDto.class);
		return studentRequestDto;
	}

	@Override
	public StudentRequestDto updateStudentData(StudentRequestDto dto) {
		Optional<StudentEntity> optional = studentRepository.findById(dto.getId());
		StudentEntity studentEntity = optional.get();
		studentEntity.setId(dto.getId());
		studentEntity.setMarks(dto.getMarks());
		studentEntity.setName(dto.getName());
		studentEntity.setRollno(dto.getRollno());
		studentEntity.setSubject(dto.getSubject());
		StudentEntity entity = studentRepository.save(studentEntity);
		StudentRequestDto studentRequestDto = modelMapper.map(entity, StudentRequestDto.class);
		return studentRequestDto;
	}

	@Override
	public void deleteStudentData(Long studentid) {
		Optional<StudentEntity> optional = studentRepository.findById(studentid);
		StudentEntity studentEntity = optional.get();
		studentRepository.delete(studentEntity);
	}
}
