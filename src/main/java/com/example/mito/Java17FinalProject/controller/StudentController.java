package com.example.mito.Java17FinalProject.controller;

import com.example.mito.Java17FinalProject.dto.StudentDTO;
import com.example.mito.Java17FinalProject.entity.Student;
import com.example.mito.Java17FinalProject.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final IStudentService service;
    private final ModelMapper mapper;

    @Autowired
    public StudentController(IStudentService service, @Qualifier("studentMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception {
        List<StudentDTO> list = service.readAll()
                .stream()
                .map(this::convertToDto)
                .sorted(Comparator.comparing(StudentDTO::getIdStudent, Comparator.reverseOrder()))
                .collect(Collectors.toList());
                //toList() desde java 16
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestBody StudentDTO dto) throws Exception{
        dto.setIdStudent(id);
        Student obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception
    {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ////////////////////////
    private StudentDTO convertToDto(Student obj)
    {
        return mapper.map(obj, StudentDTO.class);
    }
    private Student convertToEntity(StudentDTO dto)
    {
        return mapper.map(dto, Student.class);
    }
}
