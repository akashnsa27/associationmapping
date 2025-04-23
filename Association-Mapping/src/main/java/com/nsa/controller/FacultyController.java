package com.nsa.controller;

import com.nsa.entity.Faculty;
import com.nsa.model.request.FacultyRequest;
import com.nsa.model.response.FacultyResponse;
import com.nsa.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<String> saveFaculty(@RequestBody FacultyRequest request){
      String msg = facultyService.saveFaculty(request);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<FacultyResponse>> getAllFaculty(){
        return new ResponseEntity<>(facultyService.getAllFaculty(), HttpStatus.CREATED);
    }
}
