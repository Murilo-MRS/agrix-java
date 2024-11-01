package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.models.entities.Crop;
import java.time.LocalDate;

/**
 * The type Crop creation dto.
 */
public record CropCreationDto(
    String name,
    double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate
) {

  /**
   * To entity crop.
   *
   * @return the crop
   */
  public Crop toEntity() {
    return new Crop(plantedArea, name, plantedDate, harvestDate);
  }
}
