package com.nsa.runner;

import com.nsa.entity.Student;
import com.nsa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

//@Component
//@RequiredArgsConstructor
//public class SortRunner implements CommandLineRunner {
//
//
////    private final StudentRepository studRepo;
//
//    @Override
////    public void run(String... args) throws Exception {
////
//////        Sort sortByName = Sort.by("name");
//////        Sort sortByName = Sort.by(Sort.Direction.ASC, "name");
//////        Sort sortByName = Sort.by(Sort.Direction.DESC, "name");
//////        Sort sortByName = Sort.by( "name", "age");
//////        Sort sortByName = Sort.by(Sort.Direction.DESC, "name", "age"); //descending
//////        Sort sortByName = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("age"));
//////        Sort sortByName = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("age"));
////
//////        Pageable pageRequest = PageRequest.of(0, 10, Sort.Direction.ASC, "name");
////
////        Sort sortByName = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("age"));
////        Pageable pageRequest = PageRequest.of(0, 10, sortByName);
////        Page<Student> studPagedResult = studRepo.findAll(pageRequest);
////        List<Student> studList = studPagedResult.getContent();
////
//////        List<Student> studList = studRepo.findAll();
////
////        studList.forEach((stud) -> {
////            System.out.println("============Next==========");
////            System.out.println("Id " + stud.getId());
////            System.out.println("Name " + stud.getName());
////            System.out.println("age " + stud.getAge());
////
////            if (Objects.nonNull(stud.getAddress())) {
////                System.out.println("Address City : " + stud.getAddress().getCity());
////            }
////
////            stud.getCourses().forEach(course ->
////                    System.out.println("course id : " + course.getId() + "\n" + "course name : " + course.getName()));
////        });
////    }
//}
