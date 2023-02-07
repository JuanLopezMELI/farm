package com.farmers.farm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Race {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String race;
  private String scientificName;
  @ManyToOne
  @JoinColumn(name = "origin_country_id")
  private Country originCountry;

  public Country getOriginCountry() {
    return originCountry;
  }

  public void setOriginCountry(Country originCountry) {
    this.originCountry = originCountry;
  }

  public Race() {}

  public Integer getId() {
    return id;
  }

  public Race setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getRace() {
    return race;
  }

  public Race setRace(String race) {
    this.race = race;
    return this;
  }

  public String getScientificName() {
    return scientificName;
  }

  public Race setScientificName(String scientificName) {
    this.scientificName = scientificName;
    return this;
  }
}
