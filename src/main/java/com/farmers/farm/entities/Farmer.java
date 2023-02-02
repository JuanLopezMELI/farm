package com.farmers.farm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmer")
public class Farmer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  private String name;
  private String city;
  private String profession;

  public Farmer() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public Farmer setName(String name) {
    this.name = name;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Farmer setCity(String city) {
    this.city = city;
    return this;
  }

  public String getProfession() {
    return profession;
  }

  public Farmer setProfession(String profession) {
    this.profession = profession;
    return this;
  }
}