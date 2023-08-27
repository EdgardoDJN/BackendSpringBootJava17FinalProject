package com.example.mito.Java17FinalProject.service;

import com.example.mito.Java17FinalProject.dto.CourseStudentsDTO;
import com.example.mito.Java17FinalProject.entity.Course;

import java.util.List;
import java.util.Map;

public interface ICourseService extends ICRUD<Course,Integer> {

    List<CourseStudentsDTO> courseAndStudentNames();
}
