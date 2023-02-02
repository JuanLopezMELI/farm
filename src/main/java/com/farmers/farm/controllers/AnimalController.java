package com.farmers.farm.controllers;

import com.farmers.farm.dtos.AnimalDTO;
import com.farmers.farm.dtos.BasicResponseDTO;
import com.farmers.farm.entities.Animal;
import com.farmers.farm.services.AnimalService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/animals")
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping("{id}")
  public ResponseEntity<BasicResponseDTO<AnimalDTO>> getAnimalById(@PathVariable Integer id) {
    return new ResponseEntity<>(animalService.getAnimalById(id), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<BasicResponseDTO<List<AnimalDTO>>> getAllAnimals() {
    return new ResponseEntity<>(animalService.getAllAnimals(), HttpStatus.OK);
  }

  @GetMapping("race/{raceName}")
  public ResponseEntity<BasicResponseDTO<List<AnimalDTO>>> getAllAnimalsByRaceName(@PathVariable String raceName) {
    return new ResponseEntity<>(animalService.getAllAnimalsByRaceName(raceName), HttpStatus.OK);
  }

  @GetMapping("scientific-name/{scientificName}")
  public ResponseEntity<BasicResponseDTO<List<AnimalDTO>>> getAllAnimalsByRaceScientificName(@PathVariable String scientificName) {
    return new ResponseEntity<>(animalService.getAllAnimalsByRaceScientificName(scientificName), HttpStatus.OK);
  }

  @GetMapping("kingdom/{kingdom}")
  public ResponseEntity<BasicResponseDTO<List<AnimalDTO>>> getAllAnimalsByKingdom(@PathVariable String kingdom) {
    return new ResponseEntity<>(animalService.getAllAnimalsByKingdom(kingdom), HttpStatus.OK);
  }

  @GetMapping("owner/city/{city}")
  public ResponseEntity<BasicResponseDTO<List<AnimalDTO>>> getAllAnimalsByOwnerCity(@PathVariable String city) {
    return new ResponseEntity<>(animalService.getAllAnimalsByOwnerCity(city), HttpStatus.OK);
  }
}
