package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentRequestDto;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/createstudentdata")
	public ResponseEntity<StudentRequestDto> createStudentData(@RequestBody StudentRequestDto dto) {
		StudentRequestDto savedStudentData = studentService.createStudentData(dto);
		return new ResponseEntity<>(savedStudentData, HttpStatus.CREATED);
	}
	
	@GetMapping("/getallstudentsdata")
	public ResponseEntity<List<StudentRequestDto>> getAllStudentsData(){
		List<StudentRequestDto> allStudentsData = studentService.getAllStudentsData();
		return new ResponseEntity<>(allStudentsData, HttpStatus.OK);
	}
	
	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<StudentRequestDto> getStudentById(@PathVariable("id") Long studentid) {
		StudentRequestDto studentRequestDto = studentService.getStudentById(studentid);
		return new ResponseEntity<>(studentRequestDto, HttpStatus.OK);
	}
	
	@PutMapping("/updatestudentdata/{id}")
	public ResponseEntity<StudentRequestDto> updateStudentData(@PathVariable("id") Long studentid, 
			@RequestBody StudentRequestDto dto){
		dto.setId(studentid);
		StudentRequestDto updateStudentData = studentService.updateStudentData(dto);
		return new ResponseEntity<>(updateStudentData, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletestudentdata/{id}")
	public ResponseEntity<String> deleteStudentData(@PathVariable("id") Long studentid) {
		studentService.deleteStudentData(studentid);
		return new ResponseEntity<>("Student data successfully deleted !!", HttpStatus.OK);
	}

}
