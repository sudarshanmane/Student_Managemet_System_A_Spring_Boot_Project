package com.student.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.exception.StudentException;
import com.student.model.Student;
import com.student.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[[[Save Student ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@PostMapping("saveStudentDetails")
	public ResponseEntity<Student> savaStudent(@Valid @RequestBody Student student) throws StudentException{
		
		System.out.println(student);
		
		if(student.getRoll() != null) {
			throw new StudentException("Please do not provide the student roll to save the Student Details.");
		}else {
			Student student2 = service.saveStudent(student);
			return new ResponseEntity<Student>(student2,HttpStatus.ACCEPTED);	
		}
	}
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[Get All Student]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent() throws StudentException{
		
		List<Student> list = service.getAllStudents();
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	} 
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[[Get Student By Roll]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@GetMapping("/getStudentByRoll/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathParam("roll") Integer roll) throws StudentException{
		
		Student st = service.getStudentByRoll(roll);
		return new ResponseEntity<Student>(st,HttpStatus.OK);
	} 
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[Delete Student By Roll]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@DeleteMapping("/deleteStudent/{roll}")
	public ResponseEntity<String> deleteStudentbyRoll(@PathVariable("roll") Integer roll) throws StudentException{
		
		return new ResponseEntity<String>("Details of the deleted student : " + service.deleteStudent(roll),HttpStatus.ACCEPTED);		
	}
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[Get High Marks Student]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@GetMapping("/getHighetMarksStudent")
	public ResponseEntity<List<Student>> getHighMarksStudent() throws StudentException{
		
		List<Student> list = service.getHighMarksStudent();
		return new ResponseEntity<List<Student>>(list,HttpStatus.ACCEPTED);
	}
	
// [[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@GetMapping("/getTopThreeHighMarksStudents")
	public ResponseEntity<List<Student>> getTopThreeMarksStudent() throws StudentException{
		
		List<Student> list = service.getAllStudents();
		
		Collections.sort(list,(o1,o2) ->{
			return o1.getMarks() > o2.getMarks() ? +1 : -1;
		});
		
		Collections.reverse(list);
		
		List<Student> list2 = new LinkedList<>();
		
		try {
			list2.add(list.get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			list2.add(list.get(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			list2.add(list.get(2));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.ACCEPTED);
	}
	
	
}
