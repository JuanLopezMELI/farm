package com.farmers.farm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Farmer owner;

  @ManyToOne
  @JoinColumn(name = "race_id")
  private Race race;

  private AnimalKingdom kingdom;
  private double weight;

  public Animal(Integer id, Farmer owner, AnimalKingdom kingdom, double weight) {
    this.id = id;
    this.owner = owner;
    this.kingdom = kingdom;
    this.weight = weight;
  }

  public Animal() {

  }

  public Farmer getOwner() {
    return owner;
  }

  public void setOwner(Farmer owner) {
    this.owner = owner;
  }


  public Integer getId() {
    return id;
  }

  public Animal setId(Integer id) {
    this.id = id;
    return this;
  }

  public AnimalKingdom getKingdom() {
    return kingdom;
  }

  public Animal setKingdom(AnimalKingdom kingdom) {
    this.kingdom = kingdom;
    return this;
  }

  public double getWeight() {
    return weight;
  }

  public Animal setWeight(double weight) {
    this.weight = weight;
    return this;
  }

  public Race getRace() {
    return race;
  }

  public Animal setRace(Race race) {
    this.race = race;
    return this;
  }
}
