package com.example.tpnotee.generic;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplementationGeneric<T,ID> implements Igeneric<T,ID>{
   @Autowired
   public GenericRepo<T,ID> repo;

    @Override
    public List<T> findAll() throws Exception {
        return null;
    }

    @Override
    public T save(T entity) throws Exception {
        return null;
    }

    @Override
    public void delete(ID id) throws Exception {

    }

    @Override
    public T retrieve(ID id) throws Exception {
        return null;
    }

    @Override
    public T update(T entity) throws Exception {
        return null;
    }
}
