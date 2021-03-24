package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class BaseResource<T> {

    @Autowired
    private BaseService<T> service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> find(@PathVariable Long id) {
        T entity = service.find(id);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
