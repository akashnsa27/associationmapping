package com.nsa.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private Integer age;
    private Long mobile;
    private Long pincode;
    private String street;
    private String city;
    private List<Long> courseId;

}
