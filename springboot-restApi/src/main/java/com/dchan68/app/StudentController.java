package com.dchan68.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("John", "Cena");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Roger", "Yu"));
		students.add(new Student("Affan", "Khan"));
		students.add(new Student("John", "Ra"));
		students.add(new Student("Jared", "Dookie"));
		students.add(new Student("Almer", "Handridzil"));
		return students;
	}
	
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	//build rest API to handle query parameter
	//http://localhost:8080/student/query?firstName=Tom&lastName=Yu
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);
	}
}
