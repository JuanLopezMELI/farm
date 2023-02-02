package com.farmers.farm.entities;

import static com.farmers.farm.entities.AnimalFamily.invertebrate;
import static com.farmers.farm.entities.AnimalFamily.vertebrate;

public enum AnimalKingdom {
  bird(vertebrate),
  mammal(vertebrate),
  amphibian(vertebrate),
  reptile(vertebrate),
  fish(vertebrate),
  arthropods(invertebrate),
  annelids(invertebrate),
  mollusks(invertebrate),
  poriferans(invertebrate),
  cnidarians(invertebrate);

  AnimalFamily family;

  AnimalKingdom(AnimalFamily family) {
    this.family = family;
  }

  public AnimalFamily getFamily() {
    return family;
  }
}
