package com.example.tpnotee.generic;

import com.example.tpnotee.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerGeneric<T,ID> {
    @Autowired
    private ImplementationGeneric<T,ID> service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
        public T save(@RequestBody T t) throws Exception {
        T Response = (T) service.save(t);
        return Response;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<T> RetrieveAll() {
        try {
            return service.repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStock(@PathVariable ID id) {
        try {
            service.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
