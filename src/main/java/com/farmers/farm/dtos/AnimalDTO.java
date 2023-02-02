package com.farmers.farm.dtos;

import com.farmers.farm.entities.AnimalFamily;
import com.farmers.farm.entities.AnimalKingdom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnimalDTO {
  private Integer id;
  private AnimalKingdom kingdom;
  private AnimalFamily family;
  private double weight;
  private RaceDTO race;
  private FarmerDTO owner;
}
