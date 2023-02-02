package com.farmers.farm.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BasicResponseDTO <T> {
  private String message;
  private String statusCode;
  private T body;
}
