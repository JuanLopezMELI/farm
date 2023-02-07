package com.farmers.farm.services;

import com.farmers.farm.config.ModelMapper;
import com.farmers.farm.dtos.AnimalDTO;
import com.farmers.farm.dtos.AnimalPhotoLinkUpdateDTO;
import com.farmers.farm.dtos.BasicResponseDTO;
import com.farmers.farm.entities.Animal;
import com.farmers.farm.entities.AnimalKingdom;
import com.farmers.farm.entities.Continent;
import com.farmers.farm.exceptions.AnimalNotFoundException;
import com.farmers.farm.repositories.AnimalRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service @Slf4j
public class AnimalService {

  private final AnimalRepository animalRepository;
  private final ModelMapper modelMapper;

  public AnimalService(AnimalRepository animalRepository, ModelMapper modelMapper) {
    this.animalRepository = animalRepository;
    this.modelMapper = modelMapper;
  }

  public BasicResponseDTO<AnimalDTO> getAnimalById(Integer id) {
    Animal animal = findAnimalById(id);

    return new BasicResponseDTO<>(
        "Success",
        HttpStatus.OK.getReasonPhrase(),
        modelMapper.map(animal, AnimalDTO.class)
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

  public BasicResponseDTO<String> updateAnimalPhotoLink(AnimalPhotoLinkUpdateDTO linkDTO) {
    Integer animalId = linkDTO.getAnimalId();
    String photoLink = linkDTO.getLink();

    Animal animalToUpdate = findAnimalById(animalId);
    animalToUpdate.setPhotoLink(photoLink);
    animalRepository.saveAndFlush(animalToUpdate);

    return new BasicResponseDTO<String>()
        .setMessage("The animal with id %s was updated successfully. Photo link was set to %s".formatted(animalId, photoLink))
        .setStatusCode(HttpStatus.OK.getReasonPhrase());
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByContinent(String continentName) {

    Continent continent = Continent.AMERICA;
    try{
      continent = Continent.valueOf(continentName);
    } catch (IllegalArgumentException e) {
      log.info("That continent does not exists");
    }

    List<AnimalDTO> response = mapToAnimalDTOList(animalRepository.findByRace_OriginCountry_Continent(continent));

    return listResponse(response);
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByCountry(String country) {
    return listResponse(mapToAnimalDTOList(animalRepository.findByRace_OriginCountry_NameIgnoreCase(country)));
  }

  public BasicResponseDTO<List<AnimalDTO>> getAllAnimalsByOwnerProfession(String ownerProfession) {
    return listResponse(mapToAnimalDTOList(animalRepository.findByOwner_ProfessionIgnoreCase(ownerProfession)));
  }

  private Animal findAnimalById(Integer id) {
    Optional<Animal> animal = animalRepository.findById(id);

    if(animal.isEmpty()) {
      String message = String.format("Animal with id %s was not found", id);
      throw new AnimalNotFoundException(message);
    }

    return animal.get();
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
