package com.greenfoxacademy.finalexamendpoint.repositories;

import com.greenfoxacademy.finalexamendpoint.models.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepo extends CrudRepository<Exercise, Long> {

  List <Exercise> findAll();                      //this is for the list of all objects in service

  Exercise findByName(String name);              //this is for finding one object by name

  Exercise findById(long id);                    //this is for finding one object by id

  @Query(value = "SELECT u FROM Exercise WHERE id >= 2 and ORDER BY name;", nativeQuery = true)
  List <Exercise> findAllAfterIdOrderByName();

//this is for a custom query to find all objects after the id 2 and order them by name

}
