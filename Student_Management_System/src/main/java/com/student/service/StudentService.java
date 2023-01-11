package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.StudentException;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public Student saveStudent(Student student) {
		Student student2 = repository.save(student);
		return student2;
	}
	
	public Student deleteStudent(Integer roll) throws StudentException {
		
		Optional<Student> student2 = repository.findById(roll);
		
		if(student2.isPresent()) {
			repository.deleteById(roll);
		}else {
			throw new StudentException("No student is available with roll " + roll);
		}
		
		return student2.get();
	}
	
	public List<Student> getAllStudents() throws StudentException{
		List<Student> list = repository.findAll();
		
		try {
			return list;
		} catch (Exception e) {
			throw new StudentException("No Student Found.");
		}
	}

	public Student getStudentByRoll(Integer roll) throws StudentException {
		
		Optional<Student> student2 = repository.findById(roll);
		if(student2.isPresent()) {
			return student2.get();
		}else {
			throw new StudentException("No student is Present with roll " + roll);
		}
	}
	
	public List<Student> getHighMarksStudent() throws StudentException {

		List<Student> list = repository.getHighMarksStudent();
		
		try {
			Student student  = list.get(0);
		} catch (Exception e) {
			throw new StudentException("No Student Found.");
		}
		return list;
	}
	
	
	
	
	
}
