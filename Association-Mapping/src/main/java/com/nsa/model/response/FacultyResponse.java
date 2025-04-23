package com.nsa.model.response;

import com.nsa.model.request.CourseRequest;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultyResponse {

    private Long id;
    private String name;
    private Double experience;
    private List<CourseResponse> courses;

}
