package com.example.mito.Java17FinalProject.service.impl;

import com.example.mito.Java17FinalProject.dto.CourseStudentsDTO;
import com.example.mito.Java17FinalProject.dto.StudentDTO2;
import com.example.mito.Java17FinalProject.entity.Course;
import com.example.mito.Java17FinalProject.repo.ICourseRepo;
import com.example.mito.Java17FinalProject.repo.IGenericRepo;
import com.example.mito.Java17FinalProject.repo.IRegistrationDetailRepo;
import com.example.mito.Java17FinalProject.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {
    private final ICourseRepo repo;
    private final IRegistrationDetailRepo repo2;
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<CourseStudentsDTO> courseAndStudentNames() {
        List<CourseStudentsDTO> courseStudentsDTOList = repo2.findAll().stream()
                .collect(Collectors.groupingBy(
                        registrationDetail -> registrationDetail.getCourse().getName(),
                        Collectors.mapping(
                                registrationDetail -> new StudentDTO2(
                                        registrationDetail.getRegistration().getStudent().getFirstName(),
                                        registrationDetail.getRegistration().getStudent().getLastName()
                                ),
                                Collectors.toList()
                        )
                ))
                .entrySet().stream()
                .map(entry -> new CourseStudentsDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return courseStudentsDTOList;
    }

}
