package com.farmers.farm.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AnimalPhotoLinkUpdateDTO {
  private Integer animalId;
  private String link;
}
