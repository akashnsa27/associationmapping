package com.nsa.model.response;

import lombok.*;

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

}
