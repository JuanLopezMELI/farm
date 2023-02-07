package com.farmers.farm.dtos;

import com.farmers.farm.entities.AnimalFamily;
import com.farmers.farm.entities.AnimalKingdom;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AnimalDTO {
  private Integer id;
  private AnimalKingdom kingdom;
  private AnimalFamily family;
  private double weight;
  private RaceDTO race;
  private FarmerDTO owner;
}
