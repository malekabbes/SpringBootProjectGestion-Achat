package com.example.tpnotee.generic;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplementationGeneric<T,ID> implements Igeneric<T,ID>{
   @Autowired
   public GenericRepo<T,ID> repo;

    @Override
    public List<T> findAll() throws Exception {
        try {
            return (List<T>) repo.findAll();
        } catch (Exception err) {
            System.out.println("Un erreur survenue : "+err);
        }
        return null;
    }
    @Override
    public T save(T entity) throws Exception {
        try {
            return repo.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(ID id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public T retrieve(ID id) throws Exception {
        T res=repo.findById(id).orElse(null);
        try {
            return res;
        } catch (Exception err) {
            System.out.println("Un erreur survenue"+ err);
        }
        return null;
    }

    @Override
    public T update(T entity) throws Exception {
        try {
            return repo.save(entity);
        } catch (Exception err1) {
            System.out.println("Une erreur survenue"+err1);
        }
        return entity;
    }
}
