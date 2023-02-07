package com.farmers.farm.repositories;

import com.farmers.farm.entities.Animal;
import com.farmers.farm.entities.AnimalKingdom;
import com.farmers.farm.entities.Continent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

  List<Animal> findByRace_ScientificNameIgnoreCase(String scientificName);

  List<Animal> findByKingdom(AnimalKingdom kingdom);

  List<Animal> findByOwner_CityIgnoreCase(String city);
  List<Animal> findByOwner_ProfessionIgnoreCase(String profession);

  List<Animal> findByRace_RaceLikeIgnoreCase(String race);
  List<Animal> findByRace_OriginCountry_Continent(Continent continent);
  List<Animal> findByRace_OriginCountry_NameIgnoreCase(String name);

}
