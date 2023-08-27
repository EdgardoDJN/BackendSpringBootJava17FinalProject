package com.example.mito.Java17FinalProject.service.impl;

import com.example.mito.Java17FinalProject.entity.RegistrationDetail;
import com.example.mito.Java17FinalProject.repo.IGenericRepo;
import com.example.mito.Java17FinalProject.repo.IRegistrationDetailRepo;
import com.example.mito.Java17FinalProject.repo.IRegistrationRepo;
import com.example.mito.Java17FinalProject.service.IRegistrationDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationDetailServiceImpl extends CRUDImpl<RegistrationDetail,Integer> implements IRegistrationDetailService {
    private final IRegistrationDetailRepo repo;
    @Override
    protected IGenericRepo<RegistrationDetail, Integer> getRepo() {
        return repo;
    }
}
