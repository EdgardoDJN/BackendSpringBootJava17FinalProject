package com.example.mito.Java17FinalProject.config;

import com.example.mito.Java17FinalProject.dto.CourseDTO;
import com.example.mito.Java17FinalProject.dto.StudentDTO;
import com.example.mito.Java17FinalProject.entity.Course;
import com.example.mito.Java17FinalProject.entity.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper studentMapper()
    {
        ModelMapper mapper = new ModelMapper();
        //Procesos de lectura
        TypeMap<Student, StudentDTO> typeMap1 = mapper.createTypeMap(Student.class, StudentDTO.class);

        //Procesos de escritura
        TypeMap<StudentDTO, Student> typeMap2 = mapper.createTypeMap(StudentDTO.class, Student.class);
        return mapper;
    }

    @Bean("courseMapper")
    public ModelMapper courseMapper()
    {
        ModelMapper mapper = new ModelMapper();
        //Procesos de lectura
        TypeMap<Course, CourseDTO> typeMap1 = mapper.createTypeMap(Course.class, CourseDTO.class);

        //Procesos de escritura
        TypeMap<CourseDTO, Course> typeMap2 = mapper.createTypeMap(CourseDTO.class, Course.class);
        return mapper;
    }
    @Bean("defaultMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
