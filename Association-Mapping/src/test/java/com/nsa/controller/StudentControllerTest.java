package com.nsa.controller;

import com.nsa.model.response.StudentResponse;
import com.nsa.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @Test
    void getStudentwithDto_Test_with_success() {

        int studId = 1;

        StudentResponse mcokResposne = StudentResponse.builder()
                .studId(studId)
                .name("akash")
                .age(18)
                .mobile(789654L)
                .street("dev nagar")
                .city("Pune")
                .courses(Collections.emptyList())
                .build();

        when(studentService.getStudentwithDto(studId)).thenReturn(mcokResposne);

        //when
        ResponseEntity<StudentResponse> response = studentController.getStudentwithDto(studId);

        //then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mcokResposne, response.getBody());

        verify(studentService, times(1)).getStudentwithDto(studId);

    }
}