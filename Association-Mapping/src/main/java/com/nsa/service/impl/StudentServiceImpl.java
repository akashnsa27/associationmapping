package com.nsa.service.impl;

import com.nsa.entity.Address;
import com.nsa.entity.Course;
import com.nsa.entity.Student;
import com.nsa.model.request.StudentRequest;
import com.nsa.model.response.CourseResponse;
import com.nsa.model.response.StudentResponse;
import com.nsa.repository.CourseRepository;
import com.nsa.repository.StudentRepository;
import com.nsa.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studRepo;

    @Autowired
    private CourseRepository courseRepository;

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
    public String saveStudentWithDto(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setMobile(request.getMobile());

        Address address = new Address();
        address.setCity(request.getCity());
        address.setPincode(request.getPincode());
        address.setStreet(request.getStreet());

        student.setAddress(address);

        studRepo.save(student);
        return "student saved";
    }

    @Override
    public String saveStudWithCourse(StudentRequest request) {
        return "";
    }

//    @Override
//    @Transactional(rollbackFor = ArithmeticException.class)
//    public String saveStudWithCourse(StudentRequest request) {
//        Student student = new Student();
//        student.setName(request.getName());
//        student.setAge(request.getAge());
//        student.setMobile(request.getMobile());
//        studRepo.save(student);
//
//        if(request.getCourseId().isEmpty()){
//            throw new RuntimeException("Course id not provided");
//        }
//        List<Long> courseId = request.getCourseId();
//        List<Course> courseList = courseRepository.findAllById(courseId);
//
//        student.setCourses(courseList);
//
//        studRepo.save(student);
//        return "student saved";
//    }

    @Override
    public StudentResponse getStudWithCourse(Integer id) {
        Student student = studRepo.findById(id).orElseThrow();

        List<Course> courses = student.getCourses();
        List<CourseResponse> courseResponseList = courses.stream().map((course) -> {
            CourseResponse courseResponse = new CourseResponse();
            courseResponse.setId(course.getId());
            courseResponse.setName(course.getName());
            courseResponse.setStartDate(course.getStartDate());
            courseResponse.setEndDate(course.getEndDate());
            return courseResponse;
        }).toList();

        StudentResponse response = StudentResponse.builder()
                .studId(student.getId())
                .age(student.getAge())
                .name(student.getName())
                .courses(courseResponseList)
                .build();

        return response;
    }

    @Override
    public Student getStudentById(Integer id) {

//        log.info("Student id : {}", id);
        return studRepo.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("invalid id " + id);
        });
    }

    @Override
    public StudentResponse getStudentwithDto(Integer id) {

        Student student = studRepo.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("invalid id " + id);
        });

        StudentResponse resposne = StudentResponse.builder()
                .age(student.getAge())
                .name(student.getName())
                .mobile(student.getMobile())
                .street(student.getAddress().getStreet())
                .city(student.getAddress().getCity())
                .pincode(student.getAddress().getPincode())
                .build();

        return resposne;
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
