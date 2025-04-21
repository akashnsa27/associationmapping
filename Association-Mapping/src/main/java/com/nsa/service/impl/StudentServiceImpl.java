package com.nsa.service.impl;

import com.nsa.entity.Student;
import com.nsa.repository.StudentRepository;
import com.nsa.service.StudentService;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studRepo;

    @Override
    public String saveStudent(Student student) {

        if (student != null) {
            studRepo.save(student);
            return "student saved successfully";
        } else {
            throw new IllegalArgumentException("invalid input");
        }
    }

    @Override
    public Student getStudentById(Integer id) {

//        log.info("Student id : {}", id);
        return studRepo.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("invalid id " + id);
        });
    }

    @Override
    public List<Student> getAllStudent() {
        return studRepo.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(int id) {

    }
}
