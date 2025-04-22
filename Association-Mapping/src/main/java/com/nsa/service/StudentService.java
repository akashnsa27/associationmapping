package com.nsa.service;

import com.nsa.entity.Student;
import com.nsa.model.request.StudentRequest;
import com.nsa.model.response.StudentResponse;

import java.util.List;

public interface StudentService {

    public String saveStudent(Student student);

    public String saveStudentWithDto(StudentRequest request);

    public Student getStudentById(Integer id);

    public StudentResponse getStudentwithDto(Integer id);

    public List<Student> getAllStudent();

    public Student updateStudent(Student student);

    public void deleteStudent(int id);
}
