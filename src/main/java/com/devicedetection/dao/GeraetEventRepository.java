package com.devicedetection.dao;

import java.util.List;

import com.devicedetection.model.Geraet;
import com.devicedetection.model.GeraetEvent;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GeraetEventRepository extends CrudRepository<GeraetEvent, Integer> {

    List<GeraetEvent> findByGeraet(Geraet geraet);
}