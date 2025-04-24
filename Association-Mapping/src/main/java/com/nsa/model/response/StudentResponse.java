package com.nsa.model.response;

import com.nsa.entity.Course;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {

    private Integer studId;
    private String name;
    private Integer age;
    private Long mobile;
    private Long pincode;
    private String street;
    private String city;
    private List<CourseResponse> courses;
}
