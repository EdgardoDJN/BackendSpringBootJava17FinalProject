package com.example.mito.Java17FinalProject.controller;

import com.example.mito.Java17FinalProject.dto.CourseDTO;
import com.example.mito.Java17FinalProject.dto.CourseStudentsDTO;
import com.example.mito.Java17FinalProject.entity.Course;
import com.example.mito.Java17FinalProject.service.ICourseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final ICourseService service;
    private final ModelMapper mapper;

    @Autowired
    public CourseController(ICourseService service, @Qualifier("courseMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception {
        List<CourseDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/coursestudent")
    public ResponseEntity<List<CourseStudentsDTO>> read() throws Exception {
        List<CourseStudentsDTO> courseAndStudentNames = service.courseAndStudentNames();
        //List<CourseDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(courseAndStudentNames, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id, @RequestBody CourseDTO dto) throws Exception{
        dto.setIdCourse(id);
        Course obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception
    {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ////////////////////////
    private CourseDTO convertToDto(Course obj)
    {
        return mapper.map(obj, CourseDTO.class);
    }
    private Course convertToEntity(CourseDTO dto)
    {
        return mapper.map(dto, Course.class);
    }
}
