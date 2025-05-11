package com.nsa.runner;

import com.nsa.entity.Student;
import com.nsa.repository.AddressRepository;
import com.nsa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

//@Component
//@Order(1)
public class QueryRunner implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private AddressRepository addRepo;

    @Override
    public void run(String... args) throws Exception {

//PageRequest of(int pageNumber, int pageSize)

        int pageNo = 4;

        int pageNumber = pageNo - 1; //0  //33 records - 10 10 10 3   - 4 pages
        int pageSize = 9;   // 9 9 9 6

//        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

//        Page<Student> pageResult = studentRepo.findAll(pageable);
//        System.out.println("page result : " + pageResult.getContent().size());

//        List<Student> studList = pageResult.getContent();

        Page<Student> allStudentPaged = studentRepo.getAllStudentPaged(pageable);

        System.out.println(allStudentPaged.isFirst());  //No - False
        System.out.println(allStudentPaged.isLast());  // yes - true
        System.out.println(allStudentPaged.getTotalPages());
        System.out.println(allStudentPaged.getTotalElements());  //



        //        List<Student> studList = allStudentPaged.getContent();


//        List<Student> studList = studentRepo.findAll();
//        System.out.println("normal result : " + studList.size());

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
