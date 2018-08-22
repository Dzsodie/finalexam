package com.greenfoxacademy.finalexamendpoint.controllers;

import com.greenfoxacademy.finalexamendpoint.models.Exercise;
import com.greenfoxacademy.finalexamendpoint.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/download")
public class DownloadFileRestController {

  @Autowired
  ServletContext context;
  ExerciseService exerciseService;

  @RequestMapping(value = "/pdf/{fileName:.+}", method = RequestMethod.GET, produces = "application/pdf")
  public ResponseEntity<InputStreamResource> download(@PathVariable("fileName") String fileName) throws IOException {
    System.out.println("Calling Download:- " + fileName);
    ClassPathResource pdfFile = new ClassPathResource("downloads/" + fileName);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
    headers.add("Access-Control-Allow-Headers", "Content-Type");
    headers.add("Content-Disposition", "filename=" + fileName);
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");

    headers.setContentLength(pdfFile.contentLength());
    ResponseEntity<InputStreamResource> response = new ResponseEntity<>(
            new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
    return response;
  }

  @GetMapping("/rest")                           //return httpStatus.OK
  public ResponseEntity<Exercise> getOne() {
    return ResponseEntity.status(HttpStatus.OK).body(new Exercise());
  }

  @RequestMapping(value = "/outdated/{id}", method = RequestMethod.DELETE)      //delete one object by id in JSON
  @ResponseBody
  public String outdated(@PathVariable(value = "id") long id) {
    exerciseService.deleteById(id);
    return "deleted: " + id;
  }

  @RequestMapping(value = "/add", method = RequestMethod.PUT)      // update one object sent in JSON
  @ResponseBody
  public String addNewJsonObject(@ModelAttribute Exercise exercise) {
    exerciseService.save(exercise);
    return "added new exercise";
  }

  @GetMapping("/all")                       //get list of exercises in JSON
  public List<Exercise> getAllExercises() {
    return exerciseService.getExerciseList();
  }

}
