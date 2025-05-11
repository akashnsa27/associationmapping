package com.nsa.model.response;

import com.nsa.model.request.CourseRequest;
import lombok.*;

import java.util.List;


import java.util.List;

public class FacultyResponse {

    private Long id;
    private String name;
    private Double experience;
    private List<CourseResponse> courses;

    // ✅ No-arg constructor
    public FacultyResponse() {
    }

    // ✅ All-arg constructor
    public FacultyResponse(Long id, String name, Double experience, List<CourseResponse> courses) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.courses = courses;
    }

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getExperience() {
        return experience;
    }

    public List<CourseResponse> getCourses() {
        return courses;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public void setCourses(List<CourseResponse> courses) {
        this.courses = courses;
    }

    // ✅ builder() method
    public static Builder builder() {
        return new Builder();
    }

    // ✅ Manual Builder class
    public static class Builder {
        private Long id;
        private String name;
        private Double experience;
        private List<CourseResponse> courses;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder experience(Double experience) {
            this.experience = experience;
            return this;
        }

        public Builder courses(List<CourseResponse> courses) {
            this.courses = courses;
            return this;
        }

        public FacultyResponse build() {
            return new FacultyResponse(id, name, experience, courses);
        }
    }
}

