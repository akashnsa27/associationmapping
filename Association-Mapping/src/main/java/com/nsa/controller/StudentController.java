package com.nsa.controller;

import com.nsa.entity.Student;
import com.nsa.model.request.StudentRequest;
import com.nsa.model.response.StudentResponse;
import com.nsa.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        String s = studentService.saveStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PostMapping("/withdto")
    public ResponseEntity<String> saveStudentWithDTO(@RequestBody StudentRequest request) {
        String s = studentService.saveStudentWithDto(request);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studId) {
        Student studentById = studentService.getStudentById(studId);
        return ResponseEntity.ok().body(studentById);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<StudentResponse> getStudentwithDto(@PathVariable("id") int studId) {
        StudentResponse response = studentService.getStudentwithDto(studId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> allStudent = studentService.getAllStudent();
        return ResponseEntity.ok(allStudent);
    }
}
