package com.nsa.runner;

import com.nsa.entity.Student;
import com.nsa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Objects;

//@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public void run(String... args) throws Exception {

//
//        Student student = studentRepo.findByAddressId(1L).orElseThrow();
//        System.out.println("student name : " + student.getName());

//        List<Student> studList = studentRepo.findByNameIgnoreCase("david");
//        List<Student> studList = studentRepo.findByAgeLessThan(25);
//        List<Student> studList = studentRepo.findByNameAndMobile("Rahul", 6959L);

//        List<Student> studList = studentRepo.findByAddressCity("nagpur");
//        List<Student> studList = studentRepo.findByCoursesId(1L);
//        List<Student> studList = studentRepo.findByCoursesName("PYTHON");
//        List<Student> studList = studentRepo.findByCoursesNameOrderByAgeDesc("PYTHON");
//        List<Student> studList = studentRepo.findTop2ByCoursesNameOrderByAgeDesc("PYTHON");
  //     List<Student> studList;// = studentRepo.findByNameContaining("t");

//        studList.forEach((stud) -> {
//            System.out.println("============Next==========");
//            System.out.println("Id " + stud.getId());
//            System.out.println("Name " + stud.getName());
//            System.out.println("age " + stud.getAge());
//
//            if (Objects.nonNull(stud.getAddress())) {
//                System.out.println("Address City : " + stud.getAddress().getCity());
//            }
//
//            stud.getCourses().forEach(course ->
//                    System.out.println("course id : " + course.getId() + "\n" + "course name : " + course.getName()));
//        });
    }
}
