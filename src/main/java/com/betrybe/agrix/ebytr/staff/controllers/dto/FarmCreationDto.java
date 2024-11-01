package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.models.entities.Farm;

/**
 * The type Farm creation dto.
 */
public record FarmCreationDto(String name, double size) {

  /**
   * To entity farm.
   *
   * @return the farm
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
