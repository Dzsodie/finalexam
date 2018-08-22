package com.greenfoxacademy.finalexamendpoint.controllers;

import com.greenfoxacademy.finalexamendpoint.models.Exercise;
import com.greenfoxacademy.finalexamendpoint.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

  ExerciseService exerciseService;

  @Autowired
  public MainController(ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  @GetMapping("/")            //gives back an empty root page
  public String showRootWithWhiteLabel() {
    return "/";
  }

  @GetMapping("/index")        //show index page with list and empty forms
  public String renderIndexPage(Model model) {
    model.addAttribute("list2", exerciseService.getExerciseList());
    model.addAttribute("exercise", new Exercise());
    return "index";
  }

  @GetMapping("/add")         //go to new page to add a new Object
  public String addNewExercise(Model model) {
    model.addAttribute("exercise", new Exercise());
    return "add";
  }

  @PostMapping("/add")         //add a new Object to existing database
  public String addExerciseName(@ModelAttribute Exercise exercise, Model model) {
    model.addAttribute("newExercise", exercise);
    exerciseService.save(exercise);
    return "redirect:/index";
  }

  @GetMapping("/go/{id}")       //go to edit page for one Object chosen by id - id is seen in URL
  public String showExerciseToEdit(@PathVariable(value = "id") long id, Model model) {
    model.addAttribute("newExercise", exerciseService.getOneExerciseById(id));
    return "go";
  }

  @PostMapping("/go/{id}")       //changing anything on an Object chosen by id - id is seen in URL
  public String goToOtherPage(@PathVariable(value = "id") long id, @ModelAttribute Exercise exercise) {
    exerciseService.save(exercise);
    return "redirect:/index";
  }

  @GetMapping("/random")         //get a random Object on a new page
  public String randomExercise(@ModelAttribute Exercise exercise, Model model) {
    model.addAttribute("randomExercise", exerciseService.getOneRandomExercise());
    return "random";
  }

  @PostMapping("/random")        //message handling
  public String showResult(@ModelAttribute Exercise exercise, Model model, @RequestParam(value = "id") long id, @RequestParam(value = "name") String name) {
    model.addAttribute("randomExercise", exerciseService.getOneRandomExercise());
    model.addAttribute("message", exerciseService.isRightExercise(id, name));
    return "random";
  }

  @GetMapping("/status")               //status.NOT_FOUND message for name
  public String endpointName(@RequestParam(value = "name") String name, Model model) {
    if (!exerciseService.isFound(name)) {      // isFound() method needs to be defined in service
      throw new ResourceNotFoundException(name + " not found");
    }
    return "index";
  }
}