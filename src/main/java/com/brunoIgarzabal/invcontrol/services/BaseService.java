package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.repositories.BaseRepository;
import com.brunoIgarzabal.invcontrol.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public T find(Long id) {
        Optional<T> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id
        ));
    }

    public T insert(T entity) {
        return repository.save(entity);
    }

}
