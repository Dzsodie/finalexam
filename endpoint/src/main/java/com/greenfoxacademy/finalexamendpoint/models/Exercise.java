package com.greenfoxacademy.finalexamendpoint.models;

import javax.persistence.*;

@Entity
@Table(name = "other")
public class Exercise {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false) //this helps if there are missing ids
  private long id;
  private String name;
  private String period;
  private String user;


  public Exercise() {
  }

  public Exercise(long id, String name, String period, String user) {
    this.id = id;
    this.name = name;
    this.period = period;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

}
