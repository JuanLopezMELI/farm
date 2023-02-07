package com.farmers.farm.dtos;

import com.farmers.farm.entities.Continent;
import com.farmers.farm.entities.ContinentSubdivision;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDTO {
  private Integer id;
  private String name;
  private Continent continent;
  private ContinentSubdivision continentSubdivision;
}
