package com.example.tpnotee.generic;

import com.example.tpnotee.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerGeneric<T,ID> {
    @Autowired
    private ImplementationGeneric<T,ID> serviceG;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
        public T save(@RequestBody T t) throws Exception {
        T Response = (T) serviceG.save(t);
        return Response;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<T> RetrieveAll() {
        try {
            return serviceG.repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStock(@PathVariable ID id) {
        try {
            serviceG.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
