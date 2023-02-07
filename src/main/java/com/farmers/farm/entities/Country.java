package com.farmers.farm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  private String name;
  private Continent continent;
  private ContinentSubdivision continentSubdivision;

  public String getName() {
    return name;
  }

  public Country setName(String name) {
    this.name = name;
    return this;
  }

  public Continent getContinent() {
    return continent;
  }

  public Country setContinent(Continent continent) {
    this.continent = continent;
    return this;
  }

  public Integer getId() {
    return id;
  }

  public Country setId(Integer id) {
    this.id = id;
    return this;
  }

  public ContinentSubdivision getContinentSubdivision() {
    return continentSubdivision;
  }

  public Country setContinentSubdivision(
      ContinentSubdivision continentSubdivision) {
    this.continentSubdivision = continentSubdivision;
    return this;
  }
}