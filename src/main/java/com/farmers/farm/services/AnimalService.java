package com.farmers.farm.services;

import com.farmers.farm.config.ModelMapper;
import com.farmers.farm.dtos.AnimalDTO;
import com.farmers.farm.dtos.BasicResponseDTO;
import com.farmers.farm.entities.Animal;
import com.farmers.farm.entities.AnimalKingdom;
import com.farmers.farm.exceptions.AnimalNotFoundException;
import com.farmers.farm.repositories.AnimalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

  private final AnimalRepository animalRepository;
  private final ModelMapper modelMapper;

  public AnimalService(AnimalRepository animalRepository, ModelMapper modelMapper) {
    this.animalRepository = animalRepository;
    this.modelMapper = modelMapper;
  }

  public BasicResponseDTO<AnimalDTO> getAnimalById(Integer id) {
    Optional<Animal> animal = animalRepository.findById(id);

    if(animal.isEmpty()) {
      String message = String.format("Animal with id %s was not found", id);
      throw new AnimalNotFoundException(message);
    }

    return new BasicResponseDTO<>(
        "Success",
        HttpStatus.OK.getReasonPhrase(),
        modelMapper.map(animal.get(), AnimalDTO.class)
    );

  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimals() {
    List<Animal> animals = animalRepository.findAll();
    List<AnimalDTO> animalDTOS = mapToAnimalDTOList(animals);
    return listResponse(animalDTOS);
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByRaceName(String raceName) {
    return listResponse(mapToAnimalDTOList(animalRepository.findByRace_RaceLikeIgnoreCase(raceName)));
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByRaceScientificName(String scientificName) {
    return listResponse(mapToAnimalDTOList(animalRepository.findByRace_ScientificNameIgnoreCase(scientificName)));
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByKingdom(String animalKingdom) {
    return listResponse(mapToAnimalDTOList(animalRepository.findByKingdom(AnimalKingdom.valueOf(animalKingdom))));
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByOwnerCity(String city) {
    return listResponse(mapToAnimalDTOList(animalRepository.findByOwner_CityIgnoreCase(city)));
  }

  public <T> BasicResponseDTO<List<T>> listResponse(List<T> body) {
    return new BasicResponseDTO<>(
        "Success",
        HttpStatus.OK.getReasonPhrase(),
        body
    );
  }

  private List<AnimalDTO> mapToAnimalDTOList(List<Animal> animals) {
    return modelMapper.mapObjectList(animals, AnimalDTO.class);
  }

}
