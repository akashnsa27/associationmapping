package com.nsa.model.response;

import com.nsa.entity.Course;
import lombok.*;

import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class StudentResponse {

    private Integer studId;
    private String name;
    private Integer age;
    private Long mobile;
    private Long pincode;
    private String street;
    private String city;
    private List<CourseResponse> courses;

    public StudentResponse() {
    }

    public StudentResponse(Integer studId, String name, Integer age, Long mobile, Long pincode, String street, String city, List<CourseResponse> courses) {
        this.studId = studId;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.pincode = pincode;
        this.street = street;
        this.city = city;
        this.courses = courses;
    }

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
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

    public List<CourseResponse> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResponse> courses) {
        this.courses = courses;
    }

    // Private constructor
    private StudentResponse(Builder builder) {
        this.studId = builder.studId;
        this.name = builder.name;
        this.age = builder.age;
        this.mobile = builder.mobile;
        this.pincode = builder.pincode;
        this.street = builder.street;
        this.city = builder.city;
        this.courses = builder.courses;
    }

    // ✅ Static builder() method to match Lombok usage
    public static Builder builder() {
        return new Builder();
    }

    // Static inner Builder class
    public static class Builder {
        private Integer studId;
        private String name;
        private Integer age;
        private Long mobile;
        private Long pincode;
        private String street;
        private String city;
        private List<CourseResponse> courses;

        public Builder studId(Integer studId) {
            this.studId = studId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder mobile(Long mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder pincode(Long pincode) {
            this.pincode = pincode;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder courses(List<CourseResponse> courses) {
            this.courses = courses;
            return this;
        }

        public StudentResponse build() {
            return new StudentResponse(this);
        }
    }
}
