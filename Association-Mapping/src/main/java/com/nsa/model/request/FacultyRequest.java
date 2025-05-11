package com.nsa.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class FacultyRequest {

    private String name;
    private Double experience;
    private List<CourseRequest> courses;


    public FacultyRequest() {
    }

    public FacultyRequest(String name, Double experience, List<CourseRequest> courses) {
        this.name = name;
        this.experience = experience;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public List<CourseRequest> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseRequest> courses) {
        this.courses = courses;
    }
}
