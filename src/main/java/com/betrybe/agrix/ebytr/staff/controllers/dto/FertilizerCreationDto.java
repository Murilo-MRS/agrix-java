package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.models.entities.Fertilizer;

/**
 * The type Fertilizer creation dto.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {

  /**
   * To entity fertilizer.
   *
   * @return the fertilizer
   */
  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}
