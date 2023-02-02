package com.farmers.farm.repositories;

import com.farmers.farm.entities.Animal;
import com.farmers.farm.entities.AnimalKingdom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

  List<Animal> findByRace_RaceLikeIgnoreCase(String race);

  List<Animal> findByRace_ScientificNameIgnoreCase(String scientificName);

  List<Animal> findByKingdom(AnimalKingdom kingdom);

  List<Animal> findByOwner_CityIgnoreCase(String city);

}
