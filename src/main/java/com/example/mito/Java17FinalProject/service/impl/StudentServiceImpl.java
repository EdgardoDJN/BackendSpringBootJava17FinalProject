package com.example.mito.Java17FinalProject.service.impl;

import com.example.mito.Java17FinalProject.entity.Student;
import com.example.mito.Java17FinalProject.repo.ICourseRepo;
import com.example.mito.Java17FinalProject.repo.IGenericRepo;
import com.example.mito.Java17FinalProject.repo.IStudentRepo;
import com.example.mito.Java17FinalProject.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {
    private final IStudentRepo repo;
    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}
