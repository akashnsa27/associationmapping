package com.nsa.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentRequest {

    private String name;
    private Integer age;
    private Long mobile;
    private Long pincode;
    private String street;
    private String city;
    //    private List<Long> courseId;
    private String courseName;

    public StudentRequest() {
    }

    public StudentRequest(String name, Integer age, Long mobile, Long pincode, String street, String city, String courseName) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.pincode = pincode;
        this.street = street;
        this.city = city;
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
