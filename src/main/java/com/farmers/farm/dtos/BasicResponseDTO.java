package com.farmers.farm.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class BasicResponseDTO <T> {
  private String message;
  private String statusCode;
  private T body;

  public BasicResponseDTO<T> setMessage(String message) {
    this.message = message;
    return this;
  }

  public BasicResponseDTO<T> setStatusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  public BasicResponseDTO<T> setBody(T body) {
    this.body = body;
    return this;
  }
}
