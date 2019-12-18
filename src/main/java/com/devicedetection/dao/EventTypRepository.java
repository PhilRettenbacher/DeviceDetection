package com.devicedetection.dao;

import com.devicedetection.model.EventTyp;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EventTypRepository extends CrudRepository<EventTyp, Integer> {

}