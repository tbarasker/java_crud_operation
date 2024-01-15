package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
