package com.farmers.farm.entities;

import static com.farmers.farm.entities.ContinentSubdivision.AUSTRALIA_AND_NEW_ZEALAND;
import static com.farmers.farm.entities.ContinentSubdivision.CARIBBEAN;
import static com.farmers.farm.entities.ContinentSubdivision.CENTRAL;
import static com.farmers.farm.entities.ContinentSubdivision.EASTERN;
import static com.farmers.farm.entities.ContinentSubdivision.MELANESIA;
import static com.farmers.farm.entities.ContinentSubdivision.MICRONESIA;
import static com.farmers.farm.entities.ContinentSubdivision.MIDDLE;
import static com.farmers.farm.entities.ContinentSubdivision.NORTHERN;
import static com.farmers.farm.entities.ContinentSubdivision.POLYNESIA;
import static com.farmers.farm.entities.ContinentSubdivision.SOUTH;
import static com.farmers.farm.entities.ContinentSubdivision.SOUTHERN;
import static com.farmers.farm.entities.ContinentSubdivision.SOUTH_EASTERN;
import static com.farmers.farm.entities.ContinentSubdivision.WESTERN;

import java.util.List;
import java.util.Locale;

public enum Continent {
  ASIA(List.of(CENTRAL, EASTERN, SOUTHERN, SOUTH_EASTERN, WESTERN)),
  AFRICA(List.of(NORTHERN, EASTERN, MIDDLE, SOUTHERN, WESTERN)),
  AMERICA(List.of(CARIBBEAN, NORTHERN, CENTRAL, SOUTH)),
  EUROPE(List.of(EASTERN, NORTHERN, SOUTHERN, WESTERN)),
  OCEANIA(List.of(AUSTRALIA_AND_NEW_ZEALAND, MELANESIA, MICRONESIA, POLYNESIA)),
  ANTARCTICA(List.of());

  Continent(List<ContinentSubdivision> subdivisions) {}

  public String toString() {
    return name().toLowerCase(Locale.ROOT);
  }
}
