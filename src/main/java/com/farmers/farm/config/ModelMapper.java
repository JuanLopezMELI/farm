package com.farmers.farm.config;

import com.farmers.farm.dtos.AnimalDTO;
import com.farmers.farm.entities.Animal;
import com.farmers.farm.entities.AnimalFamily;
import com.farmers.farm.entities.AnimalKingdom;
import com.farmers.farm.entities.ContinentSubdivision;
import com.farmers.farm.entities.Country;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {

  private final org.modelmapper.ModelMapper mapper;

  public ModelMapper() {
    mapper = new org.modelmapper.ModelMapper();
    configure();
  }

  public <T,D> D map(T object, Class<D> destinationType) {
    return mapper.map(object, destinationType);
  }

  public <T, D> List<D> mapObjectList(List<T> list, Class<D> destinationType) {
    return list.stream()
        .map(animal -> mapper.map(animal, destinationType))
        .collect(Collectors.toList());
  }

  public void configure() {

    Converter<AnimalKingdom, AnimalFamily> enumConverter = context -> {
      if(context.getSource() != null) {
        return AnimalFamily.valueOf(context.getSource().getFamily().toString());
      }
      return null;
    };

    PropertyMap<Animal, AnimalDTO> animalMapper = new PropertyMap<>() {
      @Override
      protected void configure() {
        using(enumConverter).map().setFamily(this.source("kingdom"));
      }
    };

    mapper.addMappings(animalMapper);
  }
}
