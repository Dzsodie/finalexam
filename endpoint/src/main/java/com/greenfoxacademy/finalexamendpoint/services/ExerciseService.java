package com.greenfoxacademy.finalexamendpoint.services;

import com.greenfoxacademy.finalexamendpoint.models.Exercise;

import java.util.List;

public interface ExerciseService {

  List<Exercise> getExerciseList();
  void deleteById(long id);
  int getDeterminant(String matrixNumbers);
  boolean isFound(String name);
  void save(Exercise exercise);
  Exercise getOneRandomExercise();
  String isRightExercise(long id, String name);
  Exercise getOneExerciseById(long id);

}
