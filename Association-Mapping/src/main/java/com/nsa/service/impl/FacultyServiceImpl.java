package com.nsa.service.impl;

import com.nsa.entity.Course;
import com.nsa.entity.Faculty;
import com.nsa.model.request.CourseRequest;
import com.nsa.model.request.FacultyRequest;
import com.nsa.model.response.CourseResponse;
import com.nsa.model.response.FacultyResponse;
import com.nsa.repository.CourseRepository;
import com.nsa.repository.FacultyRepository;
import com.nsa.service.FacultyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
//@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepo;

    @Autowired
    private CourseRepository courseRepo;


    @Override
    public String saveFaculty(FacultyRequest request) {
        Faculty faculty = new Faculty();
        faculty.setName(request .getName());
        faculty.setExperience(request.getExperience());

        List<CourseRequest> courses = request.getCourses();

        List<Course> courseList = courses.stream().map((courseRequest) -> {
            Course course = new Course();
            course.setName(courseRequest.getName());
            course.setStartDate(courseRequest.getStartDate());
            course.setEndDate(courseRequest.getEndDate());
            course.setFaculty(faculty);
            return course;
        }).collect(Collectors.toList());

        faculty.setCourse(courseList);

        facultyRepo.save(faculty);

        return "Faculty Saved";

    }

    @Override
    public List<FacultyResponse> getAllFaculty() {

        List<Faculty> allFaculties = facultyRepo.findAll();


        List<FacultyResponse> facultyResponseList = allFaculties.stream().map((faculty) -> {
            FacultyResponse facultyResponse = new FacultyResponse();
            facultyResponse.setId(faculty.getId());
            facultyResponse.setName(faculty.getName());
            facultyResponse.setExperience(faculty.getExperience());

            List<Course> courseList = faculty.getCourse();

            List<CourseResponse> courseResponseList = courseList.stream().map((course) -> {
                CourseResponse response = new CourseResponse();
                response.setId(course.getId());
                response.setName(course.getName());
                response.setEndDate(course.getEndDate());
                response.setStartDate(course.getStartDate());
                return response;
            }).toList();

            facultyResponse.setCourses(courseResponseList);

            return facultyResponse;

        }).collect(Collectors.toList());

        return facultyResponseList;
    }

    @Override
    public FacultyResponse getFacultyById(Long id) {
        return null;
    }

    @Override
    public String updateFaculty(FacultyRequest fac) {
        return "";
    }

    @Override
    public void deleteFacultyById(Long id) {

    }
}
