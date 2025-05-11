package com.nsa.runner;

import com.nsa.model.request.StudentRequest;
import com.nsa.service.impl.StudentFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class CriteriaRunner implements CommandLineRunner {

    @Autowired
    private StudentFilterService studentFilterService;

    @Override
    public void run(String... args) throws Exception {

//        List<Student> studList = studentFilterService.findStudentWithSearchAndFilter("akash", 25, 440034L, LocalDate.now());
        List<StudentRequest> studList = studentFilterService.findStudentWithSearchAndFilter("akash", null, null, null);


        studList.forEach((stud) -> {
            System.out.println("============Next==========");
            System.out.println("Name " + stud.getName());
            System.out.println("age " + stud.getAge());
            System.out.println("mobile : " + stud.getMobile());
            System.out.println("pincode : " + stud.getPincode());
            System.out.println("street : " + stud.getStreet());
            System.out.println("city : " + stud.getCity());
            System.out.println("courseName : " + stud.getCourseName());

        });

    }
}
