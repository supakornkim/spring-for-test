package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	// Get All student
	public List<Student> findAll() {
		return studentRepository.findAll(Sort.by("id").ascending());
	}

	public Student getOne(Integer id) {
		return studentRepository.getOne(id);
	}

	// Add edit
	public Student save(Student std) {
		return studentRepository.save(std);
	}

	public void delete(Student std) {
		studentRepository.delete(std);
	}

}
