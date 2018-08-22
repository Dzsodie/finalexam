package com.greenfoxacademy.finalexamendpoint.services;

import com.greenfoxacademy.finalexamendpoint.models.Exercise;
import com.greenfoxacademy.finalexamendpoint.repositories.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ExerciseServiceImpl implements ExerciseService {

  ExerciseRepo exerciseRepo;

  @Autowired
  public ExerciseServiceImpl(ExerciseRepo exerciseRepo) {
    this.exerciseRepo = exerciseRepo;
  }


  @Override
  public void save(Exercise exercise) {                        //this is for saving one object for edit and add functionalities
    exerciseRepo.save(exercise);
  }

  @Override
  public List<Exercise> getExerciseList() {                    //this is for table to get object list on index page
    return exerciseRepo.findAll();
  }

  @Override
  public void deleteById(long id) {                             //this is for delete one object by id through delete endpoint in restcontroller
    exerciseRepo.deleteById(id);
  }

  @Override
  public Exercise getOneRandomExercise() {                       //this is for getting one random object
    Random random = new Random();
    return exerciseRepo.findAll().get(random.nextInt(exerciseRepo.findAll().size()));
  }

  @Override public Exercise getOneExerciseById(long id) {        //this is for getting one object by id
    return exerciseRepo.findById(id);
  }

  @Override
  public String isRightExercise(long id, String name) {          //this is for message handling
    if (exerciseRepo.findById(id).getName() != name) {
      return "Try again!";
    }
    return "Success";
  }

  @Override
  public int getDeterminant(String matrixNumbers) {              //this is for restcontroller matrix
    String[] elements = matrixNumbers.split(";");
    int determinant = Math.abs((Integer.parseInt(elements[0])) * (Integer.parseInt(elements[3])) - (Integer.parseInt(elements[1])) * (Integer.parseInt(elements[2])));
    return determinant;
  }

  @Override
  public boolean isFound(String name) {                          //this is for status.NOT_FOUND message
    if (exerciseRepo.findById(5l).equals(exerciseRepo.findByName(name))) {
      return true;
    }
    return false;
  }

}
