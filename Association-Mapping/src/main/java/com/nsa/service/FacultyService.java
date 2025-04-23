package com.nsa.service;

import com.nsa.entity.Faculty;
import com.nsa.model.request.FacultyRequest;
import com.nsa.model.response.FacultyResponse;

import java.util.List;

public interface FacultyService {

    //save faculty
    public String saveFaculty(FacultyRequest request);

    //get all faculty
    public List<FacultyResponse> getAllFaculty();

    //get faculty by id
    public FacultyResponse getFacultyById(Long id);

    //update faculty
    public String updateFaculty(FacultyRequest request);

    //delete faculty
    public void deleteFacultyById(Long id);


}
