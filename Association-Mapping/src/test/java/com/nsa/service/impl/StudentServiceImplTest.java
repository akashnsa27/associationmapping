package com.nsa.service.impl;

import com.nsa.entity.Address;
import com.nsa.entity.Student;
import com.nsa.model.response.StudentResponse;
import com.nsa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @Mock
    private StudentRepository studentRepository;


    @Test
    void getStudentwithDto_withValidId_Test() {

        int studId = 101;

        Address address = new Address();
        address.setId(1L);
        address.setStreet("Main Street");
        address.setCity("Gotham");
        address.setPincode(400001L);

        Student student = new Student();
        student.setId(studId);
        student.setName("tom cruise");
        student.setAge(60);
        student.setMobile(78965413L);
        student.setAddress(address);

        when(studentRepository.findById(studId)).thenReturn(Optional.of(student));

        //when
        StudentResponse response = studentServiceImpl.getStudentwithDto(studId);

        //then
        assertNotNull(response);
        assertEquals("tom cruise", response.getName());
        assertEquals(400001L, response.getPincode());

        verify(studentRepository, times(1)).findById(studId);

    }


    @Test
    void testGetStudentwithDto_with_InvalidId_throwException() {

        int invalidStudId = 100;

        when(studentRepository.findById(invalidStudId)).thenReturn(Optional.empty());

        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> studentServiceImpl.getStudentwithDto(invalidStudId));

        assertEquals("invalid id " + invalidStudId, illegalArgumentException.getMessage());

        verify(studentRepository, times(1)).findById(invalidStudId);
    }

}