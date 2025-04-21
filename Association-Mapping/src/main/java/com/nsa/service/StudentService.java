package com.nsa.service;

import com.nsa.entity.Student;

import java.util.List;

public interface StudentService {

    public String saveStudent(Student student);

    public Student getStudentById(Integer id);

    public List<Student> getAllStudent();

    public Student updateStudent(Student student);

    public void deleteStudent(int id);
}
