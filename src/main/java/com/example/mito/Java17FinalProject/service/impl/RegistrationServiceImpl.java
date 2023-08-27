package com.example.mito.Java17FinalProject.service.impl;

import com.example.mito.Java17FinalProject.entity.Registration;
import com.example.mito.Java17FinalProject.repo.ICourseRepo;
import com.example.mito.Java17FinalProject.repo.IGenericRepo;
import com.example.mito.Java17FinalProject.repo.IRegistrationRepo;
import com.example.mito.Java17FinalProject.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl extends CRUDImpl<Registration,Integer> implements IRegistrationService {
    private final IRegistrationRepo repo;
    @Override
    protected IGenericRepo<Registration, Integer> getRepo() {
        return repo;
    }
}
