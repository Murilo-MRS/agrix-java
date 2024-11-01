package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.models.entities.Farm;

/**
 * The type Farm dto.
 */
public record FarmDto(Long id, String name, double size) {

  /**
   * From entity farm dto.
   *
   * @param farm the farm
   * @return the farm dto
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }
}
