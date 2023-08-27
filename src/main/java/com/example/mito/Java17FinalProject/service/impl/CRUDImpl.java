package com.example.mito.Java17FinalProject.service.impl;

import com.example.mito.Java17FinalProject.exception.ModelNotFoundException;
import com.example.mito.Java17FinalProject.repo.IGenericRepo;
import com.example.mito.Java17FinalProject.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {
    protected abstract IGenericRepo<T, ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT EXISTS : " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        //No puedo instanciar un generico osea un new T
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT EXISTS : " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT EXISTS : " + id));
        getRepo().deleteById(id);
    }
}
